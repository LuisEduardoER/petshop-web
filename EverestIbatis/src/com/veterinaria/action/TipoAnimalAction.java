package com.veterinaria.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.TipoAnimal;
import com.veterinaria.service.TipoAnimalService;

@ParentPackage(value = "Veterinaria")
public class TipoAnimalAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4552921042091447368L;
	private TipoAnimal tipoAnimal;
	private List<TipoAnimal> tipoAnimalLista;
	private String oper;
	
	private static TipoAnimalService tipoAnimalService = new TipoAnimalService();
	
	@Action(value = "/showTipoAnimalLista", 
			results = { @Result(location = "tipoAnimalListaTile", name = "success", type="tiles") } )
	public String showTipoAnimales() throws Exception {
		tipoAnimalLista = tipoAnimalService.listarTipoAnimal();
		return SUCCESS;
	}
	
	@Action(value = "/obtenerTipoAnimalJSON", 
			results = { @Result(name="success", type="json") } )
	public String obtenerTipoAnimalLista() throws Exception {
		tipoAnimalLista = tipoAnimalService.listarTipoAnimal();
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
			tipoAnimalService.GrabarTipoAnimal(tipoAnimal);
			
		} else if (oper.equals("edit")) {
			tipoAnimalService.ModificarTipoAnimal(tipoAnimal);
			
		}else if (oper.equals("del")) {
			tipoAnimalService.EliminarTipoAnimal(tipoAnimal);
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
