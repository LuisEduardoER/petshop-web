<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h1>
	Atencion de Citas
</h1>

<fieldset>
<s:form id="frmFiltro">
	<table class="dls-table-form" style="width: 100%;" cellspacing="0" cellpadding="0">
		<tr>
			<th>DNI</th>
			<th>Cliente</th>
			<th>Mascota</th>
			<th>Estado</th>			
		</tr>
		<tr>
			<td><sj:textfield name="cliente.dni" size="6" maxlength="8"/></td>
			<td><s:textfield name="cliente.nombres"/></td>
			<td><s:textfield name="mascota.nombre"/></td>
			<td>
				<s:select list="#{'1':'Pendiente'}"
						name="cita.estado" cssStyle="width: 85px;"/>
			</td>
			<td>				
				<sj:a button="true" 
					buttonIcon="ui-icon-circle-zoomout"
					href="filtrarCliente"
					indicator="myLoadingBar"
					formIds="frmFiltro"
					targets="divLista"
					>Buscar</sj:a> 
			</td>
		</tr>
	</table>
</s:form>
</fieldset>

<br/>

<table class="dls-table" style="width: 100%;" cellspacing="0" cellpadding="0">
<thead>
	<tr>
		<th style="width: 20px;">Nro</th>
		<th>Cliente</th>
		<th>Mascota</th>
		<th style="width: 60px;">Fecha</th>
		<th style="width: 70px;">Hora</th>
		<th class="ui-state-disabled tdButton">
         	<sj:submit 
				type="button"
				cssClass="no-margin"
				button="true"
				buttonIcon="ui-icon-calculator" 
				buttonText="false">
				Cita
			</sj:submit>
         </th>
	</tr>
</thead>
<tbody class="dls-table-body">
	<s:if test="citaLista.size==0">
		<tr>
			<td colspan="5" style="text-align: center;">
				No hay Citas Registradas para el dia de hoy.
			</td>
		</tr>
	</s:if>
	
	<s:iterator value="citaLista" status="stat">
		<tr>
			<td><s:property value="idCita"/> </td>
			<td><s:property value="cliente.nombreCompleto"/> </td>
			<td><s:property value="mascota.nombre"/> </td>
			<td><s:date name="fecIniProg" format="dd/MM/yyyy"/> </td>
			<td>
				<s:date name="fecIniProg" format="hh:mm"/> -
				<s:date name="fecFinProg" format="hh:mm"/>
			</td>
			<td class="tdButton">
	       		<s:form id="formDetalleCita%{#stat.count}" action="showCitaAtencionForm" method="post">
			      <s:hidden name="cita.idCita" 		value="%{idCita}"/>
			      
			      <s:hidden name="mascota.idMascota" value="%{mascota.idMascota}"/>
			      <s:hidden name="mascota.nombre" value="%{mascota.nombre}"/>
			      
			      <s:hidden name="cliente.idCliente" value="%{cliente.idCliente}"/>
			      <s:hidden name="cliente.nombres" value="%{cliente.nombres}"/>
			      <s:hidden name="cliente.apePat" value="%{cliente.apePat}"/>
			      <s:hidden name="cliente.apeMat" value="%{cliente.apeMat}"/>
			      
					<sj:submit 
						type="button"
						formIds="formDetalleCita%{#stat.count}"
						indicator="myLoadingBar"
						cssClass="no-margin"
						button="true"
						buttonIcon="ui-icon-calculator" 
						buttonText="false">
						Cita
					</sj:submit>
				</s:form>
           </td>
		</tr>
	</s:iterator>
	<tr>
		<td colspan="5"> </td>
	</tr>
	
</tbody>
</table>