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

import main.dto.Estudios;
import main.services.EstudiosServices;

@RestController
@RequestMapping("/api")
public class EstudiosController {

	@Autowired
	EstudiosServices estudiosServices;
	
	@GetMapping("/estudios")
	public List<Estudios> listarEstudios(){
		return estudiosServices.listarEstudios();
	}
	
	@GetMapping("/estudios/{id}")
	public Estudios buscarEstudios(@PathVariable(name="id")Long id) {
		return estudiosServices.buscarEstudios(id);
	}
	
	@PostMapping("/estudios")
	public Estudios guardarEstudios(@RequestBody Estudios estudios) {
		return estudiosServices.guardarEstudios(estudios);
	}
	
	@PutMapping("/estudios/{id}")
	public Estudios actualizarEstudios(@PathVariable(name="id")Long id, @RequestBody Estudios estudios) {
		
		Estudios estudiosSeleccionados = estudiosServices.buscarEstudios(id);
		
		estudiosSeleccionados.setDescripcion(estudios.getDescripcion());
		estudiosSeleccionados.setTitulo(estudios.getTitulo());
		estudiosSeleccionados.setFecha_fin(estudios.getFecha_fin());
		estudiosSeleccionados.setFecha_inicio(estudios.getFecha_inicio());
		
		return estudiosServices.actualizarEstudios(estudiosSeleccionados);
	}
	
	@DeleteMapping("/estudios/{id}")
	public void eliminarEstudios(@PathVariable(name="id")Long id) {
		estudiosServices.eliminarEstudios(id);
	}
}
