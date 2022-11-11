package main.services;

import org.springframework.beans.factory.annotation.Autowired;

import main.dao.IIdiomasDAO;

public class IdiomaService implements IIdiomaServices{

	@Autowired
	IIdiomasDAO iIdiomasDAO;
	
	@Override
	public List<Idioma> listarIdiomas() {
		
		return iIdiomasDAO.findAll();
	}

	@Override
	public Idioma buscarIdioma(Long id) {
		
		return iIdiomasDAO.findById(id);
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
