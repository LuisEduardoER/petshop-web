<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<h1>Mantenimiento de Clientes</h1>

<s:url id="insert" action="showClienteFormAction" escapeAmp="false">
    <s:param name="oper">add</s:param>
</s:url>
<sj:a 
	openDialog="dlgForm"
	href="%{insert}"
	button="true" 
	buttonIcon="ui-icon-plus"
	>Agregar</sj:a>

<table id="tableClientes" class="dls-table" cellspacing="0" cellpadding="0">
    <thead>
        <tr>
            <th>ID</th>
            <th>Tipo</th>
            <th>Documento</th>
            <th>Nombres</th>
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
	            <td> <s:property value="tipoDocumento.descripcion"/> </td>
	            <td> <s:property value="documento"/> </td>
	            <td> <s:property value="nombres"/> </td>
	            <td> <s:property value="apePat"/> </td>
	            <td> <s:property value="apeMat"/> </td>
	            <td class="tdButton">
	            	
		            <s:url id="update" action="showClienteFormAction" escapeAmp="false">
		       		    <s:param name="cliente.idCliente" value="idCliente"/>
		       		    <s:param name="oper">edit</s:param>
		       		</s:url>
					<sj:a openDialog="dlgForm"
					  href="%{update}"
					  targets="dlgForm" 
					  button="true" 
					  buttonText="false"
					  cssClass="no-border"
					  indicator="myLoadingBar"
					  buttonIcon="ui-icon-pencil">
						Editar
					</sj:a>
	            </td>
	            <td class="tdButton">
		       		<s:form id="formMascota%{#stat.count}" action="showMascotaMantenimientoAction" method="post">
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

