package main.services;

import java.util.List;

import dto.Menu;

public interface IMenuServices {

	public List<Menu> listarMenus();
	
	public Menu buscarMenu(Long id);
	
	public Menu guardarMenu(Menu menu);
	
	public Menu actualizarMenu(Menu menu);
	
	public void eliminarMenu(Long id);
	
}
