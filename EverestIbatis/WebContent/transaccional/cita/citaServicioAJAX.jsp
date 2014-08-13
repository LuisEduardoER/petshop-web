<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<table>
	<tr>
		<td>Servicio </td>
		<td>
			<s:url var="urlLoadServicio" action="loadServicioJSON"/>
			<sj:select
				href="%{urlLoadServicio}"
				formIds="frmDetalleCita"
				name="servicio.idServicio"
				list="servicioLista"
				listKey="idServicio"
				listValue="descripcion"
				headerKey="0"
				headerValue="-- Seleccione --"
				onChangeTopics="reloadCitaServicioAjax"
			/>
		</td>
	</tr>
	<s:if test="servicio.idServicio==2">
		<tr>
			<td>Pelo</td>
			<td>
				<sj:radio
		           id="chkPelo"
		           list="{'Corto', 'Mediano', 'Largo'}"
		           name="detalleCita.pelo"
			    />
			</td>
		</tr>
		<tr>
			<td>Tamaño</td>
			<td>
				<sj:radio
		           id="chkTamano"
		           list="{'Pequeño', 'Normal', 'Alto'}"
		           name="detalleCita.tamano"
			    />
			</td>
		</tr>
	</s:if>
	
	<tr>
		<td>Tiempo Aprox. </td>
		<td>
			<sj:datepicker
				name="detalleCita.tiempoAprox"
				value="%{detalleCita.tiempoAprox}"
				timepickerFormat="hh:mm"
				timepicker="true" 
				timepickerOnly="true" 
				timepickerShowHour="false"
				timepickerGridMinute="10" 
				timepickerStepMinute="10"
				inline="true"
			/>
		</td>
	</tr>
	<tr>
		<td>Costo </td>
		<td><s:textfield name="detalleCita.costo"/> </td>
	</tr>
	<tr>
		<td>Observaciones </td>
		<td><s:textarea name="detalleCita.observaciones"/> </td>
	</tr>
	
</table>