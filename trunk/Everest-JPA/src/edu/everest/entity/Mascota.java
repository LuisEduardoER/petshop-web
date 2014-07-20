package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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

	private String alergia;

	private String codMascota;

	private int edad;

	private String esterilizacion;

	@Temporal(TemporalType.DATE)
	private Date fecNac;

	@Lob
	private byte[] fotobin;

	private String nombre;

	private String observaciones;

	private String pedigree;

	private String raza;

	private String sexo;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="mascota")
	private List<Cita> citas;

	//bi-directional many-to-one association to HistoriaClinica
	@OneToMany(mappedBy="mascota")
	private List<HistoriaClinica> historiaClinicas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	//bi-directional many-to-one association to TipoAnimal
	@ManyToOne
	@JoinColumn(name="idTipoAnimal")
	private TipoAnimal tipoAnimal;

	public Mascota() {
	}

	public int getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getAlergia() {
		return this.alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getCodMascota() {
		return this.codMascota;
	}

	public void setCodMascota(String codMascota) {
		this.codMascota = codMascota;
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

	public List<HistoriaClinica> getHistoriaClinicas() {
		return this.historiaClinicas;
	}

	public void setHistoriaClinicas(List<HistoriaClinica> historiaClinicas) {
		this.historiaClinicas = historiaClinicas;
	}

	public HistoriaClinica addHistoriaClinica(HistoriaClinica historiaClinica) {
		getHistoriaClinicas().add(historiaClinica);
		historiaClinica.setMascota(this);

		return historiaClinica;
	}

	public HistoriaClinica removeHistoriaClinica(HistoriaClinica historiaClinica) {
		getHistoriaClinicas().remove(historiaClinica);
		historiaClinica.setMascota(null);

		return historiaClinica;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoAnimal getTipoAnimal() {
		return this.tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

}