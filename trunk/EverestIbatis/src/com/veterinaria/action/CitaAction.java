package com.veterinaria.action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;

import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.dhtmlx.planner.controls.DHXExternalLightboxForm;
import com.dhtmlx.planner.data.DHXDataFormat;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Cliente;
import com.veterinaria.beans.DetalleCita;
import com.veterinaria.beans.Local;
import com.veterinaria.beans.Mascota;
import com.veterinaria.beans.Medico;
import com.veterinaria.beans.Servicio;
import com.veterinaria.beans.Turno;
import com.veterinaria.planner.CitaEvento;
import com.veterinaria.planner.MessageStore;
import com.veterinaria.service.ClienteService;
import com.veterinaria.service.DetalleCitaService;
import com.veterinaria.service.LocalService;
import com.veterinaria.service.MascotaService;
import com.veterinaria.service.MedicoService;
import com.veterinaria.service.ServicioService;
import com.veterinaria.service.TurnoService;

@ParentPackage(value = "Veterinaria")
public class CitaAction extends ActionSupport {

	private static final long serialVersionUID = 6790540391660566857L;
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(CitaAction.class);
	
	@SuppressWarnings("unused")
	private SessionMap<String, Object> session = (SessionMap<String, Object>)ActionContext.getContext().getSession();
	
	private String mensaje, productoApicola, envase, cantidad,envase2;
	private String operario, fechaProgramada;
	private MessageStore messageStore = new MessageStore();
	
	private Cliente 		cliente;
	private Mascota 		mascota;
	private Turno 			turno;
	private Medico 			medico;
	private Local			local;
	private DetalleCita 				detalleCita;
	private Servicio 					servicio;
	
	private List<Mascota> 	mascotaLista = new ArrayList<Mascota>();
	private List<Turno> 	turnoLista;
	private List<Medico> 	medicoLista;
	private List<Local>		localLista;	
	private static List<DetalleCita> 	detalleCitaLista;
	private static List<Servicio>				servicioLista;
	
	private String idLocal, idTurno, idMedico, idMascota, message;
	
	MedicoService 		medicoService = 	new MedicoService();
	TurnoService 		turnoService = 		new TurnoService();
	ClienteService 		clienteService = 	new ClienteService();
	MascotaService 		mascotaService = 	new MascotaService();
	LocalService 		localService = 		new LocalService();
	ServicioService 	servicioService = 	new ServicioService();
	DetalleCitaService 	detalleCitaService =new DetalleCitaService();
	
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
	
	@Action(value = "/editar", results = { @Result(location = "/transaccional/cita/editar.jsp", name = "success") })
	public String editar() throws Exception {
		System.out.println("===== editar =====");
		return SUCCESS;
	}
	
