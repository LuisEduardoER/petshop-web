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
import edu.everest.entity.Cliente;
import edu.everest.entity.Mascota;
import edu.everest.entity.Tab;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.CitaService;
import edu.everest.service.ClienteService;
import edu.everest.service.MascotaService;
import edu.everest.util.Constants;
import edu.everest.util.MiUtil;

@ParentPackage(value = "dawii")
public class CitaAction extends ActionSupport{

	private static final long serialVersionUID = 2427618726975693997L;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static ClienteService clienteService = abd.getClienteService();
	private static MascotaService mascotaService = abd.getMascotaService();
	private static CitaService citaService = abd.getCitaService();
	
	private Cita 			cita;
	private Cliente 		cliente;
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
	
	@Action(value="/showCitaRegistroAction",
			results={ @Result(name="success", location="citaRegistrarTile",type="tiles") })
	public String showClienteRegistrar() throws Exception{
		return SUCCESS;
	}
	
	@Action(value="/loadTurnoJSON",
			results={ @Result(name="success", type="json") })
	public String loadTurno() throws Exception{
		
		turnoLista.add(new Tab("M", "Manana"));
		turnoLista.add(new Tab("T", "Tarde"));
		
		return SUCCESS;
	}
	
	@Action(value="/validarClienteAction",
			results={ @Result(name="success",location="/cita/citaMascota.jsp") })
	public String validarClient() throws Exception{
		System.out.println("validarClient");
		System.out.println("Documento: "+cliente.getDocumento());
		
		if(cliente.getDocumento() != null){
			
			cliente = clienteService.obtenerCliente(cliente);
			System.out.println("Cliente: "+cliente.getNombres()+" "+cliente.getApePat()+" "+cliente.getApeMat());
			
			mascotaLista = mascotaService.obtenerTodosMascota(cliente);
			System.out.println("Mascotas: "+mascotaLista.size());
			cliente.setMascotas(mascotaLista);
			
		}else
			strMessage = "Ingrese el Documento del cliente";
		
		return SUCCESS;
	}
	
	@Action(value="/loadDaysOfWeekAction",
			results={ @Result(name="success",location="/cita/citaHorarios.jsp") })
	public String loadDays(){
		
		calFirstDayOfWeek = Calendar.getInstance();
		
		//Obteniendo el primer dia de la semana (Lunes)
		int nFirstDayOfWeek = MiUtil.getMondayOfWeek( Calendar.getInstance() );
		
		System.out.println("nFirstDayOfWeek:  "+nFirstDayOfWeek);
		
		calFirstDayOfWeek.set(Calendar.DAY_OF_WEEK, nFirstDayOfWeek);
//		calFirstDayOfWeek.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println("calFirstDayOfWeek: "+dateFormatFull.format( calFirstDayOfWeek.getTime() ));
		
		return SUCCESS;
	}
	
	@Action(value="/reloadCalendarAction",
	results={ @Result(name="success",location="/cita/citaCalendar.jsp") })
	public String reloadCalendar(){
		
		System.out.println("oper: "+oper);
		if(oper != null || !oper.equals("")){
			
			if(oper.equals("next"))
				calFirstDayOfWeek.add(Calendar.DAY_OF_MONTH, 7);
			else if(oper.equals("prev"))
				if(!calNow.getTime().after(calFirstDayOfWeek.getTime()))
					calFirstDayOfWeek.add(Calendar.DAY_OF_MONTH, -7);
			
			turno = "M";
			loadCalendar();
			
		}
		
		return SUCCESS;
	}	
	
