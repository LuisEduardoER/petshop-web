package edu.everest.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.TipoAnimal;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.TipoAnimalService;

@ParentPackage(value = "dawii")
public class TipoAnimalAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4552921042091447368L;
	private TipoAnimal tipoAnimal;
	private List<TipoAnimal> tipoAnimalLista;
	private String oper;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static TipoAnimalService tipoAnimalService = abd.getTipoAnimalDAOService();
	
	@Action(value = "/showTipoAnimalLista", 
			results = { @Result(location = "tipoAnimalListaTile", name = "success", type="tiles") } )
	public String showTipoAnimales() throws Exception {
		tipoAnimalLista = tipoAnimalService.obtenerTodosTipoAnimal();
		return SUCCESS;
	}
	
	@Action(value = "/obtenerTipoAnimalJSON", 
			results = { @Result(name="success", type="json") } )
	public String obtenerTipoAnimalLista() throws Exception {
		tipoAnimalLista = tipoAnimalService.obtenerTodosTipoAnimal();
		return SUCCESS;
	}
	
	@Action(value = "/showTipoAnimalFormAction", 
			results = { @Result(location="/mantenimiento/tipoAnimal/tipoAnimalForm.jsp", name = "success") })
	public String showInsertarOActualizar() throws Exception {
		System.out.println("showInsertarOActualizar");
		if (tipoAnimal != null && tipoAnimal.getIdTipoAnimal() != 0) {			
			tipoAnimal = tipoAnimalService.obtenerTipoAnimal(tipoAnimal);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarTipoAnimal",  
			results = { @Result(location = "showTipoAnimalLista", name = "success", type = "redirectAction")})
	public String insertarOActualizar() throws Exception {
		
	System.out.println("oper: "+oper);
	System.out.println("cod:"+tipoAnimal.getIdTipoAnimal() );
	
	
		if (oper.equals("add")) {
			tipoAnimalService.insertarTipoAnimal(tipoAnimal);
			
		} else if (oper.equals("edit")) {
			tipoAnimalService.actualizarTipoAnimal(tipoAnimal);
			
		}else if (oper.equals("del")) {
			tipoAnimalService.eliminarTipoAnimal(tipoAnimal);
		}
		
		return SUCCESS;
	}	
	
	@Action(value = "/detalleTipoAnimal", 
			results = { @Result(location = "tipoAnimalDetailTile", name = "success", type="tiles") })
	// Metodo 5: Obtener detalle de Empleado
	public String detalleTipoAnimal() throws Exception {
		tipoAnimal = tipoAnimalService.obtenerTipoAnimal(tipoAnimal);
		return SUCCESS;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public List<TipoAnimal> getTipoAnimalLista() {
		return tipoAnimalLista;
	}

	public void setTipoAnimalLista(List<TipoAnimal> tipoAnimalLista) {
		this.tipoAnimalLista = tipoAnimalLista;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}
		
}
