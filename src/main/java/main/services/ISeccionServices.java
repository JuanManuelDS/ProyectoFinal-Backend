package main.services;

import java.util.List;

import dto.Seccion;

public interface ISeccionServices {

	public List<Seccion> listarSecciones();
	
	public Seccion buscarSeccion(Long id);
	
	public Seccion guardarSeccion(Seccion seccion);
	
	public Seccion actualizarSeccion(Seccion seccion);
	
	public void eliminarSeccion(Long id);
	
}
