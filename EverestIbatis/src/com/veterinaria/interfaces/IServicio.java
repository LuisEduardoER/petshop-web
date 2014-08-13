package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.Servicio;

public interface IServicio {
	
	public abstract ArrayList<Servicio> listarServicio() throws Exception;
	public abstract Servicio obtenerServicio(Servicio obj) throws Exception;
	public abstract String GrabarServicio(Servicio obj) throws Exception;
	public abstract String ModificarServicio(Servicio obj) throws Exception;
	public abstract String EliminarServicio(Servicio obj) throws Exception;

}
