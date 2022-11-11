package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "menu")
public class Menu {

	// Atributos
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "imagen")
	private String imagen;
	
	@Column(name = "precio_menu")
	private double precio_menu;
	
	@OneToOne
	@JoinColumn(name="cartas_restaurantes")
	private Cartas_restaurantes cartas_restaurantes;

	@OneToMany
	@JoinColumn(name="PlatoMenu")
	private List<PlatoMenu> plato_menu;


	// ----------------------CONSTRUCTORES---------------------------
	
	public Menu() {
		
	}

	public Menu(Long id, String nombre, String imagen, Double precio_menu, Cartas_restaurantes cartas_restaurantes) {
		//super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.precio_menu = precio_menu;
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

	public Double getPrecio() {
		return precio_menu;
	}

	public void setPrecio(Double precio_menu) {
		this.precio_menu = precio_menu;
	}
	
	public Cartas_restaurantes getCartas() {
		return cartas_restaurantes;
	}

	public void setCartas(Cartas_restaurantes cartas_restaurantes) {
		this.cartas_restaurantes = cartas_restaurantes;
	}

	// --------------------------------TOSTRING-------------------------------
	
	@Override
	public String toString() {
		return "Menu [id=" + id + "nombre=" + nombre + ", imagen=" + imagen + ", precio_menu=" + precio_menu + ", nombre_archivo=" + cartas_restaurantes + "]";
	}
	
}