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
@Table(name="listado")
public class Listado extends Plantilla{

	// Atributos
	@Id
	@OneToOne
	@JoinColumn(name="nombre_archivo")
	private String nombre_archivo;
	
	@Column
	private String titulo;
	
	@ManyToOne
	@JoinColumn
	private List<Entrada> entradas;

	

	// ----------------------CONSTRUCTORES---------------------------
	
		public Listado() {
			this.nombre_archivo = super.getNombre_archivo();
		}

		public Listado(String titulo) {
			super();
			this.nombre_archivo = super.getNombre_archivo();
			this.titulo = titulo;
		}

		// -----------------------GETTERS Y SETTERS-----------------------------
		
		public String getNombre_archivo() {
			return nombre_archivo;
		}

		public void setNombre_archivo(String nombre_archivo) {
			this.nombre_archivo = nombre_archivo;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Entrada")
		public List<Entrada> getEntradas() {
			return entradas;
		}

		public void setEntradas(List<Entrada> entradas) {
			this.entradas = entradas;
		}
		
		// --------------------------------TOSTRING-------------------------------
		
		@Override
		public String toString() {
			return "Listadp [nombre_archivo=" + nombre_archivo + ", titulo=" + titulo
					+ "]";
		}
}