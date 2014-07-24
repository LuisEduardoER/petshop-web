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
     		 	
    <s:form id="frmFormaPago" action="insertarOActualizarFormaPago">
    	<s:hidden name="formaPago.idFormaPago"/>
    	<s:hidden name="oper"/>
		<table align="center">
		    <tr>
		    	<td class="tdLabel"><s:text name="Descripcion"/></td>
		    	<td><s:textfield name="formaPago.descripcion" size="30"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Tipo"/></td>
		    	<td><s:textfield name="formaPago.ripo" size="30"/></td>
		    </tr>
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
<%-- 				    	<sj:a button="true" buttonIcon="ui-icon-disk" href="insertarOActualizarFormaPago.action" formIds="frmFormaPago">Guardar</sj:a> --%>
<%-- 				    	<s:submit action="insertarOActualizarFormaPago" key="button.label.submit" cssClass="butStnd"/> --%>
				    	<sj:submit button="true" value="Guardar"/>
				    </td>
		        	<td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
				 </tr>
		</table>
    </s:form>
	

