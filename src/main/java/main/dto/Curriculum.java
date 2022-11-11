package main.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="curriculums")
public class Curriculum  extends Plantilla{
	
	@Id
	@OneToOne
	@JoinColumn(name="nombre_archivo")
	private String nombre_archivo;
	
	@Column
	private String texto_presentacion;
	
	@Column
	private String imagen;
	
	@OneToMany
	@JoinColumn(name="nombre_archivo")
	private List<Estudios> estudios;
	
	@OneToOne
	@JoinColumn(name="nombre_archivo")
	private Datos datos;
	
	@OneToMany
	@JoinColumn(name="nombre_archivo")
	private List<Otro> otros;
	
	@OneToMany
	@JoinColumn(name="nombre_archivo")
	private List<ExperienciaLaboral> experienciaLaboral;
	
	@OneToMany
	@JoinColumn(name="nombre_archivo")
	private List<Idioma> idioma;
	
	// ----------------------CONSTRUCTORES---------------------------
	
	public Curriculum() {
		// TODO Auto-generated constructor stub
		this.nombre_archivo = super.getNombre_archivo();
	}

	public Curriculum(String texto_presentacion, String imagen) {
		super();
		this.nombre_archivo = super.getNombre_archivo();
		this.texto_presentacion = texto_presentacion;
		this.imagen = imagen;
	}
	
	// -----------------------GETTERS Y SETTERS-----------------------------

	public String getNombre_archivo() {
		return nombre_archivo;
	}

	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}

	public String getTexto_presentacion() {
		return texto_presentacion;
	}

	public void setTexto_presentacion(String texto_presentacion) {
		this.texto_presentacion = texto_presentacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Estudios")
	public List<Estudios> getEstudios() {
		return estudios;
	}

	public void setEstudios(List<Estudios> estudios) {
		this.estudios = estudios;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "Datos")
	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Otro")
	public List<Otro> getOtros() {
		return otros;
	}

	public void setOtros(List<Otro> otros) {
		this.otros = otros;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ExperienciaLaboral")
	public List<ExperienciaLaboral> getExperienciaLaboral() {
		return experienciaLaboral;
	}

	public void setIxperienciaLaboral(List<ExperienciaLaboral> experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Idioma")
	public List<Idioma> getIdioma() {
		return idioma;
	}

	public void setIdioma(List<Idioma> idioma) {
		this.idioma = idioma;
	}
	
	// --------------------------------TOSTRING-------------------------------

	@Override
	public String toString() {
		return "Curriculum [nombre_archivo=" + nombre_archivo + ", texto_presentacion=" + texto_presentacion
				+ ", imagen=" + imagen + "]";
	}
	
	
	
}
