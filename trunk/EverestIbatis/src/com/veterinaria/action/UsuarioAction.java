package com.veterinaria.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Rol;
import com.veterinaria.beans.Usuario;
import com.veterinaria.service.RolService;
import com.veterinaria.service.UsuarioService;

@ParentPackage(value = "Veterinaria")
public class UsuarioAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Rol rol;
	
	private List<Usuario> usuarioLista;
	private List<Rol> rolLista = new ArrayList<Rol>();
	
	private String oper;
	
	UsuarioService usuarioService = new UsuarioService();
	RolService rolService = new RolService();
	
	@Action(value="showUsuarioLista",
			results={ @Result(name="success", location="usuarioListaTile", type="tiles") }
	)
	public String showUsuarioLista(){
		System.out.println("===== showUsuarioLista2 =====");
		
		try {
			
			rolLista = rolService.listarRol();
			System.out.println("rolLista: "+rolLista.size());
			
			usuarioLista = usuarioService.listarUsuario();
			System.out.println("usuarioLista: "+usuarioLista.size());
			
		} catch (Exception e) {
			System.out.println("showUsuarioLista.error: "+e);
		}
		
		return SUCCESS;
	}
	
	@Action(value="showUsuarioForm",
			results={ @Result(name="success", location="usuarioFormTile", type="tiles") }
	)
	public String showUsuarioForm(){
		System.out.println("===== showUsuarioForm =====");
		System.out.println("oper: "+oper);
		
		try{
		if(oper != null){
			System.out.println("usuario: "+usuario);
			
			//Cargando Roles
			rolLista = rolService.listarRol();
			System.out.println("rolLista: "+rolLista.size());
			
			if(oper.equals("add")){
				
			}else if(oper.equals("edit")){
				usuario = usuarioService.obtenerUsuario(usuario);
			}
			
		}
		}catch(Exception e){
			System.out.println("showUsuarioForm.error: "+e);
		}
		
		return SUCCESS;
	}
	
	@Action(value="saveUsuarioForm",
			results={ @Result(name="success", location="usuarioListaTile", type="tiles") }
	)
	public String saveUsuarioForm(){
		System.out.println("===== saveUsuarioForm =====");
		System.out.println("oper: "+oper);
		String result="";
		
		try{
			if(oper != null){
				System.out.println("usuario: "+usuario);
				
				if(oper.equals("add")){
					result = usuarioService.GrabarUsuario(usuario);
				}else if(oper.equals("edit")){
					result = usuarioService.ModificarUsuario(usuario);
				}
				System.out.println("result: "+result);
				showUsuarioLista();
				
			}
			
		}catch(Exception e){
			System.out.println("saveUsuarioForm.error: "+e);
		}
		
		return SUCCESS;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public List<Usuario> getUsuarioLista() {
		return usuarioLista;
	}
	public void setUsuarioLista(List<Usuario> usuarioLista) {
		this.usuarioLista = usuarioLista;
	}
	public List<Rol> getRolLista() {
		return rolLista;
	}
	public void setRolLista(List<Rol> rolLista) {
		this.rolLista = rolLista;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	
}
