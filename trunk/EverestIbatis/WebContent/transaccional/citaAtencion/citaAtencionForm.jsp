<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h1>Atencion de Cita </h1>

<fieldset>
	<legend>
		<h2>Datos de la cita</h2>
	</legend>
	
	<table class="dls-table-form" style="width: 100%;" cellspacing="0" cellpadding="0">
		<tr>
			<th>Cita</th>
			<th>Cliente</th>
			<th>Mascota</th>
			<th>Fecha</th>
			<th>Hora</th>
		</tr>
		<tr>
			<td><s:property value="cita.idCita"/> </td>
			<td><s:property value="cliente.nombres"/><s:property value="cliente.apePat"/> </td>
			<td><s:property value="mascota.nombre"/> </td>
			<td><s:date name="cita.fecIniProg" format="dd/MM/yyyy"/> </td>
			<td><s:date name="cita.fecIniProg" format="hh:mm"/> - <s:date name="cita.fecFinProg" format="hh:mm"/></td>
		</tr>
	</table>
	
</fieldset>

<br/>

<fieldset>
	<legend>
		<h2>Servicios</h2>
	</legend>
	
	<table class="dls-table" style="width: 100%;" cellspacing="0" cellpadding="0">
	<thead>
		<tr>
			<th style="width: 20px;">Nro</th>
			<th>Servicio</th>
			<th>Tiempo Aprox</th>
			<th>Costo</th>
			<th class="ui-state-disabled tdButton">
	         	<sj:submit 
					type="button"
					cssClass="no-margin"
					button="true"
					buttonIcon="ui-icon-circle-close" 
					buttonText="false">
					Mascotas
				</sj:submit>
	         </th>
		</tr>
	</thead>
	<tbody class="dls-table-body">
		<s:if test="detalleCitaLista.size==0">
			<tr>
				<td colspan="5" style="text-align: center;">
					Agregue los Servicios que desea tomar para su mascota, por favor.
				</td>
			</tr>
		</s:if>
		
		<s:iterator value="detalleCitaLista" status="stat">
			<tr>
				<td><s:property value="#stat.count"/> </td>
				<td>
					<s:select 
						list="servicioLista"
						name="idServicio"
						listKey="idServicio"
						listValue="descripcion"
						disabled="true"
					/> 
				</td>
				<td><s:date name="tiempoAprox" format="hh:mm"/> </td>
				<td><s:property value="costo"/> </td>
				<td class="tdButton">
		       		<s:form id="formDetalleCita%{#stat.count}" action="" method="post">
				      <s:hidden name="cliente.idCliente" value="%{idCliente}"/>
						<sj:submit 
							type="button"
							formIds="formDetalleCita%{#stat.count}"
							indicator="myLoadingBar"
							cssClass="no-margin"
							button="true"
							buttonIcon="ui-icon-circle-close" 
							buttonText="false">
							Eliminar
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
	
</fieldset>

<fieldset>
	<legend>
		<h2>Historia Clinica</h2>
	</legend>
	
	<table class="dls-table" style="width: 100%;" cellspacing="0" cellpadding="0">
	<thead>
		<tr>
			<th style="width: 20px;">Nro</th>
			<th>Fecha</th>
			<th>Analisis</th>
			<th class="ui-state-disabled tdButton">
	         	<sj:submit 
					type="button"
					cssClass="no-margin"
					button="true"
					buttonIcon="ui-icon-circle-close" 
					buttonText="false">
					Mascotas
				</sj:submit>
	         </th>
		</tr>
	</thead>
	<tbody class="dls-table-body">
		<s:if test="historiaClinicaLista.size==0">
			<tr>
				<td colspan="5" style="text-align: center;">
					Hay historias Clinicas Registradas aun.
				</td>
			</tr>
		</s:if>
		
		<s:iterator value="historiaClinicaLista" status="stat">
			<tr>
				<td><s:property value="#stat.count"/> </td>
				<td><s:date name="fecAtencion" format="dd/MM/yy hh:mm"/> </td>
				<td><s:property value="analisis"/> </td>
				<td class="tdButton">
		       		<s:form id="formHc%{#stat.count}" action="" method="post">
				      <s:hidden name="historiaClinica.idHistoriaClinica" value="%{idHistoriaClinica}"/>
						<sj:submit 
							type="button"
							formIds="formHc%{#stat.count}"
							indicator="myLoadingBar"
							cssClass="no-margin"
							button="true"
							buttonIcon="ui-icon-circle-close" 
							buttonText="false">
							Eliminar
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
	
</fieldset>

