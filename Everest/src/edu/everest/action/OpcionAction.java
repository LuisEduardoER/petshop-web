package edu.everest.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Opcion;
import edu.everest.entity.Rol;
import edu.everest.entity.Tab;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.OpcionService;
import edu.everest.service.RolService;

@ParentPackage(value = "dawii")
public class OpcionAction extends ActionSupport{

	private static final long serialVersionUID = 7498472392709441123L;
	
	private Opcion opcion;
	private Rol rol;
	private List<Opcion> opcionLista;
	private List<Opcion> opcionParentLista;
	private List<Tab> 	 tipoLista;
	private String oper, tipo;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static RolService rolService 		= abd.getRolService();
	private static OpcionService opcionService 	= abd.getOpcionService();
	
	@Action(value = "/showOpcionListaAction", 
			results = { @Result(location = "opcionListaTile", name = "success", type="tiles") } )
	public String showOpciones() throws Exception {
		System.out.println("===== showOpcionListaAction =====");
		
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
			System.out.println("showOpciones: "+e);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/showOpcionFormAction", 
			results = { @Result(location="/mantenimiento/opcion/opcionForm.jsp", name = "success") })
	public String showInsertarOActualizar() throws Exception {
		System.out.println("===== showRolFormAction =====");
		
		if (opcion != null && opcion.getIdOpcion() != 0) {	
			opcionParentLista = opcionService.obtenerOpcionParents();
			System.out.println("opcionParentLista: "+opcionParentLista.size() );
			
			opcion = opcionService.obtenerOpcion(opcion);
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarOpcion",
			results = { @Result(location = "opcionListaTile", name = "success", type="tiles")})
	public String insertarOActualizar() throws Exception {
		System.out.println("===== insertarOActualizarOpcion =====");
		
		System.out.println("opcion:"+opcion.getIdOpcion() );
		System.out.println("rol: "+rol.getIdRol() );
		
		if (opcion.getIdOpcion() == 0) {
			opcionService.insertarOpcion(opcion);
		} else {
			opcionService.actualizarOpcion(opcion);
		}
		
		showOpciones();
		
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
	
}
