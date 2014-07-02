package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pago database table.
 * 
 */
@Entity
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPago;

	private double importe;

	private String numCheque;

	public Pago() {
	}

	public int getIdPago() {
		return this.idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public double getImporte() {
		return this.importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getNumCheque() {
		return this.numCheque;
	}

	public void setNumCheque(String numCheque) {
		this.numCheque = numCheque;
	}

}