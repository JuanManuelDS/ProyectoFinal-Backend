package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IPlantillaDAO;

@Service
public class PlantillaService implements IPlantillaServices {

	@Autowired
	IPlantillaDAO iPlantillaDAO;
	
	@Override
	public List<Plantilla> listarPlantillas() {
		// TODO Auto-generated method stub
		return iPlantillaDAO.findAll();
	}

	@Override
	public Plantilla buscarPlantilla(Long id) {
		// TODO Auto-generated method stub
		return iPlantillaDAO.findById(id).get();
	}

	@Override
	public Plantilla guardarPlantilla(Plantilla plantilla) {
		// TODO Auto-generated method stub
		return iPlantillaDAO.save(plantilla);
	}

	@Override
	public Plantilla actualizarPlantilla(Plantilla plantilla) {
		// TODO Auto-generated method stub
		return iPlantillaDAO.save(plantilla);
	}

	@Override
	public void eliminarPlantilla(Long id) {
		// TODO Auto-generated method stub
		iPlantillaDAO.deleteById(id);
	}

}
