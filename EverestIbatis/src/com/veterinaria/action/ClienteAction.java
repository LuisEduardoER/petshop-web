package com.veterinaria.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;
import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Cliente;
import com.veterinaria.beans.Usuario;
import com.veterinaria.service.ClienteService;
import com.veterinaria.service.UsuarioService;
import com.veterinaria.utils.Constants;

@ParentPackage(value = "Veterinaria")
public class ClienteAction extends ActionSupport{
	
	private static final long serialVersionUID = 2312605187941863156L;	
	private ClienteService clienteService = new ClienteService();
	private UsuarioService usuarioService = new UsuarioService();
	
	private Cliente cliente;
	private Cliente familiar;
	private Usuario usuario;
	
	private List<Cliente> clienteLista;
	private List<Cliente> familiarLista;
	
//	private Usuario usu	ario;
	
	private String oper, result, message;
		
	DateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
		
	@Action(value="/showClienteLista",
			results={ @Result(name="success", location="clienteListaTile",type="tiles") })
	public String showClienteLista() throws Exception{
		System.out.println("===== showClienteLista =====");
		
		cliente = new Cliente();				
		clienteLista = clienteService.listarCliente(cliente);
		System.out.println("clienteLista: "+clienteLista.size());
		
		return SUCCESS;
	}
	@Action(value="/filtrarCliente",
			results={ @Result(name="success", location="/mantenimiento/cliente/clienteLista.jsp") })
	public String filtrarCliente() throws Exception{
		System.out.println("===== filtrarCliente =====");
		
		if(cliente == null)
			cliente = new Cliente();
		
		System.out.println( "TipoCliente: "+cliente.getTipoCliente() );
		System.out.println( "DNI: "+cliente.getDni() );
		System.out.println( "Nombres: "+cliente.getNombres() );
		
		cliente.setNombreCompleto("%"+cliente.getNombres()+"%");
		
		clienteLista = clienteService.listarCliente(cliente);
		System.out.println("clienteLista: "+clienteLista.size());
		
		return SUCCESS;
	}
	
	@Action(value="/showClienteRegistrar",
			results={ @Result(name="success", location="clienteRegistrarTile",type="tiles") })
	public String showClienteRegistrar() throws Exception{
		System.out.println("===== showClienteRegistrar =====");
		System.out.println("oper: "+oper);
		
		if(oper != null){
			if(oper.equals("add")){
				cliente = new Cliente();
				cliente.setTipoCliente("P");
				
			}else if(oper.equals("edit"))
				cliente = clienteService.obtenerCliente(cliente);
		}
		
		return SUCCESS;
	}
	
	@Action(value="/saveClienteForm",
	results={ @Result(name="success", location="mascotaListaTile",type="tiles"),
			@Result(name="ERROR", location="clienteRegistrarTile",type="tiles"),
			@Result(name="input", location="clienteRegistrarTile",type="tiles")
			})
	public String saveClienteForm() throws Exception{
		System.out.println("===== saveClienteForm =====");
		System.out.println("oper: "+oper);
		String result = "";
		String request = SUCCESS;
		
		if(oper != null){
			if(cliente.getLineaCredito() > 0)
				cliente.setLineaCreditoBool("1");
			else
				cliente.setLineaCreditoBool("0");
			
			if(oper.equals("add")){
				
				//Validar Usuario
				usuario.setUser(cliente.getEmail());
				if(usuario.getPass().equals(""))
					usuario.setPass( cliente.getDni() );
				
				Usuario auxUsuario = usuarioService.obtenerUsuario(usuario);
				System.out.println("auxUsuario: "+auxUsuario);
				if(auxUsuario != null){
					message = "Correo ya se encuentra registrado en el sistema.";
					request = "ERROR";
				}
				
				//Validar Cliente
				Cliente auxCliente = clienteService.obtenerCliente(cliente);
				System.out.println("auxCliente: "+auxCliente);
				if(auxCliente != null){
					message = "DNI ya se encuentra registrado en el sistema";
					request = "ERROR";
				}else{
					result = usuarioService.obtenerMaxUsuario();
					System.out.println("obtenerMaxUsuario: "+result);
					usuario.setIdUsuario(Integer.parseInt(result));
					cliente.setIdUsuario(Integer.parseInt(result));
					
					usuario.setIdRol(Constants.KV_ROL_CLIENTE);
					usuario.setEstado(cliente.getEstado());
					
					result = usuarioService.GrabarUsuario(usuario);
					System.out.println("GrabarUsuario: "+result);
					
					result = clienteService.GrabarCliente(cliente);
					System.out.println("GrabarCliente: "+result);
				}
				
			}else if(oper.equals("edit")){
				result = clienteService.ModificarCliente(cliente);
				
				showClienteLista();
				request = SUCCESS;
			}
			
			message = "Registro Guardado Correctamente.";
			
			System.out.println("result: "+result);
		}
		
		return request;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClienteLista() {
		return clienteLista;
	}

	public void setClienteLista(List<Cliente> clienteLista) {
		this.clienteLista = clienteLista;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public Cliente getFamiliar() {
		return familiar;
	}

	public void setFamiliar(Cliente familiar) {
		this.familiar = familiar;
	}

	public List<Cliente> getFamiliarLista() {
		return familiarLista;
	}

	public void setFamiliarLista(List<Cliente> familiarLista) {
		this.familiarLista = familiarLista;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

