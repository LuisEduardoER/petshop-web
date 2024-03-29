package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idServicio;

	private double costoRef;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreate;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.TIME)
	private Calendar tiempoAprox;

	private String userCreate;

	//bi-directional many-to-one association to DetalleCita
	@OneToMany(mappedBy="servicio")
	private List<DetalleCita> detalleCitas;

	//bi-directional many-to-one association to DetalleCobro
	@OneToMany(mappedBy="servicio")
	private List<DetalleCobro> detalleCobros;

	public Servicio() {
	}

	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public double getCostoRef() {
		return this.costoRef;
	}

	public void setCostoRef(double costoRef) {
		this.costoRef = costoRef;
	}

	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Calendar getTiempoAprox() {
		return this.tiempoAprox;
	}

	public void setTiempoAprox(Calendar tiempoAprox) {
		this.tiempoAprox = tiempoAprox;
	}

	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public List<DetalleCita> getDetalleCitas() {
		return this.detalleCitas;
	}

	public void setDetalleCitas(List<DetalleCita> detalleCitas) {
		this.detalleCitas = detalleCitas;
	}

	public DetalleCita addDetalleCita(DetalleCita detalleCita) {
		getDetalleCitas().add(detalleCita);
		detalleCita.setServicio(this);

		return detalleCita;
	}

	public DetalleCita removeDetalleCita(DetalleCita detalleCita) {
		getDetalleCitas().remove(detalleCita);
		detalleCita.setServicio(null);

		return detalleCita;
	}

	public List<DetalleCobro> getDetalleCobros() {
		return this.detalleCobros;
	}

	public void setDetalleCobros(List<DetalleCobro> detalleCobros) {
		this.detalleCobros = detalleCobros;
	}

	public DetalleCobro addDetalleCobro(DetalleCobro detalleCobro) {
		getDetalleCobros().add(detalleCobro);
		detalleCobro.setServicio(this);

		return detalleCobro;
	}

	public DetalleCobro removeDetalleCobro(DetalleCobro detalleCobro) {
		getDetalleCobros().remove(detalleCobro);
		detalleCobro.setServicio(null);

		return detalleCobro;
	}

}