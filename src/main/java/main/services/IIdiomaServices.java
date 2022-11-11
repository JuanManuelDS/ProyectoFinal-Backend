package main.services;

import dto.Idioma;

public interface IIdiomaServices {
	
	public List<Idioma> listarIdiomas();
	
	public Idioma buscarIdioma(Long id);
	
	public Idioma guardarIdioma(Idioma idioma);
	
	public Idioma actualizarIdioma(Idioma idioma);
	
	public void eliminarIdioma(Long id);
}
