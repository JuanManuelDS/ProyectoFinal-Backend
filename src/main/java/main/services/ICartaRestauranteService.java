package main.services;

import java.util.List;
import main.dto.CartasRestaurantes;

public interface ICartaRestauranteService {

	public List<CartasRestaurantes> listarCartasRestaurantes();

	public CartasRestaurantes buscarCartaRestaurante(Long id);

	public CartasRestaurantes guardarCartaRestaurante(CartasRestaurantes cartaRestaurante);

	public CartasRestaurantes actualizarCartaRestaurante(CartasRestaurantes cartaRestaurante);

	public void eliminarCartaRestaurante(Long id);

}
