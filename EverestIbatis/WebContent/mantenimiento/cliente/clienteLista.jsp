<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<table id="tableClientes" class="dls-table" cellspacing="0" cellpadding="0">
    <thead>
        <tr>
            <th>ID</th>
            <th>DNI/RUC</th>
            <th>Nombres/Razon Social</th>
            <th>Ape. Pat.</th>
            <th>Ape. Mat.</th>
            <th class="ui-state-disabled tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-pencil" buttonText="false" disabled="false" cssClass="no-border">Editar</sj:a>
            </th>
            <th class="ui-state-disabled tdButton">
            	<sj:submit 
 						type="button"
 						cssClass="no-margin"
 						button="true"
 						buttonIcon="ui-icon-calculator" 
 						buttonText="false">
 						Mascotas
 					</sj:submit>
            </th>
        </tr>
    </thead>
    <tbody class="dls-table-body">
    	<s:if test="opcionLista.size==0">
			<tr>
				<td colspan="8" style="text-align: center;">
					<h3>No hay Registros disponibles</h3>
				</td>
			</tr>
		</s:if>
    	<s:iterator value="clienteLista" var="objCliente" status="stat">
	        <tr>
	            <td class="id"> <s:property value="idCliente"/> </td>
	            <td> <s:property value="dni"/> </td>
	            <td> <s:property value="nombres"/> </td>
	            <td> <s:property value="apePat"/> </td>
	            <td> <s:property value="apeMat"/> </td>
	            <td class="tdButton">
	            	<s:form id="frmEdit" action="showClienteRegistrar">
	            		<s:hidden name="oper" value="edit"/>
	            		<s:hidden name="cliente.idCliente"/>
						<sj:submit
							type="button"
							  button="true"
							  formIds="frmEdit" 
							  buttonText="false"
							  cssClass="no-border"
							  indicator="myLoadingBar"
							  buttonIcon="ui-icon-pencil">
							Editar
						</sj:submit>
					</s:form>
	            </td>
	            <td class="tdButton">
		       		<s:form id="formMascota%{#stat.count}" action="showMascotaLista" method="post">
				      <s:hidden name="cliente.idCliente" value="%{idCliente}"/>
 					<sj:submit 
 						type="button"
 						formIds="formMascota%{#stat.count}"
 						indicator="myLoadingBar"
 						cssClass="no-margin"
 						button="true"
 						buttonIcon="ui-icon-calculator" 
 						buttonText="false">
 						Mascotas
 					</sj:submit>
 					</s:form>
	            </td>
	        </tr>
		</s:iterator>
			<tr>
				<td colspan="8"></td>
			</tr>
    </tbody>
</table>

