package main.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "secciones")
public class Secciones {

	// Atributos
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "imagen")
	private String imagen;
	
	@OneToOne
	@JoinColumn(name="nombre_archivo")
	private CartasRestaurantes cartas_restaurantes;

	@OneToMany
	@JoinColumn(name="platos")
	private List<Plato> platos;
	
	// ----------------------CONSTRUCTORES---------------------------
	
		public Secciones() {
			
		}

		public Secciones(Long id, String nombre, String imagen, CartasRestaurantes cartas_restaurantes) {
			//super();
			this.id = id;
			this.nombre = nombre;
			this.imagen = imagen;
			this.cartas_restaurantes = cartas_restaurantes;
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
	
		public CartasRestaurantes getCartas() {
			return cartas_restaurantes;
		}

		public void setCartas(CartasRestaurantes cartas_restaurantes) {
			this.cartas_restaurantes = cartas_restaurantes;
		}
		
		// --------------------------------TOSTRING-------------------------------
		
		@Override
		public String toString() {
			return "Menu [id=" + id + "nombre=" + nombre + ", imagen=" + imagen + ", cartas_restaurantes=" + cartas_restaurantes + "]";
		}
		
}