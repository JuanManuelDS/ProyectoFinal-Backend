package main.services;

import java.util.List;

import dto.Datos;

public interface IDatosServices {

<<<<<<< HEAD
	public List<DatosServices> listarDatos();
	
	public DatosServices buscarDatos(Long id);
	
	public DatosServices guardarDatos(DatosServices datos);
	
	public actualizarDatos(DatosServices datos);
=======
	public List<Datos> listarDatos();
	
	public Datos buscarDatos(Long id);
	
	public Datos guardarDatos(Datos datos);
	
	public actualizarDatos(Datos datos);
>>>>>>> 0e680caf9db624be918991b8b6c94ef0378eff3b
	
	public void eliminarDatos(Long id);
	
}
