package main.services;

import java.util.List;

import main.dto.Curriculum;

public interface ICurriculumServices {
	
	public List<Curriculum> listarCurriculums();
	
	public Curriculum buscarCurriculum(Long id);
	
	public Curriculum guardarCurriculum(Curriculum curriculum);
	
	public Curriculum actualizarCurriculum(Curriculum curriculum);
	
	public void eliminarCurriculum(Long id);
}
