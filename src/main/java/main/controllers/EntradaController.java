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

import main.dto.Entrada;
import main.services.EntradaServices;

@RestController
@RequestMapping("/api")
public class EntradaController {

	@Autowired
	EntradaServices entradaServices;
	
	@GetMapping("/entradas")
	public List<Entrada> listarEntradas(){
		return entradaServices.listarEntradas();
	}
	
	@GetMapping("/entradas/{id}")
	public Entrada buscarEntrada(@PathVariable(name="id")Long id) {
		return entradaServices.buscarEntrada(id);
	}
	
	@PostMapping("/entradas")
	public Entrada guardarEntrada(@RequestBody Entrada entrada) {
		return entradaServices.guardarEntrada(entrada);
	}
	
	@PutMapping("/entradas/{id}")
	public Entrada actualizarEntrada(@PathVariable(name="id")Long id, @RequestBody Entrada entrada) {
		
		Entrada entradaSeleccionada = entradaServices.buscarEntrada(id);
		
		entradaSeleccionada.setNombre(entrada.getNombre());
		entradaSeleccionada.setUnidades(entrada.getUnidades());
		
		return entradaServices.actualizarEntrada(entradaSeleccionada);
	}
	
	@DeleteMapping("/entradas/{id}")
	public void eliminarEntrada(@PathVariable(name="id")Long id) {
		entradaServices.eliminarEntrada(id);
	}
}
