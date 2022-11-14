package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IPlatoMenuDAO;
import main.dto.PlatoMenus;

@Service
public class PlatoMenuService implements IPlatoMenuServices {

	@Autowired
	IPlatoMenuDAO iPlatoMenuDAO;

	@Override
	public List<PlatoMenus> listarPlatoMenus() {
		// TODO Auto-generated method stub
		return iPlatoMenuDAO.findAll();
	}

	@Override
	public PlatoMenus buscarPlatoMenu(Long id) {
		// TODO Auto-generated method stub
		return iPlatoMenuDAO.findById(id).get();
	}

	@Override
	public PlatoMenus guardarPlatoMenu(PlatoMenus platoMenu) {
		// TODO Auto-generated method stub
		return iPlatoMenuDAO.save(platoMenu);
	}

	@Override
	public PlatoMenus actualizarPlatoMenu(PlatoMenus platoMenu) {
		// TODO Auto-generated method stub
		return iPlatoMenuDAO.save(platoMenu);
	}

	@Override
	public void eliminarPlatoMenu(Long id) {
		// TODO Auto-generated method stub
		iPlatoMenuDAO.deleteById(id);
	}
}
