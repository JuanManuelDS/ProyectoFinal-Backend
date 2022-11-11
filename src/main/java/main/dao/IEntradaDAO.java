package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Entrada;

public interface IEntradaDAO extends JpaRepository<Entrada, Long>{

}
