package com.veterinaria.beans;

import org.apache.tomcat.jni.Local;

public class Medico {
	
	private int idMedico;
	private int idTurno;
	private int idLocal;
	private int idUsuario;
	private String nombres;
	private String apePat;
	private String apeMat;
	private int telefono;
	private String nombreCompleto;
	
	private Turno turno;
	private Local local;
	private Usuario usuario;
	
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public int getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}
	public int getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getApePat() {
		return apePat;
	}
	public void setApePat(String apePat) {
		this.apePat = apePat;
	}
	public String getApeMat() {
		return apeMat;
	}
	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public String getNombreCompleto() {
		return nombres+" "+apePat+" "+apeMat;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
}
