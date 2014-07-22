package edu.everest.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Correlativo;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.CorrelativoService;

@ParentPackage(value = "dawii")
public class CorrelativoAction extends ActionSupport{
private static final long serialVersionUID = -2090286063724725176L;
	
	private Correlativo correl;
	private List<Correlativo> correlLista;
	private String oper;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static CorrelativoService correlService = abd.getCorrelativoService();
	
	@Action(value = "/showCorrelativoLista", 
			results = { @Result(location = "CorrelativoListaTile", name = "success", type="tiles") } )
	public String showCorrelativoes() throws Exception {
		correlLista = correlService.obtenerTodosCorrelativo();
		return SUCCESS;
	}
	
	@Action(value = "/obtenerCorrelativoJSON", 
			results = { @Result(name="success", type="json") } )
	public String obtenerCorrelativoLista() throws Exception {
		correlLista = correlService.obtenerTodosCorrelativo();
		return SUCCESS;
	}
	
	@Action(value = "/showCorrelativoFormAction", 
			results = { @Result(location="/mantenimiento/correlativo/correlativoForm.jsp", name = "success") })
	public String showInsertarOActualizar() throws Exception {
		System.out.println("showInsertarOActualizar");
		if (correl != null && correl.getIdCorrelativo() != 0) {			
			correl = correlService.obtenerCorrelativo(correl);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarCorrelativo",  
			results = { @Result(location = "showCorrelativoLista", name = "success", type = "redirectAction")})
	public String insertarOActualizar() throws Exception {
		
	System.out.println("oper: "+oper);
	System.out.println("cod:"+correl.getIdCorrelativo() );
	
	
		if (oper.equals("add")) {
			correlService.insertarCorrelativo(correl);
			
		} else if (oper.equals("edit")) {
			correlService.actualizarCorrelativo(correl);
			
		}else if (oper.equals("del")) {
			correlService.eliminarCorrelativo(correl);
		}
		
		return SUCCESS;
	}	
	
	@Action(value = "/detalleCorrelativo", 
			results = { @Result(location = "correlDetailTile", name = "success", type="tiles") })
	// Metodo 5: Obtener detalle de Empleado
	public String detalleCorrelativo() throws Exception {
		correl = correlService.obtenerCorrelativo(correl);
		return SUCCESS;
	}

	public Correlativo getCorrel() {
		return correl;
	}

	public void setCorrel(Correlativo correl) {
		this.correl = correl;
	}

	public List<Correlativo> getCorrelLista() {
		return correlLista;
	}

	public void setCorrelLista(List<Correlativo> correlLista) {
		this.correlLista = correlLista;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}
	
	

}
