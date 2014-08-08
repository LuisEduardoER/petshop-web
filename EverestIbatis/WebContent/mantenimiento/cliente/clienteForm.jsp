<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<h1>
	<s:if test="oper=='add'">
		Agregar 
	</s:if>
	<s:if test="oper=='edit'">
		Editar
	</s:if>
	 Cliente
</h1>

<s:if test="message != null">
<jsp:include page="/info.jsp"/>
</s:if>

	 <table>
		<tr><td align="left" style="font:bold;color:red"> 
	            <s:fielderror/> 	 	
                <s:actionerror/>
                <s:actionmessage/>
             </td>
        </tr>
     </table>
     		 	
    <s:form id="frmCliente" action="saveClienteForm">
    	<s:hidden name="cliente.idCliente"/>
    	<s:hidden name="oper"/>
    	<s:hidden name="cliente.tipoCliente" value="P"/>
    	
		<table align="center">
<!-- 			<tr> -->
<%-- 		    	<td class="tdLabel"><s:text name="Tipo Cliente"/></td> --%>
<!-- 		    	<td> -->
<%-- 		    		<sj:radio  --%>
<%-- 				       name="cliente.tipoCliente" --%>
<%-- 				       list="#{'P':'Cliente', 'E':'Empresa'}" --%>
<%-- 				       value="cliente.tipoCliente" --%>
<%-- 					/> --%>
<!-- 		    	</td> -->
<!-- 		    </tr> -->
		    <tr>
		    	<td class="tdLabel"><s:text name="Nombres"/></td>
		    	<td><s:textfield name="cliente.nombres" required="true"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Ape. Pat."/></td>
		    	<td><s:textfield name="cliente.apePat" required="true"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Ape. Mat."/></td>
		    	<td><s:textfield name="cliente.apeMat" required="true"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="DNI"/></td>
		    	<td><sj:textfield name="cliente.dni" maxlength="8" required="true"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Sexo"/></td>
		    	<td>
		    		<sj:radio 
				       name="cliente.sexo"
				       list="#{'M':'M', 'F':'F'}"
				       value="cliente.sexo"
				       required="true"
					/>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Fec. Nac."/></td>
		    	<td>
		    		<sj:datepicker name="cliente.fecNac" 
		    						buttonImageOnly="true"
		    						displayFormat="dd/mm/yy" 
		    						changeMonth="true" 
		    						changeYear="true" 
		    						required="true"
		    						maxDate="-18y"
		    						/>
		    		<div style="position: absolute; width: 154px; height: 22px; z-index: 1000; margin-top: -25px; margin-left: 1px;"></div>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel">Email</td>
		    	<td><s:textfield name="cliente.email" required="true"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel">Telefono </td>
		    	<td><s:textfield name="cliente.telefono"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel">Celular</td>
		    	<td><s:textfield name="cliente.celular" required="true"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel">Distrito</td>
		    	<td>
		    		<s:select 
				       name="cliente.idDistrito"
				       list="#{'27':'San Isidro', '22':'Puente Piedra'}"
				       value="cliente.sexo"
				       required="true"
					/>
				</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Direccion"/></td>
		    	<td><s:textarea name="cliente.direccion"/> </td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Linea de Credito"/></td>
		    	<td>
					<s:textfield name="cliente.lineaCredito"/>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Password"/></td>
		    	<td>
					<s:password name="usuario.pass" required="true"/>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Reingrese su Password"/></td>
		    	<td>
					<s:password name="usuario.rePass" required="true"/>
		    	</td>
		    </tr>
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
				    	<s:submit value="Guardar"/>
				    </td>
		        	<td><input type="button" value="Volver" onclick="javascript:history.back(-1);"> </td>
				 </tr>
		</table>
		<s:hidden name="cliente.estado" value="1"/>
    </s:form>
	

