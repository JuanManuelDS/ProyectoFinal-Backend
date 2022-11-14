package main.dto;

import java.util.List;

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
@Table(name = "menu")
public class Menu {

	// Atributos
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "imagen")
	private String imagen;
	
	@Column(name = "precio_menu")
	private double precio_menu;
	
	@ManyToOne
	@JoinColumn(name="carta")
	private CartasRestaurantes carta;

	@OneToMany
	@JoinColumn(name="PlatoMenu")
	private List<PlatoMenus> plato_menu;


	// ----------------------CONSTRUCTORES---------------------------
	
	public Menu() {
		
	}

	public Menu(Long id, String nombre, String imagen, Double precio_menu, CartasRestaurantes cartas_restaurantes) {
		//super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.precio_menu = precio_menu;
		this.carta = cartas_restaurantes;
	}
	
	// -----------------------GETTERS Y SETTERS-----------------------------

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getPrecio_menu() {
		return precio_menu;
	}

	public void setPrecio_menu(double precio_menu) {
		this.precio_menu = precio_menu;
	}

	public CartasRestaurantes getCarta() {
		return carta;
	}

	public void setCarta(CartasRestaurantes carta) {
		this.carta = carta;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "PlatoMenus")
	public List<PlatoMenus> getPlato_menu() {
		return plato_menu;
	}

	public void setPlato_menu(List<PlatoMenus> plato_menu) {
		this.plato_menu = plato_menu;
	}
	

	// --------------------------------TOSTRING-------------------------------
	
	
	@Override
	public String toString() {
		return "Menu [id=" + id + "nombre=" + nombre + ", imagen=" + imagen + ", precio_menu=" + precio_menu + ", carta_restaurante=" + carta + "]";
	}
	
}