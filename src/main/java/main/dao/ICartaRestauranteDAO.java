package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.CartaRestaurante;

public interface ICartaRestauranteDAO extends JpaRepository<CartaRestaurante, Long>{

}
