<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<h1>
	<s:if test="oper=='add'">
		Agregar 
	</s:if>
	<s:if test="oper=='edit'">
		Editar
	</s:if>
	 Usuario
	</h1>

	 <table>
		<tr><td align="left" style="font:bold;color:red"> 
	            <s:fielderror/> 	 	
                <s:actionerror/>
                <s:actionmessage/>
             </td>
        </tr>
     </table>
     		 	
    <s:form id="frmUsuario" action="saveUsuarioForm">
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
				       name="usuario.idRol"
				       headerKey="0" headerValue="-- Seleccione --"
				       list="rolLista"
				       listKey="idRol"
				       listValue="descripcion"
				       required="true"
				       value="usuario.idRol"
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
		        	<td>
    		    	<sj:a button="true" buttonIcon="ui-icon-circle-arrow-w" onclick="javascript:history.back(-1);">
    		    		Volver
    		    	</sj:a>
    		    </td>
				 </tr>
		</table>
    </s:form>
	

