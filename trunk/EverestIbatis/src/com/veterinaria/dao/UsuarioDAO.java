package com.veterinaria.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.veterinaria.beans.Usuario;
import com.veterinaria.interfaces.IUsuario;

public class UsuarioDAO implements IUsuario {
	
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
	public ArrayList<Usuario> listarUsuario() throws Exception {
		ArrayList<Usuario> lista= null;
		SqlSession session=sqlmapper.openSession();
		try {
			lista= (ArrayList<Usuario>)session.selectList("usuarioXML.listarUsuario");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public Usuario obtenerUsuario(Usuario obj) throws Exception {
		Usuario usuario= null;
		SqlSession session=sqlmapper.openSession();
		try {
			usuario= (Usuario)session.selectOne("usuarioXML.obtenerUsuario",obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
		return usuario;
	}

	@Override
	public String obtenerMaxUsuario() throws Exception {
		String usuario= null;
		SqlSession session=sqlmapper.openSession();
		try {
			usuario= (String)session.selectOne("usuarioXML.obtenerMaxUsuario");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
		return usuario;
	}

	@Override
	public String GrabarUsuario(Usuario obj) throws Exception {
		String msg="";
	    SqlSession session=sqlmapper.openSession();
		try {
			
			msg="Exito"+session.insert("usuarioXML.grabarUsuario",obj);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
		msg=e.getMessage();
		}finally{
			
		}session.close();
		return msg;
	}

	@Override
	public String ModificarUsuario(Usuario obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg="Resultado"+session.update("usuarioXML.modificarUsuario",obj);
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
	public String EliminarUsuario(Usuario obj) throws Exception {
		SqlSession session=sqlmapper.openSession();
		String msg="";
		try {
		
			msg="Resultado"+session.delete("usuarioXML.eliminarUsuario",obj);
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
	public int validarUsuario(Usuario obj) throws Exception {
		int result= 0;
		SqlSession session=sqlmapper.openSession();
		try {
			result= Integer.parseInt( (String)session.selectOne("usuarioXML.validarUsuario",obj) );
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}

}
