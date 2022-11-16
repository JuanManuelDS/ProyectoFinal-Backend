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
@Table(name = "secciones")
public class Seccion {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "imagen")
	private String imagen;

	@ManyToOne
	@JoinColumn(name = "carta")
	private CartasRestaurantes cartaRestaurante;

	@OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL)
	private List<Plato> platos;

	// ----------------------CONSTRUCTORES---------------------------

	public Seccion() {

	}

	public Seccion(Long id, String nombre, String imagen, CartasRestaurantes cartaRestaurante, List<Plato> platos) {
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.cartaRestaurante = cartaRestaurante;
		this.platos = platos;
	}

	// -----------------------GETTERS Y SETTERS-----------------------------

	public Long getId() {
		return id;
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

	public CartasRestaurantes getCartaRestaurante() {
		return cartaRestaurante;
	}

	public void setCartaRestaurante(CartasRestaurantes cartaRestaurante) {
		this.cartaRestaurante = cartaRestaurante;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}

	// --------------------------------TOSTRING-------------------------------

	@Override
	public String toString() {
		return "Seccion [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", cartaRestaurante="
				+ cartaRestaurante + ", platos=" + platos + "]";
	}

}