package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the formapago database table.
 * 
 */
@Entity
@NamedQuery(name="FormaPago.findAll", query="SELECT f FROM FormaPago f")
public class FormaPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFormaPago;

	private String descripcion;

	private String tipo;

	public FormaPago() {
	}

	public int getIdFormaPago() {
		return this.idFormaPago;
	}

	public void setIdFormaPago(int idFormaPago) {
		this.idFormaPago = idFormaPago;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}