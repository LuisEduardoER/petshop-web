package edu.everest.service;

import java.util.List;

import edu.everest.dao.DAOFactory;
import edu.everest.dao.FormaPagoDAO;
import edu.everest.entity.FormaPago;

public class FormaPagoDAOService implements FormaPagoService {

	private FormaPagoDAO dao;
	private DAOFactory fabrica = null;
	
	public FormaPagoDAOService(int whichFactory) {
		fabrica = DAOFactory.getDAOFactory(whichFactory);
		this.dao = fabrica.getFormaPagoDAO();
	}
	
	@Override
	public List<FormaPago> obtenerTodosFormaPago() throws Exception {
		return dao.obtenerTodos();
	}

	@Override
	public void insertarFormaPago(FormaPago formaPago) throws Exception {
		dao.insertar(formaPago);

	}

	@Override
	public void actualizarFormaPago(FormaPago formaPago) throws Exception {
		dao.actualizar(formaPago);

	}

	@Override
	public void eliminarFormaPago(FormaPago formaPago) throws Exception {
		dao.eliminar(formaPago);

	}

	@Override
	public FormaPago obtenerFormaPago(FormaPago formaPago) throws Exception {
		return dao.obtenerFormaPago(formaPago);
	}

}
