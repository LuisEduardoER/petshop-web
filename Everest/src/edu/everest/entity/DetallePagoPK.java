package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detallepago database table.
 * 
 */
@Embeddable
public class DetallePagoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=true)
	private int idPago;

	private int idTipo;

	private int idDetalle;

	public DetallePagoPK() {
	}
	public int getIdPago() {
		return this.idPago;
	}
	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}
	public int getIdTipo() {
		return this.idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public int getIdDetalle() {
		return this.idDetalle;
	}
	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallePagoPK)) {
			return false;
		}
		DetallePagoPK castOther = (DetallePagoPK)other;
		return 
			(this.idPago == castOther.idPago)
			&& (this.idTipo == castOther.idTipo)
			&& (this.idDetalle == castOther.idDetalle);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPago;
		hash = hash * prime + this.idTipo;
		hash = hash * prime + this.idDetalle;
		
		return hash;
	}
}