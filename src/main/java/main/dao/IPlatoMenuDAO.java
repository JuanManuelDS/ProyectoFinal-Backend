package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.PlatoMenu;

public interface IPlatoMenuDAO extends JpaRepository<PlatoMenu, Long>{

}
