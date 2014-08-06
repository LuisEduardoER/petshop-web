package com.veterinaria.beans;

public class Correlativo {
	
	private int idCorrelativo;
	private String tabla;
	private String prefijo;
	private int valor;
	private int tamano;
	private String descripcion;
	
	public int getIdCorrelativo() {
		return idCorrelativo;
	}
	public void setIdCorrelativo(int idCorrelativo) {
		this.idCorrelativo = idCorrelativo;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
