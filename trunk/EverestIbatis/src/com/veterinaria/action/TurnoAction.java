package com.veterinaria.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Turno;
import com.veterinaria.service.TurnoService;

@ParentPackage(value = "Veterinaria")

public class TurnoAction extends ActionSupport{

	private static final long serialVersionUID = -101088637535806324L;
	private Turno turno;
	private List<Turno> turnoLista;
	private String oper;
	
	
	private static TurnoService turnoService = new TurnoService();
	
	@Action(value = "/showTurnoLista", 
			results = { @Result(location = "turnoListaTile", name = "success", type="tiles") } )
	public String showTurnos() throws Exception {
		turnoLista = turnoService.listarTurno();
		return SUCCESS;
	}
	
	@Action(value = "/obtenerTurnoJSON", 
			results = { @Result(name="success", type="json") } )
	public String obtenerTurnoLista() throws Exception {
		turnoLista = turnoService.listarTurno();
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
			turnoService.GrabarTurno(turno);
			
		} else if (oper.equals("edit")) {
			turnoService.ModificarTurno(turno);
			
		}else if (oper.equals("del")) {
			turnoService.EliminarTurno(turno);
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
