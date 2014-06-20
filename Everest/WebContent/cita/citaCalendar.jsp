<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>


<sj:div cssStyle="width: 800px; float: left; border-right: 1px dotted #FECA40">
	
	<s:iterator value="calendarioDaysLista">
		<div class="selectable selectableHead"><s:property value="valueTab"/></div>
	</s:iterator>
	
</sj:div>
     
<sj:div id="selectabledivs" 
	selectableOnStopTopics="onstop" 
	selectable="true"
	formIds="formHorarios"
	cssStyle="width: 800px; float: left; border-right: 1px dotted #FECA40" >
	
	<s:iterator value="calendarioLista" status="stat">
 		
 		<s:if test="hourTab==1">
 			<div class="selectable divHour"><s:property value="valueTab"/></div>
 		</s:if>
 		<s:else>
 			<div class="selectable selectableBody"><s:property value="valueTab"/></div>
 		</s:else>
 		
 	</s:iterator>
	
</sj:div>

Tu Seleccionaste:  <strong><span id="selectresult"></span></strong>. <br/>
			
<br>