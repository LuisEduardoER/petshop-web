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
     		 	
    <s:form id="frmRol" action="insertarOActualizarRol">
    	<s:hidden name="rol.idRol"/>
		<table align="center">
		    <tr>
		    	<td class="tdLabel"><s:text name="Descripcion"/></td>
		    	<td><s:textfield name="rol.descripcion" size="30"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Estado"/></td>
		    	<td>
		    		<s:select 
				       name="rol.estado"			       
				       headerKey="" headerValue="-- Seleccione --"
				       list="#{'Activo':'Activo', 'Inactivo':'Inactivo'}"
				       value="rol.estado"
					/>
				</td>
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
	

