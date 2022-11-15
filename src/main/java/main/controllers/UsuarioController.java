package main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Usuario;
import main.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario buscarUsuario(@PathVariable(name = "id") Long id) {
		return usuarioService.buscarUsuario(id);
	}
	
	@PostMapping("/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.guardarUsuario(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public Usuario actualizarUsuario(@PathVariable(name = "id") Long id, @RequestBody Usuario usuario) {
		Usuario usuarioSeleccionado = usuarioService.buscarUsuario(id);
		
		usuarioSeleccionado.setNombre_usuario(usuario.getNombre_usuario());
		usuarioSeleccionado.setEmail(usuario.getEmail());
		usuarioSeleccionado.setContrasena(usuario.getContrasena());
		
		return usuarioService.actualizarUsuario(usuarioSeleccionado);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public void eliminarUsuario(@PathVariable(name = "id") Long id) {
		usuarioService.eliminarUsuario(id);
	}
}
