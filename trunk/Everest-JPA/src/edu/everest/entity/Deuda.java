package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the deudas database table.
 * 
 */
@Entity
@Table(name="deudas")
@NamedQuery(name="Deuda.findAll", query="SELECT d FROM Deuda d")
public class Deuda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDeuda;

	private double monto;

	private double saldo;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private Proveedor proveedor;

	public Deuda() {
	}

	public int getIdDeuda() {
		return this.idDeuda;
	}

	public void setIdDeuda(int idDeuda) {
		this.idDeuda = idDeuda;
	}

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}