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

import main.dto.Datos;
import main.services.DatosServices;

@RestController
@RequestMapping("/api")
public class DatosController {
	
	@Autowired 
	DatosServices datosServices;
	
	@GetMapping("/datos")
	public List<Datos> listarDatos(){
		return datosServices.listarDatos();
	}
	
	@GetMapping("/datos/{id}")
	public Datos buscarDatos(@PathVariable(name="id")Long id) {
		return datosServices.buscarDatos(id);
	}
	
	@PostMapping("/datos")
	public Datos guardarDatos(@RequestBody Datos datos) {
		return datosServices.guardarDatos(datos);
	}
	
	@PutMapping("/datos/{id}")
	public Datos actualizarDatos(@PathVariable(name="id")Long id, @RequestBody Datos datos) {
		
		Datos datosSeleccionados = datosServices.buscarDatos(id);
		
		datosSeleccionados.setApellidos(datos.getApellidos());
		datosSeleccionados.setNombre(datos.getNombre());
		datosSeleccionados.setTelefono(datos.getTelefono());
		datosSeleccionados.setEmail(datos.getEmail());
		datosSeleccionados.setEdad(datos.getEdad());
		datosSeleccionados.setCodigo_postal(datos.getCodigo_postal());
		datosSeleccionados.setCiudad(datos.getCiudad());

		return datosServices.actualizarDatos(datosSeleccionados);
	}
	
	@DeleteMapping("/datos/{id}")
	public void eliminarDatos(@PathVariable(name="id")Long id) {
		datosServices.eliminarDatos(id);
	}
}
