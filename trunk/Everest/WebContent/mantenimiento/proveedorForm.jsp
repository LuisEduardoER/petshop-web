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
     		 	
    <s:form id="frmProveedor">
    	<s:hidden name="proveedor.idProveedor"/>
		<table align="center">
		    <tr>
		    	<td class="tdLabel"><s:text name="RUC"/></td>
		    	<td><s:textfield name="proveedor.ruc" size="30"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Razon Social"/></td>
		    	<td><s:textfield name="proveedor.razonSocial" size="30"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Direccion"/></td>
		    	<td><s:textfield name="proveedor.direccion" size="30"/></td>
		     </tr>
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
				    	<sj:a button="true" buttonIcon="ui-icon-disk"  href="insertarOActualizarProveedor" formIds="frmProveedor">Guardar</sj:a>
				    </td>
		        	<td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
				 </tr>
		</table> 		  		 
    </s:form>
	

