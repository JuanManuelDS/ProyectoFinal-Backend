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
@Table(name="entradas")
public class Entrada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private Long unidades;
	
	@ManyToOne
	@JoinColumn(name="listado")
	private Listado listado;

	public Entrada(Long id, String nombre, Long unidades, Listado listado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.unidades = unidades;
		this.listado = listado;
	}
	
	public Entrada() {
		// TODO Auto-generated constructor stub
	}

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

	public Long getUnidades() {
		return unidades;
	}

	public void setUnidades(Long unidades) {
		this.unidades = unidades;
	}

	public Listado getListado() {
		return listado;
	}

	public void setListado(Listado listado) {
		this.listado = listado;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", nombre=" + nombre + ", unidades=" + unidades + "]";
	}
	
	
}
