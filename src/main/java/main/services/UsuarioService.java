package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IUsuarioDAO;
import main.dto.Usuario;

@Service
public class UsuarioService implements IUsuarioServices{

	@Autowired
	IUsuarioDAO iUsuarioDAO;

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return iUsuarioDAO.findAll();
	}

	@Override
	public Usuario buscarUsuario(Long id) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.findById(id).get();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) {
		// TODO Auto-generated method stub
		iUsuarioDAO.deleteById(id);
	}

	@Override
	public Usuario buscarUsuarioPorEmail(String email) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.findByEmail(email);
	}

	@Override
	public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.findByNombreUsuario(nombreUsuario);
	}
}
