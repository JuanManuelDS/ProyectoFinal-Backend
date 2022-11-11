package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.PlatoMenu;

//La tabla plato menú tiene 2 primary key por ende no se cómo sería.
public interface IPlatoMenu extends JpaRepository<PlatoMenu, Long>{

}
