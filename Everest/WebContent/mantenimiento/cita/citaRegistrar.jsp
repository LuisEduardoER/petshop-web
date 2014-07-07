<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<script>
$(function() {
	$.subscribe('closeCalDialog', function(event,data) {
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

<s:form id="frmCita">

<h1>
Registro de Citas
</h1>

<sj:accordion cssClass="accAccordion" autoHeight="true">
	<sj:accordionItem title="Mascota">
		<s:include value="citaMascota.jsp"/>
	</sj:accordionItem>
</sj:accordion>

<sj:accordion cssClass="accAccordion" autoHeight="true">
	<sj:accordionItem title="Servicios">
		<s:include value="citaServicioLista.jsp"/>
		
		<s:url />
		<sj:div/>
		
	</sj:accordionItem>
    <sj:accordionItem title="Cita">
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
    </sj:accordionItem>
   </sj:accordion>
<br>

<sj:a button="true" buttonIcon="ui-icon-disk">Registrar</sj:a>

<br>
<script type="text/javascript">
$(function() {
	var icons = {
		header: "ui-icon-circle-arrow-e",
		activeHeader: "ui-icon-circle-arrow-s"
	};
// 	$(".accAccordion").accordion("option","icons",null);
// 	$("h3.accAccordion span").css("float","left");
});
</script>

</s:form>

<sj:dialog
	id="dlgCalendar" 
	autoOpen="false" 
	modal="true"
	showEffect="slide"
	hideEffect="explode"
	width="830"
	closeOnEscape="true"
	onCloseTopics="closeCalDialog"
	title="Horarios">
 	
 	<table id="dlgLoading" style="width: 100%; ">
       	<tr>
       		<td style="width: 100%; text-align: center;">
       			<img alt="Loading" src="img/loading.gif">
       		</td>
       	</tr>
	</table>
 	
</sj:dialog>