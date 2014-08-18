package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.HistoriaClinica;
import com.veterinaria.beans.Mascota;

public interface IHistoriaClinica {
	
	public abstract ArrayList<HistoriaClinica> listarHistoriaClinica(Mascota obj) throws Exception;
	public abstract HistoriaClinica obtenerHistoriaClinica(HistoriaClinica obj) throws Exception;
	public abstract String GrabarHistoriaClinica(HistoriaClinica obj) throws Exception;
	public abstract String ModificarHistoriaClinica(HistoriaClinica obj) throws Exception;
	public abstract String EliminarHistoriaClinica(HistoriaClinica obj) throws Exception;
	
}
