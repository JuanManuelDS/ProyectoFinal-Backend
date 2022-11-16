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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "platos")
public class Plato {

	// Atributos
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "nombre")
		private String nombre;
		
		@Column(name = "imagen")
		private String imagen;
		
		@Column(name = "descripcion")
		private String descripcion;
		
		@Column(name = "precio")
		private int precio;
		
		@ManyToOne
		@JoinColumn
		private Seccion seccion;
		
		@OneToMany
		@JoinColumn
		private List<PlatoMenus> platoMenus;

		// ----------------------CONSTRUCTORES---------------------------
		
		public Plato() {
			
		}

		public Plato(Long id, String nombre, String imagen, String descripcion, int precio, Seccion seccion) {
			this.id = id;
			this.nombre = nombre;
			this.imagen = imagen;
			this.descripcion = descripcion;
			this.precio = precio;
			this.seccion = seccion;
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

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}

		public Seccion getSeccion() {
			return seccion;
		}

		public void setSeccion(Seccion seccion) {
			this.seccion = seccion;
		}
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "PlatoMenus")
		public List<PlatoMenus> getPlatoMenus() {
			return platoMenus;
		}

		public void setPlatoMenus(List<PlatoMenus> platoMenus) {
			this.platoMenus = platoMenus;
		}

		// --------------------------------TOSTRING-------------------------------

		@Override
		public String toString() {
			return "Plato [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", descripcion=" + descripcion
					+ ", precio=" + precio + ", seccion=" + seccion + "]";
		}

		
		
		
		
}
