package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.CartasRestaurantes;

public interface ICartaRestauranteDAO extends JpaRepository<CartasRestaurantes, Long>{

}
