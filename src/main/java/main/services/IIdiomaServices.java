package main.services;

import java.util.List;

import main.dto.Idioma;

public interface IIdiomaServices {
	
	public List<Idioma> listarIdiomas();
	
	public Idioma buscarIdioma(Long id);
	
	public Idioma guardarIdioma(Idioma idioma);
	
	public Idioma actualizarIdioma(Idioma idioma);
	
	public void eliminarIdioma(Long id);
}
