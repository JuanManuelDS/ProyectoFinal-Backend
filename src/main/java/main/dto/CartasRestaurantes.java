package main.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cartas_restaurantes")
public class CartasRestaurantes extends Plantilla{

	// Atributos
	@Id
	@OneToOne
	@JoinColumn(name="nombre_archivo")
	private String nombre_archivo;
	
	@Column
	private String nombre_restaurante;
	
	@ManyToOne
	@JoinColumn
	private List<Menu> menus;
	
	@ManyToOne
	@JoinColumn
	private List<Seccion> secciones;
	

	// ----------------------CONSTRUCTORES---------------------------
	
	public CartasRestaurantes() {
		this.nombre_archivo = super.getNombre_archivo();
	}

	public CartasRestaurantes(String nombre_restaurante) {
		super();
		this.nombre_archivo = super.getNombre_archivo();
		this.nombre_restaurante = nombre_restaurante;
	}

	// -----------------------GETTERS Y SETTERS-----------------------------
	
	public String getNombre_archivo() {
		return nombre_archivo;
	}

	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}

	public String getNombre_restaurante() {
		return nombre_restaurante;
	}

	public void setNombre_restaurante(String nombre_restaurante) {
		this.nombre_restaurante = nombre_restaurante;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Menu")
	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Seccion")
	public List<Seccion> getSecciones() {
		return secciones;
	}

	public void setSecciones(List<Seccion> secciones) {
		this.secciones = secciones;
	}

	// --------------------------------TOSTRING-------------------------------
	
	@Override
	public String toString() {
		return "CartasRestaurantes [nombre_archivo=" + nombre_archivo + ", nombre_restaurante=" + nombre_restaurante
				+ "]";
	}
}
