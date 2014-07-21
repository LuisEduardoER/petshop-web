package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cobro database table.
 * 
 */
@Entity
@NamedQuery(name="Cobro.findAll", query="SELECT c FROM Cobro c")
public class Cobro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idCobro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreate;

	private String userCreate;

	//bi-directional many-to-one association to Cita
	@ManyToOne
	@JoinColumn(name="idCita")
	private Cita cita;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	//bi-directional many-to-one association to DetalleCobro
	@OneToMany(mappedBy="cobro")
	private List<DetalleCobro> detalleCobros;

	public Cobro() {
	}

	public String getIdCobro() {
		return this.idCobro;
	}

	public void setIdCobro(String idCobro) {
		this.idCobro = idCobro;
	}

	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleCobro> getDetalleCobros() {
		return this.detalleCobros;
	}

	public void setDetalleCobros(List<DetalleCobro> detalleCobros) {
		this.detalleCobros = detalleCobros;
	}

	public DetalleCobro addDetalleCobro(DetalleCobro detalleCobro) {
		getDetalleCobros().add(detalleCobro);
		detalleCobro.setCobro(this);

		return detalleCobro;
	}

	public DetalleCobro removeDetalleCobro(DetalleCobro detalleCobro) {
		getDetalleCobros().remove(detalleCobro);
		detalleCobro.setCobro(null);

		return detalleCobro;
	}

}