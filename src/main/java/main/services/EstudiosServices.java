package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IEstudiosDAO;
import main.dto.Estudios;

@Service
public class EstudiosServices implements IEstudiosService{

	@Autowired
	IEstudiosDAO iEstudiosDAO;

	@Override
	public List<Estudios> listarEstudios() {
		
		return iEstudiosDAO.findAll();
	}

	@Override
	public Estudios buscarEstudios(Long id) {
		
		return iEstudiosDAO.findById(id).get();
	}

	@Override
	public Estudios guardarEstudios(Estudios estudios) {
		
		return iEstudiosDAO.save(estudios);
	}

	@Override
	public Estudios actualizarEstudios(Estudios estudios) {
		
		return iEstudiosDAO.save(estudios);
	}

	@Override
	public void eliminarEstudios(Long id) {
		// TODO Auto-generated method stub
		iEstudiosDAO.deleteById(id);
	}
}
