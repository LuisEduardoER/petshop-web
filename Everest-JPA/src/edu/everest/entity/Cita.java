package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


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
	private String idCita;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreate;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Calendar fecProg;

	@Temporal(TemporalType.TIME)
	private Calendar hourProg;

	private String userCreate;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Mascota
	@ManyToOne
	@JoinColumn(name="idMascota")
	private Mascota mascota;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="idMedico")
	private Medico medico;

	//bi-directional many-to-one association to DetalleCita
	@OneToMany(mappedBy="cita")
	private List<DetalleCita> detalleCitas;

	public Cita() {
	}

	public String getIdCita() {
		return this.idCita;
	}

	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}

	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Mascota getMascota() {
		return this.mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<DetalleCita> getDetalleCitas() {
		return this.detalleCitas;
	}

	public void setDetalleCitas(List<DetalleCita> detalleCitas) {
		this.detalleCitas = detalleCitas;
	}

	public DetalleCita addDetalleCita(DetalleCita detalleCita) {
		getDetalleCitas().add(detalleCita);
		detalleCita.setCita(this);

		return detalleCita;
	}

	public DetalleCita removeDetalleCita(DetalleCita detalleCita) {
		getDetalleCitas().remove(detalleCita);
		detalleCita.setCita(null);

		return detalleCita;
	}

}