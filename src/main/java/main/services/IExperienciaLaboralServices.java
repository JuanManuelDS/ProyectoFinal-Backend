package main.services;

import java.util.List;

import dto.ExperienciaLaboral;

public interface IExperienciaLaboralServices {
	
	public List<ExperienciaLaboral> listarExperienciasLaborales();
	
	public ExperienciaLaboral buscarExperienciaLaboral(Long id);
	
	public ExperienciaLaboral guardarExperienciaLaboral (ExperienciaLaboral experienciaLaboral);
	
	public ExperienciaLaboral actualizarExperienciaLaboral (ExperienciaLaboral experienciaLaboral);
	
	public void eliminarExperienciaLaboral(Long id);
}
