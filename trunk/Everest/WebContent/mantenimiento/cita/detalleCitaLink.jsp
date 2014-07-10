<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<table>
		<tr><td align="left" style="font:bold;color:red"> 
	            <s:fielderror/> 	 	
                <s:actionerror/>
                <s:actionmessage/>
             </td>
        </tr>
     </table>
     		 	
    <s:form id="frmDetalleCita" >
    
    	<s:url id="showDetalleCitaForm" action="showDetalleCitaForm"></s:url>
		<sj:div 
			id="divDetalleCitaForm" 
			href="%{showDetalleCitaForm}"
			formIds="frmDetalleCita"
			reloadTopics="reloadDivForm" 
			effect="blind" 
			effectDuration="500"
			effectMode="show"/>
	
    </s:form>


	