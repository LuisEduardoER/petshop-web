package com.veterinaria.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.TipoProducto;
import com.veterinaria.service.TipoProductoService;

@ParentPackage(value = "Veterinaria")

public class TipoProductoAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -134066766107486779L;
	/**
	 * 
	 */
	
	private TipoProducto tipoProducto;
	private List<TipoProducto> tipoProductoLista;
	private String oper;
	
	private static TipoProductoService tipoProductoService = new TipoProductoService();
	@Action(value = "/showTipoProductoLista", 
			results = { @Result(location = "tipoProductoListaTile", name = "success", type="tiles") } )
	public String showTipoProductoes() throws Exception {
		tipoProductoLista = tipoProductoService.listarTipoProducto();
		return SUCCESS;
	}
	
	@Action(value = "/obtenerTipoProductoJSON", 
			results = { @Result(name="success", type="json") } )
	public String obtenerTipoProductoLista() throws Exception {
		tipoProductoLista = tipoProductoService.listarTipoProducto();
		return SUCCESS;
	}
	
	@Action(value = "/showTipoProductoFormAction", 
			results = { @Result(location="/mantenimiento/tipoProducto/tipoProductoForm.jsp", name = "success") })
	public String showInsertarOActualizar() throws Exception {
		System.out.println("showInsertarOActualizar");
		if (tipoProducto != null && tipoProducto.getIdTipoProducto() != 0) {			
			tipoProducto = tipoProductoService.obtenerTipoProducto(tipoProducto);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarTipoProducto",  
			results = { @Result(location = "showTipoProductoLista", name = "success", type = "redirectAction")})
	public String insertarOActualizar() throws Exception {
		
	System.out.println("oper: "+oper);
	System.out.println("cod:"+tipoProducto.getIdTipoProducto() );
	
	
		if (oper.equals("add")) {
			tipoProductoService.GrabarTipoProducto(tipoProducto);
			
		} else if (oper.equals("edit")) {
			tipoProductoService.ModificarTipoProducto(tipoProducto);
			
		}else if (oper.equals("del")) {
			tipoProductoService.EliminarTipoProducto(tipoProducto);
		}
		
		return SUCCESS;
	}	
	
	@Action(value = "/detalleTipoProducto", 
			results = { @Result(location = "tipoProductoDetailTile", name = "success", type="tiles") })
	// Metodo 5: Obtener detalle de Empleado
	public String detalleTipoProducto() throws Exception {
		tipoProducto = tipoProductoService.obtenerTipoProducto(tipoProducto);
		return SUCCESS;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public List<TipoProducto> getTipoProductoLista() {
		return tipoProductoLista;
	}

	public void setTipoProductoLista(List<TipoProducto> tipoProductoLista) {
		this.tipoProductoLista = tipoProductoLista;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}
	
	
	

}
