package com.veterinaria.beans;

import java.io.Serializable;
import java.util.Date;

public class DetalleCita implements Serializable {
	private static final long serialVersionUID = 1L;

	private String idCita;
	private int idServicio;
	
	private double costo;
	private String observaciones;
	private String pelo;
	private String tamano;
	private Date tiempoAprox;
	private String strTiempoAprox;
	
	//bi-directional many-to-one association to Cita
	private Cita cita;

	//bi-directional many-to-one association to Servicio
	private Servicio servicio;

	public DetalleCita() {
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

	public Date getTiempoAprox() {
		return this.tiempoAprox;
	}

	public void setTiempoAprox(Date tiempoAprox) {
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

	public String getIdCita() {
		return idCita;
	}

	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

}