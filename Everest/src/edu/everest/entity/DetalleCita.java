package edu.everest.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the detallecita database table.
 * 
 */
@Entity
@NamedQuery(name="DetalleCita.findAll", query="SELECT d FROM DetalleCita d")
public class DetalleCita implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleCitaPK id;

	private double costo;

	private String observaciones;

	private String pelo;

	private String tamano;

	@Temporal(TemporalType.TIME)
	private Calendar tiempoAprox;
	
	@Transient
		private String strTiempoAprox;
	
	//bi-directional many-to-one association to Cita
	@ManyToOne
	@JoinColumn(name="idCita", referencedColumnName="idCita")
	private Cita cita;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idServicio", referencedColumnName="idServicio")
	private Servicio servicio;

	public DetalleCita() {
	}

	public DetalleCitaPK getId() {
		return this.id;
	}

	public void setId(DetalleCitaPK id) {
		this.id = id;
	}

	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPelo() {
		return this.pelo;
	}

	public void setPelo(String pelo) {
		this.pelo = pelo;
	}

	public String getTamano() {
		return this.tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public Calendar getTiempoAprox() {
		return this.tiempoAprox;
	}

	public void setTiempoAprox(Calendar tiempoAprox) {
		this.tiempoAprox = tiempoAprox;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public String getStrTiempoAprox() {
		return strTiempoAprox;
	}

	public void setStrTiempoAprox(String strTiempoAprox) {
		this.strTiempoAprox = strTiempoAprox;
	}

}