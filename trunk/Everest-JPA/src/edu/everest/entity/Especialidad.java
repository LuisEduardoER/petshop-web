package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the especialidad database table.
 * 
 */
@Entity
@NamedQuery(name="Especialidad.findAll", query="SELECT e FROM Especialidad e")
public class Especialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEspecialidad;

	private String descripcion;

	private String estado;

	public Especialidad() {
	}

	public int getIdEspecialidad() {
		return this.idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
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

}