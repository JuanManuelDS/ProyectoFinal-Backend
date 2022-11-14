package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.ISeccionDAO;

@Service
public class SeccionService implements ISeccionServices{

	@Autowired
	ISeccionDAO iSeccionDAO;
	
	@Override
	public List<Seccion> listarSecciones() {
		// TODO Auto-generated method stub
		return iSeccionDAO.findAll();
	}

	@Override
	public Seccion buscarSeccion(Long id) {
		// TODO Auto-generated method stub
		return iSeccionDAO.findById(id).get();
	}

	@Override
	public Seccion guardarSeccion(Seccion seccion) {
		// TODO Auto-generated method stub
		return iSeccionDAO.save(seccion);
	}

	@Override
	public Seccion actualizarSeccion(Seccion seccion) {
		// TODO Auto-generated method stub
		return iSeccionDAO.save(seccion);
	}

	@Override
	public void eliminarSeccion(Long id) {
		// TODO Auto-generated method stub
		iSeccionDAO.deleteById(id);
	}

}
