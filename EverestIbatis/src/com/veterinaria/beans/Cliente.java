package com.veterinaria.beans;

import java.util.Date;
import java.util.List;

public class Cliente{
	
	private int idCliente;
	private String idParentCliente;	
	private int idUsuario;	
	private int idDistrito;
	
	private String dni;	
	private int ruc;	
	private String nombres;	
	private String apePat;
	private String apeMat;
	private String sexo;
	private Date fecNac;
	private String email;
	private int telefono;
	private int celular;
	private String Direccion;
	private String estado;
	private String lineaCreditoBool;
	private double lineaCredito;
	private double lineaDisponible;
	private String tipoCliente;
	
	private String nombreCompleto;
	
	private Usuario usuario;

	//bi-directional many-to-one association to Cita
//	private List<Cita> citas;

	//bi-directional many-to-one association to Cliente
	private Cliente cliente;

	//bi-directional many-to-one association to Cliente
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Usuario
//	private Usuario usuario;

	//bi-directional many-to-one association to HistoriaClinica
//	private List<HistoriaClinica> historiaClinicas;

	//bi-directional many-to-one association to Mascota
//	private List<Mascota> mascotas;

	//bi-directional many-to-one association to Cobro
//	private List<Cobro> cobros;

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
		return this.Direccion;
	}

	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
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

	public String getIdParentCliente() {
		return idParentCliente;
	}

	public void setIdParentCliente(String idParentCliente) {
		this.idParentCliente = idParentCliente;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public int getRuc() {
		return ruc;
	}

	public void setRuc(int ruc) {
		this.ruc = ruc;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}