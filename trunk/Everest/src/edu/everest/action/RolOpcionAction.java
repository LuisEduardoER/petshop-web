package edu.everest.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Opcion;
import edu.everest.entity.Rol;
import edu.everest.entity.RolOpcion;
import edu.everest.entity.RolOpcionPK;
import edu.everest.entity.Tab;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.OpcionService;
import edu.everest.service.RolOpcionService;
import edu.everest.service.RolService;

@ParentPackage(value = "dawii")
public class RolOpcionAction extends ActionSupport{

	private static final long serialVersionUID = 7498472392709441123L;
	
	private Opcion opcion;
	private Opcion opcionParent;
	private Rol rol;
	private RolOpcion rolOpcion;
	private List<Opcion> opcionLista;
	private List<Opcion> opcionParentLista;
	private List<Tab> 	 tipoLista;
	private String oper, tipo;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static RolService rolService 				= abd.getRolService();
	private static OpcionService opcionService 			= abd.getOpcionService();
	private static RolOpcionService rolOpcionService 	= abd.getRolOpcionService();
	
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
	
	@Action(value = "/showRolOpcionFormAction", 
			results = { @Result(location="/mantenimiento/rolOpcion/rolOpcionForm.jsp", name = "success") })
	public String showInsertarOActualizar() throws Exception {
		System.out.println("===== showRolOpcionFormAction =====");
		System.out.println("oper: " +oper);
		
		opcionParentLista = opcionService.obtenerOpcionParents();
		System.out.println("opcionParentLista: "+opcionParentLista.size() );
		
		if (oper.equals("add")) {
			opcion = new Opcion();
			opcionParent = new Opcion();
		}else {
			opcion = opcionService.obtenerOpcion(opcion);
			opcionParent = opcion.getOpcion();
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unused")
	@Action(value = "/insertarOActualizarRolOpcion",
			results = { @Result(location = "rolOpcionListaTile", name = "success", type="tiles")})
	public String insertarOActualizar() throws Exception {
		System.out.println("===== insertarOActualizarRolOpcion =====");
		
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
			
			objRolOpcion.setOpcion(opcion);
			objRolOpcion.setRol(rol);
			
			rolOpcionService.insertarRolOpcion(objRolOpcion);
			
		}else if(oper.equals("edit")){
			rolOpcionService.actualizarRolOpcion(rolOpcion);
			
		}else if(oper.equals("del")){
			rolOpcionService.eliminarRolOpcion(rolOpcion);
			
		}
		
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
	
}
