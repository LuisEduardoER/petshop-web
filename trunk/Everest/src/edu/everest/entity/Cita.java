package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;


/**
 * The persistent class for the cita database table.
 * 
 */
@Entity
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCita;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateCreate;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Calendar fecProg;

	@Temporal(TemporalType.TIME)
	private Calendar hourProg;

	private String userCreate;

	//bi-directional many-to-one association to Mascota
	@ManyToOne
	@JoinColumn(name="idMascota")
	private Mascota mascota;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idServicio")
	private Servicio servicio;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="idMedico")
	private Medico medico;
	
	@Transient
	private String descripcion;

	public Cita() {
	}

	public int getIdCita() {
		return this.idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public Calendar getCalendarCreate() {
		return this.dateCreate;
	}

	public void setCalendarCreate(Calendar dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Calendar getFecProg() {
		return this.fecProg;
	}

	public void setFecProg(Calendar fecProg) {
		this.fecProg = fecProg;
	}

	public Calendar getHourProg() {
		return this.hourProg;
	}

	public void setHourProg(Calendar hourProg) {
		this.hourProg = hourProg;
	}

	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public Mascota getMascota() {
		return this.mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}