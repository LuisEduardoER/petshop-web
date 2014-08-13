<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h1>
	Cita
</h1>

<s:form id="frm01" action="showCitaCalendario">
<s:url var="urlLoadTurno" action="loadTurnoJSON"></s:url>

<div id="divMascota">
	<jsp:include page="citaMascota.jsp"/>
</div>

<table class="dls-table-form" style="width: 100%;" cellspacing="0" cellpadding="0">
	<tr>
		<th style="width: 200px;">Local</th>
		<th style="width: 235px;">Turno</th>
		<th style="width: 235px;">Medico</th>
	</tr>
	<tr>
		<td>
			<s:select list="localLista"
				listKey="idLocal"
				listValue="nomLocal"
				name="idLocal"
			/>
		</td>
		<td>
			<sj:select 
				href="%{urlLoadTurno}" 
				onChangeTopics="reloadMedico" 
				name="idTurno" 
				list="turnoLista" 
				listKey="idTurno" 
				listValue="nomTurno"
				formIds="frm01" 
				headerKey="-1" 
				headerValue="-- Seleccione --"
			/>
		</td>
		<td>
			<sj:select 
				href="%{urlLoadTurno}" 
				reloadTopics="reloadMedico" 
				name="idMedico" 
				list="medicoLista" 
				listKey="idMedico" 
				listValue="nombreCompleto"
				formIds="frm01"
				cssStyle="min-width: 100px;"
			/>
		</td>
	</tr>
</table>

<br/>

<sj:submit 
	type="button"
	button="true" 
	formIds="frm01"
	buttonIcon="ui-icon-calculator">
	Calendario
</sj:submit>

<s:url var="urlShowCitaCalendario" action="showCitaCalendario"/>
<sj:a 
	openDialog="dlgForm"
	href="%{urlShowCitaCalendario}"
	button="true" 
	formIds="frm01"
	effectMode="show"
	buttonIcon="ui-icon-calculator">
	Calendario
</sj:a>

</s:form>