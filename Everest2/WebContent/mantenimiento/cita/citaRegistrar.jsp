<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<script>
$(function() {
	$.subscribe('closeDialog', function(event,data) {
		var html = "<table style='width: 100%;'>"+
				    	"<tr>"+
						"<td style='width: 100%; text-align: center;'>"+
							"<img alt='Loading' src='img/loading.gif'>"+
						"</td>"+
					"</tr>"+
				"</table>";
        $("#dlgCalendar").empty();
        $("#dlgCalendar").html(html);
    });
});
</script>

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
			<td>Local</td>
			<td>
				<select>
					<option>Local 1</option>
					<option>Local 2</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Fecha</td>
			<td>Hora</td>
		</tr>
		<tr>
			<td>
				<s:label name="cita.fecProg" value="DD/MM/YYYY"/>
			</td>
			<td>
				<s:label name="cita.hourProg" value="HH:MM"/>
			</td>
			<td>
				<s:url var="urlLoadHorarios" value="loadDaysOfWeekAction"/>
				<sj:a openDialog="dlgCalendar"
  					button="true"
  					buttonIcon="ui-icon-calendar"
  					href="%{urlLoadHorarios}"
  					>Horarios</sj:a>
 					 
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
	hideEffect="explode"
	width="830"
	closeOnEscape="true"
	onCloseTopics="closeDialog"
	title="Horarios">
 	
 	<table id="dlgLoading" style="width: 100%; ">
       	<tr>
       		<td style="width: 100%; text-align: center;">
       			<img alt="Loading" src="img/loading.gif">
       		</td>
       	</tr>
	</table>
 	
</sj:dialog>
    