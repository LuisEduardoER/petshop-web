package edu.everest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;

	private String apeMat;

	private String apePat;

	private int celular;

	private String direccion;

	private String dni;

	private String email;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecNac;

	private int idDIstrito;

	private double lineaCredito;

	private String lineaCreditoBool;

	private double lineaDisponible;

	private String nombres;

	private String sexo;

	private int telefono;

	private String tipoCliente;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="cliente")
	private List<Cita> citas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idParentCliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="cliente")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	//bi-directional many-to-one association to HistoriaClinica
	@OneToMany(mappedBy="cliente")
	private List<HistoriaClinica> historiaClinicas;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="cliente")
	private List<Mascota> mascotas;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getApeMat() {
		return this.apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

	public String getApePat() {
		return this.apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	public int getCelular() {
		return this.celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecNac() {
		return this.fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}

	public int getIdDIstrito() {
		return this.idDIstrito;
	}

	public void setIdDIstrito(int idDIstrito) {
		this.idDIstrito = idDIstrito;
	}

	public double getLineaCredito() {
		return this.lineaCredito;
	}

	public void setLineaCredito(double lineaCredito) {
		this.lineaCredito = lineaCredito;
	}

	public String getLineaCreditoBool() {
		return this.lineaCreditoBool;
	}

	public void setLineaCreditoBool(String lineaCreditoBool) {
		this.lineaCreditoBool = lineaCreditoBool;
	}

	public double getLineaDisponible() {
		return this.lineaDisponible;
	}

	public void setLineaDisponible(double lineaDisponible) {
		this.lineaDisponible = lineaDisponible;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setCliente(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setCliente(null);

		return cita;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setCliente(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setCliente(null);

		return cliente;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<HistoriaClinica> getHistoriaClinicas() {
		return this.historiaClinicas;
	}

	public void setHistoriaClinicas(List<HistoriaClinica> historiaClinicas) {
		this.historiaClinicas = historiaClinicas;
	}

	public HistoriaClinica addHistoriaClinica(HistoriaClinica historiaClinica) {
		getHistoriaClinicas().add(historiaClinica);
		historiaClinica.setCliente(this);

		return historiaClinica;
	}

	public HistoriaClinica removeHistoriaClinica(HistoriaClinica historiaClinica) {
		getHistoriaClinicas().remove(historiaClinica);
		historiaClinica.setCliente(null);

		return historiaClinica;
	}

	public List<Mascota> getMascotas() {
		return this.mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota addMascota(Mascota mascota) {
		getMascotas().add(mascota);
		mascota.setCliente(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setCliente(null);

		return mascota;
	}

}