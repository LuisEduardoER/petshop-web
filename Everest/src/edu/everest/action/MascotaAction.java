package edu.everest.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Cliente;
import edu.everest.entity.Mascota;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.MascotaService;

@ParentPackage(value = "dawii")
public class MascotaAction extends ActionSupport{
	
	private static final long serialVersionUID = 4740942509922335538L;
	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();	
	private static MascotaService mascotaService = abd.getMascotaService();
	
	private Mascota mascota;
	private Cliente cliente;
	private List<Mascota> mascotaLista;
	private String oper;
	private int count;
	
	@Action(value="/showMascotaMantenimientoAction",
			results={ @Result(name="success", location="mascotaMantenimientoTile",type="tiles") })
	public String showMascotaLista() throws Exception{
		try{
			System.out.println( "idCliente(): "+cliente.getIdCliente() );
//			Cliente cliente = new Cliente();
//			cliente.setIdCliente( Integer.parseInt(hdIdCliente) );
			
			mascotaLista = mascotaService.obtenerTodosMascota(cliente);
			count = mascotaLista.size();
		}catch(Exception ex){
			System.out.println("showMascotaLista: "+ex);
		}
		return SUCCESS;
	}
	
	@Action(value="/showMascotaFormAction",
			results={ @Result(name="success", location="mascotaFormTile",type="tiles") })
	public String showMascotaForm() throws Exception{
		try{
			
			System.out.println("oper: "+oper);
			System.out.println( "idMascota: "+mascota.getIdMascota() );
			System.out.println( "idCliente(): "+cliente.getIdCliente() );
			
			if( mascota.getIdMascota() != 0 )
				mascota = mascotaService.obtenerMascota(mascota);
			
		}catch(Exception ex){
			System.out.println("showMascotaForm: "+ex);
		}
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarMascota", 
			results = { @Result(location = "mascotaMantenimientoTile", name = "success", type = "tiles"),
						@Result(location = "mascotaFormTile", name = "input", type = "tiles")
						})
	public String insertarOActualizar() throws Exception {
	
	System.out.println( "idCliente(): "+cliente.getIdCliente() );
	
	if(cliente != null){
		System.out.println("cod:"+mascota.getIdMascota() );
		System.out.println("insertarOActualizar");
		
//		cliente.setIdCliente(Integer.parseInt(hdIdCliente));
		mascota.setCliente(cliente);
		
	}
	
		if (mascota.getIdMascota() == 0) {
			mascotaService.insertarMascota(mascota);
			System.out.println("insertarMascota");
		} else {
			mascotaService.actualizarMascota(mascota);
			System.out.println("actualizarMascota");
		}
		
		showMascotaLista();
	
		return SUCCESS;
	}
		
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public List<Mascota> getMascotaLista() {
		return mascotaLista;
	}
	public void setMascotaLista(List<Mascota> mascotaLista) {
		this.mascotaLista = mascotaLista;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
