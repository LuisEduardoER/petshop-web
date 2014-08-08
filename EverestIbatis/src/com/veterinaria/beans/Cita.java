package com.veterinaria.beans;

import java.util.Date;

public class Cita {
	
	private String idCita;
	private String idMascota;
	private int idCliente;
	private int idMedico;
	private Date fecIniProg;
	private Date fecFinProg;
	private Date fecAtencion;
	private String estado;
	
	private Mascota mascota;
	private Cliente cliente;
	private Medico medico;
	
	public String getIdCita() {
		return idCita;
	}
	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}
	public String getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(String idMascota) {
		this.idMascota = idMascota;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public Date getFecIniProg() {
		return fecIniProg;
	}
	public void setFecIniProg(Date fecIniProg) {
		this.fecIniProg = fecIniProg;
	}
	public Date getFecFinProg() {
		return fecFinProg;
	}
	public void setFecFinProg(Date fecFinProg) {
		this.fecFinProg = fecFinProg;
	}
	public Date getFecAtencion() {
		return fecAtencion;
	}
	public void setFecAtencion(Date fecAtencion) {
		this.fecAtencion = fecAtencion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	

}
