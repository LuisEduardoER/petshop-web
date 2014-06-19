<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:form id="form1">

<h1>
Registro de Citas
</h1>

<fieldset id="fsMascota">
	
	<legend> <h2>Mascota</h2> </legend>
	
	<s:include value="citaMascota.jsp"/>
	
</fieldset>

<br>

<fieldset>
	<legend> <h2>Cita </h2> </legend>

	<table>
		<tr>
			<td>Fecha</td>
			<td>Hora</td>
		</tr>
		<tr>
			<td>
				<sj:datepicker showOn="focus" changeMonth="true" changeYear="true"/>
			</td>
			<td>
				<sj:datepicker showOn="focus" timepicker="true" timepickerOnly="true" timepickerGridHour="2" timepickerGridMinute="30" timepickerStepMinute="30"/>
			</td>
			<td>
				<sj:a openDialog="dlgCalendar" button="true" buttonIcon="ui-icon-calendar">Horarios</sj:a>
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

<br>

<sj:a button="true" buttonIcon="ui-icon-disk">Registrar</sj:a>

<br>
</s:form>

<sj:dialog 
	id="dlgCalendar" 
	autoOpen="false" 
	modal="true"
	showEffect="slide"
	width="830"
	closeOnEscape="true"
	hideEffect="destroy"
	title="Horarios">
 
 <s:include value="citaHorarios.jsp"/>
 
</sj:dialog>
    