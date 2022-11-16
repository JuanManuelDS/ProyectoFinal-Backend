package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{
	
	public Usuario findByEmail(String email);
	
	public Usuario findByNombreUsuario(String nombreUsuario);
	
}
