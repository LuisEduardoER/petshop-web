package com.veterinaria.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.veterinaria.beans.Local;
import com.veterinaria.interfaces.ILocal;

public class LocalDAO implements ILocal{

	
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
	public ArrayList<Local> listarLocal() throws Exception {
		ArrayList<Local> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<Local>)session.selectList("localXML.listarLocal");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
		
	}

	@Override
	public Local obtenerLocal(Local obj) throws Exception {
		Local local= null;
		SqlSession session=sqlmapper.openSession();
		try {
			local= (Local)session.selectOne("localXML.obtenerLocal",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return local;
	}

	@Override
	public String GrabarLocal(Local obj) throws Exception {
		String msg="";
	    SqlSession session=sqlmapper.openSession();
		try {
			
			msg = ""+session.insert("localXML.grabarLocal",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String ModificarLocal(Local obj) throws Exception {
	
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.update("localXML.modificarLocal",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String EliminarLocal(Local obj) throws Exception {
		
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.delete("localXML.eliminarLocal",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

}
