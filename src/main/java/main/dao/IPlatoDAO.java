package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Plato;

public interface IPlatoDAO extends JpaRepository<Plato, Long> {

}
