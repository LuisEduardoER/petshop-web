package edu.everest.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Proveedor;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.ProveedorService;

@ParentPackage(value = "dawii")
public class ProveedorAction extends ActionSupport{

	private static final long serialVersionUID = 8875052730654892023L;
	
	private Proveedor proveedor;
	private List<Proveedor> proveedores;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static ProveedorService proveedorService = abd.getProveedorService();
	
	@Action(value = "/obtenerProveedores", 
			results = { @Result(location = "proveedorListaTile", name = "success", type="tiles") } )
	public String obtenerTodosProveedores() throws Exception {		
		proveedores = proveedorService.obtenerTodosProveedores();
		syso("obtenerProveedores");
		return SUCCESS;
	}
	
	@Action(value = "/inicializarInsertarOActualizarProveedor", 
			results = { @Result(location = "proveedorFormTile", name = "success", type="tiles") })
	public String inicializarInsertarOActualizar() throws Exception {
		
		if (proveedor != null && proveedor.getIdProveedor() != 0) {			
			proveedor = proveedorService.obtenerProveedor(proveedor);
			syso("inicializarInsertarOActualizar - 1");
		}
		
		// listados
		proveedores = proveedorService.obtenerTodosProveedores();
		syso("inicializarInsertarOActualizar - 2");
		
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarProveedor", 
			results = { @Result(location = "obtenerProveedores", name = "success", type = "redirectAction")})
	public String insertarOActualizar() throws Exception {
		
	System.out.println("cod:"+proveedor.getIdProveedor() );
	syso("insertarOActualizar");
	
		if (proveedor.getIdProveedor() == 0) {
			proveedorService.insertarProveedor(proveedor);
			syso("insertarProveedor");
		} else {
			proveedorService.actualizarProveedor(proveedor);
			syso("actualizarProveedor");
		}
		
		return SUCCESS;
	}	
	
	@Action(value = "/eliminaProveedor", 
			results = { 
						@Result(
						location = "obtenerProveedores",
						name = "success", 
						type = "redirectAction") 
			}
	)	
	public String eliminarProveedor() throws Exception {
		proveedorService.eliminarProveedor(proveedor);
		return SUCCESS;
	}
	
	@Action(value = "/detalleProveedor", 
			results = { @Result(location = "proveedorDetailTile", name = "success", type="tiles") })
	// Metodo 5: Obtener detalle de Empleado
	public String detalleProveedor() throws Exception {
		proveedor = proveedorService.obtenerProveedor(proveedor);
		return SUCCESS;
	}
	
	public void syso(String str){
		System.out.println("[ProveedorAction."+str+"]");
	}
	
	public List<Proveedor> getProveedores() {
		return proveedores;
	}
	
	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
}
