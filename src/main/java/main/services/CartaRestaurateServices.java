package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.ICartaRestauranteDAO;

@Service
public class CartaRestaurateServices implements ICartaRestauranteService {
	
	@Autowired
	ICartaRestauranteDAO iCartaRestauranteDAO;

	@Override
	public List<CartaRestaurante> listarCartasRestaurantes() {
		
		return iCartaRestauranteDAO.findAll();
	}

	@Override
	public CartaRestaurante buscarCartaRestaurante(Long id) {
		
		return iCartaRestauranteDAO.findById(id)
	}

	@Override
	public CartaRestaurante guardarCartaRestaurante(CartaRestaurante cartaRestaurante) {
		return iCartaRestauranteDAO.save(cartaRestaurante);
	}

	@Override
	public CartaRestaurante actualizarCartaRestaurante(CartaRestaurante cartaRestaurante) {
		
		return iCartaRestauranteDAO.save(cartaRestaurante);
	}

	@Override
	public void eliminarCartaRestaurante(Long id) {

		iCartaRestauranteDAO.deleteById(id);
	}
	
}
