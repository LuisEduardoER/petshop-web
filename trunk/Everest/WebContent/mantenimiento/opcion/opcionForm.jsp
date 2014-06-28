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
     		 	
    <s:form id="frmOpcion" action="insertarOActualizarOpcion">
    	<s:hidden name="rol.idRol"/>
    	<s:hidden name="opcion.idOpcion"/>
		<table align="center">
		    <tr>
		    	<td class="tdLabel"><s:text name="Id"/></td>
		    	<td><s:text name="opcion.idOpcion"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Parent"/></td>
		    	<td>
		    		<s:select
				       name="opcion.opcion.idOpcion"
				       headerKey="0" headerValue="-- Parent --"
				       list="opcionParentLista"
				       listKey="idOpcion"
				       listValue="descripcion"
				       value="opcion.opcion.idOpcion"
					/>
<%-- 		    		<s:textfield name="opcion.opcion.descripcion" size="30"/> --%>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Descripcion"/></td>
		    	<td><s:textfield name="opcion.descripcion" size="30"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Titulo"/></td>
		    	<td><s:textfield name="opcion.titulo" size="30"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="URL"/></td>
		    	<td><s:textfield name="opcion.url" size="30"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="orden"/></td>
		    	<td><s:textfield name="opcion.orden" size="30"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Estado"/></td>
		    	<td>
		    		<s:select 
				       name="opcion.estado"			       
				       headerKey="" headerValue="-- Seleccione --"
				       list="#{'Activo':'Activo', 'Inactivo':'Inactivo'}"
				       value="opcion.estado"
					/>
				</td>
		    </tr>
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
<%-- 				    	<sj:a button="true" buttonIcon="ui-icon-disk" href="insertarOActualizarOpcion.action" formIds="frmOpcion">Guardar</sj:a> --%>
<%-- 				    	<s:submit action="insertarOActualizarOpcion" key="button.label.submit" cssClass="butStnd"/> --%>
				    	<sj:submit button="true" value="Guardar"/>
				    </td>
		        	<td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
				 </tr>
		</table>
    </s:form>
	

