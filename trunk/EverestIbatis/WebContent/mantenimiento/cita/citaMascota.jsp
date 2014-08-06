<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

	

	<table id="tbMascota">
		<tr>
			<td>DNI</td>
			<td>
				<s:textfield name="cliente.documento"/>
			</td>
			<td>
				<sj:a button="true"
					href="validarClienteAction"
					targets="tbMascota"
					formIds="frmCita" 
					buttonIcon="ui-icon-circle-triangle-e" 
					buttonText="false">Validar</sj:a>
			</td>
		</tr>
		<tr>
			<td>
				Cliente
			</td>
			<td>
				<s:label name="cliente.nombres"/>&nbsp;<s:label name="cliente.apePat"/>&nbsp;<s:label name="cliente.apeMat"/>
			</td>
		</tr>
		<tr>
			<td>Mascota(s)</td>
			<td>
				<s:select list="mascotaLista" 
					name="mascota.idMascota"
					listKey="idMascota"
					listValue="nombre"
					headerKey=""
					headerValue="-- Seleccione --"/>
			</td>
		</tr>
		
	</table>
