package com.veterinaria.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.veterinaria.beans.HistoriaClinica;
import com.veterinaria.interfaces.IHistoriaClinica;

public class HistoriaClinicaDAO implements IHistoriaClinica {
	
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
	public ArrayList<HistoriaClinica> listarHistoriaClinica() throws Exception {
		ArrayList<HistoriaClinica> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<HistoriaClinica>)session.selectList("historiaClinicaXML.listarHistoriaClinica");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public HistoriaClinica obtenerHistoriaClinica(HistoriaClinica obj)
			throws Exception {
		HistoriaClinica historiaClinica= null;
		SqlSession session=sqlmapper.openSession();
		try {
			historiaClinica= (HistoriaClinica)session.selectOne("historiaClinicaXML.obtenerHistoriaClinica",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return historiaClinica;
	}

	@Override
	public String GrabarHistoriaClinica(HistoriaClinica obj) throws Exception {
		String msg="";
	    SqlSession session=sqlmapper.openSession();
		try {
			
			msg = ""+session.insert("historiaClinicaXML.grabarHistoriaClinica",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String ModificarHistoriaClinica(HistoriaClinica obj)
			throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.update("historiaClinicaXML.modificarHistoriaClinica",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String EliminarHistoriaClinica(HistoriaClinica obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.delete("historiaClinicaXML.eliminarHistoriaClinica",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

}
