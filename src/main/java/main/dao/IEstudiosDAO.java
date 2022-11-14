package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Estudios;

public interface IEstudiosDAO extends JpaRepository<Estudios, Long>{

}
