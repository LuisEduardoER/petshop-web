package edu.everest.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.FormaPago;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.FormaPagoService;

@ParentPackage(value = "dawii")
public class FormaPagoAction extends ActionSupport {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 8102583793179409582L;
	private FormaPago formaPago;
	private List<FormaPago> formaPagoLista;
	private String oper;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static FormaPagoService formaPagoService = abd.getFormaPagoService();
	
	@Action(value = "/showFormaPagoLista", 
			results = { @Result(location = "formaPagoListaTile", name = "success", type="tiles") } )
	public String showFormaPagos() throws Exception {
		formaPagoLista = formaPagoService.obtenerTodosFormaPago();
		return SUCCESS;
	}
	
	@Action(value = "/obtenerFormaPagoJSON", 
			results = { @Result(name="success", type="json") } )
	public String obtenerFormaPagoLista() throws Exception {
		formaPagoLista = formaPagoService.obtenerTodosFormaPago();
		return SUCCESS;
	}
	
	@Action(value = "/showFormaPagoFormAction", 
			results = { @Result(location="/mantenimiento/formaPago/formaPagoForm.jsp", name = "success") })
	public String showInsertarOActualizar() throws Exception {
		System.out.println("showInsertarOActualizar");
		if (formaPago != null && formaPago.getIdFormaPago() != 0) {			
			formaPago = formaPagoService.obtenerFormaPago(formaPago);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarFormaPago",  
			results = { @Result(location = "showFormaPagoLista", name = "success", type = "redirectAction")})
	public String insertarOActualizar() throws Exception {
		
	System.out.println("oper: "+oper);
	System.out.println("cod:"+formaPago.getIdFormaPago() );
	
	
		if (oper.equals("add")) {
			formaPagoService.insertarFormaPago(formaPago);
			
		} else if (oper.equals("edit")) {
			formaPagoService.actualizarFormaPago(formaPago);
			
		}else if (oper.equals("del")) {
			formaPagoService.eliminarFormaPago(formaPago);
		}
		
		return SUCCESS;
	}	
	
	@Action(value = "/detalleFormaPago", 
			results = { @Result(location = "formaPagoDetailTile", name = "success", type="tiles") })
	// Metodo 5: Obtener detalle de Empleado
	public String detalleFormaPago() throws Exception {
		formaPago = formaPagoService.obtenerFormaPago(formaPago);
		return SUCCESS;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public List<FormaPago> getFormaPagoLista() {
		return formaPagoLista;
	}

	public void setFormaPagoLista(List<FormaPago> formaPagoLista) {
		this.formaPagoLista = formaPagoLista;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}
	
	
	
}
