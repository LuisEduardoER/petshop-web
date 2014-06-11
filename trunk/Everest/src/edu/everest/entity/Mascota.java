package edu.everest.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the mascota database table.
 * 
 */
@Entity
@NamedQuery(name="Mascota.findAll", query="SELECT m FROM Mascota m")
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMascota;

	private int edad;

	private String esterilizacion;

	@Temporal(TemporalType.DATE)
	private Date fecNac;

	@Lob
	private byte[] fotobin;
	
	//Para trabajar con struts file
	
	@Transient
	private File foto;	
	@Transient
	private String fotoContentType;	
	@Transient
	private String fotoFileName;
		

	private int idAnimal;

	private String nombre;

	private String observaciones;

	private String pedigree;

	private String raza;

	private String sexo;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="mascota")
	private List<Cita> citas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	public Mascota() {
	}

	public int getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
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

	public byte[] getFotobin() {
		return this.fotobin;
	}

	public void setFotobin(byte[] fotobin) {
		this.fotobin = fotobin;
	}

	public int getIdAnimal() {
		return this.idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
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

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setMascota(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setMascota(null);

		return cita;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public String getFotoContentType() {
		return fotoContentType;
	}

	public void setFotoContentType(String fotoContentType) {
		this.fotoContentType = fotoContentType;
	}

	public String getFotoFileName() {
		return fotoFileName;
	}

	public void setFotoFileName(String fotoFileName) {
		this.fotoFileName = fotoFileName;
	}
	
	
}