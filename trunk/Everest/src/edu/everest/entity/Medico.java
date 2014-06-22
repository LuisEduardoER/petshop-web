package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medico database table.
 * 
 */
@Entity
@NamedQuery(name="Medico.findAll", query="SELECT m FROM Medico m")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMedico;

	private String apellidos;

	private String nombres;

	private String telefono;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="medico")
	private List<Cita> citas;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idTurno")
	private Turno turno;

	//bi-directional many-to-one association to Especialidad
	@ManyToOne
	@JoinColumn(name="idEspecialidad")
	private Especialidad especialidad;

	//bi-directional many-to-one association to Local
	@ManyToOne
	@JoinColumn(name="idLocal")
	private Local local;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	private Medico medico;

	//bi-directional many-to-one association to Medico
	@OneToMany(mappedBy="medico")
	private List<Medico> medicos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Medico() {
	}

	public int getIdMedico() {
		return this.idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setMedico(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setMedico(null);

		return cita;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Especialidad getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Local getLocal() {
		return this.local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getMedicos() {
		return this.medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public Medico addMedico(Medico medico) {
		getMedicos().add(medico);
		medico.setMedico(this);

		return medico;
	}

	public Medico removeMedico(Medico medico) {
		getMedicos().remove(medico);
		medico.setMedico(null);

		return medico;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}