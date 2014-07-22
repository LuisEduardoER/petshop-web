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
     		 	
    <s:form id="frmTipoAnimal" action="insertarOActualizarTipoAnimal">
    	<s:hidden name="tipoAnimal.idTipoAnimal"/>
    	<s:hidden name="oper"/>
    	
		<table align="center">
		    <tr>
		    	<td class="tdLabel"><s:text name="Descripcion"/></td>
		    	<td><s:textfield name="tipoAnimal.descripcion" size="30"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Estado"/></td>
		    	<td>
		    		<s:select 
				       name="tipoAnimal.estado"			       
				       headerKey="" headerValue="-- Seleccione --"
				       list="#{'1':'Activo', '0':'Inactivo'}"
				       value="tipoAnimal.estado"
					/>
				</td>
		    </tr>
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
<%-- 				    	<sj:a button="true" buttonIcon="ui-icon-disk" href="insertarOActualizarTipoAnimal.action" formIds="frmTipoAnimal">Guardar</sj:a> --%>
<%-- 				    	<s:submit action="insertarOActualizarTipoAnimal" key="button.label.submit" cssClass="butStnd"/> --%>
				    	<sj:submit button="true" value="Guardar"/>
				    </td>
		        	<td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
				 </tr>
		</table>
    </s:form>
	

