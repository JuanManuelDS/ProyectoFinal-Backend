package main.services;

import java.util.List;

import main.dto.Listado;

public interface IListadoServices {

	public List<Listado> listarListados();
	
	public Listado buscarListado(Long id);
	
	public Listado guardarListado(Listado listado);
	
	public Listado actualizarListado(Listado listado);
	
	public void eliminarListado(Long id);
}
