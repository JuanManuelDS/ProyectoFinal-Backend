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

import main.dto.Plantilla;
import main.dto.Usuario;
import main.services.PlantillaService;
import main.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class PlantillaController {

	@Autowired
	PlantillaService plantillaService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/plantillas")
	public List<Plantilla> listarPlantillas(){
		return plantillaService.listarPlantillas();
	}
	
	@GetMapping("/plantillas/{username}")
	public List<Plantilla> plantillasUsuario(@PathVariable(name="username") String username){
		Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(username);
		return plantillaService.plantillasUsuario(usuario);
	}
	
	@GetMapping("/plantillas/{id}")
	public Plantilla buscarPlantilla(@PathVariable(name = "id") Long id) {
		return plantillaService.buscarPlantilla(id);
	}
	
	@PostMapping("/plantillas")
	public Plantilla guardarPlantilla(@RequestBody Plantilla plantilla) {
		return plantillaService.guardarPlantilla(plantilla);
	}
	
	@PutMapping("/plantillas/{id}")
	public Plantilla actualizarPlantilla(@PathVariable(name = "id") Long id, @RequestBody Plantilla plantilla) {
		Plantilla plantillaSeleccionada = plantillaService.buscarPlantilla(id);
		
		plantillaSeleccionada.setNombreArchivo(plantilla.getNombre_archivo());
		plantillaSeleccionada.setFirma(plantilla.getFirma());
		plantillaSeleccionada.setUsuario(plantilla.getUsuario());
		
		return plantillaService.actualizarPlantilla(plantillaSeleccionada);
	}
	
	@DeleteMapping("/plantillas/{id}")
	public void eliminarPlantilla(@PathVariable(name = "id") Long id) {
		plantillaService.eliminarPlantilla(id);
	}
}
