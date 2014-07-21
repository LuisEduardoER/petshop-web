package edu.everest.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Cita;
import edu.everest.entity.Cliente;
import edu.everest.entity.Cobro;
import edu.everest.entity.DetalleCobro;

@ParentPackage(value = "dawii")
public class CobroAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2701563596684432802L;
	
	private Cobro 				cobro;
	private DetalleCobro 		detalleCobro;
	private List<Cobro> 		cobroLista 			= new ArrayList<Cobro>();
	private List<DetalleCobro> 	detalleCobroLista 	= new ArrayList<DetalleCobro>();
	
	private Cliente				cliente;
	private List<Cita>			citaLista	 		= new ArrayList<Cita>();;
	
	private Map<String,String>  tipoComprobanteLista;
	private String				tipoComprobante;
	private String 				tipoCobro;
	private String				oper;
	
	@Action(value="/showCobroPageAction",
			results={ @Result(name="success", location="cobroFormTile",type="tiles") })
	public String showClienteRegistrar() throws Exception{
		tipoComprobante = "boleta";
		tipoCobro		= "contado";
		return SUCCESS;
	}
	
	@Action(value="/showCobroClienteAction",
			results={ @Result(name="success", location="/mantenimiento/cobro/cobroFormCliente.jsp") })
	public String showCobroCliente() throws Exception{
		
		if(oper != null){
			
			cliente = new Cliente();
			Cita cita;
			for(int i=1; i<=5; i++){
				cita = new Cita();
				
				cita.setIdCita("CIT0000"+i);
//				cita.setFecProg();
				
				citaLista.add(cita);
			}
			
		}
		
		return SUCCESS;
	}
	
	@Action(value="/loadTipoComprobanteAction",
			results={ @Result(name="success", location="/mantenimiento/cobro/cobroBoleta.jsp"),
					  @Result(name="factura", location="/mantenimiento/cobro/cobroFactura.jsp")
					})
	public String loadTipoComprobante() throws Exception{
		System.out.println("===== loadTipoComprobanteAction =====");
		String strReturn="";
		
		System.out.println("tipoComprobante: "+tipoComprobante);
		if(tipoComprobante == null){
			tipoComprobante = "contado";
		}
		
		if(tipoComprobante.equals("boleta"))
			strReturn = SUCCESS;
		else if(tipoComprobante.equals("factura"))
			strReturn = tipoComprobante;
		
		return strReturn;
	}
	
	@Action(value="/loadTipoCobroAction",
			results={ @Result(name="success", location="/mantenimiento/cobro/cobroContado.jsp"),
					  @Result(name="tarjeta", location="/mantenimiento/cobro/cobroTarjeta.jsp"),
					  @Result(name="lineaCredito", location="/mantenimiento/cobro/cobroLineaCredito.jsp")
					})
	public String loadTipoCobro() throws Exception{
		System.out.println("===== loadTipoCobroAction =====");
		String strReturn="";
		
		System.out.println("tipoCobro: "+tipoCobro);
		
		if(tipoCobro.equals("contado"))
			strReturn = SUCCESS;
		else if(tipoCobro.equals("tarjeta"))
			strReturn = tipoCobro;
		else if(tipoCobro.equals("lineaCredito"))
			strReturn = tipoCobro;
		
		return strReturn;
	}

	public Cobro getCobro() {
		return cobro;
	}

	public void setCobro(Cobro cobro) {
		this.cobro = cobro;
	}

	public DetalleCobro getDetalleCobro() {
		return detalleCobro;
	}

	public void setDetalleCobro(DetalleCobro detalleCobro) {
		this.detalleCobro = detalleCobro;
	}

	public List<Cobro> getCobroLista() {
		return cobroLista;
	}

	public void setCobroLista(List<Cobro> cobroLista) {
		this.cobroLista = cobroLista;
	}

	public List<DetalleCobro> getDetalleCobroLista() {
		return detalleCobroLista;
	}

	public void setDetalleCobroLista(List<DetalleCobro> detalleCobroLista) {
		this.detalleCobroLista = detalleCobroLista;
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

	public String getTipoCobro() {
		return tipoCobro;
	}

	public void setTipoCobro(String tipoCobro) {
		this.tipoCobro = tipoCobro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cita> getCitaLista() {
		return citaLista;
	}

	public void setCitaLista(List<Cita> citaLista) {
		this.citaLista = citaLista;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}
	
}
