package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Idioma;

public interface IIdiomasDAO extends JpaRepository<Idioma, Long>{
	
}
