<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<td>
	<s:textfield name="cliente.dni"/>
	<sj:a button="true" 
		buttonIcon="ui-icon-circle-zoomout"
		buttonText="false"
		href="loadMascota"
		indicator="myLoadingBar"
		formIds="frm01"
		targets="trMascota"
		>Buscar</sj:a>
</td>
<td><s:textfield name="cliente.nombreCompleto" disabled="true"/></td>
<td>				
	<s:select list="mascotaLista"
		listKey="idMascota"
		listValue="nombre"
		name="idMascota"
		cssStyle="min-width: 100px;"
	/>
</td>