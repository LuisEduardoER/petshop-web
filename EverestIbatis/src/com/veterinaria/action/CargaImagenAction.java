package com.veterinaria.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Mascota;
import com.veterinaria.services.MascotaService;

@ParentPackage(value = "Veterinaria")
public class CargaImagenAction extends ActionSupport{
	
	//Atributos del action
	private static final long serialVersionUID = 3845203583072153344L;

	//Atributos de salida
	private InputStream imagenMascota;	
	//Atributos de entrada
	private String idMascota, img;
	
	MascotaService mascotaService = new MascotaService();

	@Action(value="cargaImagenAction",
			results={ @Result(name="success",type="stream", params = {"inputName", "imagenMascota"}) }
	)
	public String execute(){
		
		System.out.println("===== Cargando imagen de mascota ======");
		System.out.println("idMascota : " + idMascota);
		System.out.println("img: "+img);
		
		//Recuperamos la imagen de la mascota
			
		try{
			Mascota mascota = new Mascota();
			mascota.setIdMascota(idMascota);
			
			mascota = mascotaService.obtenerImgMascota(mascota);
			
			byte[] fotoBinary = null;
			
			if(img.equals("1"))
				fotoBinary =  mascota.getFotobin1();
			if(img.equals("2"))
				fotoBinary =  mascota.getFotobin2();
			if(img.equals("3"))
				fotoBinary =  mascota.getFotobin3();
			if(img.equals("4"))
				fotoBinary =  mascota.getFotobin4();
			
			imagenMascota = new ByteArrayInputStream(fotoBinary);
			System.out.println("Imagen Cargada");
		}catch(Exception ex){
			System.out.println("===== cargaImagenAction.error: "+ex+" =====");
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
