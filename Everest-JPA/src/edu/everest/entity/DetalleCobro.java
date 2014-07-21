package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detallecobro database table.
 * 
 */
@Entity
@NamedQuery(name="DetalleCobro.findAll", query="SELECT d FROM DetalleCobro d")
public class DetalleCobro implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleCobroPK id;

	private double costo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreate;

	private String userCreate;

	//bi-directional many-to-one association to Cobro
	@ManyToOne
	@JoinColumn(name="idCobro")
	private Cobro cobro;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="idProducto")
	private Producto producto;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idServicio")
	private Servicio servicio;

	public DetalleCobro() {
	}

	public DetalleCobroPK getId() {
		return this.id;
	}

	public void setId(DetalleCobroPK id) {
		this.id = id;
	}

	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public Cobro getCobro() {
		return this.cobro;
	}

	public void setCobro(Cobro cobro) {
		this.cobro = cobro;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}