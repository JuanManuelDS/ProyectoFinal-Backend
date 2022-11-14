package main.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plato_menus")
public class PlatoMenus {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_menu")
	private Menu menu;
	
	@ManyToOne
	@JoinColumn(name = "id_plato")
	private Plato plato;

	//------------------CONSTRUCTORES----------------------------
	
	public PlatoMenus() {
		
	}

	public PlatoMenus(Long id, Menu menu, Plato plato) {
		this.id = id;
		this.menu = menu;
		this.plato = plato;
	}

	//----------------GETTERS Y SETTERS------------------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	//------------------------TOSTRING-----------------------------
	
	@Override
	public String toString() {
		return "PlatoMenus [id=" + id + ", menu=" + menu + ", plato=" + plato + "]";
	}
	
	

}
