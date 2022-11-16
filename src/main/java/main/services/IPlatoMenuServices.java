package main.services;

import java.util.List;

import main.dto.PlatoMenu;

public interface IPlatoMenuServices {

	public List<PlatoMenu> listarPlatoMenus();
	
	public PlatoMenu buscarPlatoMenu(Long id);
	
	public PlatoMenu guardarPlatoMenu(PlatoMenu platoMenu);
	
	public PlatoMenu actualizarPlatoMenu(PlatoMenu platoMenu);
	
	public void eliminarPlatoMenu(Long id);
	
}
