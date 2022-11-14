package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IPlatoDAO;
import main.dto.Plato;

@Service
public class PlatoService implements IPlatoServices{

	@Autowired
	IPlatoDAO iPlatoDAO;
	
	@Override
	public List<Plato> listarPlatos() {
		// TODO Auto-generated method stub
		return iPlatoDAO.findAll();
	}

	@Override
	public Plato buscarPlato(Long id) {
		// TODO Auto-generated method stub
		return iPlatoDAO.findById(id).get();
	}

	@Override
	public Plato guardarPlato(Plato plato) {
		// TODO Auto-generated method stub
		return iPlatoDAO.save(plato);
	}

	@Override
	public Plato actualizarPlato(Plato plato) {
		// TODO Auto-generated method stub
		return iPlatoDAO.save(plato);
	}

	@Override
	public void eliminarPlato(Long id) {
		// TODO Auto-generated method stub
		iPlatoDAO.deleteById(id);
	}

	
}
