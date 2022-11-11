package main.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="curriculums")
public class Curriculum {
	
	@Id
	@OneToOne
	@JoinColumn(name="nombre_archivo")
	private Plantilla plantilla;
	
	@Column
	private String texto_presentacion;
	
	@Column
	private String imagen;
	
	@OneToMany
	@JoinColumn(name="nombre_archivo")
	private List<Estudios> estudios;
	
	@OneToOne
	@JoinColumn(name="nombre_archivo")
	private List<Datos> datos;
	
	@OneToMany
	@JoinColumn(name="nombre_archivo")
	private List<Otros> otros;
	
	@OneToMany
	@JoinColumn(name="nombre_archivo")
	private List<ExperienciaLaboral> ixperienciaLaboral;
	
	@OneToMany
	@JoinColumn(name="nombre_archivo")
	private List<Idioma> idioma;
	
	public Curriculum() {
		// TODO Auto-generated constructor stub
	}

	public Curriculum(String nombre_archivo, String texto_presentacion) {
		super();
		this.nombre_archivo = nombre_archivo;
		this.texto_presentacion = texto_presentacion;
		this.imagen = imagen;
		this.estudios = estudios;
	}

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

	public List<Estudios> getEstudios() {
		return estudios;
	}

	public void setEstudios(List<Estudios> estudios) {
		this.estudios = estudios;
	}

	public List<Datos> getDatos() {
		return datos;
	}

	public void setDatos(List<Datos> datos) {
		this.datos = datos;
	}

	public List<Otros> getOtros() {
		return otros;
	}

	public void setOtros(List<Otros> otros) {
		this.otros = otros;
	}

	public List<ExperienciaLaboral> getIxperienciaLaboral() {
		return ixperienciaLaboral;
	}

	public void setIxperienciaLaboral(List<ExperienciaLaboral> ixperienciaLaboral) {
		this.ixperienciaLaboral = ixperienciaLaboral;
	}

	public List<Idioma> getIdioma() {
		return idioma;
	}

	public void setIdioma(List<Idioma> idioma) {
		this.idioma = idioma;
	}

	@Override
	public String toString() {
		return "Curriculum [nombre_archivo=" + nombre_archivo + ", texto_presentacion=" + texto_presentacion
				+ ", imagen=" + imagen + ", estudios=" + estudios + ", datos=" + datos + "]";
	}
	
	
	
}
