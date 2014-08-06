<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>


	<table style="width: 100%;">
		<tr>
			<td>RUC</td>
			<td>Razon Social</td>
			<td>Direccion</td>
		</tr>
		<tr>
			<td>
				<s:textfield/>
				<sj:a button="true" buttonIcon="ui-icon-circle-triangle-e" buttonText="false">search</sj:a> 
			</td>
			<td><s:textfield/> </td>
			<td><s:textfield/> </td>
		</tr>
	</table>


