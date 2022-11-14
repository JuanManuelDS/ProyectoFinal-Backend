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
	@JoinColumn(name="id")
	private Long id;

	@Column
	private String titulo;
	
	@OneToMany
	@JoinColumn
	private List<Entrada> entradas;

	// ----------------------CONSTRUCTORES---------------------------
	
		public Listado() {
			this.id = super.getId();
		}

		public Listado(String titulo) {
			super();
			this.id = super.getId();
			this.titulo = titulo;
		}

		// -----------------------GETTERS Y SETTERS-----------------------------

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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
			return "Listado [id=" + id + ", titulo=" + titulo + "]";
		}
}