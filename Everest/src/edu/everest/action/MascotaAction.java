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
	private List<Mascota> mascotaLista;
	private String hdIdCliente, oper;
	private int count;
	
	@Action(value="/showMascotaMantenimientoAction",
			results={ @Result(name="success", location="mascotaMantenimientoTile",type="tiles") })
	public String showMascotaLista() throws Exception{
		try{
			System.out.println( "hdIdCliente"+hdIdCliente );
			Cliente cliente = new Cliente();
			cliente.setIdCliente( Integer.parseInt(hdIdCliente) );
			
			mascotaLista = mascotaService.obtenerTodosMascota(cliente);
			count = mascotaLista.size();
		}catch(Exception ex){
			System.out.println("showMascotaLista: "+ex);
		}
		return SUCCESS;
	}
	
	@Action(value = "/insertarOActualizarMascota", 
			results = { @Result(location = "mascotaMantenimientoTile", name = "success", type = "tiles")})
	public String insertarOActualizar() throws Exception {
		
	System.out.println("hdIdCliente: "+hdIdCliente);
	System.out.println("cod:"+mascota.getIdMascota() );
	System.out.println("insertarOActualizar");
	
	
		if (mascota.getIdMascota() == 0) {

			Cliente cliente = new Cliente();
			cliente.setIdCliente(Integer.parseInt(hdIdCliente));
			mascota.setCliente(cliente);
			
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

	public String getHdIdCliente() {
		return hdIdCliente;
	}

	public void setHdIdCliente(String hdIdCliente) {
		this.hdIdCliente = hdIdCliente;
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
	
	
}
