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
.selectableHead{
height: 20px;
background: #61B4C8;
color: white;
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
	$.subscribe('onstop', function(event,data) {
        var result = $("#selectresult").empty();
        
        $(".ui-selected").each(function(){
        	
        	var className= $(this).attr("class").indexOf("divHour");
                  	
            if(className == -1)
            	result.append($(this).html()+' ');
        });
	});
// 	function turnoChange(value){
// 		  window.location="loadCalendarAction?turno="+value; //or you can submit a form from here or make an ajax call
// 		}
    </script> 
<s:form id="formHorarios">

<table style="width: 100%;">
	<tr>
		<td style="width: 100%;">
			
			<table style="width: 800px;">
				<tr>
					<td style="width: 90px;">
						<sj:a button="true"
							buttonIcon="ui-icon-seek-prev">Anterior</sj:a>
					</td>
					<td>
						Turno
						<s:url var="urlTurno" action="loadTurnoJSON"/>
						<sj:select
							id="turno"
 					        href="%{urlTurno}"
 					        name="turno"
 					        list="turnoLista"
 					        listKey="idTab"
 					        listValue="valueTab"
 					        formIds="formHorarios"
 					        value="turno"
 					        onChangeTopics="reloadDivData"/>
					     
<%-- 					     <s:select name="turno" --%>
<%-- 								list="#{'M':'Manana', 'T':'Tarde'}" --%>
<%-- 					     		onchange="turnoChange(this.value)"/> --%>
					</td>
					<td style="text-align: right;">
						<sj:a button="true"
							buttonIcon="ui-icon-seek-next">Siguiente</sj:a>
					</td>
				</tr>
			</table>
			
		</td>
	</tr>
	<tr>
		<td style="width: 100%;">
					    
		    <sj:div cssStyle="width: 800px; float: left; border-right: 1px dotted #FECA40">
		    	
		    	<s:iterator value="calendarioDaysLista">
		    		<div class="selectable selectableHead"><s:property/></div>
		    	</s:iterator>
		    	
		    </sj:div>
		     
		    <s:url id="urlLoadCalendar" action="loadCalendarAction"/>
		    <sj:div id="selectabledivs" 
		    	selectableOnStopTopics="onstop" 
		    	selectable="true"
		    	formIds="formHorarios"
		    	effect="highlight"
		    	effectDuration="500"
		    	reloadTopics="reloadDivData"
		    	href="%{urlLoadCalendar}"
		    	cssStyle="width: 800px; float: left; border-right: 1px dotted #FECA40" >
		    	
		    	<s:iterator value="calendarioLista" status="stat">
		    		
		    		<s:if test="hourTab==1">
		    			<div class="selectable divHour"><s:property value="valueTab"/></div>
		    		</s:if>
		    		<s:else>
		    			<div class="selectable"><s:property value="valueTab"/></div>
		    		</s:else>
		    		
		    	</s:iterator>
		    	
		    </sj:div>
			
			Tu Seleccionaste:  <strong><span id="selectresult"></span></strong>. <br/>
			
			<br>
					     
		</td>
	</tr>
</table>

</s:form>