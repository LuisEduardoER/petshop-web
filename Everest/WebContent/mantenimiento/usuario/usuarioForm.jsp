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
     		 	
    <s:form id="frmUsuario" action="insertarOActualizarUsuario">
    	<s:hidden name="rol.idRol" value="%{rol.idRol}"/>
    	<s:hidden name="usuario.idUsuario"/>
		<table align="center">
		
		<s:if test="usuario.idUsuario != 0">
			<tr>
		    	<td class="tdLabel"><s:text name="Id"/></td>
		    	<td><s:text name="usuario.idUsuario"/></td>
		    </tr>
		</s:if>
		    
		    <tr>
		    	<td class="tdLabel"><s:text name="Rol"/></td>
		    	<td>
		    		<s:select
				       name="usuario.rol.idRol"
				       headerKey="0" headerValue="-- Seleccione --"
				       list="listaRol"
				       listKey="idRol"
				       listValue="descripcion"
				       required="true"
				       value="usuario.rol.idRol"
					/>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="User"/></td>
		    	<td><s:textfield name="usuario.user" size="30"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Pass"/></td>
		    	<td><s:textfield name="usuario.pass" size="30" required="true"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Estado"/></td>
		    	<td>
		    		<s:select 
				       name="usuario.estado"			       
				       headerKey="" headerValue="-- Seleccione --"
				       list="#{'Activo':'Activo', 'Inactivo':'Inactivo'}"
				       value="usuario.estado"
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
	

