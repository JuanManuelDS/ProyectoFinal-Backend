package main.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "plantillas")
public class Plantilla {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre_archivo")
	private String nombre_archivo;
	
	@Column(name = "firma")
	private String firma;
	
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	// ----------------------CONSTRUCTORES---------------------------
	
	public Plantilla() {
		
	}
	
	public Plantilla(Long id, String nombre_archivo, String firma, Usuario usuario) {
		//super();
		this.id = id;
		this.nombre_archivo = nombre_archivo;
		this.firma = firma;
		this.usuario = usuario;
	}

	// -----------------------GETTERS Y SETTERS-----------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre_archivo() {
		return nombre_archivo;
	}

	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	// --------------------------------TOSTRING-------------------------------

	@Override
	public String toString() {
		return "Plantilla [id=" + id + ", nombre_archivo=" + nombre_archivo + ", firma=" + firma + ", usuario="
				+ usuario + "]";
	}
	
}
