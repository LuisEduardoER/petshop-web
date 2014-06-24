<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<style>
.selectable {
border:1px solid #F1F1F1;
float:left;
height:20px;
margin:1px;
padding:5px;
width:85px;
}
.selectable p{
margin: 0px;
}
.selectableHead{
height: 20px;
background: #61B4C8 !important;
color: white !important;
}
.alignRight{
width: 100%;
text-align: right;
}
.alignLeft{
width: 100%;
text-align: left;
}
.selectableBody{
color: white;
font-size: 11px;
line-height: 11px;
}
.selectableBody:HOVER{
color: #64B9B4;
background: #F0F9F0;
}
.selectableReserved{
background: #DC716E !important;
color: white !important;
font-size: 11px;
line-height: 11px;
}
.selectableLocked{
background: #656b6b !important;
color: #fff !important;
font-size: 11px;
line-height: 11px;
}
.divHour{
background: white !important;
color: black !important;
}

.selectablelist {
border:1px solid #000;
height:25px;
margin:5px;
padding:10px;
list-style-type: none;
}

.ui-selected {
background:#47A7BF;
color:#FFF;
}

.ui-selecting {
background:#61B4C8;
color: white;
}
</style>

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
           else
        	   result.append('&nbsp;');
       });
});
</script> 
<s:form id="formHorarios">

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
<%-- 						<sj:select --%>
<%-- 							id="turno" href="%{urlTurno}" name="turno" --%>
<%--  					        list="turnoLista" listKey="idTab" listValue="valueTab" --%>
<%--  					        formIds="formHorarios" value="turno" onChangeTopics="reloadDivData"/> --%>
 					        
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
					    
					     
<%-- 					     <s:select name="turno" --%>
<%-- 								list="#{'M':'Manana', 'T':'Tarde'}" --%>
<%-- 					     		onchange="turnoChange(this.value)"/> --%>
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