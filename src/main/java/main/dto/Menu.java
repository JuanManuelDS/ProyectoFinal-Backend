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
@Table(name = "menus")
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
	private double precioMenu;

	@ManyToOne
	@JoinColumn(name = "carta")
	private CartasRestaurantes carta;

	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	private List<PlatoMenu> platoMenus;

	// ----------------------CONSTRUCTORES---------------------------

	public Menu() {

	}

	public Menu(Long id, String nombre, String imagen, Double precio_menu, CartasRestaurantes cartas_restaurantes) {
		// super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.precioMenu = precio_menu;
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

	public double getPrecioMenu() {
		return precioMenu;
	}

	public void setPrecioMenu(double precioMenu) {
		this.precioMenu = precioMenu;
	}

	public CartasRestaurantes getCarta() {
		return carta;
	}

	public void setCarta(CartasRestaurantes carta) {
		this.carta = carta;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<PlatoMenu> getPlatoMenus() {
		return platoMenus;
	}

	public void setPlato_menu(List<PlatoMenu> platoMenus) {
		this.platoMenus = platoMenus;
	}


	// --------------------------------TOSTRING-------------------------------

	@Override
	public String toString() {
		return "Menu [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", precioMenu=" + precioMenu
				+ ", carta=" + carta + ", platoMenus=" + platoMenus + "]";
	}

}