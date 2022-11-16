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
@Table(name="cartas_restaurantes")
public class CartaRestaurante {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre_restaurante;
	
	@ManyToOne
	@JoinColumn(name="plantilla")
	private Long plantilla;
	
	@OneToMany(mappedBy = "cartaRestaurante", cascade = CascadeType.ALL)
	private List<Menu> menus;
	
	@OneToMany(mappedBy = "cartaRestaurante", cascade = CascadeType.ALL)
	private List<Seccion> secciones;
	

	// ----------------------CONSTRUCTORES---------------------------
	
	public CartaRestaurante() {
		
	}

	public CartaRestaurante(Long id, String nombre_restaurante, Long plantilla, List<Menu> menus,
			List<Seccion> secciones) {
		this.id = id;
		this.nombre_restaurante = nombre_restaurante;
		this.plantilla = plantilla;
		this.menus = menus;
		this.secciones = secciones;
	}


	// -----------------------GETTERS Y SETTERS-----------------------------
	
	public Long getId() {
		return id;
	}

	public String getNombre_restaurante() {
		return nombre_restaurante;
	}

	public void setNombre_restaurante(String nombre_restaurante) {
		this.nombre_restaurante = nombre_restaurante;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Seccion> getSecciones() {
		return secciones;
	}

	public void setSecciones(List<Seccion> secciones) {
		this.secciones = secciones;
	}


	// --------------------------------TOSTRING-------------------------------
	@Override
	public String toString() {
		return "CartasRestaurantes [id=" + id + ", nombre_restaurante=" + nombre_restaurante + ", plantilla="
				+ plantilla + ", menus=" + menus + ", secciones=" + secciones + "]";
	}

	
	
}
