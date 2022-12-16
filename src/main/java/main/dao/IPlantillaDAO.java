package main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Plantilla;
import main.dto.Usuario;

public interface IPlantillaDAO extends JpaRepository<Plantilla, Long>{
	
	public List<Plantilla>  findByUsuario(Usuario usuario);
}
