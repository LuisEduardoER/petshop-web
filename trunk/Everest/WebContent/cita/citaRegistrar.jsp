<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:form id="form1">

<h2>
Registro de Citas
</h2>

<fieldset>
	<legend> <h1>Cita </h1> </legend>

	<table style="width: 100%;">
		<tr>
			<td>Fecha</td>
			<td>Hora</td>
		</tr>
		<tr>
			<td>
				<sj:datepicker showButtonPanel="true"/>
			</td>
			<td>
				<sj:datepicker showButtonPanel="true" timepicker="true"/>
			</td>
		</tr>
		<tr>
			<td>Tipo Servicio</td>
			<td>Costo</td>
		</tr>
		<tr>
			<td>
				<select>
					<option>-- Seleccione --</option>
				</select>
			</td>
			<td>S/ .20 </td>
		</tr>
	</table>

</fieldset>

<fieldset>
	<legend> <h1>Mascota</h1> </legend>

	<table style="width: 100%;">
		<tr>
			<td>DNI</td>
			<td>
				<s:textfield/>
			</td>
			<td>
				<sj:a button="true" buttonIcon="ui-icon-circle-triangle-e" buttonText="false">|</sj:a>
			</td>
		</tr>
		<tr>
			<td>
				Cliente
			</td>
			<td>
				xxxxxxxx xxxxxxxx xxxxxxx
			</td>
		</tr>
		<tr>
			<td>Mascota</td>
			<td>
				<select>
					<option>-- Seleccione --</option>
				</select>
			</td>
		</tr>
		
	</table>

</fieldset>

</s:form>

