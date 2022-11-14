package main.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IIdiomasDAO;
import main.dto.Idioma;
@Service
public class IdiomaService implements IIdiomaServices{

	@Autowired
	IIdiomasDAO iIdiomasDAO;
	
	@Override
	public List<Idioma> listarIdiomas() {
		
		return iIdiomasDAO.findAll();
	}

	@Override
	public Idioma buscarIdioma(Long id) {
		
		return iIdiomasDAO.findById(id).get();
	}

	@Override
	public Idioma guardarIdioma(Idioma idioma) {
		
		return iIdiomasDAO.save(idioma);
	}

	@Override
	public Idioma actualizarIdioma(Idioma idioma) {
		return iIdiomasDAO.save(idioma);
	}

	@Override
	public void eliminarIdioma(Long id) {
		// TODO Auto-generated method stub
		iIdiomasDAO.deleteById(id);
	}

}
