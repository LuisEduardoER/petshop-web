<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>


<sj:div cssStyle="width: 800px; float: left; border-right: 1px dotted #FECA40">
	
	<s:iterator value="calendarioHeadLista">
		<div class="selectable selectableHead"><s:property value="value1"/></div>
	</s:iterator>
	
</sj:div>
     
<sj:div id="selectabledivs" 
	selectableOnStopTopics="onstop" 
	selectable="true"
	formIds="formHorarios"
	cssStyle="width: 800px; float: left; border-right: 1px dotted #FECA40" >
	
	<s:iterator value="calendarioBodyLista" status="stat">
 		
 		<s:if test="tipo==1">
 			<div class="selectable divHour"><s:property value="value1"/></div>
 		</s:if>
 		<s:elseif test="tipo==2">
 			<div class="selectable selectableReserved" title="Reservado">
 				<div><s:property value="value1"/></div>
 				<div class="alignRight"><s:property value="value2"/></div>
 			</div>
 		</s:elseif>
 		<s:else>
 			<div class="selectable selectableBody">
 				<div><s:property value="value1"/></div>
 				<div class="alignRight"><s:property value="value2"/></div>
			</div>
 		</s:else>
 		
 	</s:iterator>
	
</sj:div>

<h3><strong><span id="selectresult">&nbsp;</span></strong></h3> <br/>
			
<br>
<s:hidden id="hdnHeadSchedule" name="strHeadSchedule"/>
<%-- <s:hidden id="hdnTurno" name="turno"/> --%>
<script type="text/javascript">
var headSchedule = $("#hdnHeadSchedule").val();
// var turno = $("#hdnTurno").val();

$("#lblHeadSchedule").html(headSchedule);
// var $radios = $('input:radio[name='+turno+']');//.button( "checked", "checked" );
// var $radios = $('#turno');
// if($radios.is(':checked') == false) {
//     $radios.filter('[value='+turno+']').button( "checked", "checked" );
// }
</script>