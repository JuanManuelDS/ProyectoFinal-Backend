package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Menu;

public interface IMenuDAO extends JpaRepository<Menu, Long> {
	
}
