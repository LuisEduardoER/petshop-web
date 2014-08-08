package com.veterinaria.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.veterinaria.beans.RolOpcion;
import com.veterinaria.interfaces.IRolOpcion;

public class RolOpcionDAO implements IRolOpcion {
	
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
	public ArrayList<RolOpcion> listarRolOpcion() throws Exception {
		ArrayList<RolOpcion> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<RolOpcion>)session.selectList("rolOpcionXML.listarRolOpcion");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public RolOpcion obtenerRolOpcion(RolOpcion obj) throws Exception {
		RolOpcion rolOpcion= null;
		SqlSession session=sqlmapper.openSession();
		try {
			rolOpcion= (RolOpcion)session.selectOne("rolOpcionXML.obtenerRolOpcion",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return rolOpcion;
	}

	@Override
	public String GrabarRolOpcion(RolOpcion obj) throws Exception {
		String msg="";
	    SqlSession session=sqlmapper.openSession();
		try {
			
			msg = ""+session.insert("rolOpcionXML.grabarRolOpcion",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String ModificarRolOpcion(RolOpcion obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.update("rolOpcionXML.modificarRolOpcion",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String EliminarRolOpcion(RolOpcion obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.delete("rolOpcionXML.eliminarRolOpcion",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

}
