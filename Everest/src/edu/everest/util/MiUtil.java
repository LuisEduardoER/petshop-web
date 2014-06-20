package edu.everest.util;

import java.util.Calendar;


public class MiUtil {
		
	public static void syso(String str){
		System.out.println("["+str+"]");
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
		case Calendar.MONDAY:		strDay="Lunes"; 	break;
		case Calendar.TUESDAY:		strDay="Martes";	break;
		case Calendar.WEDNESDAY:	strDay="Miercoles";	break;
		case Calendar.THURSDAY:		strDay="Jueves";	break;
		case Calendar.FRIDAY:		strDay="Viernes";	break;
		case Calendar.SATURDAY:		strDay="Sabado";	break;
		case Calendar.SUNDAY:		strDay="Domingo";	break;
		default:					break;
	}
		
		return strDay;
	}
}
