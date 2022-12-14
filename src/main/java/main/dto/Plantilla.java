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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "plantillas")
public class Plantilla {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre_archivo")
	private String nombreArchivo;
	
	@Column
	private String firma;
	
	@Column
	private String tipo;
	
	@Column 
	private String datos;
	
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	
	
	// ----------------------CONSTRUCTORES---------------------------
	
	public Plantilla() {
		
	}

	
	public Plantilla(Long id, String nombreArchivo, String firma, String tipo, String data, Usuario usuario) {
		//super();
		this.id = id;
		this.nombreArchivo = nombreArchivo;
		this.firma = firma;
		this.tipo = tipo;
		this.datos = data;
		this.usuario = usuario;
	}

	// -----------------------GETTERS Y SETTERS-----------------------------

	public String getNombre_archivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
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

	public Long getId() {
		return id;
	}
	
	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getData() {
		return datos;
	}


	public void setData(String data) {
		this.datos = data;
	}


	public String getNombreArchivo() {
		return nombreArchivo;
	}


	// --------------------------------TOSTRING-------------------------------
	@Override
	public String toString() {
		return "Plantilla [id=" + id + ", nombre_archivo=" + nombreArchivo + ", firma=" + firma + ", usuario="
				+ usuario + "]";
	}

	
	
}
