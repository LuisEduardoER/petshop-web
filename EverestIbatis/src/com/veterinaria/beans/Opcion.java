package com.veterinaria.beans;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the opcion database table.
 * 
 */

public class Opcion{

	private int idOpcion;
	private int parentOpcionId;
	private Date dateCreate;
	private String descripcion;
	private String estado;
	private int orden;
	private String titulo;
	private String url;
	private String userCreate;

	//bi-directional many-to-one association to Opcion
	private Opcion opcion;

	//bi-directional many-to-one association to Opcion
	private List<Opcion> opcions;

	//bi-directional many-to-one association to RolOpcion
//	private List<RolOpcion> rolopcions;

	public Opcion() {
	}

	public int getIdOpcion() {
		return this.idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
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

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public Opcion getOpcion() {
		return this.opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	public List<Opcion> getOpcions() {
		return opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public int getParentOpcionId() {
		return parentOpcionId;
	}

	public void setParentOpcionId(int parentOpcionId) {
		this.parentOpcionId = parentOpcionId;
	}

}