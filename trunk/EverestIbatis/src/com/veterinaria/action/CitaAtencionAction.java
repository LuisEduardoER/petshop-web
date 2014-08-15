package com.veterinaria.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Cita;
import com.veterinaria.beans.Cliente;
import com.veterinaria.beans.DetalleCita;
import com.veterinaria.beans.Mascota;
import com.veterinaria.beans.Servicio;
import com.veterinaria.service.CitaService;
import com.veterinaria.service.ClienteService;
import com.veterinaria.service.DetalleCitaService;
import com.veterinaria.service.MascotaService;
import com.veterinaria.service.ServicioService;

@ParentPackage(value = "Veterinaria")
public class CitaAtencionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Cita				cita;
	private Cliente				cliente;
	private Mascota				mascota;
	private Servicio			servicio;
	
	private List<Cita> 			citaLista;
	private List<DetalleCita> 	detalleCitaLista;
	private static List<Servicio>		servicioLista;
	
	private String 		oper, message;
	
	CitaService 		citaService =			new CitaService();
	DetalleCitaService	detalleCitaService = 	new DetalleCitaService();
	ClienteService		clienteService = 		new ClienteService();
	MascotaService		mascotaService =		new MascotaService();
	ServicioService 	servicioService =		new ServicioService();
	
	@Action(value = "/showCitas", results = { @Result(location = "citaAtencionListaTile", name = "success", type="tiles") })
	public String showCitas() throws Exception {
		System.out.println("===== showCitas =====");
		
		citaLista = citaService.listarCita();
		System.out.println( "citaLista: "+citaLista.size() );
		
		Cliente objCliente;
		Mascota objMascota;
		
		for (Cita objCita : citaLista) {
			objCliente = new Cliente();
			objCliente.setIdCliente( objCita.getIdCliente() );
			objCliente = clienteService.obtenerCliente( objCliente );
			objCliente.setNombreCompleto( objCliente.getNombres()+" "+objCliente.getApePat()+" "+objCliente.getApeMat() );
			objCita.setCliente( objCliente );
						
			objMascota = new Mascota();
			objMascota.setIdMascota( objCita.getIdMascota() );
			objCita.setMascota( mascotaService.obtenerMascota(objMascota) );
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/showCitaAtencionForm", results = { @Result(location = "citaAtencionFormTile", name = "success", type="tiles") })
	public String showCitaAtencionForm() throws Exception {
		System.out.println("===== showCitaAtencionForm =====");
		
		if(servicioLista.size() == 0)
			servicioLista = servicioService.listarServicio();
		
		System.out.println("cita: "+cita);
		if(cita != null){
			System.out.println("idCita: "+cita.getIdCita());
			System.out.println("mascota: "+mascota);
			System.out.println("cliente: "+cliente);
			
			cita = citaService.obtenerCita(cita);
			
			detalleCitaLista = detalleCitaService.obtenerDetalleCita(cita);
			System.out.println( "detalleCitaLista: "+detalleCitaLista.size() );
		}
		
		return SUCCESS;
	}
	
	public Cita getCita() {
		return cita;
	}
	public void setCita(Cita cita) {
		this.cita = cita;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public List<Cita> getCitaLista() {
		return citaLista;
	}
	public void setCitaLista(List<Cita> citaLista) {
		this.citaLista = citaLista;
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
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	public List<DetalleCita> getDetalleCitaLista() {
		return detalleCitaLista;
	}
	public void setDetalleCitaLista(List<DetalleCita> detalleCitaLista) {
		this.detalleCitaLista = detalleCitaLista;
	}
	public List<Servicio> getServicioLista() {
		return servicioLista;
	}
	@SuppressWarnings("static-access")
	public void setServicioLista(List<Servicio> servicioLista) {
		this.servicioLista = servicioLista;
	}
	
}
