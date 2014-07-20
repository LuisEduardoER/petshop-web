package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the correlativo database table.
 * 
 */
@Entity
@NamedQuery(name="Correlativo.findAll", query="SELECT c FROM Correlativo c")
public class Correlativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCorrelativo;

	private String tabla;

	private String valor;

	public Correlativo() {
	}

	public int getIdCorrelativo() {
		return this.idCorrelativo;
	}

	public void setIdCorrelativo(int idCorrelativo) {
		this.idCorrelativo = idCorrelativo;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}