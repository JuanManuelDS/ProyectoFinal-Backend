package main.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "experiencia_laboral")
public class ExperienciaLaboral {
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "puesto")
	private String puesto;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date fecha_inicio;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date fecha_fin;
	
	@ManyToOne
	@JoinColumn(name = "nombre_archivo")
	private Curriculum curriculum;
	
	// ----------------------CONSTRUCTORES---------------------------
	
	public ExperienciaLaboral() {
		//super();
	}

	public ExperienciaLaboral(Long id, String puesto, String descripcion, Date fecha_inicio, Date fecha_fin,
			Curriculum curriculum) {
		//super();
		this.id = id;
		this.puesto = puesto;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.curriculum = curriculum;
	}
	
	// -----------------------GETTERS Y SETTERS-----------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
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
		return "ExperienciaLaboral [id=" + id + ", puesto=" + puesto + ", descripcion=" + descripcion
				+ ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", curriculum=" + curriculum + "]";
	}
	
}
