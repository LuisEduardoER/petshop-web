package com.veterinaria.beans;

import java.io.File;
import java.util.Date;

public class Mascota{
	private String idMascota;
	private String idCliente;
	private String idTipoAnimal;
	private String alergia;
	private int edad;
	private String esterilizacion;
	private Date fecNac;
		
	private byte[] fotobin1, fotobin2, fotobin3, fotobin4;
	//Para trabajar con struts file
	private File foto1, foto2, foto3, foto4;
	private String fotoContentType1, fotoContentType2, fotoContentType3, fotoContentType4;
	private String fotoFileName1, fotoFileName2, fotoFileName3, fotoFileName4;
	private String img;
	
	private String nombre;
	private String observaciones;
	private String pedigree;
	private String raza;
	private String sexo;

	//bi-directional many-to-one association to Cita
//	private List<Cita> citas;

	//bi-directional many-to-one association to HistoriaClinica
//	private List<HistoriaClinica> historiaClinicas;

	//bi-directional many-to-one association to Cliente
	private Cliente cliente;

	//bi-directional many-to-one association to TipoAnimal
//	private TipoAnimal tipoAnimal;

	public Mascota() {
	}

	public String getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(String idMascota) {
		this.idMascota = idMascota;
	}

	public String getAlergia() {
		return this.alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEsterilizacion() {
		return this.esterilizacion;
	}

	public void setEsterilizacion(String esterilizacion) {
		this.esterilizacion = esterilizacion;
	}

	public Date getFecNac() {
		return this.fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPedigree() {
		return this.pedigree;
	}

	public void setPedigree(String pedigree) {
		this.pedigree = pedigree;
	}

	public String getRaza() {
		return this.raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public byte[] getFotobin1() {
		return fotobin1;
	}

	public void setFotobin1(byte[] fotobin1) {
		this.fotobin1 = fotobin1;
	}

	public byte[] getFotobin2() {
		return fotobin2;
	}

	public void setFotobin2(byte[] fotobin2) {
		this.fotobin2 = fotobin2;
	}

	public byte[] getFotobin3() {
		return fotobin3;
	}

	public void setFotobin3(byte[] fotobin3) {
		this.fotobin3 = fotobin3;
	}

	public byte[] getFotobin4() {
		return fotobin4;
	}

	public void setFotobin4(byte[] fotobin4) {
		this.fotobin4 = fotobin4;
	}

	public File getFoto1() {
		return foto1;
	}

	public void setFoto1(File foto1) {
		this.foto1 = foto1;
	}

	public File getFoto2() {
		return foto2;
	}

	public void setFoto2(File foto2) {
		this.foto2 = foto2;
	}

	public File getFoto3() {
		return foto3;
	}

	public void setFoto3(File foto3) {
		this.foto3 = foto3;
	}

	public File getFoto4() {
		return foto4;
	}

	public void setFoto4(File foto4) {
		this.foto4 = foto4;
	}

	public String getFotoContentType1() {
		return fotoContentType1;
	}

	public void setFotoContentType1(String fotoContentType1) {
		this.fotoContentType1 = fotoContentType1;
	}

	public String getFotoContentType2() {
		return fotoContentType2;
	}

	public void setFotoContentType2(String fotoContentType2) {
		this.fotoContentType2 = fotoContentType2;
	}

	public String getFotoContentType3() {
		return fotoContentType3;
	}

	public void setFotoContentType3(String fotoContentType3) {
		this.fotoContentType3 = fotoContentType3;
	}

	public String getFotoContentType4() {
		return fotoContentType4;
	}

	public void setFotoContentType4(String fotoContentType4) {
		this.fotoContentType4 = fotoContentType4;
	}

	public String getFotoFileName1() {
		return fotoFileName1;
	}

	public void setFotoFileName1(String fotoFileName1) {
		this.fotoFileName1 = fotoFileName1;
	}

	public String getFotoFileName2() {
		return fotoFileName2;
	}

	public void setFotoFileName2(String fotoFileName2) {
		this.fotoFileName2 = fotoFileName2;
	}

	public String getFotoFileName3() {
		return fotoFileName3;
	}

	public void setFotoFileName3(String fotoFileName3) {
		this.fotoFileName3 = fotoFileName3;
	}

	public String getFotoFileName4() {
		return fotoFileName4;
	}

	public void setFotoFileName4(String fotoFileName4) {
		this.fotoFileName4 = fotoFileName4;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdTipoAnimal() {
		return idTipoAnimal;
	}

	public void setIdTipoAnimal(String idTipoAnimal) {
		this.idTipoAnimal = idTipoAnimal;
	}
	
}