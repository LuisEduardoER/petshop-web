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
     		 	
    <s:form id="frmMedico" action="insertarOActualizarMedico">
    	<s:hidden name="medico.idMedico"/>
    	<s:hidden name="oper"/>
		<table align="center">
		    <tr>
		    	<td class="tdLabel"><s:text name="Nombres"/></td>
		    	<td><s:textfield name="medico.nombres"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Apellidos"/></td>
		    	<td><s:textfield name="medico.apellidos"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Telefono"/></td>
		    	<td><s:textfield name="medico.telefono"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel">Turno</td>
		    	<td>
		    		<s:select
				       name="turno.idTurno"
				       headerKey="0" headerValue="-- Seleccione --"
				       list="turnoLista"
				       listKey="idTurno"
				       listValue="nomTurno"
				       required="true"
				       value="turno.idTurno"
					/>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel">Local</td>
		    	<td>
		    		<s:select
				       name="local.idLocal"
				       headerKey="0" headerValue="-- Seleccione --"
				       list="localLista"
				       listKey="idLocal"
				       listValue="nomLocal"
				       required="true"
				       value="local.idLocal"
					/>
		    	</td>
		    </tr>
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
<%-- 				    	<sj:a button="true" buttonIcon="ui-icon-disk" href="insertarOActualizarMedico.action" formIds="frmMedico">Guardar</sj:a> --%>
<%-- 				    	<s:submit action="insertarOActualizarMedico" key="button.label.submit" cssClass="butStnd"/> --%>
				    	<sj:submit button="true" value="Guardar"/>
				    </td>
		        	<td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
				 </tr>
		</table>
    </s:form>
	

