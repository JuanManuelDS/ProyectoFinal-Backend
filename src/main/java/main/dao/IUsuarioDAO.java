package main.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{
	
	Page<Usuario> findAll(Pageable pageable);
	
	public Usuario findByEmail(String email);
	
	public Usuario findByNombreUsuario(String nombreUsuario);
	
}
