package com.veterinaria.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.veterinaria.beans.DetalleCita;
import com.veterinaria.interfaces.IDetalleCita;

public class DetalleCitaDAO implements IDetalleCita {
	
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
	public ArrayList<DetalleCita> listarDetalleCita() throws Exception {
		ArrayList<DetalleCita> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<DetalleCita>)session.selectList("detalleCitaXML.listarDetalleCita");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public DetalleCita obtenerDetalleCita(DetalleCita obj) throws Exception {
		DetalleCita detalleCita= null;
		SqlSession session=sqlmapper.openSession();
		try {
			detalleCita= (DetalleCita)session.selectOne("detalleCitaXML.obtenerDetalleCita",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return detalleCita;
	}

	@Override
	public String GrabarDetalleCita(DetalleCita obj) throws Exception {
		String msg="";
	    SqlSession session=sqlmapper.openSession();
		try {
			
			msg = ""+session.insert("detalleCitaXML.grabarDetalleCita",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String ModificarDetalleCita(DetalleCita obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.update("detalleCitaXML.modificarDetalleCita",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String EliminarDetalleCita(DetalleCita obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.delete("detalleCitaXML.eliminarDetalleCita",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

}