	@Action(value = "/evento", results = { @Result(location = "/transaccional/cita/evento.jsp", name = "success") })
	public String eventoProgramacionEnvasado() throws Exception {
		System.out.println("===== eventoProgramacionEnvasado =====");
		
		try {
			CitaEvento evs = new CitaEvento(ServletActionContext.getRequest());
			String data = evs.run();
			messageStore.setData(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/showCitaIni", results = { @Result(name = "success", location = "citaIniTile", type="tiles") })
	public String showCitaIni() throws Exception {
		System.out.println("===== showCitaIni =====");
		
		localLista = localService.listarLocal();
		System.out.println("localLista: "+localLista.size());
		
		servicioLista = servicioService.listarServicio();	
		
		if(detalleCitaLista == null)
			detalleCitaLista = new ArrayList<DetalleCita>();
		
		System.out.println("detalleCitaLista: "+detalleCitaLista.size());
		
		return SUCCESS;
	}
	
	@Action(value = "/loadMascota", results = { @Result(name = "success", location = "/transaccional/cita/citaMascota.jsp") })
	public String loadMascota() throws Exception {
		System.out.println("===== loadMascota =====");
		
		if(cliente!=null){
			if(!cliente.getDni().equals("")){
				
			System.out.println("dni: "+cliente.getDni());
			cliente = clienteService.obtenerCliente(cliente);
			
				if(cliente != null){
					cliente.setNombreCompleto( cliente.getNombres()+" "+cliente.getApePat()+" "+cliente.getApeMat() );
					System.out.println("NombreCompleto: "+cliente.getNombreCompleto());
					
					mascotaLista = mascotaService.obtenerMascotaXCliente(cliente);
					System.out.println("mascotaLista: "+mascotaLista.size());
				}else{
					message = "DNI no registrado en el sistema.";
				}
				
			}
		}
		
		System.out.println("message: "+message);
		return SUCCESS;
	}
	
	@Action(value = "/loadTurnoJSON", results = { @Result(name = "success", type="json") })
	public String loadTurnoJSON() throws Exception {
		System.out.println("===== loadTurnoJSON =====");
		System.out.println("idLocal: "+idLocal);
		System.out.println("idTurno: "+idTurno);
		System.out.println("idMedico: "+idMedico);
		
		turnoLista = turnoService.listarTurno();
		System.out.println("turnoLista: "+turnoLista.size());
		
		if(idTurno!=null)
			if( !idTurno.equals("") ){
				medico = new Medico();
				medico.setIdTurno( Integer.parseInt(idTurno) );
				
				medicoLista = new ArrayList<Medico>();
				medicoLista.add( medicoService.obtenerMedico(medico) );
				System.out.println("medicoLista: "+medicoLista.size());
			}
		
		return SUCCESS;
	}
	
	@Action(value = "/showCitaCalendario", results = { @Result(name = "success", location="citaCalendarTile", type="tiles") })
	public String showCitaCalendario() throws Exception {
		System.out.println("===== showCitaCalendario =====");
		
		try {
			// creates and configures scheduler instance
	    	DHXPlanner s = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
	    	s.setWidth(900);
	    	s.setInitialDate(new Date());
	    	s.config.setScrollHour(12);
	    	s.config.setDetailsOnCreate(true);
	    	s.config.setDblClickCreate(true);
	    	s.config.setDetailsOnDblClick(true);
	    	s.config.setHighlightDisplayedEvent(true);
	    	
	     	//invoca al action eventoProgramacionEnvasado
	    	s.load("evento", DHXDataFormat.JSON);
	    	s.data.dataprocessor.setURL("evento");

	    	//invoca al action editarProgramacion
	    	DHXExternalLightboxForm box = s.lightbox.setExternalLightboxForm("./editar", 450, 280);    
	    	box.setClassName("custom_lightbox");

	    	//s.render se va a generar el caledario en html	
			messageStore.setScheduler(s.render());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/****************************************************************/
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
//			servicio.setStrTiempoAprox( sdf.format( servicio.getTiempoAprox() ) );
			System.out.println("servicio: "+servicio);
			
			if(servicio != null){
				detalleCita.setIdServicio( Integer.parseInt( servicio.getIdServicio()) );
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
	
	@Action(value = "/addDetalleCita", results = { @Result(name = "success", location="/transaccional/cita/citaDetalle.jsp") })
	public String addDetalleCita() throws Exception {
		System.out.println("===== addDetalleCita =====");
				
		if(detalleCita != null){
			detalleCita.setIdServicio( Integer.parseInt(servicio.getIdServicio()) );
			detalleCitaLista.add(detalleCita);
			System.out.println("detalleCitaLista: "+detalleCitaLista.size());
			
//			servicioLista = servicioService.listarServicio();
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/loadDetalleCitaLista", results = { @Result(name = "success", location="/transaccional/cita/citaDetalle.jsp") })
	public String loadDetalleCitaLista() throws Exception {
		System.out.println("====== loadDetalleCitaLista =====");
			
//			detalleCitaLista = detalleCitaService.listarDetalleCita();
			servicioLista = servicioService.listarServicio();
			
			if(detalleCitaLista == null)
				detalleCitaLista = new ArrayList<DetalleCita>();
			
			System.out.println("detalleCitaLista: "+detalleCitaLista.size());
			
		return SUCCESS;
	}
	
	public String getProductoApicola() {
		return productoApicola;
	}


	public void setProductoApicola(String productoApicola) {
		this.productoApicola = productoApicola;
	}


	public String getEnvase() {
		return envase;
	}


	public void setEnvase(String envase) {
		this.envase = envase;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	

	public String getMensaje() {
		return mensaje;
	}


	public String getOperario() {
		return operario;
	}

	

	public String getFechaProgramada() {
		return fechaProgramada;
	}

	public void setFechaProgramada(String fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}

	public void setOperario(String operario) {
		this.operario = operario;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}


	public String getEnvase2() {
		return envase2;
	}


	public void setEnvase2(String envase2) {
		this.envase2 = envase2;
	}


	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
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

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Mascota> getMascotaLista() {
		return mascotaLista;
	}

	public void setMascotaLista(List<Mascota> mascotaLista) {
		this.mascotaLista = mascotaLista;
	}

	public List<Turno> getTurnoLista() {
		return turnoLista;
	}

	public void setTurnoLista(List<Turno> turnoLista) {
		this.turnoLista = turnoLista;
	}

	public List<Medico> getMedicoLista() {
		return medicoLista;
	}

	public void setMedicoLista(List<Medico> medicoLista) {
		this.medicoLista = medicoLista;
	}

	public String getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(String idTurno) {
		this.idTurno = idTurno;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(String idLocal) {
		this.idLocal = idLocal;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public List<Local> getLocalLista() {
		return localLista;
	}

	public void setLocalLista(List<Local> localLista) {
		this.localLista = localLista;
	}

	public String getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(String idMascota) {
		this.idMascota = idMascota;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public List<DetalleCita> getDetalleCitaLista() {
		return detalleCitaLista;
	}

	public void setDetalleCitaLista(List<DetalleCita> detalleCitaLista) {
		CitaAction.detalleCitaLista = detalleCitaLista;
	}

	public List<Servicio> getServicioLista() {
		return servicioLista;
	}

	public void setServicioLista(List<Servicio> servicioLista) {
		this.servicioLista = servicioLista;
	}

}
