package edu.everest.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Turno;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.TurnoService;

@ParentPackage(value = "dawii")

public class TurnoAction extends ActionSupport{

	private static final long serialVersionUID = -101088637535806324L;
	private Turno turno;
	private List<Turno> turnoLista;
	private String oper;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static TurnoService turnoService = abd.getTurnoService();
	
	@Action(value = "/showTurnoLista", 
			results = { @Result(location = "turnoListaTile", name = "success", type="tiles") } )
	public String showTurnos() throws Exception {
		turnoLista = turnoService.obtenerTodosTurno();
		return SUCCESS;
	}
	
	@Action(value = "/obtenerTurnoJSON", 
			results = { @Result(name="success", type="json") } )
	public String obtenerTurnoLista() throws Exception {
		turnoLista = turnoService.obtenerTodosTurno();
		return SUCCESS;
	}
	
	@Action(value = "/showTurnoFormAction", 
			results = { @Result(location="/mantenimiento/turno/turnoForm.jsp", name = "success") })
	public String showInsertarOActualizar() throws Exception {
		System.out.println("showInsertarOActualizar");
		if (turno != null && turno.getIdTurno() != 0) {			
			turno = turnoService.obtenerTurno(turno);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarTurno",  
			results = { @Result(location = "showTurnoLista", name = "success", type = "redirectAction")})
	public String insertarOActualizar() throws Exception {
		
	System.out.println("oper: "+oper);
	System.out.println("cod:"+turno.getIdTurno());
	
	
		if (oper.equals("add")) {
			turnoService.insertarTurno(turno);
			
		} else if (oper.equals("edit")) {
			turnoService.actualizarTurno(turno);
			
		}else if (oper.equals("del")) {
			turnoService.eliminarTurno(turno);
		}
		
		return SUCCESS;
	}	
	
	@Action(value = "/detalleturno", 
			results = { @Result(location = "turnoDetailTile", name = "success", type="tiles") })
	// Metodo 5: Obtener detalle de Empleado
	public String detalleturno() throws Exception {
		turno = turnoService.obtenerTurno(turno);
		return SUCCESS;
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

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}
	
	
}
