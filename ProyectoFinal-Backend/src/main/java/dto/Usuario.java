package dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String email;
	
	@Column(name = "nombre_usuario")
	private String nombre_usuario;
	
	@Column(name = "contrasena")
	private String contrasena;
	
	@OneToMany
	@JoinColumn(name = "email")
	private List<Plantilla> plantillas;
	

	public Usuario() {
		
	}
	
	//------------------CONSTRUCTORES----------------------------

	public Usuario(String email, String nombre_usuario, String contrasena) {
		//super();
		this.email = email;
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contrasena;
	}
	
	//----------------GETTERS Y SETTERS------------------------------

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Plantilla")
	public List<Plantilla> getPlantillas() {
		return plantillas;
	}

	public void setPlantillas(List<Plantilla> plantillas) {
		this.plantillas = plantillas;
	}

	//------------------------TOSTRING-----------------------------
	
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre_usuario=" + nombre_usuario + ", contrasena=" + contrasena + "]";
	}

}
