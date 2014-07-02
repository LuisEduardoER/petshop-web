package edu.everest.service;

import java.util.List;

import edu.everest.entity.Cliente;
import edu.everest.entity.TipoDocumento;

public interface TipoDocumentoService {
	
	public List<TipoDocumento> obtenerTodosTipoDocumento(Cliente cliente) throws Exception;
	public TipoDocumento obtenerTipoDocumento(TipoDocumento tipoDocumento) throws Exception;
	public void insertarTipoDocumento(TipoDocumento tipoDocumento) throws Exception;
	public void actualizarTipoDocumento(TipoDocumento tipoDocumento) throws Exception;
	public void eliminarTipoDocumento(TipoDocumento tipoDocumento) throws Exception;
	
	
}
