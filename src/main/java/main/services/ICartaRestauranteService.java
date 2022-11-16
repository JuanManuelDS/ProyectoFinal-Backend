package main.services;

import java.util.List;
import main.dto.CartaRestaurante;

public interface ICartaRestauranteService {

	public List<CartaRestaurante> listarCartasRestaurantes();

	public CartaRestaurante buscarCartaRestaurante(Long id);

	public CartaRestaurante guardarCartaRestaurante(CartaRestaurante cartaRestaurante);

	public CartaRestaurante actualizarCartaRestaurante(CartaRestaurante cartaRestaurante);

	public void eliminarCartaRestaurante(Long id);

}
