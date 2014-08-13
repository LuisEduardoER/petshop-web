package com.veterinaria.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Cliente;
import com.veterinaria.beans.DetalleCita;
import com.veterinaria.beans.Servicio;
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
	
	ServicioService servicioService = new ServicioService();
	
	@Action(value = "/showCitaServicioForm", results = { @Result(location = "/transaccional/cita/citaServicio.jsp", name = "success") })
	public String showCitaServicioForm() throws Exception {
		System.out.println("===== showCitaServicioForm =====");
		return SUCCESS;
	}
	
	@Action(value = "/loadServicioAJAX", results = { @Result(location = "/transaccional/cita/citaServicioAJAX.jsp", name = "success") })
	public String loadServicioAJAX() throws Exception {
		System.out.println("===== loadServicioAJAX =====");
		
		if(servicio != null){
			System.out.println("idServicio: "+servicio.getIdServicio());
			
			servicio = servicioService.obtenerServicio(servicio);
			System.out.println("servicio: "+servicio);
			
			if(servicio != null){
				detalleCita.setIdServicio( Integer.parseInt( servicio.getIdServicio()) );
				detalleCita.setTiempoAprox( servicio.getTiempoAprox() );
				detalleCita.setCosto( servicio.getCostoRef() );
			}else{
				detalleCita = new DetalleCita();
			}
			
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/loadServicioJSON", results = { @Result(name = "success", type="json") })
	public String loadServicioJSON() throws Exception {
		System.out.println("===== loadServicioJSON ======");
		
		servicioLista = servicioService.listarServicio();
		System.out.println("servicioLista: "+servicioLista.size());
		
		return SUCCESS;
	}
	
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
