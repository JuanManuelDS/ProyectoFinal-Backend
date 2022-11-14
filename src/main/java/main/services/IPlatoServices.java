package main.services;

import java.util.List;

import main.dto.Plato;

public interface IPlatoServices {

	public List<Plato> listarPlatos();
	
	public Plato buscarPlato(Long id);
	
	public Plato guardarPlato(Plato plato);
	
	public Plato actualizarPlato(Plato plato);
	
	public void eliminarPlato(Long id);
}
