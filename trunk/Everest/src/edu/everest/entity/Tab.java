package edu.everest.entity;

import java.util.Calendar;

public class Tab {
	
	private String 		idTab;
	private String 		value1;
	private String 		value2;
	private int			hourTab = 0;
	private int			tipo;
	private Calendar	date;
	
	public Tab(String idTab, String value1) {
		this.idTab = 	idTab;
		this.value1 = value1;
	}
	
	public Tab(String idTab, String value1, String value2) {
		this.idTab = 	idTab;
		this.value1 = value1;
		this.value2 = value2;
	}
	
	public Tab(String idTab, String value1, int tipo) {
		this.idTab = 	idTab;
		this.value1 = value1;
		this.tipo = tipo;
	}
	
	public Tab(String idTab, String value1, String value2, int tipo) {
		this.idTab = 	idTab;
		this.value1 = value1;
		this.value2 = value2;
		this.tipo = tipo;
	}
	
	public Tab(String idTab, String value1, int hourTab, Calendar date) {
		this.idTab = 	idTab;
		this.value1 = value1;
		this.hourTab = hourTab;
		this.date = date;
	}
	
	public String getIdTab() {
		return idTab;
	}
	public void setIdTab(String idTab) {
		this.idTab = idTab;
	}
	public int getHourTab() {
		return hourTab;
	}
	public void setHourTab(int hourTab) {
		this.hourTab = hourTab;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
