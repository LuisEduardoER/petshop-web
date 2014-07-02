package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rolopcion database table.
 * 
 */
@Embeddable
public class RolOpcionPK implements Serializable {
	//default serial version id, required for serializable classes.S
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=true)
	private int idRol;

	@Column(insertable=false, updatable=true)
	private int idOpcion;

	public RolOpcionPK() {
	}
	public int getIdRol() {
		return this.idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public int getIdOpcion() {
		return this.idOpcion;
	}
	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolOpcionPK)) {
			return false;
		}
		RolOpcionPK castOther = (RolOpcionPK)other;
		return 
			(this.idRol == castOther.idRol)
			&& (this.idOpcion == castOther.idOpcion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRol;
		hash = hash * prime + this.idOpcion;
		
		return hash;
	}
}