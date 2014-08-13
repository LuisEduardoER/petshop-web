package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.DetalleCita;

public interface IDetalleCita {
	
	public abstract ArrayList<DetalleCita> listarDetalleCita() throws Exception;
	public abstract DetalleCita obtenerDetalleCita(DetalleCita obj) throws Exception;
	public abstract String GrabarDetalleCita(DetalleCita obj) throws Exception;
	public abstract String ModificarDetalleCita(DetalleCita obj) throws Exception;
	public abstract String EliminarDetalleCita(DetalleCita obj) throws Exception;
	
}
