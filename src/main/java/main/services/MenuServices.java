package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IMenuDAO;

@Service
public class MenuServices implements IMenuServices{

	@Autowired
	IMenuDAO iMenuDAO;
	
	@Override
	public List<Menu> listarMenus() {
		// TODO Auto-generated method stub
		return iMenuDAO.findAll();
	}

	@Override
	public Menu buscarMenu(Long id) {
		// TODO Auto-generated method stub
		return iMenuDAO.findById(id).get();
	}

	@Override
	public Menu guardarMenu(Menu menu) {
		// TODO Auto-generated method stub
		return iMenuDAO.save(menu);
	}

	@Override
	public Menu actualizarMenu(Menu menu) {
		// TODO Auto-generated method stub
		return iMenuDAO.save(menu);
	}

	@Override
	public void eliminarMenu(Long id) {
		// TODO Auto-generated method stub
		iMenuDAO.deleteById(id);
	}

}
