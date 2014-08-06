<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<link rel="stylesheet" href="css/styleServicio.css" type="text/css" />

<s:form>

<h1>
Disponibilidad de Servicios
</h1>

<fieldset >
	
	<legend> <h2>&nbsp;</h2> </legend>
	
</fieldset>

<div style="width: 100%; height: 300px;">
	
	<s:iterator value="{citaListaHoras,
						citaListaMonday,
						citaListaTuesday,
						citaListaWednesday,
						citaListaThursday,
						citaListaFriday,
						citaListaSaturday,
						citaListaSunday
						}" var="semanas">
	
		<sj:div selectable="true" cssClass="selecColumn">
			<s:iterator value="#semanas" status="stat">
				<s:if test="#stat.count == 1">
					<div class="selectable selectableHead">
						<s:property value="descripcion"/>
						<s:date name="houtrProg" format="hh"/>
					</div>
				</s:if>
				<s:else>
					<div class="selectable">
						
<%-- 						<sj:a openDialog="dlgForm" --%>
<%-- 			  					button="true" --%>
<%-- 			  					buttonIcon="ui-icon-plus" --%>
<%-- 			  					buttonText="false"			  					 --%>
<%-- 			  					>Horarios</sj:a> --%>
			  					
					</div>
				</s:else>
			</s:iterator>
		</sj:div>
		
	</s:iterator>
	
	<br>
	<sj:div cssStyle="width: 100%; float: left;">
		<div class="selectable selectableHead" style="width: 10.4%;"></div>
		<div class="selectable selectableHead" style="width: 10.4%;">Lunes</div>
		<div class="selectable selectableHead" style="width: 10.4%;">Martes</div>
		<div class="selectable selectableHead" style="width: 10.4%;">Miercoles</div>
		<div class="selectable selectableHead" style="width: 10.4%;">Jueves</div>
		<div class="selectable selectableHead" style="width: 10.4%;">Viernes</div>
		<div class="selectable selectableHead" style="width: 10.4%;">Sabado</div>
		<div class="selectable selectableHead" style="width: 10.4%;">Domingo</div>
	</sj:div>
	
</div>

</s:form>
