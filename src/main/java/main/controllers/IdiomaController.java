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

import main.dto.Idioma;
import main.services.IdiomaService;

@RestController
@RequestMapping("/api")
public class IdiomaController {
	
	@Autowired
	IdiomaService idiomaService;
	
	@GetMapping("/idiomas")
	public List<Idioma> listarIdiomas(){
		return idiomaService.listarIdiomas();
	}
	
	@GetMapping("/idiomas/{id}")
	public Idioma buscarIdioma(@PathVariable(name="id")Long id) {
		return idiomaService.buscarIdioma(id);
	}
	
	@PostMapping("/idiomas")
	public Idioma guardarIdioma(@RequestBody Idioma idioma) {
		return idiomaService.guardarIdioma(idioma);
	}
	
	@PutMapping("/idiomas/{id}")
	public Idioma actualizarIdioma(@PathVariable(name="id")Long id, @RequestBody Idioma idioma) {
		
		Idioma idiomaSeleccionado = idiomaService.buscarIdioma(id);
		
		idiomaSeleccionado.setIdioma(idioma.getIdioma());
		idiomaSeleccionado.setNivelEscrito(idioma.getNivelEscrito());
		idiomaSeleccionado.setNivelOral(idioma.getNivelOral());
		
		return idiomaService.actualizarIdioma(idiomaSeleccionado);
	}
	
	@DeleteMapping("/idiomas/{id}")
	public void eliminarIdioma(@PathVariable(name="id")Long id) {
		idiomaService.eliminarIdioma(id);
	}
}
