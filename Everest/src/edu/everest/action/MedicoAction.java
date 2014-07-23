package edu.everest.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Local;
import edu.everest.entity.Medico;
import edu.everest.entity.Turno;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.LocalService;
import edu.everest.service.MedicoService;
import edu.everest.service.TurnoService;

@ParentPackage(value = "dawii")
public class MedicoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8058595419809614910L;
	
	private Medico medico;
	private List<Medico> medicoLista;
	private String oper;
	
	private Turno turno = new Turno();
	private List<Turno> turnoLista = new ArrayList<Turno>();
	
	private Local local = new Local();
	private List<Local> localLista = new ArrayList<Local>();
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static MedicoService medicoService = abd.getMedicoService();
	private static TurnoService turnoService = abd.getTurnoService();
	private static LocalService localService = abd.getLocalService();	
	
	@Action(value = "/showMedicoLista", 
			results = { @Result(location = "medicoListaTile", name = "success", type="tiles") } )
	public String showMedicoes() throws Exception {
		medicoLista = medicoService.obtenerTodosMedico();
		return SUCCESS;
	}
	
	@Action(value = "/obtenerMedicoJSON", 
			results = { @Result(name="success", type="json") } )
	public String obtenerMedicoLista() throws Exception {
		medicoLista = medicoService.obtenerTodosMedico();
		return SUCCESS;
	}
	
	@Action(value = "/showMedicoFormAction", 
			results = { @Result(location="/mantenimiento/medico/medicoForm.jsp", name = "success") })
	public String showInsertarOActualizar() throws Exception {
		System.out.println("showInsertarOActualizar");
		System.out.println("oper: "+oper);
		
		turnoLista = turnoService.obtenerTodosTurno();
		localLista = localService.obtenerTodosLocal();
		
		if(oper != null)
		if (oper.equals("edit")) {
			
			medico = medicoService.obtenerMedico(medico);
			
			turno = medico.getTurno();
			local = medico.getLocal();
		}else if (oper.equals("add")) {
//			turno = new Turno();
//			local = new Local();
//			medico.setTurno(turno);
//			medico.setLocal(local);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarMedico",  
			results = { @Result(location = "showMedicoLista", name = "success", type = "redirectAction")})
	public String insertarOActualizar() throws Exception {
		
	System.out.println("oper: "+oper);
	System.out.println("cod:"+medico.getIdMedico() );
		
		medico.setTurno(turno);
		medico.setLocal(local);
	
		if (oper.equals("add")) {
			
			medicoService.insertarMedico(medico);
			
		} else if (oper.equals("edit")) {
			medicoService.actualizarMedico(medico);
			
		}else if (oper.equals("del")) {
			medicoService.eliminarMedico(medico);
		}
		
		return SUCCESS;
	}	
	
	@Action(value = "/detalleMedico", 
			results = { @Result(location = "medicoDetailTile", name = "success", type="tiles") })
	// Metodo 5: Obtener detalle de Empleado
	public String detalleMedico() throws Exception {
		medico = medicoService.obtenerMedico(medico);
		return SUCCESS;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getMedicoLista() {
		return medicoLista;
	}

	public void setMedicoLista(List<Medico> medicoLista) {
		this.medicoLista = medicoLista;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<Turno> getTurnoLista() {
		return turnoLista;
	}

	public void setTurnoLista(List<Turno> turnoLista) {
		this.turnoLista = turnoLista;
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
	
}
