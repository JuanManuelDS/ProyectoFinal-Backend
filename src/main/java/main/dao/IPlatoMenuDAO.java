package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.PlatoMenus;

public interface IPlatoMenuDAO extends JpaRepository<PlatoMenus, Long>{

}
