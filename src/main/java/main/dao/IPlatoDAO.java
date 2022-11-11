package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Plato;

public interface IPlatoDAO extends JpaRepository<Plato, Long> {

}
