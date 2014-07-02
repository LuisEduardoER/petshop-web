package edu.everest.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Servicio;
import edu.everest.entity.Cliente;
import edu.everest.entity.Mascota;
import edu.everest.entity.Medico;
import edu.everest.entity.Tab;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.ClienteService;
import edu.everest.service.MascotaService;
import edu.everest.util.Constants;
import edu.everest.util.MiUtil;

@ParentPackage(value = "dawii")
public class ServicioAction extends ActionSupport{

	private static final long serialVersionUID = 2427618726975693997L;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static ClienteService clienteService = abd.getClienteService();
	private static MascotaService mascotaService = abd.getMascotaService();
//	private static ServicioService servicioService = abd.getServicioService();
	
	private Servicio 			servicio;
	private Cliente 		cliente;
	private Medico			medico;
	private Mascota 		mascota;
	private List<Mascota> 	mascotaLista = 			new ArrayList<Mascota>();
	private String 			strMessage;
	private String 			strHeadSchedule;
	private String 			turno = "M";
	private List<Tab> 		turnoLista = 			new ArrayList<Tab>();
	private List<Tab> 		calendarioHeadLista = 	new ArrayList<Tab>();
	private List<Tab> 		calendarioBodyLista = 	new ArrayList<Tab>();
	private static Calendar	calFirstDayOfWeek;
	private static Calendar	calNow;
	private String 			oper;
	
	DateFormat hourFormat 		= new SimpleDateFormat ("HH:mm");
	DateFormat dateFormatMin 	= new SimpleDateFormat ("dd/MM");
	DateFormat dateFormat 		= new SimpleDateFormat ("dd/MM/yyyy");
	DateFormat dateFormatFull 	= new SimpleDateFormat ("dd/MM/yyyy HH:mm");
	
	@Action(value="/showServicioDisponiblidadAction",
			results={ @Result(name="success", location="servicioDisponibilidadTile",type="tiles") })
	public String showServicioDisponibilidad() throws Exception{
		return SUCCESS;
	}
	
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
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

	public List<Mascota> getMascotaLista() {
		return mascotaLista;
	}

	public void setMascotaLista(List<Mascota> mascotaLista) {
		this.mascotaLista = mascotaLista;
	}

	public String getStrMessage() {
		return strMessage;
	}

	public void setStrMessage(String strMessage) {
		this.strMessage = strMessage;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public List<Tab> getTurnoLista() {
		return turnoLista;
	}

	public void setTurnoLista(List<Tab> turnoLista) {
		this.turnoLista = turnoLista;
	}

	public String getStrHeadSchedule() {
		return strHeadSchedule;
	}

	public void setStrHeadSchedule(String strHeadSchedule) {
		this.strHeadSchedule = strHeadSchedule;
	}

	public List<Tab> getCalendarioHeadLista() {
		return calendarioHeadLista;
	}

	public void setCalendarioHeadLista(List<Tab> calendarioHeadLista) {
		this.calendarioHeadLista = calendarioHeadLista;
	}

	public List<Tab> getCalendarioBodyLista() {
		return calendarioBodyLista;
	}

	public void setCalendarioBodyLista(List<Tab> calendarioBodyLista) {
		this.calendarioBodyLista = calendarioBodyLista;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
}
