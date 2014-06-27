package edu.everest.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Rol;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.RolService;

@ParentPackage(value = "dawii")
public class RolAction extends ActionSupport{

	private static final long serialVersionUID = -2090286063724725176L;
	
	private Rol rol;
	private List<Rol> rolLista;
	private String oper;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static RolService rolService = abd.getRolService();
	
	@Action(value = "/showRolLista", 
			results = { @Result(location = "rolListaTile", name = "success", type="tiles") } )
	public String showRoles() throws Exception {
		rolLista = rolService.obtenerTodosRol();
		return SUCCESS;
	}
	
	@Action(value = "/obtenerRolJSON", 
			results = { @Result(name="success", type="json") } )
	public String obtenerRolLista() throws Exception {
		rolLista = rolService.obtenerTodosRol();
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
		
	System.out.println("cod:"+rol.getIdRol() );
	
	
		if (rol.getIdRol() == 0) {
			rolService.insertarRol(rol);
			
		} else {
			rolService.actualizarRol(rol);
			
		}
		
		return SUCCESS;
	}	
	
	@Action(value = "/eliminaRol", 
			results = { 
						@Result(
						location = "obtenerRoles",
						name = "success", 
						type = "redirectAction") 
			}
	)	
	public String eliminarRol() throws Exception {
		rolService.eliminarRol(rol);
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
