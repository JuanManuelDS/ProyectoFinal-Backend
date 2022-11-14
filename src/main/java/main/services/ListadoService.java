package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IListadoDAO;
import main.dto.Listado;

@Service
public class ListadoService implements IListadoServices{

	@Autowired
	IListadoDAO iListadoDAO;
	
	@Override
	public List<Listado> listarListados() {
		
		return iListadoDAO.findAll();
	}

	@Override
	public Listado buscarListado(Long id) {
		
		return iListadoDAO.findById(id).get();
	}

	@Override
	public Listado guardarListado(Listado listado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Listado actualizarListado(Listado listado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarListado(Long id) {
		// TODO Auto-generated method stub
		
	}

}
