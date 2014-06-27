package model;

import java.io.Serializable;
import javax.persistence.*;
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
	private List<RolOpcion> rolOpcions;

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

	public List<RolOpcion> getRolOpcions() {
		return this.rolOpcions;
	}

	public void setRolOpcions(List<RolOpcion> rolOpcions) {
		this.rolOpcions = rolOpcions;
	}

	public RolOpcion addRolOpcion(RolOpcion rolOpcion) {
		getRolOpcions().add(rolOpcion);
		rolOpcion.setOpcion(this);

		return rolOpcion;
	}

	public RolOpcion removeRolOpcion(RolOpcion rolOpcion) {
		getRolOpcions().remove(rolOpcion);
		rolOpcion.setOpcion(null);

		return rolOpcion;
	}

}