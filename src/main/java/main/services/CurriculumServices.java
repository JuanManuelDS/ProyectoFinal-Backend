package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.dao.ICurriculumDAO;
import main.dto.Curriculum;

public class CurriculumServices implements ICurriculumServices {

	@Autowired
	ICurriculumDAO iCurriculumDAO;

	@Override
	public List<Curriculum> listarCurriculums() {
		return iCurriculumDAO.findAll();
	}

	@Override
	public Curriculum buscarCurriculum(Long id) {

		return iCurriculumDAO.findById(id);
	}

	@Override
	public Curriculum guardarCurriculum(Curriculum curriculum) {

		return iCurriculumDAO.save(curriculum);
	}

	@Override
	public Curriculum actualizarCurriculum(Curriculum curriculum) {

		return iCurriculumDAO.save(curriculum);
	}

	@Override
	public void eliminarCurriculum(Long id) {
		
		iCurriculumDAO.deleteById(id);

	}

}
