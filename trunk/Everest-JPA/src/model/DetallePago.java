package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detallepago database table.
 * 
 */
@Entity
@NamedQuery(name="DetallePago.findAll", query="SELECT d FROM DetallePago d")
public class DetallePago implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetallePagoPK id;

	private double costo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreate;

	private String userCreate;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="idProducto")
	private Producto producto;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idServicio")
	private Servicio servicio;

	//bi-directional many-to-one association to Pago
	@ManyToOne
	@JoinColumn(name="idPago")
	private Pago pago;

	public DetallePago() {
	}

	public DetallePagoPK getId() {
		return this.id;
	}

	public void setId(DetallePagoPK id) {
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

	public Pago getPago() {
		return this.pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

}