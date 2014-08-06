<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

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
			<sj:datepicker name="cita.fecProg" showOn="focus" size="10px" displayFormat="dd/mm/yy" value="today"/>
		</td>
		<td>
			<sj:datepicker name="cita.hourProg" showOn="focus" timepicker="true" timepickerOnly="true" size="10" value="today" displayFormat="hh:mm"/>
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
</table>
