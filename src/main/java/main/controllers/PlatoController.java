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

import main.dto.Plato;
import main.services.PlatoService;

@RestController
@RequestMapping("/api")
public class PlatoController {

	
	@Autowired
	PlatoService platoService;
	
	@GetMapping("/platos")
	public List<Plato> listarPlatos (){
		return platoService.listarPlatos();
	}
	
	@GetMapping("/platos/{id}")
	public Plato buscarPlato(@PathVariable(name="id")Long id) {
		return platoService.buscarPlato(id);
	}
	
	@PostMapping("/platos")
	public Plato guardarPlato(@RequestBody Plato plato) {
		return platoService.guardarPlato(plato);
	}
	
	@PutMapping("/platos/{id}")
	public Plato actualizarPlato(@PathVariable(name="id")Long id, @RequestBody Plato plato) {
		
		Plato platoSeleccionado = platoService.buscarPlato(id);
		
		platoSeleccionado.setDescripcion(plato.getDescripcion());
		platoSeleccionado.setImagen(plato.getImagen());
		platoSeleccionado.setNombre(plato.getNombre());
		platoSeleccionado.setPrecio(plato.getPrecio());
		platoSeleccionado.setSeccion(plato.getSeccion());
		
		return platoService.actualizarPlato(platoSeleccionado);
	}
	
	@DeleteMapping("/platos/{id}")
	public void eliminarPlato(@PathVariable(name="id")Long id) {
		platoService.eliminarPlato(id);
	}
}
