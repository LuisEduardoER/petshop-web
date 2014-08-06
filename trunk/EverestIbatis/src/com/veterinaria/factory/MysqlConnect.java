package com.veterinaria.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlConnect {
	private static final String PASS="mysql";
	Connection cn=null;
	public MysqlConnect(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			cn = DriverManager.
			getConnection("jdbc:mysql://localhost:3306/petshop","root",PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Connection getConexion(){
		Connection cnx=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cnx=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/petshop","root",PASS);
		}catch(Exception e){System.out.println(e);}
		return cnx;
	}
	
	public String Ejecutar(String SQL,Object[] arreglo){
		String result="";
		try {
			PreparedStatement cmd=cn.prepareStatement(SQL);
			//SQL="insert into ciudad values(?,?)";
			for(int i=0;i<arreglo.length;i++){
				cmd.setObject(i+1, arreglo[i]);
			}
			int f=cmd.executeUpdate();
			result="Se afectaron "+f+" filas";
		} catch (Exception e) {
			// TODO: handle exception
			result ="Error "+e.getMessage();
		}	
		return result;
	}
	
	public ResultSet Listado(String SQL,Object[] arreglo){
		ResultSet rs=null;
		try {
			PreparedStatement cmd=cn.prepareStatement(SQL);
			for(int i=0;i<arreglo.length;i++){
				cmd.setObject(i+1, arreglo[i]);
			}
			rs=cmd.executeQuery();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return rs;
	}	

}
