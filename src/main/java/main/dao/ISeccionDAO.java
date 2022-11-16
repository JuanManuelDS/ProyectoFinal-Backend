package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Seccion;

public interface ISeccionDAO extends JpaRepository<Seccion, Long>{

}
