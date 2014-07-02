<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<link rel="stylesheet" href="css/styleHorario.css" type="text/css" />

<script type="text/javascript">
$.subscribe('onstart', function(event,data) {
// 	var result = $("#selectresult").empty();
    var className;
    
    $(".ui-selected").each(function(){
    	className= $(this).attr("class").indexOf("divHour");
       	className= $(this).attr("class").indexOf("selectableReserved");
       	className= $(this).attr("class").indexOf("selectableLocked");
       	
       	if(className != -1)
       		return false;
       	
    });
    
});
$.subscribe('onstop', function(event,data) {
       var result = $("#selectresult").empty();
       var className;
       
       $(".ui-selected").each(function(){
       	
       	className= $(this).attr("class").indexOf("divHour");
       	className= $(this).attr("class").indexOf("selectableReserved");
       	className= $(this).attr("class").indexOf("selectableLocked");
       	
//        	$(this).each(function(){
//        		className= $(this).attr("class").indexOf("alignLeft");
//        		className= $(this).attr("class").indexOf("alignRight");
//        	});
       	
           if(className == -1){
        	   
        	   var detalle = 'Fecha: '+$(this).find('.alignLeft').html()+'<br/>'+
        	   				 'Hora:  '+$(this).find('.alignRight').html();
        	   result.html( detalle );
        	   
           }   
           else{
        	   var detalle = 'Fecha: DD/MM/YYYY<br/>'+
 				 'Hora: HH:MM';
 				result.html( detalle );
        	   
        	   
           }
       });
});
</script> 
<s:form id="formHorarios">

<fieldset>
	
	<table style="width: 100%;">
		<tr>
			<td style="width: 50%;">
				<h3>Medico de Turno: Carol Alvarez</h3>
			</td>
			<td style="width: 50%;">
				<h3>
					<div id="selectresult">
						Fecha: DD/MM/YYYY<br/> 
						Hora: HH:MM
					</div>
				</h3>
			</td>
		</tr>
	</table>
</fieldset>

<table style="width: 100%;">
	<tr>
		<td style="width: 100%;">
			
			<table style="width: 800px;">
				<tr>
					<td style="width: 90px;">
						<sj:a id="btnPrevWeek" 
							href="reloadCalendarAction.action?oper=prev"
							targets="divCalendarDinamic"
							button="true"
							buttonIcon="ui-icon-seek-prev">Anterior</sj:a>
					</td>
					<td style="width: 40px;">
						Turno
					</td>
					<td>

						<s:url var="urlTurno" action="loadTurnoJSON"/> 					        
 					     <sj:radio
 					     	id="rdnTurno"
 					        href="%{urlTurno}"
 					        name="turno"
 					        list="turnoLista"
 					        listKey="idTab"
 					        listValue="value1"
 					        formIds="formHorarios"
 					        value="turno"
 					        onChangeTopics="reloadDivData"/>
					    
					</td>
					<td>
						<h1><s:label id="lblHeadSchedule"/></h1>
					</td>
					<td style="text-align: right;">
						<sj:a id="btnNextWeek"
							href="reloadCalendarAction.action?oper=next"
							targets="divCalendarDinamic"
							button="true"
							buttonIcon="ui-icon-seek-next">Siguiente</sj:a>
							
					</td>
				</tr>
			</table>
			
		</td>
	</tr>
	<tr>
		<td style="width: 100%;">
		
		<table id="dlgLoading" style="width: 100%; margin-top: -23px; position: absolute; display: none;">
	       	<tr>
	       		<td style="width: 100%; text-align: center;">
	       			<img alt="Loading" src="img/loading.gif">
	       		</td>
	       	</tr>
		</table>
		
		<s:url id="urlLoadCalendar" action="loadCalendarAction"/>
		<sj:div
			id="divCalendarDinamic"
			formIds="formHorarios"
			effect="blind"
			effectMode="show"
			effectDuration="500"
			indicator="dlgLoading"
			reloadTopics="reloadDivData"
			href="%{urlLoadCalendar}" />
		</td>
	</tr>
</table>

<sj:a button="true" buttonIcon="ui-icon-circle-check">Aceptar</sj:a>

</s:form>