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
     		 	
    <s:form id="frmCorrelativo" action="insertarOActualizarCorrelativo">
    	<s:hidden name="correl.idCorrelativo"/>
    	<s:hidden name="oper"/>
		<table align="center">
		    <tr>
		    	<td class="tdLabel"><s:text name="tabla"/></td>
		    	<td><s:textfield name="correl.tabla" size="30"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="valor"/></td>
		    	<td><s:textfield name="correl.valor" size="30"/></td>
		    </tr>
		    
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
<%-- 				    	<sj:a button="true" buttonIcon="ui-icon-disk" href="insertarOActualizarCorrelativo.action" formIds="frmCorrelativo">Guardar</sj:a> --%>
<%-- 				    	<s:submit action="insertarOActualizarCorrelativo" key="button.label.submit" cssClass="butStnd"/> --%>
				    	<sj:submit button="true" value="Guardar"/>
				    </td>
		        	<td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
				 </tr>
		</table>
    </s:form>
	

