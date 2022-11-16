package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.CartaRestaurante;

public interface ICartaRestauranteDAO extends JpaRepository<CartaRestaurante, Long>{

}
