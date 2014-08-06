package com.veterinaria.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.veterinaria.Interfaces.ITipoAnimal;
import com.veterinaria.beans.TipoAnimal;

public class TipoAnimalDAO implements ITipoAnimal {
	
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
	public ArrayList<TipoAnimal> listarTipoAnimal() throws Exception {
		ArrayList<TipoAnimal> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<TipoAnimal>)session.selectList("tipoAnimalXML.listarTipoAnimal");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public TipoAnimal obtenerTipoAnimal(TipoAnimal obj) throws Exception {
		TipoAnimal tipoAnimal= null;
		SqlSession session=sqlmapper.openSession();
		try {
			tipoAnimal= (TipoAnimal)session.selectOne("tipoAnimalXML.obtenerTipoAnimal",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return tipoAnimal;
	}

	@Override
	public String GrabarTipoAnimal(TipoAnimal obj) throws Exception {
		String msg="";
	    SqlSession session=sqlmapper.openSession();
		try {
			
			msg = ""+session.insert("tipoAnimalXML.grabarTipoAnimal",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String ModificarTipoAnimal(TipoAnimal obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.update("tipoAnimalXML.modificarTipoAnimal",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String EliminarTipoAnimal(TipoAnimal obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.delete("tipoAnimalXML.eliminarTipoAnimal",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

}
