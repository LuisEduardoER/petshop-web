package com.veterinaria.utils;

import java.util.Calendar;

import org.apache.tomcat.util.codec.binary.Base64;


public class MiUtil {
		
	public static void syso(String str){
		System.out.println("["+str+"]");
	}
	
	public static String encodeImage(byte[] imageByteArray){
		return Base64.encodeBase64URLSafeString(imageByteArray);
	}
	
	public static byte[] decodeImage(String imageDataString){
		return Base64.decodeBase64(imageDataString);
	}
	
	public static int getMondayOfWeek(Calendar calendar) {
		int nDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {		
			case Calendar.MONDAY:		break;
			case Calendar.TUESDAY:		nDayOfMonth-=1; break;
			case Calendar.WEDNESDAY:	nDayOfMonth-=2; break;
			case Calendar.THURSDAY:		nDayOfMonth-=3; break;
			case Calendar.FRIDAY:		nDayOfMonth-=4; break;
			case Calendar.SATURDAY:		nDayOfMonth-=5; break;
			case Calendar.SUNDAY:		nDayOfMonth-=6; break;
			default:					break;
		}
		
		return nDayOfMonth;
	}
	
	public static String getMonthES(int nMonth){
		String strMonth = "";
		
		switch (nMonth) {		
			case Calendar.JANUARY:		strMonth="Enero";		break;
			case Calendar.FEBRUARY:		strMonth="Febrero"; 	break;
			case Calendar.MARCH:		strMonth="Marzo"; 		break;
			case Calendar.APRIL:		strMonth="Abril"; 		break;
			case Calendar.MAY:			strMonth="Mayo"; 		break;
			case Calendar.JUNE:			strMonth="Junio"; 		break;
			case Calendar.JULY:			strMonth="Julio"; 		break;
			case Calendar.AUGUST:		strMonth="Agosto"; 		break;
			case Calendar.SEPTEMBER:	strMonth="Septiembre"; 	break;
			case Calendar.OCTOBER:		strMonth="Octubre"; 	break;
			case Calendar.NOVEMBER:		strMonth="Noviembre"; 	break;
			case Calendar.DECEMBER:		strMonth="Diciembre"; 	break;
			default:					break;
		}
		
		return strMonth;
	}
	
	public static String getDayES(int nDay){
		String strDay = "";
		
		switch (nDay) {		
		case 0:		strDay="Lunes"; 	break;
		case 1:		strDay="Martes";	break;
		case 2:		strDay="Miercoles";	break;
		case 3:		strDay="Jueves";	break;
		case 4:		strDay="Viernes";	break;
		case 5:		strDay="Sabado";	break;
		case 6:		strDay="Domingo";	break;
		default:	break;
	}
		
		return strDay;
	}
	
	public static String lpad(String string, int padLength){
		int length=0;
		
		length = string.length();
		if(padLength> length){
			for(int i=0; i<(padLength-length); i++){
				string = ' '+string;
			}
		}
		
		return string;
	}
	
	public static String lpad(String string, int padLength, String padString){
		int length=0;
		
		length = string.length();
		if(padLength> length){
			for(int i=0; i<(padLength-length); i++){
				string = padString+string;
			}
		}
		
		return string;
	}
}
