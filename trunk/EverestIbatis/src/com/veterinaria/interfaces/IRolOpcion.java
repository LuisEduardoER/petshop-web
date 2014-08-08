package com.veterinaria.interfaces;

import java.util.ArrayList;

import com.veterinaria.beans.RolOpcion;

public interface IRolOpcion {
	
	public abstract ArrayList<RolOpcion> listarRolOpcion() throws Exception;
	public abstract RolOpcion obtenerRolOpcion(RolOpcion obj) throws Exception;
	public abstract String GrabarRolOpcion(RolOpcion obj) throws Exception;
	public abstract String ModificarRolOpcion(RolOpcion obj) throws Exception;
	public abstract String EliminarRolOpcion(RolOpcion obj) throws Exception;
	
}
