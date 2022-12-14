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

import main.dto.PlatoMenu;
import main.services.PlatoMenuService;

@RestController
@RequestMapping("/api")
public class PlatoMenuController {

	@Autowired
	PlatoMenuService platoMenuService;
	
	@GetMapping("/platoMenus")
	public List<PlatoMenu> listarPlatoMenus(){
		return platoMenuService.listarPlatoMenus();
	}
	
	@GetMapping("/platoMenus/{id}")
	public PlatoMenu buscarPlatoMenu(@PathVariable(name = "id") Long id) {
		return platoMenuService.buscarPlatoMenu(id);
	}
	
	@PostMapping("/platoMenus")
	public PlatoMenu guardarPlatoMenu(@RequestBody PlatoMenu platoMenu) {
		return platoMenuService.guardarPlatoMenu(platoMenu);
	}
	
	@PutMapping("/platoMenus/{id}")
	public PlatoMenu actualizarOtro(@PathVariable(name = "id") Long id, @RequestBody PlatoMenu platoMenu) {
		PlatoMenu platoMenuSeleccionado = platoMenuService.buscarPlatoMenu(id);
		
		platoMenuSeleccionado.setPlato(platoMenu.getPlato());
		platoMenuSeleccionado.setMenu(platoMenu.getMenu());
		
		return platoMenuService.actualizarPlatoMenu(platoMenuSeleccionado);
	}
	
	@DeleteMapping("/platoMenus/{id}")
	public void eliminarPlatoMenu(@PathVariable(name = "id") Long id) {
		platoMenuService.eliminarPlatoMenu(id);
	}
}
