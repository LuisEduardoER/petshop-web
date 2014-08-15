package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.HistoriaClinica;

public interface IHistoriaClinica {
	
	public abstract ArrayList<HistoriaClinica> listarHistoriaClinica() throws Exception;
	public abstract HistoriaClinica obtenerHistoriaClinica(HistoriaClinica obj) throws Exception;
	public abstract String GrabarHistoriaClinica(HistoriaClinica obj) throws Exception;
	public abstract String ModificarHistoriaClinica(HistoriaClinica obj) throws Exception;
	public abstract String EliminarHistoriaClinica(HistoriaClinica obj) throws Exception;
	
}
