package edu.everest.dao;

import java.util.List;

import edu.everest.entity.Cliente;
import edu.everest.entity.Usuario;

public interface ClienteDAO {

	public Cliente obtenerCliente(Cliente cliente) throws Exception;
	public Cliente obtenerClienteByUsuario(Usuario usuario) throws Exception;
	
	public List<Cliente> obtenerTodos() throws Exception;
	public void insertar(Cliente cliente) throws Exception;
	public void actualizar(Cliente cliente) throws Exception;
	public void eliminar(Cliente cliente) throws Exception;
	
}
