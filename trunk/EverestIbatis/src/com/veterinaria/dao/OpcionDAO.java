package com.veterinaria.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.veterinaria.beans.Opcion;
import com.veterinaria.beans.Rol;
import com.veterinaria.interfaces.IOpcion;

public class OpcionDAO implements IOpcion {
	
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
	public ArrayList<Opcion> listarOpcion() throws Exception {
		ArrayList<Opcion> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<Opcion>)session.selectList("opcionXML.listarOpcion");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public Opcion obtenerOpcion(Opcion obj) throws Exception {
		Opcion opcion= null;
		SqlSession session=sqlmapper.openSession();
		try {
			opcion= (Opcion)session.selectOne("opcionXML.obtenerOpcion",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return opcion;
	}

	@Override
	public String GrabarOpcion(Opcion obj) throws Exception {
		String msg="";
	    SqlSession session=sqlmapper.openSession();
		try {
			
			msg = ""+session.insert("opcionXML.grabarOpcion",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String ModificarOpcion(Opcion obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.update("opcionXML.modificarOpcion",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String EliminarOpcion(Opcion obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.delete("opcionXML.eliminarOpcion",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Opcion> obtenerOpcionParentByRol(Rol obj) throws Exception {
		ArrayList<Opcion> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<Opcion>)session.selectList("opcionXML.obtenerOpcionParentByRol", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Opcion> obtenerOpcionByParent(Opcion obj) throws Exception {
		ArrayList<Opcion> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<Opcion>)session.selectList("opcionXML.obtenerOpcionByParent", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Opcion> listarParentOpcion() throws Exception {
		ArrayList<Opcion> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<Opcion>)session.selectList("opcionXML.listarParentOpcion");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

}
