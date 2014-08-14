package com.veterinaria.action;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Cliente;
import com.veterinaria.beans.DetalleCita;
import com.veterinaria.beans.Servicio;
import com.veterinaria.service.DetalleCitaService;
import com.veterinaria.service.ServicioService;

@ParentPackage(value = "Veterinaria")
public class DetalleCitaAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private DetalleCita 				detalleCita;
	private Servicio 					servicio;
	private Cliente						cliente;
	
	private static List<DetalleCita> 	detalleCitaLista;
	private List<Servicio>				servicioLista;
	
	private String 						oper, message;
	
	ServicioService 	servicioService 	= new ServicioService();
	DetalleCitaService 	detalleCitaService 	= new DetalleCitaService();
	
	
	
	public DetalleCita getDetalleCita() {
		return detalleCita;
	}
	public void setDetalleCita(DetalleCita detalleCita) {
		this.detalleCita = detalleCita;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	public static List<DetalleCita> getDetalleCitaLista() {
		return detalleCitaLista;
	}
	public static void setDetalleCitaLista(List<DetalleCita> detalleCitaLista) {
		DetalleCitaAction.detalleCitaLista = detalleCitaLista;
	}
	public List<Servicio> getServicioLista() {
		return servicioLista;
	}
	public void setServicioLista(List<Servicio> servicioLista) {
		this.servicioLista = servicioLista;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
