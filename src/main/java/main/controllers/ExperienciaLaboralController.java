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

import main.dto.ExperienciaLaboral;
import main.services.ExperienciaLaboralService;

@RestController
@RequestMapping("/api")
public class ExperienciaLaboralController {

	@Autowired
	ExperienciaLaboralService experienciaLaboralService;
	
	@GetMapping("/experiencias")
	public List<ExperienciaLaboral> listarExperienciaLaborales(){
		return experienciaLaboralService.listarExperienciasLaborales();
	}
	
	@GetMapping("/experiencias/{id}")
	public ExperienciaLaboral buscarExperienciaLaboral(@PathVariable(name = "id") Long id) {
		return experienciaLaboralService.buscarExperienciaLaboral(id);
	}
	
	@PostMapping("/experiencias")
	public ExperienciaLaboral guardarExperienciaLaboral(@RequestBody ExperienciaLaboral experienciaLaboral) {
		return experienciaLaboralService.guardarExperienciaLaboral(experienciaLaboral);
	}
	
	@PutMapping("/experiencias/{id}")
	public ExperienciaLaboral actualizarExperienciaLaboral(@PathVariable(name = "id") Long id, @RequestBody ExperienciaLaboral experienciaLaboral) {
		ExperienciaLaboral experienciaSeleccionada = experienciaLaboralService.buscarExperienciaLaboral(id);
		
		experienciaSeleccionada.setPuesto(experienciaLaboral.getPuesto());
		experienciaSeleccionada.setDescripcion(experienciaLaboral.getDescripcion());
		experienciaSeleccionada.setFecha_inicio(experienciaLaboral.getFecha_inicio());
		experienciaSeleccionada.setFecha_fin(experienciaLaboral.getFecha_fin());
		experienciaSeleccionada.setCurriculum(experienciaLaboral.getCurriculum());
		
		return experienciaLaboralService.actualizarExperienciaLaboral(experienciaSeleccionada);
	}
	
	@DeleteMapping("/experiencias/{id}")
	public void eliminarExperienciaLaboral(@PathVariable(name = "id") Long id) {
		experienciaLaboralService.eliminarExperienciaLaboral(id);
	}
}
