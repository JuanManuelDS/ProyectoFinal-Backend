package main.services;

import java.util.List;

import main.dto.Otro;

public interface IOtroServices {

	public List<Otro> listarOtros();
	
	public Otro buscarOtro(Long id);
	
	public Otro guardarOtro(Otro otro);
	
	public Otro actualizarOtro(Otro otro);
	
	public void eliminarOtro(Long id);
	
}
