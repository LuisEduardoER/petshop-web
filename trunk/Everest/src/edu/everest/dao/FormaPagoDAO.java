package edu.everest.dao;

import java.util.List;

import edu.everest.entity.FormaPago;

public interface FormaPagoDAO {

	public FormaPago obtenerFormaPago(FormaPago formaPago) throws Exception;
	public List<FormaPago> obtenerTodos() throws Exception;
	public void insertar(FormaPago formaPago) throws Exception;
	public void actualizar(FormaPago formaPago) throws Exception;
	public void eliminar(FormaPago formaPago) throws Exception;
	
}
