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

import main.dto.Otro;
import main.services.OtroService;

@RestController
@RequestMapping("/api")
public class OtroController {

	@Autowired
	OtroService otroService;
	
	@GetMapping("/otros")
	public List<Otro> listarOtros(){
		return otroService.listarOtros();
	}
	
	@GetMapping("/otros/{id}")
	public Otro buscarOtro(@PathVariable(name = "id") Long id) {
		return otroService.buscarOtro(id);
	}
	
	@PostMapping("/otros")
	public Otro guardarOtro(@RequestBody Otro otro) {
		return otroService.guardarOtro(otro);
	}
	
	@PutMapping("/otros/{id}")
	public Otro actualizarOtro(@PathVariable(name = "id") Long id, @RequestBody Otro otro) {
		Otro otroSeleccionado = otroService.buscarOtro(id);
		
		otroSeleccionado.setDescripcion(otro.getDescripcion());
		otroSeleccionado.setCurriculum(otro.getCurriculum());
		
		return otroService.actualizarOtro(otroSeleccionado);
	}
	
	@DeleteMapping("/otros/{id}")
	public void eliminarOtro(@PathVariable(name = "id") Long id) {
		otroService.eliminarOtro(id);
	}
}
