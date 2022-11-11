package main.services;

import java.util.List;

import dto.PlatoMenu;

//Esta clase tiene 2 primary keys. Hay que modificar los métodos
public interface IPlatoMenuServices {

	public List<PlatoMenu> listarPlatoMenus();
	
	public PlatoMenu buscarPlatoMenu(Long id);
	
	public PlatoMenu guardarPlatoMenu(PlatoMenu platoMenu);
	
	public PlatoMenu actualizarPlatoMenu(PlatoMenu platoMenu);
	
	public void eliminarPlatoMenu(Long id);
	
}
