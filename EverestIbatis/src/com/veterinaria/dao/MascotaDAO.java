	package com.veterinaria.dao;


import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.veterinaria.beans.Cliente;
import com.veterinaria.beans.Mascota;
import com.veterinaria.interfaces.IMascota;

public class MascotaDAO implements IMascota{

	SqlSessionFactory sqlmapper=null;{
		try {
			Reader reader =	Resources.
			getResourceAsReader("ConfiguracionIbatis.xml");
			sqlmapper = new 
			SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Mascota> listarMascota() throws Exception {
		ArrayList<Mascota> lista=null;
		SqlSession session = sqlmapper.openSession();
		try {
			lista=(ArrayList<Mascota>)session.selectList("mascotaXML.listarMascotas");			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return lista;
	}
	@Override
	public int GrabarMascota(Mascota obj) throws Exception {
		int salida = -1;
		SqlSession session = sqlmapper.openSession();
		try {
			salida =session.
				insert("mascotaXML.grabarMascotas",obj);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return salida;
	}
	@Override
	public int ModificarMascota(Mascota obj) throws Exception {
		SqlSession session = 
				sqlmapper.openSession();
		int salida = -1;
			try {
				salida =session.
					update("mascotaXML.modificarMascotas",obj);
					session.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				session.close();
			}		
			return salida;
	}
	@Override
	public int EliminarMascota(Mascota obj) throws Exception {
		SqlSession session = 
				sqlmapper.openSession();
		int salida = -1;			
			try {
				salida =session.
					delete("mascotaXML.eliminarMascotas",obj);
					session.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				session.close();
			}		
			return salida;
	}
	
	@Override
	public Mascota obtenerMascota(Mascota obj) throws Exception {
		Mascota result=null;
		SqlSession session = sqlmapper.openSession();
		try {
			result=(Mascota)session.selectOne("mascotaXML.obtenerMascota",obj);			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Mascota> obtenerMascotaXCliente(Cliente obj) throws Exception {
		ArrayList<Mascota> lista=null;
		SqlSession session = sqlmapper.openSession();
		try {
			lista=(ArrayList<Mascota>)session.selectList("mascotaXML.listarMascotaXCliente", obj);			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return lista;
	}
	@Override
	public Mascota obtenerImgMascota(Mascota obj) throws Exception {
		Mascota result=null;
		SqlSession session = sqlmapper.openSession();
		try {
			result=(Mascota)session.selectOne("mascotaXML.obtenerImgMascota",obj);			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return result;
	}
	
}

