package com.veterinaria.action;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;
import com.veterinaria.beans.Opcion;
import com.veterinaria.beans.Usuario;
import com.veterinaria.service.UsuarioService;

@ParentPackage(value = "Veterinaria")
public class UsuarioAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Opcion opcion;
	
	private List<Usuario> usuarioLista;
	private List<Opcion> opcionLista;
	
	UsuarioService usuarioService = new UsuarioService();

}
