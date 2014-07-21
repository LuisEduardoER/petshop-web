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

	@Column(insertable=false, updatable=true)
	private String idCita;

	@Column(insertable=false, updatable=true)
	private int idServicio;

	public DetalleCitaPK() {
	}
	public String getIdCita() {
		return this.idCita;
	}
	public void setIdCita(String idCita) {
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
			this.idCita.equals(castOther.idCita)
			&& (this.idServicio == castOther.idServicio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCita.hashCode();
		hash = hash * prime + this.idServicio;
		
		return hash;
	}
}