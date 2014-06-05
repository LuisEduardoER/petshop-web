package edu.everest.service;

import java.util.List;

import edu.everest.entity.Cliente;
import edu.everest.entity.Usuario;

public interface ClienteService {
	
	public Cliente obtenerClienteByUsuario(Usuario usuario) throws Exception;
	
	public List<Cliente> obtenerTodosCliente() throws Exception;
	public void insertarCliente(Cliente cliente) throws Exception;
	public void actualizarCliente(Cliente cliente) throws Exception;
	public void eliminarCliente(Cliente cliente) throws Exception;
	public Cliente obtenerCliente(Cliente cliente) throws Exception;
	
}
