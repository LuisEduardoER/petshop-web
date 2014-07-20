package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detallecita database table.
 * 
 */
@Embeddable
public class DetalleCitaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idCita;

	@Column(insertable=false, updatable=false)
	private int idServicio;

	public DetalleCitaPK() {
	}
	public int getIdCita() {
		return this.idCita;
	}
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	public int getIdServicio() {
		return this.idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleCitaPK)) {
			return false;
		}
		DetalleCitaPK castOther = (DetalleCitaPK)other;
		return 
			(this.idCita == castOther.idCita)
			&& (this.idServicio == castOther.idServicio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCita;
		hash = hash * prime + this.idServicio;
		
		return hash;
	}
}