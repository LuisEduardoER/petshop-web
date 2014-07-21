package edu.everest.dao;


public abstract class DAOFactory {
    
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    public static final int MEMORY = 6;
    public static final int JPA = 7;
    
    // Existirá un método por cada DAO que pueda ser creado.
    // registramos nuestros daos
    public abstract ProveedorDAO 		getProveedorDAO();
    public abstract UsuarioDAO			getUsuarioDAO();
    public abstract RolDAO				getRolDAO();
    public abstract ClienteDAO			getClienteDAO();
    public abstract OpcionDAO			getOpcionDAO();
    public abstract MascotaDAO			getMascotaDAO();
    public abstract CitaDAO				getCitaDAO();
    public abstract RolOpcionDAO		getRolOpcionDAO();
    public abstract ServicioDAO			getServicioDAO();
    public abstract DetalleCitaDAO		getDetalleCitaDAO();
       
    public static DAOFactory getDAOFactory(int whichFactory) {
       switch(whichFactory){
      	case JPA:
       	    return new JPADAOFactory();
/*       	case XML:
       	    return new XmlDAOFactory();
       	case ORACLE:
       	    return new OracleDAOFactory();
       	case DB2:
       	    return new Db2DAOFactory();
       	case SQLSERVER:
       	    return new SqlServerDAOFactory();
       	case XML:
       	    return new XmlDAOFactory(); 
       	case MEMORY:
       	    return new MemoryDAOFactory();*/
       	default:
       	    return null;
       }
    }
    
    
}
