package com.veterinaria.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.veterinaria.beans.Correlativo;
import com.veterinaria.interfaces.ICorrelativo;

public class CorrelativoDAO implements ICorrelativo {
	
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
	public ArrayList<Correlativo> listarCorrelativo() throws Exception {
		ArrayList<Correlativo> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<Correlativo>)session.selectList("correlativoXML.listarCorrelativo");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public Correlativo obtenerCorrelativo(Correlativo obj) throws Exception {
		Correlativo correlativo= null;
		SqlSession session=sqlmapper.openSession();
		try {
			correlativo= (Correlativo)session.selectOne("correlativoXML.obtenerCorrelativo",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return correlativo;
	}

	@Override
	public String GrabarCorrelativo(Correlativo obj) throws Exception {
		String msg="";
	    SqlSession session=sqlmapper.openSession();
		try {
			
			msg = ""+session.insert("correlativoXML.grabarCorrelativo",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String ModificarCorrelativo(Correlativo obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.update("correlativoXML.modificarCorrelativo",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String EliminarCorrelativo(Correlativo obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.delete("correlativoXML.eliminarCorrelativo",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public Correlativo obtenerSigCorrelativo(Correlativo obj) throws Exception {
		Correlativo correlativo= null;
		SqlSession session=sqlmapper.openSession();
		try {
			correlativo= (Correlativo)session.selectOne("correlativoXML.obtenerSigCorrelativo",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return correlativo;
	}

}
