<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

 	<s:iterator value="calendarioLista" status="stat">
 		
 		<s:if test="hourTab==1">
 			<div class="selectable divHour"><s:property value="valueTab"/></div>
 		</s:if>
 		<s:else>
 			<div class="selectable"><s:property value="valueTab"/></div>
 		</s:else>
 		
 	</s:iterator>
     

			
