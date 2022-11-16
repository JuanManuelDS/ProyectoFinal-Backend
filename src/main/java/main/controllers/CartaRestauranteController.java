package main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.CartaRestaurante;
import main.services.CartaRestaurateServices;

@RestController
@RequestMapping("/api")
public class CartaRestauranteController {

	@Autowired
	CartaRestaurateServices cartaRestaurateServices;
	
	@GetMapping("/cartasRestaurantes")
	public List<CartaRestaurante> listarCartasRestaurantes(){
		return cartaRestaurateServices.listarCartasRestaurantes();
	}
	
	@GetMapping("/cartaRestaurantes/{id}")
	public CartaRestaurante buscarCartaRestaurante(@PathVariable(name="id")Long id) {
		return cartaRestaurateServices.buscarCartaRestaurante(id);
	}
	
	@PostMapping("/cartaRestaurantes")
	public CartaRestaurante guardarCartaRestaurante(@RequestBody CartaRestaurante cartaRestaurante) {
		return cartaRestaurateServices.guardarCartaRestaurante(cartaRestaurante);
	}
	
	@PutMapping("/cartaRestaurante/{id}")
	public CartaRestaurante actualizarCartaRestaurante(@PathVariable(name="id")Long id, @RequestBody CartaRestaurante cartaRestaurante) {
		
		CartaRestaurante cartaSeleccionada = cartaRestaurateServices.buscarCartaRestaurante(id);
		
		cartaSeleccionada.setNombre_restaurante(cartaRestaurante.getNombre_restaurante());
		
		return cartaRestaurateServices.actualizarCartaRestaurante(cartaSeleccionada);
	}
	
	@DeleteMapping("/cartaRestaurante/{id}")
	public void eliminarCartaRestaurante(@PathVariable(name="id")Long id) {
		cartaRestaurateServices.eliminarCartaRestaurante(id);
	}
}
