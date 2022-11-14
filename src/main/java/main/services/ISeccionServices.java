package main.services;

import java.util.List;

import main.dto.Secciones;

public interface ISeccionServices {

	public List<Secciones> listarSecciones();
	
	public Secciones buscarSeccion(Long id);
	
	public Secciones guardarSeccion(Secciones seccion);
	
	public Secciones actualizarSeccion(Secciones seccion);
	
	public void eliminarSeccion(Long id);
	
}
