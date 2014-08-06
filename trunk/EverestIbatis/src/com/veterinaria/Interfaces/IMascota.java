package com.veterinaria.Interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.Cliente;
import com.veterinaria.beans.Mascota;

public interface IMascota {

	public abstract ArrayList<Mascota> listarMascota() throws Exception;
	public abstract ArrayList<Mascota>  obtenerMascotaXCliente(Cliente obj) throws Exception;
	public abstract Mascota obtenerMascota(Mascota obj) throws Exception;
	public abstract Mascota obtenerImgMascota(Mascota obj) throws Exception;
	public abstract int GrabarMascota(Mascota obj) throws Exception;
	public abstract int ModificarMascota(Mascota obj) throws Exception;
	public abstract int EliminarMascota(Mascota obj) throws Exception;
	
}
