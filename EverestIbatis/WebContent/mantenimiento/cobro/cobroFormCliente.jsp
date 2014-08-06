<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:hidden name="oper" value="showCitas"/>

<fieldset>
	<legend><h2>Cliente</h2></legend>
	
	<table class="dls-table-form" style="width: 100%;" cellspacing="0" cellpadding="0">
		<tr>
			<th>DNI</th>
			<th>Cliente</th>
			<th>Direccion</th>
		</tr>
		<tr>
			<td>
				<s:textfield name="cliente.dni" size="17"/>
				<sj:a
					formIds="frmCobroCliente"
					href="showCobroClienteAction"
					targets="divCobroFormCliente"
					button="true" 
					buttonIcon="ui-icon-circle-triangle-e" 
					buttonText="false"
					effectMode="show"
					effect="blind"
					effectDuration="500"
					>
					Validar
				</sj:a>
			</td>
			<td>
				<s:property value="cliente.nombres"/>
				<s:property value="cliente.apePat"/>
				<s:property value="cliente.apeMat"/>
			</td>
			<td>
				<s:property value="cliente.direccion"/>
			</td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><h2>Cita</h2></legend>
	
	<table class="dls-table-form" style="width: 100%;" cellspacing="0" cellpadding="0">
		<tr>
			<th>ID</th>
			<th>Fecha</th>
			<th>Mascota</th>
			<th>Medico</th>
			<th>&nbsp;</th>
		</tr>
		<s:if test="citaLista.size == 0">
			<tr>
				<td colspan="5" style="text-align: center;">
					No hay Registros Disponibles
				</td>
			</tr>
		</s:if>
		<s:iterator value="citaLista" status="stat">
			<tr>
				<td><s:property value="idCita"/> </td>
				<td><s:date format="dd/MM/yyyy hh:mm" name="fecAtencion"/> </td>
				<td>[NombreMascota]</td>
				<td>Carol Alvarez</td>
				<td>
					<sj:checkboxlist
			    		id="checkCita%{#stat.count}"
			            list="{' '}"
			            name="checkCita%{#stat.count}"
					/>
				</td>
			</tr>
		</s:iterator>
	</table>
</fieldset>

