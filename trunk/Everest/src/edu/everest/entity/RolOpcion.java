package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rolopcion database table.
 * 
 */
@Entity
@NamedQuery(name="RolOpcion.findAll", query="SELECT r FROM RolOpcion r")
public class RolOpcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolOpcionPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreate;

	private String userCreate;

	//bi-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="idOpcion",referencedColumnName="idOpcion")
	private Opcion opcion;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idRol",referencedColumnName="idRol")
	private Rol rol;

	public RolOpcion() {
	}

	public RolOpcionPK getId() {
		return this.id;
	}

	public void setId(RolOpcionPK id) {
		this.id = id;
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

	public Opcion getOpcion() {
		return this.opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}