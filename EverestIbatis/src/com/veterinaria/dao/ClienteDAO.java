package com.veterinaria.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.veterinaria.beans.Cliente;
import com.veterinaria.beans.Usuario;
import com.veterinaria.interfaces.ICliente;

public class ClienteDAO implements ICliente {
	
	SqlSessionFactory sqlmapper=null;{
		try {
			Reader reader=Resources.getResourceAsReader("ConfiguracionIbatis.xml");
			sqlmapper = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Cliente> listarCliente(Cliente obj) throws Exception {
		ArrayList<Cliente> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<Cliente>)session.selectList("clienteXML.listarCliente", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public Cliente obtenerCliente(Cliente obj) throws Exception {
		Cliente cliente= null;
		SqlSession session=sqlmapper.openSession();
		try {
			cliente= (Cliente)session.selectOne("clienteXML.obtenerCliente",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return cliente;
	}

	@Override
	public String obtenerMaxCliente() throws Exception {
		String cliente= null;
		SqlSession session=sqlmapper.openSession();
		try {
			cliente= (String)session.selectOne("clienteXML.obtenerMaxCliente");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
		return cliente;
	}

	@Override
	public String GrabarCliente(Cliente obj) throws Exception {
		String msg="";
	    SqlSession session=sqlmapper.openSession();
		try {
			
			msg="Exito"+session.insert("clienteXML.grabarCliente",obj);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
		msg=e.getMessage();
		}finally{
			
		}session.close();
		return msg;
	}

	@Override
	public String ModificarCliente(Cliente obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg="Resultado"+session.update("clienteXML.modificarCliente",obj);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String EliminarCliente(Cliente obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg="Resultado"+session.delete("clienteXML.eliminarCliente",obj);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public Cliente obtenerClienteByUsuario(Usuario obj) throws Exception {
		Cliente cliente= null;
		SqlSession session=sqlmapper.openSession();
		try {
			cliente= (Cliente)session.selectOne("clienteXML.obteneClienteByUsuario",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return cliente;
	}

}
