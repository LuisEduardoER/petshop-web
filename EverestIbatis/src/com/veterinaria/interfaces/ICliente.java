package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.Cliente;
import com.veterinaria.beans.Usuario;

public interface ICliente {
	
	public abstract ArrayList<Cliente> listarCliente(Cliente obj)throws Exception;
	public abstract Cliente obtenerCliente(Cliente obj) throws Exception;
	public abstract String GrabarCliente(Cliente obj) throws Exception;
	public abstract String ModificarCliente(Cliente obj)throws Exception;
	public abstract String EliminarCliente(Cliente obj)throws Exception;
	
	public abstract Cliente obtenerClienteByUsuario(Usuario obj) throws Exception;
	public abstract String obtenerMaxCliente() throws Exception;
	
}
