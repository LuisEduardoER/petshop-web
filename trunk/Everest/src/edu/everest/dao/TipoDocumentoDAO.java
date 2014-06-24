package edu.everest.dao;

import java.util.List;

import edu.everest.entity.TipoDocumento;

public interface TipoDocumentoDAO {
	
	public TipoDocumento obtenerTipoDocumento(TipoDocumento tipoDocumento) throws Exception;	
	public List<TipoDocumento> obtenerTodos() throws Exception;
	public void insertar(TipoDocumento tipoDocumento) throws Exception;
	public void actualizar(TipoDocumento tipoDocumento) throws Exception;
	public void eliminar(TipoDocumento tipoDocumento) throws Exception;
	
}