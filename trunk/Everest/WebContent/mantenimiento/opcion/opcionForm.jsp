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
    	<s:hidden name="opcion.idOpcion"/>
    	<s:hidden name="oper" value="%{oper}"/>
		<table align="center">
		
		<s:if test="opcion.idOpcion != 0">
			<tr>
		    	<td class="tdLabel"><s:text name="Id"/></td>
		    	<td><s:text name="opcion.idOpcion"/></td>
		    </tr>
		</s:if>
		    
		    <tr>
		    	<td class="tdLabel"><s:text name="Parent"/></td>
		    	<td>
		    		<s:select
				       name="opcionParent.idOpcion"
				       headerKey="0" headerValue="-- Parent --"
				       list="opcionParentLista"
				       listKey="idOpcion"
				       listValue="descripcion"
				       required="true"
				       value="opcionParent.idOpcion"
					/>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Descripcion"/></td>
		    	<td><s:textfield name="opcion.descripcion" size="30"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Titulo"/></td>
		    	<td><s:textfield name="opcion.titulo" size="30" required="true"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="URL"/></td>
		    	<td><s:textfield name="opcion.url" size="30" required="true"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="orden"/></td>
		    	<td><s:textfield name="opcion.orden" size="30" required="true" /></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Estado"/></td>
		    	<td>
		    		<s:select 
				       name="opcion.estado"
				       list="#{'Activo':'Activo', 'Inactivo':'Inactivo'}"
				       value="opcion.estado"
				       required="true"
					/>
				</td>
		    </tr>
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
				    	<sj:submit button="true" value="Guardar"/>
				    </td>
		        	<td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
				 </tr>
		</table>
    </s:form>
	

