package com.veterinaria.beans;

import java.util.Date;

public class Rol {

	private int idRol;
	private Date dateCreate;
	private String descripcion;
	private String estado;
	private String userCreate;

	//bi-directional many-to-one association to Usuario
//	private List<Usuario> usuarios;

	//bi-directional many-to-one association to RolOpcion
//	private List<RolOpcion> rolopcions;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
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

	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

}