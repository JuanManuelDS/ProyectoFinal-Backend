package main.services;

import java.util.List;

import main.dto.Entrada;

public interface IEntradaService {

	public List<Entrada> listarEntradas();
	
	public Entrada buscarEntrada(Long id);
	
	public Entrada guardarEntrada(Entrada entrada);
	
	public Entrada actualizarEntrada(Entrada entrada);
	
	public void eliminarEntrada(Long id);
}
