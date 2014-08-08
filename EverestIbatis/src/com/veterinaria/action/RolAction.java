package com.veterinaria.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Rol;
import com.veterinaria.service.RolService;

@ParentPackage(value = "Veterinaria")
public class RolAction extends ActionSupport{

	private static final long serialVersionUID = -2090286063724725176L;
	
	private Rol rol;
	private List<Rol> rolLista;
	private String oper;
	
	private static RolService rolService = new RolService();
	
	@Action(value = "/showRolLista", 
			results = { @Result(location = "rolListaTile", name = "success", type="tiles") } )
	public String showRoles() throws Exception {
		rolLista = rolService.listarRol();
		return SUCCESS;
	}
	
	@Action(value = "/obtenerRolJSON", 
			results = { @Result(name="success", type="json") } )
	public String obtenerRolLista() throws Exception {
		rolLista = rolService.listarRol();
		return SUCCESS;
	}
	
	@Action(value = "/showRolFormAction", 
			results = { @Result(location="/mantenimiento/rol/rolForm.jsp", name = "success") })
	public String showInsertarOActualizar() throws Exception {
		System.out.println("showInsertarOActualizar");
		if (rol != null && rol.getIdRol() != 0) {			
			rol = rolService.obtenerRol(rol);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarRol",  
			results = { @Result(location = "showRolLista", name = "success", type = "redirectAction")})
	public String insertarOActualizar() throws Exception {
		
	System.out.println("oper: "+oper);
	System.out.println("cod:"+rol.getIdRol() );
	
	
		if (oper.equals("add")) {
			rolService.GrabarRol(rol);
			
		} else if (oper.equals("edit")) {
			rolService.ModificarRol(rol);
			
		}else if (oper.equals("del")) {
			rolService.EliminarRol(rol);
		}
		
		return SUCCESS;
	}	
	
	@Action(value = "/detalleRol", 
			results = { @Result(location = "rolDetailTile", name = "success", type="tiles") })
	// Metodo 5: Obtener detalle de Empleado
	public String detalleRol() throws Exception {
		rol = rolService.obtenerRol(rol);
		return SUCCESS;
	}
	
	
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public List<Rol> getRolLista() {
		return rolLista;
	}
	public void setRolLista(List<Rol> rolLista) {
		this.rolLista = rolLista;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	
}
