package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.ICartaRestauranteDAO;
import main.dto.CartasRestaurantes;

@Service
public class CartaRestaurateServices implements ICartaRestauranteService {
	
	@Autowired
	ICartaRestauranteDAO iCartaRestauranteDAO;

	@Override
	public List<CartasRestaurantes> listarCartasRestaurantes() {
		
		return iCartaRestauranteDAO.findAll();
	}

	@Override
	public CartasRestaurantes buscarCartaRestaurante(Long id) {
		
		return iCartaRestauranteDAO.findById(id)
	}

	@Override
	public CartasRestaurantes guardarCartaRestaurante(CartaRestaurante cartaRestaurante) {
		return iCartaRestauranteDAO.save(cartaRestaurante);
	}

	@Override
	public CartasRestaurantes actualizarCartaRestaurante(CartaRestaurante cartaRestaurante) {
		
		return iCartaRestauranteDAO.save(cartaRestaurante);
	}

	@Override
	public void eliminarCartaRestaurante(Long id) {

		iCartaRestauranteDAO.deleteById(id);
	}

	
}
