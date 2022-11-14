package main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.services.CurriculumServices;
import main.dto.Curriculum;

@RestController
@RequestMapping("/api")
public class CurriculumController {

	@Autowired
	CurriculumServices curriculumServices;
	
	@GetMapping("/curriculums")
	public List<Curriculum> listarCurriculums(){
		return curriculumServices.listarCurriculums();
	}
	
	@GetMapping("/curriculums/{id}")
	public Curriculum buscarCurriculum(@PathVariable(name="id")Long id) {
		return curriculumServices.buscarCurriculum(id);
	}
	
	@PostMapping("/curriculums")
	public Curriculum guardarCurriculum(@RequestBody Curriculum curriculum) {
		return curriculumServices.guardarCurriculum(curriculum);
	}
	
	@PutMapping("/curriculums/{id}")
	public Curriculum actualizarCurriculum(@PathVariable(name="id")Long id, @RequestBody Curriculum curriculum) {
		
		Curriculum curriculumSeleccionado = curriculumServices.buscarCurriculum(id);
		
		//Qué se actualiza de currículum exactamente??
		
		return curriculumServices.actualizarCurriculum(curriculumSeleccionado);
	}
	
	
	@DeleteMapping("/curriculums/{id}")
	public void eliminarCurriculum(@PathVariable(name="id")Long id) {
		
		curriculumServices.eliminarCurriculum(id);
	}
}
