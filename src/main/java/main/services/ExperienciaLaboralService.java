package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.dao.IExperienciaLaboralDAO;

public class ExperienciaLaboralService implements IExperienciaLaboralServices {

	@Autowired IExperienciaLaboralDAO iExperienciaLaboralDAO;
	
	@Override
	public List<ExperienciaLaboral> listarExperienciasLaborales() {
		
		return iExperienciaLaboralDAO.findAll();
	}

	@Override
	public ExperienciaLaboral buscarExperienciaLaboral(Long id) {
		
		return iExperienciaLaboralDAO.findById(id);
	}

	@Override
	public ExperienciaLaboral guardarExperienciaLaboral(ExperienciaLaboral experienciaLaboral) {
		
		return iExperienciaLaboralDAO.save(experienciaLaboral);
	}

	@Override
	public ExperienciaLaboral actualizarExperienciaLaboral(ExperienciaLaboral experienciaLaboral) {
		return iExperienciaLaboralDAO.save(experienciaLaboral);
	}

	@Override
	public void eliminarExperienciaLaboral(Long id) {
		// TODO Auto-generated method stub
		iExperienciaLaboralDAO.deleteById(id);
	}

}
