package main.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "otros")
public class Otro {

	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "nombre_archivo")
	private Curriculum curriculum;

	// ----------------------CONSTRUCTORES---------------------------
	
	public Otro() {
		
	}

	public Otro(Long id, String descripcion, Curriculum curriculum) {
		//super();
		this.id = id;
		this.descripcion = descripcion;
		this.curriculum = curriculum;
	}
	
	// Constructor los Super Fields

	// -----------------------GETTERS Y SETTERS-----------------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
	
	// --------------------------------TOSTRING-------------------------------

	@Override
	public String toString() {
		return "Otro [id=" + id + ", descripcion=" + descripcion + ", curriculum=" + curriculum + "]";
	}
	
}
