package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detallecobro database table.
 * 
 */
@Embeddable
public class DetalleCobroPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String idCobro;

	private int idTipo;

	private int idDetalle;

	public DetalleCobroPK() {
	}
	public String getIdCobro() {
		return this.idCobro;
	}
	public void setIdCobro(String idCobro) {
		this.idCobro = idCobro;
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
		if (!(other instanceof DetalleCobroPK)) {
			return false;
		}
		DetalleCobroPK castOther = (DetalleCobroPK)other;
		return 
			this.idCobro.equals(castOther.idCobro)
			&& (this.idTipo == castOther.idTipo)
			&& (this.idDetalle == castOther.idDetalle);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCobro.hashCode();
		hash = hash * prime + this.idTipo;
		hash = hash * prime + this.idDetalle;
		
		return hash;
	}
}