package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.dao.IDatosDAO;

public class DatosServices implements IDatosServices{

	@Autowired
	IDatosDAO iDatosDAO;
	
	@Override
	public List<DatosServices> listarDatos() {
		
		return iDatosDAO.findAll();
	}

	@Override
	public DatosServices buscarDatos(Long id) {
		return iDatosDAO.findById(id);
				
	}

	@Override
	public DatosServices guardarDatos(DatosServices datos) {
		
		return iDatosDAO.save(datos);
	}

	@Override
	public void eliminarDatos(Long id) {
		
		iDatosDAO.deleteById(id);
		
	}

}
