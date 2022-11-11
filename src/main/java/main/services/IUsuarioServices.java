package main.services;

import java.util.List;

import dto.Usuario;

public interface IUsuarioServices {

	public List<Usuario> listarUsuarios();
	
	public Usuario buscarUsuario(Long id);
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public Usuario actualizarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long id);
	
}
