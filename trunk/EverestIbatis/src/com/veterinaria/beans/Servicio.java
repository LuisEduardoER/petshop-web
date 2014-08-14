package com.veterinaria.beans;

import java.io.Serializable;
import java.util.Date;

public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	private String idServicio;
	private double costoRef;
	private Date dateCreate;
	private String descripcion;
	private String estado;
	private Date tiempoAprox;
	private String userCreate;
	
	private String strTiempoAprox;

	//bi-directional many-to-one association to DetalleCita
//	private List<DetalleCita> detalleCitas;

	//bi-directional many-to-one association to DetalleCobro
//	private List<DetalleCobro> detalleCobros;

	public Servicio() {
	}

	public String getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	public double getCostoRef() {
		return this.costoRef;
	}

	public void setCostoRef(double costoRef) {
		this.costoRef = costoRef;
	}

	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getTiempoAprox() {
		return this.tiempoAprox;
	}

	public void setTiempoAprox(Date tiempoAprox) {
		this.tiempoAprox = tiempoAprox;
	}

	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public String getStrTiempoAprox() {
		return strTiempoAprox;
	}

	public void setStrTiempoAprox(String strTiempoAprox) {
		this.strTiempoAprox = strTiempoAprox;
	}

}