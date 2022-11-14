package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IDatosDAO;
import main.dto.Datos;

@Service
public class DatosServices implements IDatosServices{

	@Autowired
	IDatosDAO iDatosDAO;
	
	@Override
	public List<Datos> listarDatos() {
		
		return iDatosDAO.findAll();
	}

	@Override
	public Datos buscarDatos(Long id) {
		return iDatosDAO.findById(id).get();
				
	}

	@Override
	public Datos guardarDatos(Datos datos) {
		
		return iDatosDAO.save(datos);
	}
	
	@Override
	public Datos actualizarDatos(Datos datos) {
		return iDatosDAO.save(datos);
	}

	@Override
	public void eliminarDatos(Long id) {
		
		iDatosDAO.deleteById(id);
		
	}


}
