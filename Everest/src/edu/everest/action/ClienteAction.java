package edu.everest.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Cliente;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.ClienteService;

@ParentPackage(value = "dawii")
public class ClienteAction extends ActionSupport{
	
	private static final long serialVersionUID = 2312605187941863156L;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static ClienteService clienteService = abd.getClienteService();
	
	private Cliente cliente;
	private List<Cliente> clientees;
	
	private String oper;
	private int idCliente, idTipoDocumento, idUsuario, idDIstrito, telefono, celular;
	private String documento, nombres, apePat, apeMat, sexo, fecNac, email, direccion, estado;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
	@Action(value="/showClienteRegistroAction",
			results={ @Result(name="success", location="clienteRegistrarTile",type="tiles") })
	public String showClienteRegistrar() throws Exception{
		return SUCCESS;
	}
	
	@Action(value="obtenerClienteJSON",
			results={ @Result(name="success",type="json") })
	public String obtenerClienteJSON() throws Exception{
		try{
		clientees = clienteService.obtenerTodosCliente();
		}catch(Exception ex){
			syso("obtenerClienteJSON: "+ex);
		}
		return SUCCESS;
	}
	
	@SuppressWarnings("deprecation")
	@Action(value="mantenimientoClienteJSON",
			results={ @Result(name="success",type="json") })
	public String MantenimientoJSON() throws Exception{
		try{
			Date dFecNac = new Date();
			syso("oper: "+oper);
			/*syso("[idCliente]["+idCliente+"]"
			   + "[ruc]["+ruc+"]"
			   + "[razonSocial]["+razonSocial+"]"
			   + "[direccion]["+direccion+"]");*/
			
			cliente = new Cliente();
			cliente.setIdCliente( idCliente );
			//cliente.setTipoDocumento(tipoDocumento);
			//cliente.setUsuario(usuario);
			cliente.setIdDIstrito(idDIstrito);
			cliente.setDocumento(documento);
			cliente.setNombres(nombres);
			cliente.setApePat(apePat);
			cliente.setApeMat(apeMat);
			cliente.setSexo(sexo);
			//cliente.setFecNac(fecNac);
			
			if(!fecNac.equals("")){
				//int date 
				//fecNac = dateFormat.format(dateFormat.parse(fecNac));
				dFecNac = new Date(fecNac);
				int nDay = dFecNac.getDate();
				int nMonth = dFecNac.getMonth();
				dFecNac.setDate(nMonth);
				dFecNac.setMonth(nDay);
			}
			
			cliente.setFecNac(dFecNac);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			cliente.setCelular(celular);
			cliente.setDireccion(direccion);
			
			if(oper.equals("add")){		
				clienteService.insertarCliente(cliente);
			}else if(oper.equals("edit")){
				clienteService.actualizarCliente(cliente);
			}else if(oper.equals("del")){
				clienteService.eliminarCliente(cliente);
			}
		}catch(Exception ex){
			syso("MantenimientoJSON: "+ex);
		}
		
		return SUCCESS;
	}
	
	public void syso(String str){
		System.out.println("[ClienteAction."+str+"]");
	}

	public static ClienteService getClienteService() {
		return clienteService;
	}

	public static void setClienteService(ClienteService clienteService) {
		ClienteAction.clienteService = clienteService;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientees() {
		return clientees;
	}

	public void setClientees(List<Cliente> clientees) {
		this.clientees = clientees;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdDIstrito() {
		return idDIstrito;
	}

	public void setIdDIstrito(int idDIstrito) {
		this.idDIstrito = idDIstrito;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApePat() {
		return apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	public String getApeMat() {
		return apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFecNac() {
		return fecNac;
	}

	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
