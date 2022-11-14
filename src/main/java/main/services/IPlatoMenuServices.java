package main.services;

import java.util.List;

import main.dto.PlatoMenus;

public interface IPlatoMenuServices {

	public List<PlatoMenus> listarPlatoMenus();
	
	public PlatoMenus buscarPlatoMenu(Long id);
	
	public PlatoMenus guardarPlatoMenu(PlatoMenus platoMenu);
	
	public PlatoMenus actualizarPlatoMenu(PlatoMenus platoMenu);
	
	public void eliminarPlatoMenu(Long id);
	
}
