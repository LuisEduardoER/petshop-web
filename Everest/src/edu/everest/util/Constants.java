package edu.everest.util;

import java.util.Calendar;

public class Constants {
	
	public static final int KV_ROL_ADMINISTRADOR 	= 1;
	public static final int KV_ROL_SECRETARIA 	 	= 2;
	public static final int KV_ROL_PEDIATRA 	 	= 3;
	public static final int KV_ROL_OPERARIO 	 	= 4;
	public static final int KV_ROL_CLIENTE 		 	= 5;
	
	public static final String KV_SEXO_MASCULINO 	= "M";
	public static final String KV_SEXO_FEMENINO	 	= "F";
	
	public static final String KV_SEXO_MACHO     	= "M";
	public static final String KV_SEXO_HEMBRA	 	= "H";
	
	public static final String KV_IMG_PET_DEFAULT 	= "/img/PetShop_Gray.png";
	
	//Duracion min de una cita (Valor expresado en minutos)
	public static int KV_INTERVAL_TIME_CITA= 30;
	
	public static Calendar KV_TODAY = Calendar.getInstance();
		
	public static int KV_TURN_MORNING_INI = 9;
	public static int KV_TURN_MORNING_FIN = 13;
	
	public static int KV_TURN_EVENING_INI = 14;
	public static int KV_TURN_EVENING_FIN = 18;
			
}
