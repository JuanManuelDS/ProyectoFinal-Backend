package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Secciones;

public interface ISeccionDAO extends JpaRepository<Secciones, Long>{

}
