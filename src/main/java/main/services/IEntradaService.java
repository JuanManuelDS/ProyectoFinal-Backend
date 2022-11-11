package main.services;

import dto.Entrada;

public interface IEntradaService {

	public List<Entrada> listarEntradas();
	
	public Entrada buscarEntrada(Long id);
	
	public Entrada guardarEntrada(Entrada entrada);
	
	public Entrada actualizarEntrada(Entrada entrada);
	
	public void eliminarEntrada(Long id);
}
