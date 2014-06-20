package edu.everest.util;

import java.util.Calendar;


public class MiUtil {
		
	public static void syso(String str){
		System.out.println("["+str+"]");
	}
	
	public static int getMondayOfWeek(int nDay) {
		switch (nDay) {		
			case Calendar.MONDAY:		break;
			case Calendar.TUESDAY:		nDay-=1; break;
			case Calendar.WEDNESDAY:	nDay-=2; break;
			case Calendar.THURSDAY:		nDay-=3; break;
			case Calendar.FRIDAY:		nDay-=4; break;
			case Calendar.SATURDAY:		nDay-=5; break;
			case Calendar.SUNDAY:		nDay-=6; break;
			default:					break;
		}
		
		return nDay;
	}
	
}
