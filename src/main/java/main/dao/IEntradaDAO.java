package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Entrada;

public interface IEntradaDAO extends JpaRepository<Entrada, Long>{

}
