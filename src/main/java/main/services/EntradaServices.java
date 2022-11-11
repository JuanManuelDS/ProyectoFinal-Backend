package main.services;

import org.springframework.beans.factory.annotation.Autowired;

import main.dao.IEntradaDAO;

public class EntradaServices implements IEntradaService {

	@Autowired
	IEntradaDAO iEntradaDAO;
	
	@Override
	public List<Entrada> listarEntradas() {
		
		return iEntradaDAO.findAll();
	}

	@Override
	public Entrada buscarEntrada(Long id) {
		
		return iEntradaDAO.findById(id);
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
