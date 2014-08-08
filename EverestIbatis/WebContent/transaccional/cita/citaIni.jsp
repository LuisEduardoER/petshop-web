<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h1>
	Cita
</h1>

<s:form id="frm01">
<s:url var="urlLoadTurno" action="loadTurnoJSON"></s:url>

<table class="dls-table-form" style="width: 100%;" cellspacing="0" cellpadding="0">
	<tr>
		<th>DNI</th>
		<th>Nombre</th>
		<th>Mascota</th>			
	</tr>
	<tr id="trMascota">
		<jsp:include page="citaMascota.jsp"/>
<%-- 		<sj:div href="loadMascota" formIds="frm01"/> --%>
	</tr>
	<tr>
		<th>Local</th>
		<th>Turno</th>
		<th>Medico</th>			
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

</s:form>