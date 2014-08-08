package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.Correlativo;

public interface ICorrelativo {

	public abstract ArrayList<Correlativo> listarCorrelativo()throws Exception;
	public abstract Correlativo obtenerCorrelativo(Correlativo obj) throws Exception;	
	public abstract String GrabarCorrelativo(Correlativo obj) throws Exception;
	public abstract String ModificarCorrelativo(Correlativo obj)throws Exception;
	public abstract String EliminarCorrelativo(Correlativo obj)throws Exception;
	
	public abstract Correlativo obtenerSigCorrelativo(Correlativo obj) throws Exception;
	
}