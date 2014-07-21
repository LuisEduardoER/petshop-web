package edu.everest.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import edu.everest.entity.Mascota;
import edu.everest.service.ApplicationBusinessDelegate;
import edu.everest.service.MascotaService;

@ParentPackage(value = "dawii")
public class CargaImagenAction extends ActionSupport{
	
	//Atributos del action
	private static final long serialVersionUID = 3845203583072153344L;

	//Atributos de salida
	private InputStream imagenMascota;	
	//Atributos de entrada
	private String idMascota;

	@Action(value="cargaImagenAction",
			results={ @Result(name="success",type="stream", params = {"inputName", "imagenMascota"}) }
	)
	public String execute(){
		
		System.out.println("Cargando imagen de mascota");		
		System.out.println("idMascota : " + idMascota);
		
		//Recuperamos la imagen de la mascota
		
		ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();	
		MascotaService mascotaService = abd.getMascotaService();
		
		try{
			Mascota mascota = new Mascota();
			mascota.setIdMascota(idMascota);
			
			mascota = mascotaService.obtenerMascota(mascota);
			
			byte[] fotoBinary =  mascota.getFotobin();
			
			imagenMascota = new ByteArrayInputStream(fotoBinary);
			System.out.println("Imagen Cargada");
		}catch(Exception ex){
			System.out.println("cargaImagenAction: "+ex);
		}
		
		return SUCCESS;
	}
	
	public InputStream getImagenMascota() {
		return imagenMascota;
	}

	public void setImagenMascota(InputStream imagenMascota) {
		this.imagenMascota = imagenMascota;
	}

	public String getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(String idMascota) {
		this.idMascota = idMascota;
	}

}
