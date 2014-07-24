package edu.everest.service;

import java.util.List;

import edu.everest.entity.FormaPago;

public interface FormaPagoService {

	
	public List<FormaPago> obtenerTodosFormaPago() throws Exception;
	public void insertarFormaPago(FormaPago formaPago) throws Exception;
	public void actualizarFormaPago(FormaPago formaPago) throws Exception;
	public void eliminarFormaPago(FormaPago formaPago) throws Exception;
	public FormaPago obtenerFormaPago(FormaPago formaPago) throws Exception;
	
}
