package main.services;

import java.util.List;

import dto.Datos;

public interface IDatosServices {

	public List<DatosServices> listarDatos();
	
	public DatosServices buscarDatos(Long id);
	
	public DatosServices guardarDatos(DatosServices datos);
	
	public actualizarDatos(DatosServices datos);
	
	public void eliminarDatos(Long id);
	
}
