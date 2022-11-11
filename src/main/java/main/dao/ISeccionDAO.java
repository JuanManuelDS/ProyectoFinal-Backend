package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Seccion;

public interface ISeccionDAO extends JpaRepository<Seccion, Long>{

}
