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
    	
		<table align="center">
			<tr>
		    	<td class="tdLabel"><s:text name="Tipo Cliente"/></td>
		    	<td>
		    		<sj:radio 
				       name="cliente.tipoCliente"
				       list="#{'C':'Cliente', 'E':'Empresa'}"
				       value="cliente.tipoCliente"
					/>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Nombres"/></td>
		    	<td><s:textfield name="cliente.nombres"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Ape. Pat."/></td>
		    	<td><s:textfield name="cliente.apePat"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Ape. Mat."/></td>
		    	<td><s:textfield name="cliente.apeMat"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="DNI"/></td>
		    	<td><s:textfield name="cliente.dni" maxLength="8"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Sexo"/></td>
		    	<td>
		    		<sj:radio 
				       name="cliente.sexo"
				       list="#{'M':'M', 'F':'F'}"
				       value="cliente.sexo"
					/>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Fec. Nac."/></td>
		    	<td><sj:datepicker name="cliente.fecNac" showOn="focus" displayFormat="dd/mm/yy" changeMonth="true" changeYear="true"/> </td>
		    </tr>
		    <tr>
		    	<td class="tdLabel">Email</td>
		    	<td><s:textfield name="cliente.email"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel">Telefono </td>
		    	<td><s:textfield name="cliente.telefono"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel">Celular</td>
		    	<td><s:textfield name="cliente.celular"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel">Distrito</td>
		    	<td>
		    		<s:select 
				       name="cliente.idDistrito"
				       list="#{'27':'San Isidro', '22':'Puente Piedra'}"
				       value="cliente.sexo"
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
					<s:password name="usuario.pass"/>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Reingrese su Password"/></td>
		    	<td>
					<s:password name="usuario.rePass"/>
		    	</td>
		    </tr>
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
				    	<s:submit value="Guardar"/>
				    </td>
		        	<td><s:reset value="Volver" cssClass="butStnd"/></td>
				 </tr>
		</table>
		<s:hidden name="cliente.estado" value="1"/>
    </s:form>
	

