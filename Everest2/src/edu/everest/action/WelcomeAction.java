package edu.everest.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "dawii")
public class WelcomeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Action(value = "/welcome", results = { @Result(location = "indexTile", name = "success", type = "tiles") })
	public String execute() {
		return SUCCESS;
	}
	
	@Action(value = "/showLoginAction", results = { @Result(location = "loginTile", name = "success", type = "tiles") })
	public String login() {
		return SUCCESS;
	}
	
	@Action(value = "/intranetBienvenidoAction", results = { @Result(location = "intranetBienvenidoTile", name = "success", type = "tiles") })
	public String intranetBienvenido() {
		return SUCCESS;
	}
	
}
