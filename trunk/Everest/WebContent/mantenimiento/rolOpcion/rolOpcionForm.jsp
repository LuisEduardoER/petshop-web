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
     		 	
    <s:form id="frmOpcion" action="insertarOActualizarRolOpcion">
    	<s:hidden name="rol.idRol" value="%{rol.idRol}"/>
    	<s:hidden name="opcion.idOpcion"/>
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
<%-- 		    		<s:select --%>
<%-- 				       name="opcionParent.idOpcion" --%>
<%-- 				       headerKey="0" headerValue="-- Parent --" --%>
<%-- 				       list="opcionParentLista" --%>
<%-- 				       listKey="idOpcion" --%>
<%-- 				       listValue="descripcion" --%>
<%-- 				       required="true" --%>
<%-- 				       value="opcionParent.idOpcion" --%>
<%-- 					/> --%>
					
					
					<s:url var="urlOpcionParent" action="loadOpcionsJSON"/>
 					     <sj:select
 					     	id="cboOpcionParent"
 					        href="%{urlOpcionParent}"
 					        name="idOpcionParent"
 					        list="opcionParentLista"
 					        listKey="idOpcion"
 					        listValue="titulo"
 					        dataType="json"
 					        emptyOption="true"
 					        onChangeTopics="reloadsecondlist"
 					        formIds="frmOpcion"/>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Descripcion"/></td>
		    	<td>
		    		<s:url var="urlOpcions" action="loadOpcionsJSON"/>
						<sj:select
 					     	id="cboOpcion"
 					        href="%{urlOpcions}"
 					        name="idOpcion"
 					        reloadTopics="reloadsecondlist"
 					        dataType="json"
 					        list="opcionLista"
 					        listKey="idOpcion"
 					        listValue="titulo"
 					        emptyOption="true"
 					        formIds="frmOpcion"/>
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
	

