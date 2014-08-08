package com.veterinaria.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.jgeppert.struts2.jquery.components.Tab;
import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Opcion;
import com.veterinaria.service.OpcionService;

@ParentPackage(value = "Veterinaria")
public class OpcionAction extends ActionSupport{

	private static final long serialVersionUID = 7498472392709441123L;
	
	private Opcion opcion;
	private Opcion opcionParent;
	private List<Opcion> opcionLista;
	private List<Opcion> opcionParentLista;
	private List<Tab> 	 tipoLista;
	private String oper, tipo;
	
	private static OpcionService opcionService = new OpcionService();
	
	@Action(value = "/showOpcionListaAction", 
			results = { @Result(location = "opcionListaTile", name = "success", type="tiles") } )
	public String showOpciones() throws Exception {
		System.out.println("===== showOpcionListaAction =====");
		
		try{
			
			List<Opcion> listaParentOpcion = new ArrayList<Opcion>();
			List<Opcion> listaChildOpcion;
			listaParentOpcion = opcionService.listarOpcion();
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
		System.out.println("===== showOpcionFormAction =====");
		System.out.println("oper: " +oper);
		
		opcionParentLista = opcionService.listarOpcion();
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
	
	@Action(value = "/insertarOActualizarOpcion",
			results = { @Result(location = "opcionListaTile", name = "success", type="tiles")})
	public String insertarOActualizar() throws Exception {
		System.out.println("===== insertarOActualizarOpcion =====");
		System.out.println("oper: "+oper );
		System.out.println("opcion:"+opcion.getIdOpcion() );
		System.out.println("parent:"+opcion.getParentOpcionId() );
		
		if (oper.equals("add")) {
			
//			if(opcionParent.getIdOpcion() == 0)
//				opcion.setOpcion( null );
			
			opcionService.GrabarOpcion(opcion);
		} else if (oper.equals("edit")) {
			opcionService.ModificarOpcion(opcion);
		}else if (oper.equals("del")) {
			opcionService.EliminarOpcion(opcion);
		}
		
		showOpciones();
		
		return SUCCESS;
	}	
	
//	@Action(value="/loadTipoJSON",
//			results={ @Result(name="success", type="json") })
//	public String loadTipo() throws Exception{
//		
//		System.out.println("===== loadTipoJSON =====");
//		
//		tipoLista = new ArrayList<Tab>();
//		tipoLista.add(new Tab("0", "Parent"));
//		tipoLista.add(new Tab("1", "Opcion"));
//		
//		return SUCCESS;
//	}
	
	public Opcion getOpcion() {
		return opcion;
	}
	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
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
	
}
