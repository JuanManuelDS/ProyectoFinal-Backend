package main.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import main.dao.IUsuarioDAO;
import main.dto.Rol;
import main.dto.Usuario;
import main.dto.UsuarioRol;

@Service
public class UsuarioService implements IUsuarioServices, UserDetailsService{

	@Autowired
	IUsuarioDAO iUsuarioDAO;
	
	@Autowired
	UsuarioRolService usuarioRolService;
		
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		Usuario usuario = iUsuarioDAO.findByNombreUsuario(nombreUsuario);
		if (usuario == null) {
			throw new UsernameNotFoundException(nombreUsuario);
		}
		//Creo una colección que contrendrá los roles del usuario
		Collection<SimpleGrantedAuthority> autoridades = new ArrayList<>();
		
		//Busco todos los roles que posee el usuario
		List<UsuarioRol> rolesUsuario = usuarioRolService.buscarRolesUsuario(usuario);
		rolesUsuario.forEach(rolUsuario -> {
			// Retorno el rol
			Rol rol = rolUsuario.getRol();
			// Retorno el nombre del rol del usuario y lo agrego a la lista de "autoridades"
			autoridades.add(new SimpleGrantedAuthority("ROLE_" + rol.getName()));
		});
		return new User(usuario.getNombreUsuario(), usuario.getContrasena(), autoridades);
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

	@Override
	public Page<Usuario> listarUsuarios(Pageable pageable) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.findAll(pageable);
	}
}
