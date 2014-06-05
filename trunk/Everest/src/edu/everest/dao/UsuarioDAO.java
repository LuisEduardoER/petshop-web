package edu.everest.dao;

import java.util.List;

import edu.everest.entity.Usuario;

public interface UsuarioDAO {
	
	public int validarUsuario(Usuario usuario) throws Exception;
	
	public Usuario obtenerUsuario(Usuario usuario) throws Exception;
	public List<Usuario> obtenerTodos() throws Exception;
	public void insertar(Usuario usuario) throws Exception;
	public void actualizar(Usuario usuario) throws Exception;
	public void eliminar(Usuario usuario) throws Exception;
	
}
