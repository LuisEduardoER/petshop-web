package edu.everest.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Cliente;
import edu.everest.entity.Opcion;
import edu.everest.entity.Usuario;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.ClienteService;
import edu.everest.service.OpcionService;
import edu.everest.service.RolService;
import edu.everest.service.UsuarioService;

@ParentPackage(value = "dawii")
public class UsuarioAction extends ActionSupport{
	
	private static final long serialVersionUID = -5554898376889712995L;
	
	private Usuario usuario;
	private Cliente cliente;
	private List<Usuario> listaUsuario;
	private List<Opcion> listaOpcion;
	private String strNameUsuario;
	private String strMessage;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static UsuarioService usuarioService = abd.getUsuarioService();
	private static RolService rolService = abd.getRolService();
	private static ClienteService clienteService = abd.getClienteService();
	private static OpcionService opcionService = abd.getOpcionService();
	
	ActionContext ctx= ActionContext.getContext();
	@SuppressWarnings("rawtypes")
	Map m=ctx.getSession();
	
	@Action(value = "/validarUsuario", 
			results = { 
				@Result(location = "intranetBienvenidoTile", name = "success",  type = "tiles"),
				@Result(location = "loginTile", 			 name = "BADLOGIN", type = "tiles")
			}
		)
	public String validarUsuario() throws Exception {
		int nValid = 0;
		
		if(m.get("objCliente") != null){			
			cliente = (Cliente) m.get("objCliente");
			return SUCCESS;
		}else{
			
			try{
				nValid = usuarioService.validarUsuario(usuario);
				usuario.setIdUsuario(nValid);
			}
			catch(Exception ex){
				
			}
			
			System.out.println("nvalid: "+nValid);
			syso("validarUsuario");
			
			if(nValid == 0){
				strMessage = "Usuario y/o Contraseña incorrectas.";
				return "BADLOGIN";
			}else{
				getDatosUsuario();
				getMenuByRol();
				return SUCCESS;
			}
			
		}
		
	}
	
	public String logOut(){
		
		
		
		return SUCCESS;
	}
	
	//Obteniendo Datos de Usuario
	@SuppressWarnings("unchecked")
	public void getDatosUsuario(){
		
		try {
			
			usuario = usuarioService.obtenerUsuario(usuario);
			usuario.setRol( rolService.obtenerRol(usuario.getRol()) );
			
			cliente = clienteService.obtenerClienteByUsuario(usuario);
			cliente.setUsuario(usuario);
			
			strNameUsuario = cliente.getNombres()+" "+cliente.getApePat();
			
			m.put("objCliente", cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	public void getMenuByRol(){
		
		try {
			
			if(m.get("objCliente") != null){				
				cliente = (Cliente) m.get("objCliente");
				
				if(m.get("objOpciones") != null)
					listaOpcion = (ArrayList<Opcion>) m.get("objOpciones");
				else
				{
					List<Opcion> listaParentOpcion = new ArrayList<Opcion>();;
					List<Opcion> listaChildOpcion;
					listaParentOpcion = opcionService.obtenerOpcionParentByRol(cliente.getUsuario().getRol());
									
					for (Opcion parentOpcion : listaParentOpcion) {
						
						listaOpcion.add(parentOpcion);
						
						listaChildOpcion = new ArrayList<Opcion>();
						listaChildOpcion = opcionService.obtenerOpcionByParent(parentOpcion);					
						
						for (Opcion childOpcion : listaParentOpcion) {
							listaOpcion.add(childOpcion);
						}
						
					}
					m.put("objOpciones",listaOpcion);
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			strMessage = "[UsuarionAction.getMenuByRol]["+e.getMessage()+"]";
			e.printStackTrace();
		}
		
	}
	
	public void syso(String str){
		System.out.println("[UsuarioAction.getMenuByRol]["+str+"]");
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}
	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public String getStrNameUsuario() {
		return strNameUsuario;
	}

	public void setStrNameUsuario(String strNameUsuario) {
		this.strNameUsuario = strNameUsuario;
	}

	public String getStrMessage() {
		return strMessage;
	}

	public void setStrMessage(String strMessage) {
		this.strMessage = strMessage;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Opcion> getListaOpcion() {
		return listaOpcion;
	}
	public void setListaOpcion(List<Opcion> listaOpcion) {
		this.listaOpcion = listaOpcion;
	}
	
}
