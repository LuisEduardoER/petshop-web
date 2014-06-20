package edu.everest.entity;

public class Tab {
	
	private String 	idTab;
	private String 	valueTab;
	private int		hourTab = 0;
	
	public Tab(String idTab, String valueTab) {
		this.idTab = 	idTab;
		this.valueTab = valueTab;
	}
	public Tab(String idTab, String valueTab, int hourTab) {
		this.idTab = 	idTab;
		this.valueTab = valueTab;
		this.hourTab = hourTab;
	}
	
	public String getIdTab() {
		return idTab;
	}
	public void setIdTab(String idTab) {
		this.idTab = idTab;
	}
	public String getValueTab() {
		return valueTab;
	}
	public void setValueTab(String valueTab) {
		this.valueTab = valueTab;
	}
	public int getHourTab() {
		return hourTab;
	}
	public void setHourTab(int hourTab) {
		this.hourTab = hourTab;
	}
	
}
