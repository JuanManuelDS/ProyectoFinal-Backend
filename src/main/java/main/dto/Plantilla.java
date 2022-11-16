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
	
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "plantilla", cascade = CascadeType.ALL)
	private List<CartasRestaurantes> cartasRestaurantes;
	
	@OneToMany(mappedBy = "plantilla", cascade = CascadeType.ALL)
	private List<Curriculum> curriculums;
	
	@OneToMany(mappedBy = "plantilla", cascade = CascadeType.ALL)
	private List<Listado> listados;
	
	// ----------------------CONSTRUCTORES---------------------------
	
	public Plantilla() {
		
	}
	
	public Plantilla(Long id, String nombre_archivo, String firma, Usuario usuario) {
		//super();
		this.id = id;
		this.nombreArchivo = nombre_archivo;
		this.firma = firma;
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
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<CartasRestaurantes> getCartasRestaurantes() {
		return cartasRestaurantes;
	}

	public void setCartasRestaurantes(List<CartasRestaurantes> cartasRestaurantes) {
		this.cartasRestaurantes = cartasRestaurantes;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Curriculum> getCurriculums() {
		return curriculums;
	}

	public void setCurriculums(List<Curriculum> curriculums) {
		this.curriculums = curriculums;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Listado> getListados() {
		return listados;
	}

	public void setListados(List<Listado> listados) {
		this.listados = listados;
	}

	public Long getId() {
		return id;
	}
	
	// --------------------------------TOSTRING-------------------------------

	@Override
	public String toString() {
		return "Plantilla [id=" + id + ", nombre_archivo=" + nombreArchivo + ", firma=" + firma + ", usuario="
				+ usuario + "]";
	}

	
	
}
