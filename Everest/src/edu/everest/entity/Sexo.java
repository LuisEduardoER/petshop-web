package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sexo database table.
 * 
 */
@Entity
@NamedQuery(name="Sexo.findAll", query="SELECT s FROM Sexo s")
public class Sexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsexo;

	private String descripcion;

	//bi-directional many-to-one association to HistoriaClinica
	@OneToMany(mappedBy="sexo")
	private List<HistoriaClinica> historiaclinicas;

	public Sexo() {
	}

	public int getIdsexo() {
		return this.idsexo;
	}

	public void setIdsexo(int idsexo) {
		this.idsexo = idsexo;
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
		historiaclinica.setSexo(this);

		return historiaclinica;
	}

	public HistoriaClinica removeHistoriaclinica(HistoriaClinica historiaclinica) {
		getHistoriaclinicas().remove(historiaclinica);
		historiaclinica.setSexo(null);

		return historiaclinica;
	}

}