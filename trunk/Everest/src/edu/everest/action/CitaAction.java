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
//	private static CitaService citaService = abd.getCitaService();
	
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
	private static Calendar		calFirstDayOfWeek;
	private String 			oper;
	
	DateFormat dateFormat = new SimpleDateFormat ("HH:mm");
	
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
				calFirstDayOfWeek.add(Calendar.DAY_OF_MONTH, -7);
			
			loadCalendar();
			
		}
		
		return SUCCESS;
	}	
	
	@SuppressWarnings({ "unused" })
	@Action(value="/loadCalendarAction",
			results={ @Result(name="success",location="/cita/citaCalendar.jsp") })
	public String loadCalendar() {
		
		//Cargando Dias de la semana
		calendarioHeadLista.add( new Tab("","") );
		for(int i=0; i<7; i++ ){
			calendarioHeadLista.add( new Tab( ""+i, MiUtil.getDayES(i) + " "+ (calFirstDayOfWeek.get(Calendar.DAY_OF_MONTH)+i) ) );
//			nFIRST_DAY_OF_WEEK+=1;
		}
		strHeadSchedule = MiUtil.getMonthES( calFirstDayOfWeek.get(Calendar.MONTH)+1 )+ " "+ calFirstDayOfWeek.get(Calendar.YEAR);		
		
		//--------------------------
		
		System.out.println("turno: "+turno);
		if(turno == null || turno.equals(""))
			turno = "M";
		
		String strHourIni = "", strHourFin = "";
		int nIni = 0, nFin = 0;
		Calendar dHourIni = Calendar.getInstance();
		Calendar dHourAux = Calendar.getInstance();
		Calendar dHourFin = Calendar.getInstance();
		
		dHourIni.set(Calendar.MINUTE, 0);
		dHourAux.set(Calendar.MINUTE, 0);
		dHourFin.set(Calendar.MINUTE, 0);
		
		//Cargando Values
		if(turno.equals("M")){
			dHourIni.set(Calendar.HOUR_OF_DAY, Constants.KV_TURN_MORNING_INI);
			dHourAux.set(Calendar.HOUR_OF_DAY, Constants.KV_TURN_MORNING_INI);
			dHourFin.set(Calendar.HOUR_OF_DAY, Constants.KV_TURN_MORNING_FIN);
			
			dHourAux.add(Calendar.MINUTE, Constants.KV_INTERVAL_TIME_CITA);
			dHourFin.add(Calendar.MINUTE, Constants.KV_INTERVAL_TIME_CITA);
		}else if(turno.equals("T")){
			dHourIni.set(Calendar.HOUR_OF_DAY, Constants.KV_TURN_EVENING_INI);
			dHourAux.set(Calendar.HOUR_OF_DAY, Constants.KV_TURN_EVENING_INI);
			dHourFin.set(Calendar.HOUR_OF_DAY, Constants.KV_TURN_EVENING_FIN);
			
			dHourAux.add(Calendar.MINUTE, Constants.KV_INTERVAL_TIME_CITA);
			dHourFin.add(Calendar.MINUTE, Constants.KV_INTERVAL_TIME_CITA);
		}
		
		int n=1;
		while( !dHourIni.equals(dHourFin) ){
			
			strHourIni = dateFormat.format(dHourIni.getTime());
			strHourFin = dateFormat.format(dHourAux.getTime());
			
			calendarioBodyLista.add( new Tab("0", strHourIni, 1) );				
			for(int i=1; i<=7; i++ ){
				calendarioBodyLista.add( 
						new Tab(""+i, 
								""+(calFirstDayOfWeek.get(Calendar.DAY_OF_MONTH)+i-1)+"/"+(calFirstDayOfWeek.get(Calendar.MONTH)+1)+
								" ["+strHourIni+" - "+strHourFin+"]") 
				);
			}
			
			n++;
			dHourIni.add(Calendar.MINUTE, Constants.KV_INTERVAL_TIME_CITA);
			dHourAux.add(Calendar.MINUTE, Constants.KV_INTERVAL_TIME_CITA);
			
			System.out.println("hora: "+dHourIni.get(Calendar.HOUR_OF_DAY)+":"+dHourIni.get(Calendar.MINUTE));
			
		};
		
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
