package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "idiomas")
public class Idiomas {

	// Atributos
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "idioma")
	private String idioma;
	
	@Column(name = "nivel_escrito ")
	private String nivel_escrito ;
	
	@Column(name = "nivel_oral  ")
	private String nivel_oral  ;

	@OneToOne
	@JoinColumn(name="curriculum")
	private Curriculum curriculum;


	// ----------------------CONSTRUCTORES---------------------------
	
	public Idiomas() {
		
	}

	public Idiomas(Long id, String idioma, String nivel_escrito, String nivel_oral, Curriculum curriculum) {
		//super();
		this.id = id;
		this.idioma = idioma;
		this.nivel_escrito = nivel_escrito;
		this.nivel_oral = nivel_oral;
		this.curriculum = curriculum;
	}
	
	// -----------------------GETTERS Y SETTERS-----------------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getNivelEscrito() {
		return nivel_escrito;
	}

	public void setNivelEscrito(String nivel_escrito) {
		this.nivel_escrito = nivel_escrito;
	}
	
	public String getNivelOral() {
		return nivel_oral;
	}

	public void setNivelOral(String nivel_oral) {
		this.nivel_oral = nivel_oral;
	}
	
	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculim(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
	
	// --------------------------------TOSTRING-------------------------------
	@Override
	public String toString() {
		return "Idiomas [id=" + id + "idioma=" + idioma + ", nivel escrito=" + nivel_escrito + ", nivel oral=" + nivel_oral + ", curriculum=" + curriculum + "]";
	}
	
