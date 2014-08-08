package com.veterinaria.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.veterinaria.beans.Proveedor;
import com.veterinaria.interfaces.IProveedor;

public class ProveedorDAO implements IProveedor{

	
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
	public ArrayList<Proveedor> listarProveedor() throws Exception {
		ArrayList<Proveedor> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<Proveedor>)session.selectList("proveedorXML.listarProveedor");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public Proveedor obtenerProveedor(Proveedor obj) throws Exception {
		Proveedor proveedor= null;
		SqlSession session=sqlmapper.openSession();
		try {
			proveedor= (Proveedor)session.selectOne("proveedorXML.obtenerProveedor",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return proveedor;
	}

	@Override
	public String GrabarProveedor(Proveedor obj) throws Exception {
		String msg="";
	    SqlSession session=sqlmapper.openSession();
		try {
			
			msg = ""+session.insert("proveedorXML.grabarProveedor",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String ModificarProveedor(Proveedor obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.update("proveedorXML.modificarProveedor",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String EliminarProveedor(Proveedor obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.delete("proveedorXML.eliminarProveedor",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

}
