package com.veterinaria.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Cliente;
import com.veterinaria.beans.Opcion;
import com.veterinaria.beans.Rol;
import com.veterinaria.beans.Usuario;
import com.veterinaria.service.ClienteService;
import com.veterinaria.service.OpcionService;
import com.veterinaria.service.RolService;
import com.veterinaria.service.UsuarioService;

@ParentPackage(value = "Veterinaria")
public class UsuarioAction extends ActionSupport{
	
	private static final long serialVersionUID = -5554898376889712995L;
	
	private Usuario usuario;
	private Cliente cliente;
	private Rol 	rol;
	private List<Usuario> listaUsuario;
	private List<Opcion> listaOpcion;
	private List<Rol> listaRol;
	private String strNameUsuario;
	private String strMessage;
	
	private static UsuarioService 	usuarioService 	= new UsuarioService();
	private static RolService 		rolService 		= new RolService();
	private static ClienteService 	clienteService 	= new ClienteService();
	private static OpcionService 	opcionService 	= new OpcionService();
	
	@SuppressWarnings("rawtypes")
	private Map session = ActionContext.getContext().getSession();
	
	@Action(value = "/validarUsuario", 
			results = { 
				@Result(location = "intranetBienvenidoTile", name = "success",  type = "tiles"),
				@Result(location = "loginTile", 			 name = "BADLOGIN", type = "tiles")
			}
		)
	public String validarUsuario() throws Exception {
		System.out.println("===== validarUsuario =====");
		int nValid = 0;
		logOut();
		
		if(session.get("objCliente") != null){			
			cliente = (Cliente) session.get("objCliente");
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
//				getMenuByRol();
				return SUCCESS;
			}
			
		}
		
	}
	
	@Action(value = "/logOut", 
			results = { 
				@Result(location = "loginTile", name = "success",  type = "tiles")
			}
		)
	public String logOut(){
		System.out.println("===== logOut =====");
		
		session.remove("objCliente");
		session.remove("objOpciones");
		
		return SUCCESS;
	}
	
	//Obteniendo Datos de Usuario
	@SuppressWarnings("unchecked")
	public void getDatosUsuario(){
		System.out.println("===== getDatosUsuario =====");
		
		rol = new Rol();
		cliente = new Cliente();
		
		try {
			usuario = usuarioService.obtenerUsuario(usuario);
			
			
			rol.setIdRol( usuario.getIdRol() );
			
			usuario.setRol( rolService.obtenerRol( rol ));
			
			cliente = clienteService.obtenerClienteByUsuario(usuario);
			cliente.setUsuario(usuario);
			
			strNameUsuario = cliente.getNombres()+" "+cliente.getApePat();
			
			session.put("objCliente", cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Action(value = "/loadMenuAction", 
			results = { @Result(location = "/layoutIntranet/rightMenu.jsp", name = "success") }
		)
	@SuppressWarnings({ "unchecked" })
	public String getMenuByRol(){
		System.out.println("===== getMenuByRol =====");
		
		try {
			if(session.get("objOpciones") != null)
				listaOpcion = (ArrayList<Opcion>) session.get("objOpciones");
			else
			{
				List<Opcion> listaParentOpcion = new ArrayList<Opcion>();;
				List<Opcion> listaChildOpcion;
				listaParentOpcion = opcionService.obtenerOpcionParentByRol(cliente.getUsuario().getRol());
				System.out.println("listaParentOpcion: "+listaParentOpcion.size());
				
				listaOpcion= new ArrayList<Opcion>();
				
				for (Opcion parentOpcion : listaParentOpcion) {
					
					listaChildOpcion = new ArrayList<Opcion>();
					listaChildOpcion = opcionService.obtenerOpcionByParent(parentOpcion);					
					System.out.println("listaChildOpcion: "+listaChildOpcion.size());
					
					parentOpcion.setOpcions( listaChildOpcion );
					
//					for (Opcion childOpcion : listaChildOpcion) {
//						listaOpcion.add(childOpcion);
//					}
					
					listaOpcion.add(parentOpcion);
					
				}
				
				for( Opcion obj : listaOpcion ){
					if(obj.getOpcion() == null){
						System.out.println( "[Parent]["+obj.getTitulo() +"]" );
					}else
						System.out.println( "\t[Child]["+obj.getTitulo() +"]" );
				}
				
				
				session.put("objOpciones",listaOpcion);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			strMessage = "[UsuarionAction.getMenuByRol]["+e.getMessage()+"]";
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/showUsuarioListaAction", 
			results = { @Result(location = "usuarioListaTile", name = "success", type="tiles") } )
	public String showUsuarios() throws Exception {
		System.out.println("===== showUsuarioListaAction =====");
		
		listaUsuario = usuarioService.listarUsuario();
		
		return SUCCESS;
	}
	
	@Action(value = "/showUsuarioFormAction", 
			results = { @Result(location="/mantenimiento/usuario/usuarioForm.jsp", name = "success") })
	public String showInsertarOActualizar() throws Exception {
		System.out.println("===== showUsuarioFormAction =====");
		
		listaRol = rolService.listarRol();
		
		if (usuario != null && usuario.getIdUsuario() != 0) {
			usuario = usuarioService.obtenerUsuario(usuario);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarUsuario",  
			results = { @Result(location = "showUsuarioLista", name = "success", type = "redirectAction")})
	public String insertarOActualizar() throws Exception {
		System.out.println("===== insertarOActualizarUsuario =====");
		System.out.println("usuario: "+usuario.getIdUsuario() );
//		System.out.println("rol: "+rol.getIdRol() );
	
		if (usuario.getIdUsuario() == 0) {
			usuarioService.GrabarUsuario(usuario);
			
		} else {
			usuarioService.ModificarUsuario(usuario);
		}
		
		return SUCCESS;
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
	
	public List<Rol> getListaRol() {
		return listaRol;
	}

	public void setListaRol(List<Rol> listaRol) {
		this.listaRol = listaRol;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}
