package com.veterinaria.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Cliente;
import com.veterinaria.beans.Correlativo;
import com.veterinaria.beans.Mascota;
import com.veterinaria.beans.TipoAnimal;
import com.veterinaria.service.ClienteService;
import com.veterinaria.service.CorrelativoService;
import com.veterinaria.service.MascotaService;
import com.veterinaria.service.TipoAnimalService;
import com.veterinaria.utils.MiUtil;


@ParentPackage(value="Veterinaria")
public class MascotaAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private MascotaService 		mascotaService = 		new MascotaService();
	private ClienteService 		clienteService = 		new ClienteService();
	private TipoAnimalService 	tipoAnimalService = 	new TipoAnimalService();
	private CorrelativoService 	correlativoService = 	new CorrelativoService();
	
	private Cliente cliente;
	private Mascota mascota;
	private TipoAnimal tipoAnimal;
	private Correlativo correlativo;
	
	private List<Mascota> mascotaLista = new ArrayList<Mascota>();
	private List<TipoAnimal> tipoAnimalLista = new ArrayList<TipoAnimal>();
	
	private String oper, result, imgFoto;
	
	@Action(value="/showMascotaLista",
			results={ @Result(name="success", location="mascotaListaTile",type="tiles") })
	public String showMascotaLista() throws Exception{
		System.out.println("===== showMascotaLista =====");
		
		if(cliente != null){
			System.out.println("IdCliente: "+cliente.getIdCliente());
			cliente = clienteService.obtenerCliente(cliente);
			
			mascotaLista = mascotaService.obtenerMascotaXCliente(cliente);
			System.out.println("mascotaLista: "+mascotaLista.size());
		}
		
		return SUCCESS;
	}
	
	@Action(value="/showMascotaForm",
			results={ @Result(name="success", location="mascotaFormTile",type="tiles"),
					  @Result(name="input", location="mascotaFormTile",type="tiles") })
	public String showMascotaForm() throws Exception{
		System.out.println("===== showMascotaForm =====");
		System.out.println("oper: "+oper);		
		
		if(oper != null){
			
			tipoAnimalLista = tipoAnimalService.listarTipoAnimal();
			
			if(oper.equals("edit")){
				System.out.println("idMascota: "+mascota.getIdMascota());
				mascota = mascotaService.obtenerMascota(mascota);
				
			}
		}
		
		return SUCCESS;
	}
	
	@Action(value="/saveMascotaForm",
			results={ @Result(name="success", location="mascotaListaTile",type="tiles") })
	public String saveMascotaForm() throws Exception{
		System.out.println("===== saveMascotaForm =====");
		System.out.println("oper: "+oper);
		System.out.println("idCliente: "+cliente.getIdCliente());
		
		correlativo = new Correlativo();
		String imageDataString;
		
		if(oper != null){
						
			try{
				
				imageDataString = mascota.getFotoContentType1();
				imageDataString = imageDataString.substring(imageDataString.indexOf(',') , imageDataString.length()-imageDataString.indexOf(','));				
				mascota.setFotobin1( MiUtil.decodeImage( imageDataString ) );
				
				imageDataString = mascota.getFotoContentType2();
				imageDataString = imageDataString.substring(imageDataString.indexOf(',') , imageDataString.length()-imageDataString.indexOf(','));				
				mascota.setFotobin2( MiUtil.decodeImage( imageDataString ) );
				
				imageDataString = mascota.getFotoContentType3();
				imageDataString = imageDataString.substring(imageDataString.indexOf(',') , imageDataString.length()-imageDataString.indexOf(','));				
				mascota.setFotobin3( MiUtil.decodeImage( imageDataString ) );
				
				imageDataString = mascota.getFotoContentType4();
				imageDataString = imageDataString.substring(imageDataString.indexOf(',') , imageDataString.length()-imageDataString.indexOf(','));				
				mascota.setFotobin4( MiUtil.decodeImage( imageDataString ) );
				
			}catch(Exception e){
				System.out.println("erorr: "+e);
			}
			
			mascota.setIdCliente( ""+cliente.getIdCliente() );
			
			if(oper.equals("add")){
				//Obteniendo el correlativo
				correlativo.setTabla("Mascota");
				correlativo = correlativoService.obtenerSigCorrelativo(correlativo);
				
				//insertando cliente
				mascota.setIdMascota(correlativo.getDescripcion());
				result = mascotaService.GrabarMascota(mascota)+"";
				
				//Actualizando correlativo
				correlativoService.ModificarCorrelativo(correlativo);
				
			}else if(oper.equals("edit"))
				result = mascotaService.ModificarMascota(mascota)+"";
			
			System.out.println("result: "+ result);
			
			mascotaLista = mascotaService.obtenerMascotaXCliente(cliente);
		}
		
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getImgFoto() {
		return imgFoto;
	}

	public void setImgFoto(String imgFoto) {
		this.imgFoto = imgFoto;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public List<TipoAnimal> getTipoAnimalLista() {
		return tipoAnimalLista;
	}

	public void setTipoAnimalLista(List<TipoAnimal> tipoAnimalLista) {
		this.tipoAnimalLista = tipoAnimalLista;
	}

	public Correlativo getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(Correlativo correlativo) {
		this.correlativo = correlativo;
	}
	
}
	