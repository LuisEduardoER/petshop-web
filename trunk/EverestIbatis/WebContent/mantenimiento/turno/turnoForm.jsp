<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
		 
	 <table>
		<tr><td align="left" style="font:bold;color:red"> 
	            <s:fielderror/> 	 	
                <s:actionerror/>
                <s:actionmessage/>
             </td>
        </tr>
     </table>
     		 	
    <s:form id="frmTurno" action="insertarOActualizarTurno">
    	<s:hidden name="turno.idTurno"/>
    	<s:hidden name="oper"/>
		<table align="center">
		    <tr>
		    	<td class="tdLabel"><s:text name="Nombre"/></td>
		    	<td><s:textfield name="turno.nomTurno" size="30"/></td>
		    </tr>
		    
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
<%-- 				    	<sj:a button="true" buttonIcon="ui-icon-disk" href="insertarOActualizarRol.action" formIds="frmRol">Guardar</sj:a> --%>
<%-- 				    	<s:submit action="insertarOActualizarRol" key="button.label.submit" cssClass="butStnd"/> --%>
				    	<sj:submit button="true" value="Guardar"/>
				    </td>
		        	<td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
				 </tr>
		</table>
    </s:form>
	

