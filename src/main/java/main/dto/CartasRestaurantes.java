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
	@JoinColumn(name="id")
	private Long id;
	
	@Column
	private String nombre_restaurante;
	
	@OneToMany
	@JoinColumn
	private List<Menu> menus;
	
	@OneToMany
	@JoinColumn
	private List<Secciones> secciones;
	

	// ----------------------CONSTRUCTORES---------------------------
	
	public CartasRestaurantes() {
		this.id = super.getId();
	}

	public CartasRestaurantes(String nombre_restaurante) {
		super();
		this.id = super.getId();
		this.nombre_restaurante = nombre_restaurante;
	}

	// -----------------------GETTERS Y SETTERS-----------------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Secciones")
	public List<Secciones> getSecciones() {
		return secciones;
	}

	public void setSecciones(List<Secciones> secciones) {
		this.secciones = secciones;
	}

	// --------------------------------TOSTRING-------------------------------
	
	@Override
	public String toString() {
		return "CartasRestaurantes [id=" + id + ", nombre_restaurante=" + nombre_restaurante + "]";
	}
}
