package main.services;

import java.util.List;

import main.dto.Estudios;

public interface IEstudiosService {
	
	public List<Estudios> listarEstudios();
	
	public Estudios buscarEstudios(Long id);
	
	public Estudios guardarEstudios(Estudios estudios);
	
	public Estudios actualizarEstudios(Estudios estudios);
	
	public void eliminarEstudios(Long id);
}
