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

	private String estado;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="tipoAnimal")
	private List<Mascota> mascotas;

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

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Mascota> getMascotas() {
		return this.mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota addMascota(Mascota mascota) {
		getMascotas().add(mascota);
		mascota.setTipoAnimal(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setTipoAnimal(null);

		return mascota;
	}

}