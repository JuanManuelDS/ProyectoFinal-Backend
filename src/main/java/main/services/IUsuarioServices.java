package main.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import main.dto.Usuario;

public interface IUsuarioServices {

	public Page<Usuario> listarUsuarios(Pageable pageable);
	
	public Usuario buscarUsuario(Long id);
	
	public Usuario buscarUsuarioPorEmail(String email);
	
	public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario);
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public Usuario actualizarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long id);
	
}
