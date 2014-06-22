package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoanimal database table.
 * 
 */
@Entity
@NamedQuery(name="TipoAnimal.findAll", query="SELECT t FROM TipoAnimal t")
public class TipoAnimal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoAnimal;

	private String descripcion;

	//bi-directional many-to-one association to HistoriaClinica
	@OneToMany(mappedBy="tipoanimal")
	private List<HistoriaClinica> historiaclinicas;

	public TipoAnimal() {
	}

	public int getIdTipoAnimal() {
		return this.idTipoAnimal;
	}

	public void setIdTipoAnimal(int idTipoAnimal) {
		this.idTipoAnimal = idTipoAnimal;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<HistoriaClinica> getHistoriaclinicas() {
		return this.historiaclinicas;
	}

	public void setHistoriaclinicas(List<HistoriaClinica> historiaclinicas) {
		this.historiaclinicas = historiaclinicas;
	}

	public HistoriaClinica addHistoriaclinica(HistoriaClinica historiaclinica) {
		getHistoriaclinicas().add(historiaclinica);
		historiaclinica.setTipoanimal(this);

		return historiaclinica;
	}

	public HistoriaClinica removeHistoriaclinica(HistoriaClinica historiaclinica) {
		getHistoriaclinicas().remove(historiaclinica);
		historiaclinica.setTipoanimal(null);

		return historiaclinica;
	}

}