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
     	
    	<s:hidden name="cliente.idCliente"/>
    	<s:hidden name="oper"/>
    	
		<table align="center">
			<tr>
		    	<td class="tdLabel"><s:text name="Tipo Cliente"/></td>
		    	<td>
		    		<s:url id="urlLoadTipoClienteJSON" action="loadTipoClienteJSON"/> 
		    		<sj:select 
						href="%{urlLoadTipoClienteJSON}" 
						name="tipoCliente"
						value="cliente.tipoCliente"
						list="tipoPersonaMap"
						onChangeTopics="reloadDivClienteForm" 
					/>
				</td>
		    </tr>
		    
		    <s:if test="%{cliente.tipoCliente=='P'}">
		    	<tr>
			    	<td class="tdLabel"><s:text name="DNI"/></td>
			    	<td><s:textfield name="cliente.dni"/></td>
			    </tr>
		    </s:if>
		    <tr>
		    	<td class="tdLabel"><s:text name="RUC"/></td>
		    	<td><s:textfield name="cliente.ruc"/></td>
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
		    	<td><sj:datepicker name="cliente.fecNac" showOn="focus" displayFormat="dd/mm/yy"/> </td>
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
		    	<td class="tdLabel"><s:text name="Direccion"/></td>
		    	<td><s:textarea name="cliente.direccion"/> </td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Estado"/></td>
		    	<td>
		    		<s:select 
				       name="cliente.estado"
				       list="#{'Activo':'Activo', 'Inactivo':'Inactivo'}"
				       value="cliente.estado"
					/>
				</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Linea de Credito"/></td>
		    	<td>
		    		
					<s:textfield name="cliente.lineaCredito"/>
		    	</td>
		    </tr>
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
				    	<sj:submit button="true" value="Guardar"/>
				    </td>
				 </tr>
		</table>
    
