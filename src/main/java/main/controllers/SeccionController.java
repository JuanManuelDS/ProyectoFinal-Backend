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

import main.dto.Seccion;
import main.services.SeccionService;

@RestController
@RequestMapping("/api")
public class SeccionController {

	@Autowired
	SeccionService seccionService;
	
	@GetMapping("/secciones")
	public List<Seccion> listarSecciones(){
		return seccionService.listarSecciones();
	}
	
	@GetMapping("/secciones/{id}")
	public Seccion buscarSeccion(@PathVariable(name="id")Long id) {
		return seccionService.buscarSeccion(id);
	}
	
	@PostMapping("/secciones")
	public Seccion guardarSeccion(@RequestBody Seccion seccion) {
		return seccionService.guardarSeccion(seccion);
	}
	
	@PutMapping("/secciones/{id}")
	public Seccion actualizarSeccion(@PathVariable(name="id")Long id, @RequestBody Seccion seccion) {
		
		Seccion seccionSeleccionada = seccionService.buscarSeccion(id);
		
		seccionSeleccionada.setImagen(seccion.getImagen());
		seccionSeleccionada.setNombre(seccion.getNombre());
		seccionSeleccionada.setCartaRestaurante(seccion.getCartaRestaurante());
		
		return seccionService.actualizarSeccion(seccionSeleccionada);
	}
	
	@DeleteMapping("/secciones/{id}")
	public void eliminarSeccion(@PathVariable(name="id")Long id) {
		
		seccionService.eliminarSeccion(id);
	}
}
