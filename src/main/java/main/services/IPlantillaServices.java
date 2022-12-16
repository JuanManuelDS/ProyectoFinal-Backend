package main.services;

import java.util.List;

import main.dto.Plantilla;
import main.dto.Usuario;

public interface IPlantillaServices {

	public List<Plantilla> listarPlantillas();
	
	public Plantilla buscarPlantilla(Long id);
	
	public Plantilla guardarPlantilla(Plantilla plantilla);
	
	public Plantilla actualizarPlantilla(Plantilla plantilla);
	
	public void eliminarPlantilla(Long id);
	
	public List<Plantilla> plantillasUsuario(Usuario usuario);
}
