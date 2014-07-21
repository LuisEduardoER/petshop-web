package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detallepago database table.
 * 
 */
@Entity
@NamedQuery(name="DetallePago.findAll", query="SELECT d FROM DetallePago d")
public class DetallePago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPago;

	private double monto;

	//bi-directional many-to-one association to Pago
	@ManyToOne
	@JoinColumn(name="idPago")
	private Pago pago;

	//bi-directional many-to-one association to FormaPago
	@ManyToOne
	@JoinColumn(name="idFormaPago")
	private FormaPago formaPago;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name="idCuenta")
	private Cuenta cuenta;

	public DetallePago() {
	}

	public int getIdPago() {
		return this.idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Pago getPago() {
		return this.pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public FormaPago getFormaPago() {
		return this.formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}