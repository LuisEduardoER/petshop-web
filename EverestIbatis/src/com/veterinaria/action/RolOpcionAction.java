package com.veterinaria.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Opcion;
import com.veterinaria.beans.Rol;
import com.veterinaria.beans.RolOpcion;
import com.veterinaria.beans.Tab;
import com.veterinaria.service.OpcionService;
import com.veterinaria.service.RolOpcionService;
import com.veterinaria.service.RolService;

@ParentPackage(value = "Veterinaria")
public class RolOpcionAction extends ActionSupport{

	private static final long serialVersionUID = 7498472392709441123L;
	
	private Opcion opcion;
	private Opcion opcionParent;
	private Rol rol;
	private RolOpcion rolOpcion;
	private List<Opcion> opcionLista;
	private List<Opcion> opcionParentLista;
	private List<Tab> 	 tipoLista;
	private String oper, tipo, idOpcionParent, idOpcion;
	
	private static RolService rolService = new RolService();
	private static OpcionService opcionService = new OpcionService();
	private static RolOpcionService rolOpcionService = new RolOpcionService();
	
	@Action(value = "/showRolOpcionListaAction", 
			results = { @Result(location = "rolOpcionListaTile", name = "success", type="tiles") } )
	public String showRolOpciones() throws Exception {
		System.out.println("===== showRolOpcionListaAction =====");
		
		try{
			System.out.println("rol: "+rol.getIdRol());
			rol = rolService.obtenerRol(rol);
			
			List<Opcion> listaParentOpcion = new ArrayList<Opcion>();;
			List<Opcion> listaChildOpcion;
			listaParentOpcion = opcionService.obtenerOpcionParentByRol(rol);
			opcionLista= new ArrayList<Opcion>();
			
			for (Opcion parentOpcion : listaParentOpcion) {
				
				opcionLista.add(parentOpcion);
				
				listaChildOpcion = new ArrayList<Opcion>();
				listaChildOpcion = opcionService.obtenerOpcionByParent(parentOpcion);
				
				for (Opcion childOpcion : listaChildOpcion) {
					opcionLista.add(childOpcion);
				}
				
			}
		
		}
		catch (Exception e) {
			System.out.println("showRolOpciones: "+e);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/loadOpcionsJSON", 
			results = { 
				@Result(name = "success", type="json"),
				@Result(name = "input", type="json")
					} 
			)
	public String loadOpcionsJSON() throws Exception {
		System.out.println("===== loadOpcionsJSON =====");
		
		if(idOpcionParent == null)
			idOpcionParent = "";
		
		opcionParentLista = opcionService.listarOpcion();
		System.out.println("opcionParentLista: "+opcionParentLista.size() );
		
		System.out.println("opcionParent: "+idOpcionParent);
		if(!idOpcionParent.equals("")){
			opcionParent = new Opcion();
			opcionParent.setIdOpcion(Integer.parseInt(idOpcionParent));
		
			opcionLista = opcionService.obtenerOpcionByParent(opcionParent);
//			List<Opcion> opcionListaAux = opcionService.obtenerOpcionChildByRol(opcionParent, rol);
//			
////			for(Opcion objOpcion : opcionLista)
////				for(Opcion objOpcionAux: opcionListaAux)
////					if(objOpcion.getIdOpcion() == objOpcionAux.getIdOpcion())
////						opcionLista.remove(objOpcion);
//			
//			for(int c=0;c>opcionListaAux.size();c++)
//				for(int p=0;p>opcionLista.size();p++)				
//					if(opcionLista.get(p).getIdOpcion() == opcionListaAux.get(c).getIdOpcion() ){
//						opcionLista.remove(p);
//						p--;
//					}
			
			System.out.println("opcionLista: "+opcionLista.size() );
			
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/showRolOpcionFormAction", 
			results = { @Result(location="/mantenimiento/rolOpcion/rolOpcionForm.jsp", name = "success") })
	public String showInsertarOActualizar() throws Exception {
		System.out.println("===== showRolOpcionFormAction =====");
		System.out.println("oper: " +oper);
		
		if (oper.equals("add")) {
			opcion = new Opcion();
			opcionParent = new Opcion();
		}else {
			opcion = opcionService.obtenerOpcion(opcion);
			opcionParent = opcion.getOpcion();
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarRolOpcion",
			results = { @Result(location = "rolOpcionListaTile", name = "success", type="tiles")})
	public String insertarOActualizar() throws Exception {
		System.out.println("===== insertarOActualizarRolOpcion =====");
		System.out.println();
		
		try{
			
			if(rolOpcion.getIdOpcion() != 0){
				System.out.println("idOpcion: "+rolOpcion.getIdOpcion() );
				System.out.println("idRol: "+rolOpcion.getIdRol() );
			}
			
			if( oper.equals("add") ){
				rolOpcionService.GrabarRolOpcion(rolOpcion);
				
			}else if( oper.equals("del") ){
				Opcion objOpcion = new Opcion();
				objOpcion.setIdOpcion( rolOpcion.getIdOpcion() );
				objOpcion = opcionService.obtenerOpcion(objOpcion);
				
				Rol objRol = new Rol();
				objRol.setIdRol( rolOpcion.getIdRol() );
				objRol = rolService.obtenerRol(objRol);
				
				rolOpcion.setOpcion( objOpcion );
				rolOpcion.setRol( objRol );
				rolOpcionService.EliminarRolOpcion(rolOpcion);
				
			}
			
			showRolOpciones();
			
			
		}catch(Exception ex){
			System.out.println("main: "+ex);
		}
		
		/*
		
//		System.out.println("opcion:"+opcion.getIdOpcion() );
//		System.out.println("rol: "+rol.getIdRol() );
		System.out.println("oper: "+oper);
		
		RolOpcion objRolOpcion = new RolOpcion();
		RolOpcionPK objRolOpcionPK = new RolOpcionPK();
		
		if(oper.equals("add")){
			opcion.setOpcion( opcionParent );
			opcionService.insertarOpcion(opcion);
			
//			objRolOpcionPK.setIdOpcion( opcion.getIdOpcion() );
//			objRolOpcionPK.setIdRol( rol.getIdRol() );			
//			objRolOpcion.setId(objRolOpcionPK);
			
			objRolOpcion.getRolOpcionPK().setOpcion(opcion);
			objRolOpcion.getRolOpcionPK().setRol(rol);
			
			rolOpcionService.insertarRolOpcion(objRolOpcion);
			
		}else if(oper.equals("edit")){
			rolOpcionService.actualizarRolOpcion(rolOpcion);
			
		}else if(oper.equals("del")){
			rolOpcionService.eliminarRolOpcion(rolOpcion);
			
		}
		*/
		
		showRolOpciones();
		
		return SUCCESS;
	}
		
	@Action(value="/loadTipoJSON",
			results={ @Result(name="success", type="json") })
	public String loadTipo() throws Exception{
		
		System.out.println("===== loadTipoJSON =====");
		
		tipoLista = new ArrayList<Tab>();
		tipoLista.add(new Tab("0", "Parent"));
		tipoLista.add(new Tab("1", "Opcion"));
		
		return SUCCESS;
	}
	
	public Opcion getOpcion() {
		return opcion;
	}
	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public List<Opcion> getOpcionLista() {
		return opcionLista;
	}
	public void setOpcionLista(List<Opcion> opcionLista) {
		this.opcionLista = opcionLista;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}

	public List<Opcion> getOpcionParentLista() {
		return opcionParentLista;
	}

	public void setOpcionParentLista(List<Opcion> opcionParentLista) {
		this.opcionParentLista = opcionParentLista;
	}

	public List<Tab> getTipoLista() {
		return tipoLista;
	}

	public void setTipoLista(List<Tab> tipoLista) {
		this.tipoLista = tipoLista;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Opcion getOpcionParent() {
		return opcionParent;
	}

	public void setOpcionParent(Opcion opcionParent) {
		this.opcionParent = opcionParent;
	}

	public RolOpcion getRolOpcion() {
		return rolOpcion;
	}

	public void setRolOpcion(RolOpcion rolOpcion) {
		this.rolOpcion = rolOpcion;
	}
	
	public String getIdOpcionParent() {
		return idOpcionParent;
	}

	public void setIdOpcionParent(String idOpcionParent) {
		this.idOpcionParent = idOpcionParent;
	}

	public String getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(String idOpcion) {
		this.idOpcion = idOpcion;
	}
	
}
