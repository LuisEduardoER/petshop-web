package edu.everest.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import edu.everest.entity.Local;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.LocalService;


@ParentPackage(value = "dawii")

public class LocalAction extends ActionSupport {


	private static final long serialVersionUID = 5624322965793407206L;
	private Local local;
	private List<Local> localLista;
	private String oper;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static LocalService localService = abd.getLocalService();
	
	
	@Action(value = "/showLocalLista", 
			results = { @Result(location = "localListaTile", name = "success", type="tiles") } )
	public String showlocales() throws Exception {
		localLista = localService.obtenerTodosLocal();
		return SUCCESS;
	}
	
	@Action(value = "/obtenerLocalJSON", 
			results = { @Result(name="success", type="json") } )
	public String obtenerLocalLista() throws Exception {
		localLista = localService.obtenerTodosLocal();
		return SUCCESS;
	}
	
	@Action(value = "/showLocalFormAction",
			results = { @Result(location="/mantenimiento/local/localForm.jsp", name = "success") })
	public String showInsertarOActualizar() throws Exception {
		System.out.println("showInsertarOActualizar");
		if (local != null && local.getIdLocal() != 0) {			
			local = localService.obtenerLocal(local);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarLocal",  
			results = { @Result(location = "showLocalLista", name = "success", type = "redirectAction")})
	public String insertarOActualizar() throws Exception {
		
	System.out.println("oper: "+oper);
	System.out.println("cod:"+local.getIdLocal() );
	
	
		if (oper.equals("add")) {
			localService.insertarLocal(local);
			
		} else if (oper.equals("edit")) {
			localService.actualizarLocal(local);
			
		}else if (oper.equals("del")) {
			localService.eliminarLocal(local);
		}
		
		return SUCCESS;
	}	
	
	@Action(value = "/detalleLocal", 
			results = { @Result(location = "localDetailTile", name = "success", type="tiles") })
	// Metodo 5: Obtener detalle de Empleado
	public String detalleLocal() throws Exception {
		local = localService.obtenerLocal(local);
		return SUCCESS;
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

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}
	
	
	
}
