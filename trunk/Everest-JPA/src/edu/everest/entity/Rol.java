package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRol;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreate;

	private String descripcion;

	private String estado;

	private String userCreate;

	//bi-directional many-to-one association to RolOpcion
	@OneToMany(mappedBy="rol")
	private List<RolOpcion> rolOpcions;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol")
	private List<Usuario> usuarios;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
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

	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public List<RolOpcion> getRolOpcions() {
		return this.rolOpcions;
	}

	public void setRolOpcions(List<RolOpcion> rolOpcions) {
		this.rolOpcions = rolOpcions;
	}

	public RolOpcion addRolOpcion(RolOpcion rolOpcion) {
		getRolOpcions().add(rolOpcion);
		rolOpcion.setRol(this);

		return rolOpcion;
	}

	public RolOpcion removeRolOpcion(RolOpcion rolOpcion) {
		getRolOpcions().remove(rolOpcion);
		rolOpcion.setRol(null);

		return rolOpcion;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRol(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRol(null);

		return usuario;
	}

}