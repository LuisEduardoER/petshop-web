package edu.everest.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Opcion;
import edu.everest.entity.Rol;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.OpcionService;

@ParentPackage(value = "dawii")
public class OpcionAction extends ActionSupport{

	private static final long serialVersionUID = 7498472392709441123L;
	
	private Opcion opcion;
	private Rol rol;
	private List<Opcion> opcionLista;
	private String oper;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static OpcionService opcionService = abd.getOpcionService();
	
	@Action(value = "/showOpcionListaAction", 
			results = { @Result(location = "/mantenimiento/opcion/opcionLista.jsp", name = "success") } )
	public String showOpciones() throws Exception {
		
		try{
		
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
	
}
