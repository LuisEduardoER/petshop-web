package edu.everest.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.DetallePago;
import edu.everest.entity.Pago;

@ParentPackage(value = "dawii")
public class PagoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2701563596684432802L;
	
	private Pago 				pago;
	private DetallePago 		detallePago;
	private List<Pago> 			pagoLista = new ArrayList<Pago>();
	private List<DetallePago> 	detallePagoLista = new ArrayList<DetallePago>();
	
	private Map<String,String>  tipoComprobanteLista;
	private String				tipoComprobante;
	private String 				dynamicResult;
	
	@Action(value="/showPagoPageAction",
			results={ @Result(name="success", location="pagoPageTile",type="tiles") })
	public String showClienteRegistrar() throws Exception{
		tipoComprobante = "boleta";
		
		return SUCCESS;
	}
	
	@Action(value="/loadTipoComprobanteAction",
			results={ @Result(name="success", location="/mantenimiento/pago/pagoBoleta.jsp"),
					  @Result(name="factura", location="/mantenimiento/pago/pagoFactura.jsp")
					})
	public String loadTipoComprobante() throws Exception{
		System.out.println("===== loadTipoComprobante =====");
		String strReturn="";
		
		System.out.println("tipoComprobante: "+tipoComprobante);
		if(tipoComprobante == null){
			tipoComprobante = "boleta";
		}
		
		if(tipoComprobante.equals("boleta"))
			strReturn = SUCCESS;
		else if(tipoComprobante.equals("factura"))
			strReturn = tipoComprobante;
		
		return strReturn;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public DetallePago getDetallePago() {
		return detallePago;
	}

	public void setDetallePago(DetallePago detallePago) {
		this.detallePago = detallePago;
	}

	public List<Pago> getPagoLista() {
		return pagoLista;
	}

	public void setPagoLista(List<Pago> pagoLista) {
		this.pagoLista = pagoLista;
	}

	public List<DetallePago> getDetallePagoLista() {
		return detallePagoLista;
	}

	public void setDetallePagoLista(List<DetallePago> detallePagoLista) {
		this.detallePagoLista = detallePagoLista;
	}

	public Map<String, String> getTipoComprobanteLista() {
		return tipoComprobanteLista;
	}

	public void setTipoComprobanteLista(Map<String, String> tipoComprobanteLista) {
		this.tipoComprobanteLista = tipoComprobanteLista;
	}

	public String getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public String getDynamicResult() {
		return dynamicResult;
	}

	public void setDynamicResult(String dynamicResult) {
		this.dynamicResult = dynamicResult;
	}
	
}
