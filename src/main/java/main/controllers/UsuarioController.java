package main.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Rol;
import main.dto.Usuario;
import main.dto.UsuarioRol;
import main.services.RolService;
import main.services.UsuarioRolService;
import main.services.UsuarioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	RolService rolService;
	
	@Autowired
	UsuarioRolService usuarioRolService;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
	
	
	@GetMapping("/usuarios/buscar/id/{id}")
	public Usuario buscarUsuario(@PathVariable(name = "id") Long id) {
		return usuarioService.buscarUsuario(id);
	}
	
	@GetMapping("/usuarios/buscar/email/{email}")
	public Usuario buscarUsuarioEmail(@PathVariable(name="email")String email) {
		return usuarioService.buscarUsuarioPorEmail(email);
	}
	
	@GetMapping("/usuarios/buscar/nombre_usuario/{nombreUsuario}")
	public Usuario buscarUsuarioNombre(@PathVariable(name="nombreUsuario") String nombreUsuario) {
		return usuarioService.buscarUsuarioPorNombreUsuario(nombreUsuario);
	}
	
	
	
	//Retorna la lista de roles de un usuario
	@GetMapping("/usuarios/roles/{nombreUsuario}")
	public List<Rol> listarRolesUsuario(@PathVariable(name = "nombreUsuario") String nombreUsuario) {

		Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(nombreUsuario);

		List<UsuarioRol> rolesUsuario = usuarioRolService.buscarRolesUsuario(usuario);
		List<Rol> roles = new ArrayList<>();
		rolesUsuario.forEach(rolUsuario -> {
			roles.add(rolUsuario.getRol());
		});
		return roles;

	}
	
	//Agrega un rol a un usuario
	@PostMapping("/roles/usuarios")
	public UsuarioRol agregarRolUsuario(@RequestBody RolAUsuarioForm form) {
			Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(form.getUsername());
			Rol rol = rolService.buscarRol(form.getRoleName());
			UsuarioRol usuarioRol = new UsuarioRol(null,usuario, rol);
			return usuarioRolService.guardaUsuarioRol(usuarioRol);
		}
	
	@PostMapping("/register")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		
		Rol rol = rolService.buscarRol("USER");
		UsuarioRol usuarioRol = new UsuarioRol(null,usuario, rol);
		usuario.setRoles(Arrays.asList(usuarioRol));
		
		usuario.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));
		Usuario nuevoUsuario =  usuarioService.guardarUsuario(usuario);
		
		//Le agrego el rol de user a todos los usuarios que se logueen
		
		
		return nuevoUsuario;
	}
	
	@PutMapping("/usuarios/{username}")
	public Usuario actualizarUsuario(@PathVariable(name = "username") String username, @RequestBody Usuario usuario) {
		Usuario usuarioSeleccionado = usuarioService.buscarUsuarioPorNombreUsuario(username);
		
		if(usuario.getNombreUsuario().length()>0) {
			usuarioSeleccionado.setNombreUsuario(usuario.getNombreUsuario());
		}
		if(usuario.getEmail().length()>0) {
			usuarioSeleccionado.setEmail(usuario.getEmail());
		}
		if(usuario.getContrasena().length()>0) {
			usuarioSeleccionado.setContrasena(usuario.getContrasena());
		}
		
		return usuarioService.actualizarUsuario(usuarioSeleccionado);
	}
	
	@DeleteMapping("/usuarios/{username}")
	public void eliminarUsuario(@PathVariable(name = "username") String username) {
		Usuario user = usuarioService.buscarUsuarioPorNombreUsuario(username);
		usuarioService.eliminarUsuario(user.getId());
	}
	
	/*---------- VALIDACIONES DE EMAIL, USUARIO Y TOKEN --------------------*/
	
	/*Uso este método para validar el token desde el front y retornar la información del usuario (nombre de usuario y roles)*/
	@GetMapping("/token/validar")
	public UsuarioInfo getUsuario() {
		String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		String credenciales = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		
		//Agrego la fecha de validación de token
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formateado =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String fecha = date.format(formateado);
		
		usuarioService.buscarUsuarioPorNombreUsuario(username).setLastLogin(fecha);
		
		return new UsuarioInfo(username, credenciales);
	}
	
	@GetMapping("/validacion/email_tomado/{email}")
	public boolean isEmailTomado(@PathVariable(name="email") String email) {
		//Si ya existe un usuario con este email retorna true, en caso contrario false
		System.out.println(email);
		Usuario usuario = usuarioService.buscarUsuarioPorEmail(email);
		System.out.println(usuario);
		if(usuario != null) {
			return true;
		} else return false;
	}
	
	@GetMapping("/validacion/username_tomado/{username}")
	public boolean isUsernameTomado(@PathVariable(name="username") String nombreUsuario) {
		//Si ya existe un usuario con este email retorna true, en caso contrario false
		Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(nombreUsuario);
		if(usuario != null) {
			return true;
		} else return false;
	}
}

class NombreUsuario {
	private String nombreUsuario;

	public NombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
}

class EmailUsuario {
	private String email;
	
	public EmailUsuario(String email) {
		this.email = email;
	}
	
	public String getEmailUsuario() {
		return email;
	}
}

//Uso esta clase para retornar la información del usuario cuando valido el token desde el front
class UsuarioInfo {
	private String nombreUsuario;
	private String roles;
	
	public UsuarioInfo(String username, String roles) {
		this.nombreUsuario = username;
		this.roles = roles;
	}
	
	public String getUsername() {
		return nombreUsuario;
	}
	
	public String getRoles() {
		return roles;
	}
}

//Utilizo esta clase para el método agregarRolUsuario, para dar forma de objeto a la request
class RolAUsuarioForm {
	private String username;
	private String roleName;

	public RolAUsuarioForm(String username, String roleName) {
		this.username = username;
		this.roleName = roleName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