	@SuppressWarnings({ "unused" })
	@Action(value="/loadCalendarAction",
			results={ @Result(name="success",location="/cita/citaCalendar.jsp") })
	public String loadCalendar() {
		
		calNow = Calendar.getInstance();
		calNow.add(Calendar.HOUR_OF_DAY, 1);
		
		try {
		
			//Cargando Dias de la semana
			calendarioHeadLista.add( new Tab("","") );
			
			for(int i=0; i<7; i++ ){
				calendarioHeadLista.add( new Tab( ""+i, MiUtil.getDayES(i) + " "+ (calFirstDayOfWeek.get(Calendar.DAY_OF_MONTH)+i) ) );
			}
			strHeadSchedule = MiUtil.getMonthES( calFirstDayOfWeek.get(Calendar.MONTH)+1 )+ " "+ calFirstDayOfWeek.get(Calendar.YEAR);		
			
			//--------------------------
			System.out.println("turno: "+turno);
			
			String strHourIni = "", strHourFin = "", strHourAux = "";
			String strFecIni  = "", strFecFin  = "";
			String strFecAux1 = "", strFecAux2 = "";
			
			Calendar cFecIni = Calendar.getInstance();
			Calendar cFecAux = Calendar.getInstance();
			Calendar cFecFin = Calendar.getInstance();
			
			cFecIni.set(Calendar.DAY_OF_MONTH, calFirstDayOfWeek.get(Calendar.DAY_OF_MONTH));
			cFecIni.set(Calendar.MONTH, calFirstDayOfWeek.get(Calendar.MONTH));
			cFecIni.set(Calendar.YEAR, calFirstDayOfWeek.get(Calendar.YEAR));
			
			cFecAux.set(Calendar.DAY_OF_MONTH, calFirstDayOfWeek.get(Calendar.DAY_OF_MONTH));
			cFecAux.set(Calendar.MONTH, calFirstDayOfWeek.get(Calendar.MONTH));
			cFecAux.set(Calendar.YEAR, calFirstDayOfWeek.get(Calendar.YEAR));
			
			cFecFin.set(Calendar.DAY_OF_MONTH, calFirstDayOfWeek.get(Calendar.DAY_OF_MONTH));
			cFecFin.set(Calendar.MONTH, calFirstDayOfWeek.get(Calendar.MONTH));
			cFecFin.set(Calendar.YEAR, calFirstDayOfWeek.get(Calendar.YEAR));
			
			cFecIni.set(Calendar.MINUTE, 0);
			cFecAux.set(Calendar.MINUTE, 0);
			cFecFin.set(Calendar.MINUTE, 0);
			
			cFecIni.set(Calendar.SECOND, 0);
			cFecAux.set(Calendar.SECOND, 0);
			cFecFin.set(Calendar.SECOND, 0);
			
			cFecFin.add(Calendar.DATE, 7);
			cFecAux.add(Calendar.MINUTE, Constants.KV_INTERVAL_TIME_CITA);
			
			//Cargando Values
			if(turno.equals("M")){
				cFecIni.set(Calendar.HOUR_OF_DAY, Constants.KV_TURN_MORNING_INI);
				cFecAux.set(Calendar.HOUR_OF_DAY, Constants.KV_TURN_MORNING_INI);
				cFecFin.set(Calendar.HOUR_OF_DAY, Constants.KV_TURN_MORNING_FIN);
				
			}else if(turno.equals("T")){
				cFecIni.set(Calendar.HOUR_OF_DAY, Constants.KV_TURN_EVENING_INI);
				cFecAux.set(Calendar.HOUR_OF_DAY, Constants.KV_TURN_EVENING_INI);
				cFecFin.set(Calendar.HOUR_OF_DAY, Constants.KV_TURN_EVENING_FIN);
				
			}
			
			System.out.println("["+dateFormat.format(cFecIni.getTime())+" - "+dateFormat.format(cFecFin.getTime())+"]");
			System.out.println("["+hourFormat.format(cFecIni.getTime())+" - "+hourFormat.format(cFecFin.getTime())+"]");
			
			//------------------------------------------------------------------------
			
			List<Cita> citaLista = citaService.obtenerTodosCliente(cFecIni, cFecFin);
			System.out.println( "citaLista: "+citaLista.size() );
			Cita objCita = new Cita();
			
			int n=1;
			int tipo = 0;
			int d=1;
			strHourIni = hourFormat.format(cFecIni.getTime());
			strHourAux = hourFormat.format(cFecAux.getTime());
			strHourFin = hourFormat.format(cFecFin.getTime());
			
			System.out.println("");
			
			//Cargando Horas
			while(!hourFormat.format(cFecIni.getTime()).equals(hourFormat.format(cFecFin.getTime()))){
			
				n=1;
				strHourIni = hourFormat.format(cFecIni.getTime());
				strHourAux = hourFormat.format(cFecAux.getTime());
				
				calendarioBodyLista.add( new Tab("0", strHourIni, 1) );
				//Cargando Dias de la semana
				while( n != 8 ){
					
					strFecIni = dateFormat.format(cFecIni.getTime());
					strFecAux1 = dateFormatFull.format(cFecIni.getTime());
					
					for(int c=0; c<citaLista.size(); c++){
						objCita = citaLista.get(c);
						
						objCita.getFecProg().set(Calendar.HOUR_OF_DAY, objCita.getHourProg().get(Calendar.HOUR_OF_DAY));
						objCita.getFecProg().set(Calendar.MINUTE, objCita.getHourProg().get(Calendar.MINUTE));
						strFecAux2 = dateFormatFull.format(objCita.getFecProg().getTime());
						
						System.out.println("strFecAux1: "+strFecAux1 );
						System.out.println("Cita Prog : "+strFecAux2 );
						System.out.println("FechaAct  : "+ dateFormatFull.format(calNow.getTime()));
						
						if( strFecAux1.equals(strFecAux2) ){
							tipo = 2;
							System.out.println("Reservado");
							c=citaLista.size();
						}else if(calNow.getTime().after(cFecIni.getTime())){
							tipo = 3;
							System.out.println("Bloqueado");
						}else 
							tipo = 0;
						System.out.println("");
						
					}
					
					cFecIni.add(Calendar.DAY_OF_MONTH, 1);
					calendarioBodyLista.add( new Tab(""+d, strFecIni, strHourIni+" - "+strHourAux, tipo) );
					d++;
					n++;
					
				};
				
				cFecIni.set(Calendar.DAY_OF_MONTH, calFirstDayOfWeek.get(Calendar.DAY_OF_MONTH));
				cFecIni.set(Calendar.MONTH, calFirstDayOfWeek.get(Calendar.MONTH));
				cFecIni.set(Calendar.YEAR, calFirstDayOfWeek.get(Calendar.YEAR));
				
				cFecIni.add(Calendar.MINUTE, Constants.KV_INTERVAL_TIME_CITA);
				cFecAux.add(Calendar.MINUTE, Constants.KV_INTERVAL_TIME_CITA);
				
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
}
