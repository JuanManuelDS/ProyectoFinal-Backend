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

import main.dto.Listado;
import main.services.ListadoService;

@RestController
@RequestMapping("/api")
public class ListadoController {

	@Autowired
	ListadoService listadoService;
	
	@GetMapping("/listados")
	public List<Listado> listarListados(){
		return listadoService.listarListados();
	}
	
	@GetMapping("/listados/{id}")
	public Listado buscarListado(@PathVariable(name="id")Long id) {
		
		return listadoService.buscarListado(id);
	}
	
	@PostMapping("/listados")
	public Listado guardarListado(@RequestBody Listado listado) {
		return listadoService.guardarListado(listado);
	}
	
	@PutMapping("/listados/{id}")
	public Listado actualizarListado(@PathVariable(name="id")Long id, @RequestBody Listado listado) {
		
		Listado listadoSeleccionado = listadoService.buscarListado(id);
		
		listadoSeleccionado.setTitulo(listado.getTitulo());
		
		return listadoService.actualizarListado(listadoSeleccionado);
	}
	
	@DeleteMapping("/listados/{id}")
	public void eliminarListado(@PathVariable(name="id")Long id) {
		listadoService.eliminarListado(id);
	}
}
