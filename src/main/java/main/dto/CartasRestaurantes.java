package main.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cartas_restaurantes")
public class CartasRestaurantes {

	@Id
	@OneToOne
	@JoinColumn(name="nombre_archivo")
	private Plantilla plantilla;
	
	@Column
	private String nombre_restaurante;

	public CartasRestaurantes(Plantilla plantilla, String nombre_restaurante) {
		super();
		this.plantilla = plantilla;
		this.nombre_restaurante = nombre_restaurante;
	}

	public Plantilla getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(Plantilla plantilla) {
		this.plantilla = plantilla;
	}

	public String getNombre_restaurante() {
		return nombre_restaurante;
	}

	public void setNombre_restaurante(String nombre_restaurante) {
		this.nombre_restaurante = nombre_restaurante;
	}

	@Override
	public String toString() {
		return "CartasRestaurantes [plantilla=" + plantilla + ", nombre_restaurante=" + nombre_restaurante + "]";
	}
	
	
	
}
