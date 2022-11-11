package main.services;

import java.util.List;

import dto.Plato;

public interface IPlatoServices {

	public List<Plato> listarPlatos();
	
	public Plato buscarPlato(Plato plato);
	
	public Plato guardarPlato(Plato plato);
	
	public Plato actualizarPlato(Plato plato);
	
	public void eliminarPlato(Long id);
}
