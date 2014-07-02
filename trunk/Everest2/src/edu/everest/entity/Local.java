package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the local database table.
 * 
 */
@Entity
@NamedQuery(name="Local.findAll", query="SELECT l FROM Local l")
public class Local implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLocal;

	private String nomLocal;

	//bi-directional many-to-one association to Medico
	@OneToMany(mappedBy="local")
	private List<Medico> medicos;

	public Local() {
	}

	public int getIdLocal() {
		return this.idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	public String getNomLocal() {
		return this.nomLocal;
	}

	public void setNomLocal(String nomLocal) {
		this.nomLocal = nomLocal;
	}

	public List<Medico> getMedicos() {
		return this.medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public Medico addMedico(Medico medico) {
		getMedicos().add(medico);
		medico.setLocal(this);

		return medico;
	}

	public Medico removeMedico(Medico medico) {
		getMedicos().remove(medico);
		medico.setLocal(null);

		return medico;
	}

}