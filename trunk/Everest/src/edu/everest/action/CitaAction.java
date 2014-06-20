package edu.everest.action;

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
	private String 			turno;
	private List<Calendar> 	calendarioWeekLista = 	new ArrayList<Calendar>();
	private List<Tab> 		calendarioLista = 		new ArrayList<Tab>();
	private List<Tab> 		calendarioDaysLista = 	new ArrayList<Tab>();;
	private List<Tab> 		turnoLista = 			new ArrayList<Tab>();
	
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
		return SUCCESS;
	}
	
	@Action(value="/loadCalendarAction",
			results={ @Result(name="success",location="/cita/citaCalendar.jsp") })
	public String loadCalendar() {
		
		Calendar today = Calendar.getInstance();
		
		//Obteniendo el primer dia de la semana (Lunes)
		int nFIRST_DAY_OF_WEEK = MiUtil.getMondayOfWeek(Calendar.getInstance());
		
		System.out.println("nFIRST_DAY_OF_WEEK:  "+nFIRST_DAY_OF_WEEK);
		today.set(Calendar.DAY_OF_WEEK, nFIRST_DAY_OF_WEEK);
		
		calendarioWeekLista = new ArrayList<Calendar>();
		for(int i = 0; i<7; i++){
			calendarioWeekLista.add(today);
			today.set( Calendar.DAY_OF_MONTH, today.get(Calendar.DAY_OF_MONTH)+1 );
						
		}
		
		//-----------------------------------
		
		//Cargando Dias de la semana
		calendarioDaysLista.add( new Tab("","") );
		for(int i=0; i<7; i++ ){
			calendarioDaysLista.add( new Tab( ""+i, MiUtil.getDayES(i) + " "+calendarioWeekLista.get(i).get(Calendar.DAY_OF_MONTH) ) );
		}
		strHeadSchedule = MiUtil.getMonthES( calendarioWeekLista.get(1).get(Calendar.MONTH)+1 )+ " "+ calendarioWeekLista.get(1).get(Calendar.YEAR);		
		
		//--------------------------
		
		System.out.println("turno: "+turno);
		if(turno == null || turno.equals(""))
			turno = "M";
		
		String strHourIni = "";
		String strHourFin = "";
		int nIni = 0, nFin = 0;
		
		//Cargando Values
		if(turno.equals("M")){
			nIni = 9;
			nFin = 13;
		}else if(turno.equals("T")){
			nIni = 14;
			nFin = 18;
		}
		
		for( int h=nIni; h<=nFin; h++ ){
			
			strHourIni = h+":00";
			strHourFin = (h+1)+":00";
			
			calendarioLista.add( new Tab("0", strHourIni, 1) );				
			for(int i=1; i<=7; i++ ){
				calendarioLista.add( 
						new Tab(""+i, 
								""+calendarioWeekLista.get(i-1).get(Calendar.DAY_OF_MONTH)+"/"+(calendarioWeekLista.get(i-1).get(Calendar.MONTH)+1)+" ["+strHourIni+" - "+strHourFin+"]") 
				);
			}
			
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

	public List<Tab> getCalendarioLista() {
		return calendarioLista;
	}

	public void setCalendarioLista(List<Tab> calendarioLista) {
		this.calendarioLista = calendarioLista;
	}

	public List<Tab> getCalendarioDaysLista() {
		return calendarioDaysLista;
	}

	public void setCalendarioDaysLista(List<Tab> calendarioDaysLista) {
		this.calendarioDaysLista = calendarioDaysLista;
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

	public List<Calendar> getCalendarioWeekLista() {
		return calendarioWeekLista;
	}

	public void setCalendarioWeekLista(List<Calendar> calendarioWeekLista) {
		this.calendarioWeekLista = calendarioWeekLista;
	}
	
}
