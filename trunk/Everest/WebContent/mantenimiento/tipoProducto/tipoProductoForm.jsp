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
     		 	
    <s:form id="frmTipoProducto" action="insertarOActualizarTipoProducto">
    	<s:hidden name="tipoProducto.idTipoProducto"/>
    	<s:hidden name="oper"/>
    	
		<table align="center">
		    <tr>
		    	<td class="tdLabel"><s:text name="Descripcion"/></td>
		    	<td><s:textfield name="tipoProducto.descripcion" size="30"/></td>
		    </tr>
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
<%-- 				    	<sj:a button="true" buttonIcon="ui-icon-disk" href="insertarOActualizarTipoProducto.action" formIds="frmTipoProducto">Guardar</sj:a> --%>
<%-- 				    	<s:submit action="insertarOActualizarTipoProducto" key="button.label.submit" cssClass="butStnd"/> --%>
				    	<sj:submit button="true" value="Guardar"/>
				    </td>
		        	<td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
				 </tr>
		</table>
    </s:form>
	

