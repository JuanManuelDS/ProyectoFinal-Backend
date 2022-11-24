package main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
		@PostMapping("/usuarios/roles")
		public UsuarioRol agregarRolUsuario(@RequestBody RolAUsuarioForm form) {
			System.out.println(form.getUsername());
			Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(form.getUsername());
			Rol rol = rolService.buscarRol(form.getRoleName());
			UsuarioRol usuarioRol = new UsuarioRol(null,usuario, rol);
			return usuarioRolService.guardaUsuarioRol(usuarioRol);
		}
	
	@PostMapping("/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		usuario.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));
		return usuarioService.guardarUsuario(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public Usuario actualizarUsuario(@PathVariable(name = "id") Long id, @RequestBody Usuario usuario) {
		Usuario usuarioSeleccionado = usuarioService.buscarUsuario(id);
		
		usuarioSeleccionado.setNombreUsuario(usuario.getNombreUsuario());
		usuarioSeleccionado.setEmail(usuario.getEmail());
		usuarioSeleccionado.setContrasena(usuario.getContrasena());
		
		return usuarioService.actualizarUsuario(usuarioSeleccionado);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public void eliminarUsuario(@PathVariable(name = "id") Long id) {
		usuarioService.eliminarUsuario(id);
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
