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

import edu.everest.entity.Cita;
import edu.everest.entity.Servicio;
import edu.everest.entity.Tab;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.ClienteService;

@ParentPackage(value = "dawii")
public class ServicioAction extends ActionSupport{

	private static final long serialVersionUID = 2427618726975693997L;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static ClienteService clienteService = abd.getClienteService();
//	private static MascotaService mascotaService = abd.getMascotaService();
//	private static ServicioService servicioService = abd.getServicioService();
	
	private Servicio 		servicio;
	private Cita			cita;
	private String 			strMessage;
	private String 			strHeadSchedule;
	private String 			turno = "M";
	
	private List<Tab> 		turnoLista = 			new ArrayList<Tab>();
	private List<Servicio>  servicioLista = 		new ArrayList<Servicio>();
	
	private	List<Cita>		citaListaHoras =		new ArrayList<Cita>();
	private List<Cita>		citaListaMonday =		new ArrayList<Cita>();
	private List<Cita>		citaListaTuesday =		new ArrayList<Cita>();
	private List<Cita>		citaListaWednesday =	new ArrayList<Cita>();
	private List<Cita>		citaListaThursday =		new ArrayList<Cita>();
	private List<Cita>		citaListaFriday =		new ArrayList<Cita>();
	private List<Cita>		citaListaSaturday =		new ArrayList<Cita>();
	private List<Cita>		citaListaSunday =		new ArrayList<Cita>();
	
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
		
		Cita objCita;
		List<Cita> objListCitaDAY;
		Calendar calendar = Calendar.getInstance();		
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		objCita = new Cita();
//		objCita.setFecProg( calendar );
//		objCita.setDescripcion("Horas");
		
		citaListaHoras.add(objCita);
		for(int i= 0;i<8;i++){
			objCita = new Cita();
//			objCita.setFecProg( calendar );
//			objCita.setHourProg( calendar );
			calendar.add(Calendar.MINUTE, 30);
			
			citaListaHoras.add(objCita);
		}
		
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		objCita = new Cita();
//		objCita.setFecProg( calendar );
//		objCita.setDescripcion( "Lunes" );
		
		
		citaListaMonday.add(objCita);
		for(int i= 0;i<8;i++){
			objCita = new Cita();
//			objCita.setFecProg( calendar );
//			objCita.setHourProg( calendar );
			calendar.add(Calendar.MINUTE, 30);
			
			citaListaMonday.add(objCita);
		}
		
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		objCita = new Cita();
//		objCita.setFecProg( calendar );
//		objCita.setDescripcion("Martes");
		
		citaListaTuesday.add(objCita);
		for(int i= 0;i<8;i++){
			objCita = new Cita();
//			objCita.setFecProg( calendar );
//			objCita.setHourProg( calendar );
			calendar.add(Calendar.MINUTE, 30);
			
			citaListaTuesday.add(objCita);
		}
		
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		objCita = new Cita();
//		objCita.setFecProg( calendar );
//		objCita.setDescripcion("Miercoles");
		
		citaListaWednesday.add(objCita);
		for(int i= 0;i<8;i++){
			objCita = new Cita();
//			objCita.setFecProg( calendar );
//			objCita.setHourProg( calendar );
			calendar.add(Calendar.MINUTE, 30);
			
			citaListaWednesday.add(objCita);
		}
		
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		objCita = new Cita();
//		objCita.setFecProg( calendar );
//		objCita.setDescripcion("Jueves");
		
		citaListaThursday.add(objCita);
		for(int i= 0;i<8;i++){
			objCita = new Cita();
//			objCita.setFecProg( calendar );
//			objCita.setHourProg( calendar );
			calendar.add(Calendar.MINUTE, 30);
			
			citaListaThursday.add(objCita);
		}
		
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		objCita = new Cita();
//		objCita.setFecProg( calendar );
//		objCita.setDescripcion("Viernes");
		
