package edu.everest.service;

import java.util.List;

import edu.everest.entity.Usuario;

public interface UsuarioService {
	
	public int validarUsuario(Usuario usuario) throws Exception;
	
	public List<Usuario> obtenerTodosUsuario() throws Exception;
	public Usuario insertarUsuario(Usuario usuario) throws Exception;
	public void actualizarUsuario(Usuario usuario) throws Exception;
	public void eliminarUsuario(Usuario usuario) throws Exception;
	public Usuario obtenerUsuario(Usuario usuario) throws Exception;
	
}
