package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IOtroDAO;

@Service
public class OtroService implements IOtroServices {

	@Autowired
	IOtroDAO iOtroDAO;

	@Override
	public List<Otro> listarOtros() {
		// TODO Auto-generated method stub
		return iOtroDAO.findAll();
	}

	@Override
	public Otro buscarOtro(Long id) {
		// TODO Auto-generated method stub
		return iOtroDAO.findById(id).get();
	}

	@Override
	public Otro guardarOtro(Otro otro) {
		// TODO Auto-generated method stub
		return iOtroDAO.save(otro);
	}

	@Override
	public Otro actualizarOtro(Otro otro) {
		// TODO Auto-generated method stub
		return iOtroDAO.save(otro);
	}

	@Override
	public void eliminarOtro(Long id) {
		// TODO Auto-generated method stub
		iOtroDAO.deleteById(id);
	}
	
	
	
}