		citaListaFriday.add(objCita);
		for(int i= 0;i<8;i++){
			objCita = new Cita();
//			objCita.setFecProg( calendar );
//			objCita.setHourProg( calendar );
			calendar.add(Calendar.MINUTE, 30);
			
			citaListaFriday.add(objCita);
		}
		
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		objCita = new Cita();
//		objCita.setFecProg( calendar );
//		objCita.setDescripcion("Sabado");
		
		citaListaSaturday.add(objCita);
		for(int i= 0;i<8;i++){
			objCita = new Cita();
//			objCita.setFecProg( calendar );
//			objCita.setHourProg( calendar );
			calendar.add(Calendar.MINUTE, 30);
			
			citaListaSaturday.add(objCita);
		}
		
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		objCita = new Cita();
//		objCita.setFecProg( calendar );
//		objCita.setDescripcion("Martes");
		
		citaListaSunday.add(objCita);
		for(int i= 0;i<8;i++){
			objCita = new Cita();
//			objCita.setFecProg( calendar );
//			objCita.setHourProg( calendar );
			calendar.add(Calendar.MINUTE, 30);
			
			citaListaSunday.add(objCita);
		}
		
		return SUCCESS;
	}
	
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
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

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public List<Servicio> getServicioLista() {
		return servicioLista;
	}

	public void setServicioLista(List<Servicio> servicioLista) {
		this.servicioLista = servicioLista;
	}

	public List<Cita> getCitaListaMonday() {
		return citaListaMonday;
	}

	public void setCitaListaMonday(List<Cita> citaListaMonday) {
		this.citaListaMonday = citaListaMonday;
	}

	public static Calendar getCalFirstDayOfWeek() {
		return calFirstDayOfWeek;
	}

	public static void setCalFirstDayOfWeek(Calendar calFirstDayOfWeek) {
		ServicioAction.calFirstDayOfWeek = calFirstDayOfWeek;
	}

	public static Calendar getCalNow() {
		return calNow;
	}

	public static void setCalNow(Calendar calNow) {
		ServicioAction.calNow = calNow;
	}

	public DateFormat getHourFormat() {
		return hourFormat;
	}

	public void setHourFormat(DateFormat hourFormat) {
		this.hourFormat = hourFormat;
	}

	public DateFormat getDateFormatMin() {
		return dateFormatMin;
	}

	public void setDateFormatMin(DateFormat dateFormatMin) {
		this.dateFormatMin = dateFormatMin;
	}

	public DateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public DateFormat getDateFormatFull() {
		return dateFormatFull;
	}

	public void setDateFormatFull(DateFormat dateFormatFull) {
		this.dateFormatFull = dateFormatFull;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Cita> getCitaListaTuesday() {
		return citaListaTuesday;
	}

	public void setCitaListaTuesday(List<Cita> citaListaTuesday) {
		this.citaListaTuesday = citaListaTuesday;
	}

	public List<Cita> getCitaListaWednesday() {
		return citaListaWednesday;
	}

	public void setCitaListaWednesday(List<Cita> citaListaWednesday) {
		this.citaListaWednesday = citaListaWednesday;
	}

	public List<Cita> getCitaListaThursday() {
		return citaListaThursday;
	}

	public void setCitaListaThursday(List<Cita> citaListaThursday) {
		this.citaListaThursday = citaListaThursday;
	}

	public List<Cita> getCitaListaFriday() {
		return citaListaFriday;
	}

	public void setCitaListaFriday(List<Cita> citaListaFriday) {
		this.citaListaFriday = citaListaFriday;
	}

	public List<Cita> getCitaListaSaturday() {
		return citaListaSaturday;
	}

	public void setCitaListaSaturday(List<Cita> citaListaSaturday) {
		this.citaListaSaturday = citaListaSaturday;
	}

	public List<Cita> getCitaListaSunday() {
		return citaListaSunday;
	}

	public void setCitaListaSunday(List<Cita> citaListaSunday) {
		this.citaListaSunday = citaListaSunday;
	}

	public List<Cita> getCitaListaHoras() {
		return citaListaHoras;
	}

	public void setCitaListaHoras(List<Cita> citaListaHoras) {
		this.citaListaHoras = citaListaHoras;
	}
	
}
