package edu.everest.entity;

import java.io.Serializable;

import javax.persistence.*;

import edu.everest.util.Constants;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the opcion database table.
 * 
 */
@Entity
@NamedQuery(name="Opcion.findAll", query="SELECT o FROM Opcion o")
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOpcion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreate;

	private String descripcion;

	private String estado;

	private int orden;

	private String titulo;

	private String url;

	private String userCreate;

	//bi-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="parentOpcionId")
	private Opcion opcion;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="opcion")
	private List<Opcion> opcions;

	//bi-directional many-to-one association to RolOpcion
	@OneToMany(mappedBy="opcion")
	private List<RolOpcion> rolopcions;

	public Opcion() {
	}

	public int getIdOpcion() {
		return this.idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		
		if(this.estado.equals(Constants.KV_STATE_COD_INACTIVE))
			this.estado = Constants.KV_STATE_INACTIVE;
		
		else if(this.estado.equals(Constants.KV_STATE_COD_ACTIVE))
			this.estado = Constants.KV_STATE_ACTIVE;
		
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public Opcion addOpcion(Opcion opcion) {
		getOpcions().add(opcion);
		opcion.setOpcion(this);

		return opcion;
	}

	public Opcion removeOpcion(Opcion opcion) {
		getOpcions().remove(opcion);
		opcion.setOpcion(null);

		return opcion;
	}

	public List<RolOpcion> getRolopcions() {
		return this.rolopcions;
	}

	public void setRolopcions(List<RolOpcion> rolopcions) {
		this.rolopcions = rolopcions;
	}

	public RolOpcion addRolopcion(RolOpcion rolopcion) {
		getRolopcions().add(rolopcion);
		rolopcion.setOpcion(this);

		return rolopcion;
	}

	public RolOpcion removeRolopcion(RolOpcion rolopcion) {
		getRolopcions().remove(rolopcion);
		rolopcion.setOpcion(null);

		return rolopcion;
	}

}