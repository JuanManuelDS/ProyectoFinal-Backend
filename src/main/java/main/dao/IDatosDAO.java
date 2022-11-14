package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Datos;

public interface IDatosDAO extends JpaRepository<Datos, Long>{

}
