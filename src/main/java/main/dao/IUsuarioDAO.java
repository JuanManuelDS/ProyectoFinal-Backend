package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, String>{

}
