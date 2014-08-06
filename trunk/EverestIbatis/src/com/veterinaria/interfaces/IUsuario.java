package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.Usuario;

public interface IUsuario {
	
	public abstract ArrayList<Usuario> listarUsuario()throws Exception;
	public abstract Usuario obtenerUsuario(Usuario obj) throws Exception;
	public abstract String obtenerMaxUsuario() throws Exception;
	public abstract String GrabarUsuario(Usuario obj) throws Exception;
	public abstract String ModificarUsuario(Usuario obj)throws Exception;
	public abstract String EliminarUsuario(Usuario obj)throws Exception;
	
	public int validarUsuario(Usuario obj) throws Exception;
	
}
