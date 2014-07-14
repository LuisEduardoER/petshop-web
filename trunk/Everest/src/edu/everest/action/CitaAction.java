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
import edu.everest.entity.DetalleCita;
import edu.everest.entity.Mascota;
import edu.everest.entity.Medico;
import edu.everest.entity.Servicio;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.ClienteService;
import edu.everest.service.DetalleCitaService;
import edu.everest.service.MascotaService;
import edu.everest.service.ServicioService;

@ParentPackage(value = "dawii")
public class CitaAction extends ActionSupport{

	private static final long serialVersionUID = 2427618726975693997L;
	
	private static ApplicationBusinessDelegate abd 	= new ApplicationBusinessDelegate();
	private static ClienteService 		clienteService 		= abd.getClienteService();
	private static MascotaService 		mascotaService 		= abd.getMascotaService();
//	private static CitaService 			citaService 		= abd.getCitaService();
	private static DetalleCitaService	detalleCitaService 	= abd.getDetalleCitaDAOService();
	private static ServicioService		servicioService 	= abd.getServicioService();
	
	private Cita 				cita;
	private DetalleCita			detalleCita;
	private Servicio 			servicio;	
	private Cliente 			cliente;
	private Medico				medico;
	private Mascota 			mascota;
	private List<Mascota> 		mascotaLista = 			new ArrayList<Mascota>();
	private String 				strMessage;
	private List<Servicio>		servicioLista		=	new ArrayList<Servicio>();
	private static List<DetalleCita>	detalleCitaLista	=	new ArrayList<DetalleCita>();
	private String 				oper;
	private int idServicio;
	
	DateFormat minuteFormat 	= new SimpleDateFormat ("mm");
	DateFormat minuteFormat2 	= new SimpleDateFormat ("hh:mm");
	
	@Action(value="/showCitaRegistroAction",
			results={ @Result(name="success", location="citaRegistrarTile",type="tiles") })
	public String showClienteRegistrar() throws Exception{
		return SUCCESS;
	}
	
	@Action(value="/validarClienteAction",
			results={ @Result(name="success",location="/mantenimiento/cita/citaMascota.jsp") })
	public String validarClient() throws Exception{
		System.out.println("===== validarClienteActio =====");
		System.out.println("Documento: "+cliente.getDocumento());
		
		if(cliente.getDocumento() != null)
			if( !cliente.getDocumento().equals("") )
		{
			
			cliente = clienteService.obtenerCliente(cliente);
			System.out.println("Cliente: "+cliente.getNombres()+" "+cliente.getApePat()+" "+cliente.getApeMat());
			
			mascotaLista = mascotaService.obtenerTodosMascota(cliente);
			System.out.println("Mascotas: "+mascotaLista.size());
			cliente.setMascotas(mascotaLista);
			
		}else
			strMessage = "Ingrese el Documento del cliente";
		
		return SUCCESS;
	}
	
	@Action(value="/showDetalleCitaLista",
			results={ @Result(name="success", location="/mantenimiento/cita/detalleCitaLista.jsp") })
	public String showdetalleCitaLista(){
		System.out.println("===== showDetalleCitaLista =====");
		
		try {
			detalleCitaLista = new ArrayList<DetalleCita>();
			
			if(cita.getIdCita()!= 0)
				detalleCitaLista = detalleCitaService.obtenerTodos(cita);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	@Action(value="/showDetalleCitaLink",
			results={ @Result(name="success", location="/mantenimiento/cita/detalleCitaLink.jsp") })
	public String showdetalleCitaLink(){
		return SUCCESS;
	}
	
	@Action(value="/showDetalleCitaForm",
			results={ @Result(name="success", location="/mantenimiento/cita/detalleCitaForm.jsp") })
	public String showdetalleCitaForm(){
		String strFecha = "";
		System.out.println("===== showDetalleCitaForm =====");
		try {
			servicioLista = servicioService.obtenerTodos();
			
			System.out.println("idServicio: "+idServicio);
			
			if(idServicio > 0){
				System.out.println("dentro");
				servicio = new Servicio();				
				servicio.setIdServicio(idServicio);
				servicio = servicioService.obtenerServicio(servicio);
				
				detalleCita.setCosto( servicio.getCostoRef() );
				strFecha = servicio.getTiempoAprox().get(Calendar.MINUTE)+":"+servicio.getTiempoAprox().get(Calendar.SECOND);
				System.out.println("strFecha: "+strFecha);
				detalleCita.setStrTiempoAprox( strFecha );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	@Action(value="/loadServiciosJSON",
			results={ @Result(name="success", type="json") })
	public String loadServicios(){
		System.out.println("===== loadServiciosJSON =====");
		
		return SUCCESS;
	}
	
	@Action(value="/showCitaDetailAction",
			results={ @Result(name="success", location="/mantenimiento/cita/citaDetail.jsp") })
	public String showCitaDetail(){
		return SUCCESS;
	}
	
	@SuppressWarnings("deprecation")
	@Action(value="/editDetalleCitaListaAction",
			results={ @Result(name="success", location="/mantenimiento/cita/detalleCitaLista.jsp"),
					  @Result(name="input", location="/mantenimiento/cita/detalleCitaLista.jsp")})
	public String editdetalleCitaLista(){
		System.out.println("===== editDetalleCitaListaAction =====");
		System.out.println("oper: "+oper);
		
		try {
			
			if(oper.equals("add")){
				detalleCita.setIdDetalleCita( detalleCitaLista.size()+1 );
				
				servicio = new Servicio();
				servicio.setIdServicio(idServicio);
				servicio = servicioService.obtenerServicio(servicio);
				detalleCita.setServicio(servicio);
				
				detalleCita.setTiempoAprox( Calendar.getInstance() );
				detalleCita.getTiempoAprox().set(Calendar.HOUR_OF_DAY, 0);				
				detalleCita.getTiempoAprox().set(Calendar.MINUTE, minuteFormat.parse(detalleCita.getStrTiempoAprox()).getMinutes() );
				detalleCita.getTiempoAprox().set(Calendar.SECOND, 0);
				
				detalleCitaLista.add(detalleCita);
				
			}else if(oper.equals("del")){
				detalleCitaLista.remove(detalleCita);
			}
			
		} catch (Exception e) {
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
	
	public List<Servicio> getServicioLista() {
		return servicioLista;
	}

	public void setServicioLista(List<Servicio> servicioLista) {
		this.servicioLista = servicioLista;
	}

	public DetalleCita getDetalleCita() {
		return detalleCita;
	}

	public void setDetalleCita(DetalleCita detalleCita) {
		this.detalleCita = detalleCita;
	}

	public List<DetalleCita> getDetalleCitaLista() {
		return detalleCitaLista;
	}

	public void setDetalleCitaLista(List<DetalleCita> detalleCitaLista) {
		this.detalleCitaLista = detalleCitaLista;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	
}
