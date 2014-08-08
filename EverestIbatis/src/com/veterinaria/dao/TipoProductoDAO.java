package com.veterinaria.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;






import com.veterinaria.beans.TipoProducto;
import com.veterinaria.interfaces.ITipoProducto;

public class TipoProductoDAO implements ITipoProducto{


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
	public ArrayList<TipoProducto> listarTipoProducto() throws Exception {
		ArrayList<TipoProducto> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<TipoProducto>)session.selectList("tipoProductoXML.listarTipoProducto");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public TipoProducto obtenerTipoProducto(TipoProducto obj) throws Exception {
		TipoProducto tipoProducto= null;
		SqlSession session=sqlmapper.openSession();
		try {
			tipoProducto= (TipoProducto)session.selectOne("tipoProductoXML.obtenerTipoProducto",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return tipoProducto;
	}

	@Override
	public String GrabarTipoProducto(TipoProducto obj) throws Exception {
		String msg="";
	    SqlSession session=sqlmapper.openSession();
		try {
			
			msg = ""+session.insert("tipoProductoXML.grabarTipoProducto",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String ModificarTipoProducto(TipoProducto obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.update("tipoProductoXML.modificarTipoProducto",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

	@Override
	public String EliminarTipoProducto(TipoProducto obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg=""+session.delete("tipoProductoXML.eliminarTipoProducto",obj);
			session.commit();
		} catch (Exception e) {
			msg=e.getMessage();
		}finally{
			session.close();
		}
		
		return msg;
	}

}
