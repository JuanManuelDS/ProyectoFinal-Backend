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
@Table(name = "listado")
public class Listado {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String titulo;

	@ManyToOne
	@JoinColumn(name="plantilla")
	private Plantilla plantilla;
	
	@OneToMany(mappedBy = "listado", cascade = CascadeType.ALL)
	private List<Entrada> entradas;

	// ----------------------CONSTRUCTORES---------------------------

	public Listado() {
	}

	public Listado(Long id, String titulo, Plantilla plantilla, List<Entrada> entradas) {
		this.id = id;
		this.titulo = titulo;
		this.plantilla = plantilla;
		this.entradas = entradas;
	}

	// -----------------------GETTERS Y SETTERS-----------------------------

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Plantilla getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(Plantilla plantilla) {
		this.plantilla = plantilla;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Long getId() {
		return id;
	}


	// --------------------------------TOSTRING-------------------------------

	
	@Override
	public String toString() {
		return "Listado [id=" + id + ", titulo=" + titulo + ", plantilla=" + plantilla + ", entradas=" + entradas + "]";
	}

	
	
}