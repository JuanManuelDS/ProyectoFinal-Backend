package main.services;

import java.util.List;

import dto.Datos;

public interface IDatosServices {

	public List<Datos> listarDatos();
	
	public Datos buscarDatos(Long id);
	
	public Datos guardarDatos(Datos datos);
	
	public actualizarDatos(Datos datos);
	
	public void eliminarDatos(Long id);
	
}
