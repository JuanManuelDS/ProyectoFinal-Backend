package main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Plantilla;
import main.dto.Usuario;
import main.services.PlantillaService;
import main.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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

	
	
	@GetMapping("/plantillas/buscar/nombreUsuario/{username}")
	public List<Plantilla> plantillasUsuario(@PathVariable(name="username") String username){
		Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(username);
		return plantillaService.plantillasUsuario(usuario);
	}
	
	@GetMapping("/plantillas/buscar/id/{id}")
	public Plantilla buscarPlantilla(@PathVariable(name = "id") Long id) {
		String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(username);
		Plantilla plantilla = plantillaService.buscarPlantilla(id);
		//Compruebo que la plantilla corresponda con el usuario que la está pidiendo
		if(plantilla.getUsuario().equals(usuario)) {
			return plantilla;
		} else throw new Error();
		
	}
	
	@PostMapping("/plantillas/{nombreUsuario}")
	public Plantilla guardarPlantilla(@RequestBody Plantilla plantilla, @PathVariable(name="nombreUsuario")String nombreUsuario) {
		Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(nombreUsuario);
		plantilla.setUsuario(usuario);
		return plantillaService.guardarPlantilla(plantilla);
	}
	
	@PutMapping("/plantillas/{id}/{username}")
	public Plantilla actualizarPlantilla(@PathVariable(name = "id") Long id,@PathVariable(name="username")String username, @RequestBody Plantilla plantilla) {
		Plantilla plantillaSeleccionada = plantillaService.buscarPlantilla(id);
		
		Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(username);
		
		plantillaSeleccionada.setNombreArchivo(plantilla.getNombreArchivo())
		plantillaSeleccionada.setNombreArchivo(plantilla.getNombre_archivo());
		plantillaSeleccionada.setDatos(plantilla.getDatos());
		plantillaSeleccionada.setFirma(plantilla.getFirma());
		plantillaSeleccionada.setUsuario(usuario);
		
		return plantillaService.actualizarPlantilla(plantillaSeleccionada);
	}
	
	@DeleteMapping("/plantillas/{id}")
	public void eliminarPlantilla(@PathVariable(name = "id") Long id) {
		plantillaService.eliminarPlantilla(id);
	}
}
