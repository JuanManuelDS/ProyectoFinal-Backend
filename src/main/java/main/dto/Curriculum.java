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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="curriculums")
public class Curriculum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String texto_presentacion;
	
	@Column
	private String imagen;
	
	@ManyToOne
	@JoinColumn(name="plantilla")
	private Plantilla plantilla;
	
	@OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
	private List<Estudios> estudios;
	
	@OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
	private Datos datos;
	
	@OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
	private List<Otro> otros;
	
	@OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
	private List<ExperienciaLaboral> experienciaLaboral;
	
	@OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
	private List<Idioma> idioma;
	
	// ----------------------CONSTRUCTORES---------------------------
	
	public Curriculum() {
		
	}
	
	public Curriculum(Long id, String texto_presentacion, String imagen) {
		this.id = id;
		this.texto_presentacion = texto_presentacion;
		this.imagen = imagen;
	}

	// -----------------------GETTERS Y SETTERS-----------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	@OneToMany(fetch = FetchType.LAZY)
	public List<Estudios> getEstudios() {
		return estudios;
	}

	public void setEstudios(List<Estudios> estudios) {
		this.estudios = estudios;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Otro> getOtros() {
		return otros;
	}

	public void setOtros(List<Otro> otros) {
		this.otros = otros;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<ExperienciaLaboral> getExperienciaLaboral() {
		return experienciaLaboral;
	}

	public void setExperienciaLaboral(List<ExperienciaLaboral> experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Idioma> getIdioma() {
		return idioma;
	}

	public void setIdioma(List<Idioma> idioma) {
		this.idioma = idioma;
	}

	
	// --------------------------------TOSTRING-------------------------------

	@Override
	public String toString() {
		return "Curriculum [id=" + id + ", texto_presentacion=" + texto_presentacion + ", imagen=" + imagen
				+ ", plantilla=" + plantilla + ", estudios=" + estudios + ", datos=" + datos + ", otros=" + otros
				+ ", experienciaLaboral=" + experienciaLaboral + ", idioma=" + idioma + "]";
	}
	
}
