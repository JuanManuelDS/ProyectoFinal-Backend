package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.ISeccionDAO;
import main.dto.Secciones;


@Service
public class SeccionService implements ISeccionServices{

	@Autowired
	ISeccionDAO iSeccionDAO;
	
	@Override
	public List<Secciones> listarSecciones() {
		// TODO Auto-generated method stub
		return iSeccionDAO.findAll();
	}

	@Override
	public Secciones buscarSeccion(Long id) {
		// TODO Auto-generated method stub
		return iSeccionDAO.findById(id).get();
	}

	@Override
	public Secciones guardarSeccion(Secciones seccion) {
		// TODO Auto-generated method stub
		return iSeccionDAO.save(seccion);
	}

	@Override
	public Secciones actualizarSeccion(Secciones seccion) {
		// TODO Auto-generated method stub
		return iSeccionDAO.save(seccion);
	}

	@Override
	public void eliminarSeccion(Long id) {
		// TODO Auto-generated method stub
		iSeccionDAO.deleteById(id);
	}

}
