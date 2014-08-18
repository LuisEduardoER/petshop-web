<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:if test="message != null">
  <sj:a button="true" buttonIcon="ui-icon-info" buttonText="false">Info</sj:a>	<s:property value="%{message}"/>
</s:if>

<s:hidden name="idCliente" value="%{cliente.idCliente}"/>
<table class="dls-table-form" style="width: 100%;" cellspacing="0" cellpadding="0">
	<tr>
		<th style="width: 200px;">DNI</th>
		<th style="width: 235px;">Nombre</th>
		<th style="width: 235px;">Mascota</th>
	</tr>
	<tr id="trMascota">
		<td>
			<s:textfield name="cliente.dni"/>
			<sj:a button="true" 
				buttonIcon="ui-icon-circle-zoomout"
				buttonText="false"
				href="loadMascota"
				indicator="myLoadingBar"
				formIds="frm01"
				targets="divMascota"
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
	</tr>
</table>
