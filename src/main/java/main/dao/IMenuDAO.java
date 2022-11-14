package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Menu;

public interface IMenuDAO extends JpaRepository<Menu, Long> {
	
}
