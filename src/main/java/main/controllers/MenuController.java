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

import main.dto.Menu;
import main.services.MenuServices;

@RestController
@RequestMapping("/api")
public class MenuController {

	@Autowired
	MenuServices menuServices;
	
	@GetMapping("/menus")
	public List<Menu> listarMenus (){
		return menuServices.listarMenus();
	}
	
	@GetMapping("/menus/{id}")
	public Menu buscarMenu(@PathVariable(name="id")Long id) {
		return menuServices.buscarMenu(id);
	}
	
	@PostMapping("/menus")
	public Menu guardarMenu(@RequestBody Menu menu) {
		return menuServices.guardarMenu(menu);
	}
	
	@PutMapping("/menus/{id}")
	public Menu actualizarMenu(@PathVariable(name="id")Long id, @RequestBody Menu menu) {
		
		Menu menuSeleccionado = menuServices.buscarMenu(id);
		
		menuSeleccionado.setImagen(menu.getImagen());
		menuSeleccionado.setNombre(menu.getNombre());
		menuSeleccionado.setPrecioMenu(menu.getPrecioMenu());
		
		return menuServices.actualizarMenu(menuSeleccionado);
	
	}
	
	@DeleteMapping("/menus/{id}")
	public void eliminarMenu(@PathVariable(name="id")Long id) {
		menuServices.eliminarMenu(id);
	}
}
