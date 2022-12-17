package main.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nombre_usuario")
	private String nombreUsuario;
	
	@Column(name = "contrasena")
	private String contrasena;
	
	@Column(name="last_login")
	private String lastLogin;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<UsuarioRol> roles;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY, mappedBy="usuario")
	private List<Plantilla> plantillas;
	
	//------------------CONSTRUCTORES----------------------------

	public Usuario() {
		
	}

	public Usuario(Long id, String email, String nombreUsuario, String contrasena, String lastLogin,
			List<UsuarioRol> roles, List<Plantilla> plantillas) {
		this.id = id;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.lastLogin = lastLogin;
		this.roles = roles;
		this.plantillas = plantillas;
	}



	//----------------GETTERS Y SETTERS------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@JsonIgnore
	public List<Plantilla> getPlantillas() {
		return plantillas;
	}

	public void setPlantillas(List<Plantilla> plantillas) {
		this.plantillas = plantillas;
	}
	
	@JsonIgnore
	public List<UsuarioRol> getRoles() {
		return roles;
	}

	public void setRoles(List<UsuarioRol> roles) {
		this.roles = roles;
	}
	
	
	

	public String getLastLogin() {
		return lastLogin;
	}



	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}





	//------------------------TOSTRING-----------------------------

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", nombreUsuario=" + nombreUsuario + ", lastLogin="
				+ lastLogin + "]";
	}
	

}
