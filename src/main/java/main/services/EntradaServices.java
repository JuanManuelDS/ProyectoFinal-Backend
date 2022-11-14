package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IEntradaDAO;
import main.dto.Entrada;

@Service
public class EntradaServices implements IEntradaService {

	@Autowired
	IEntradaDAO iEntradaDAO;
	
	@Override
	public List<Entrada> listarEntradas() {
		
		return iEntradaDAO.findAll();
	}

	@Override
	public Entrada buscarEntrada(Long id) {
		
		return iEntradaDAO.findById(id).get();
	}

	@Override
	public Entrada guardarEntrada(Entrada entrada) {
		
		return iEntradaDAO.save(entrada);
	}

	@Override
	public Entrada actualizarEntrada(Entrada entrada) {
		return iEntradaDAO.save(entrada);
	}

	@Override
	public void eliminarEntrada(Long id) {
		// TODO Auto-generated method stub
		iEntradaDAO.deleteById(id);
	}

	
}
