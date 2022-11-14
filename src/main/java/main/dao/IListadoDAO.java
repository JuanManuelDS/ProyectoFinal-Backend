package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Listado;


public interface IListadoDAO extends JpaRepository<Listado, Long>{

}
