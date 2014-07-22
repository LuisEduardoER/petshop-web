<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<fieldset>
	<legend>
		<h1>Mantenimiento de TipoProductos</h1>
	</legend>
</fieldset>

<s:url id="insert" action="showTipoProductoFormAction" escapeAmp="false">
    <s:param name="oper">add</s:param>
</s:url>
<sj:a 
	openDialog="dlgForm"
	href="%{insert}"
	button="true" 
	buttonIcon="ui-icon-plus"
	>Agregar</sj:a>

<table id="table" class="dls-table" cellspacing="0" cellpadding="0">
    <thead>
    <tr>
         <th>ID</th>
            <th>Descripcion</th> 
            <th class="ui-state-disabled tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-pencil" buttonText="false" disabled="false" cssClass="no-border">Editar</sj:a>
            </th>
            <th class="ui-state-disabled tdButton">
            	<sj:submit 
 						type="button"
 						cssClass="no-margin"
 						button="true"
 						buttonIcon="ui-icon-circle-close" 
 						buttonText="false">
 						Eliminar
 					</sj:submit>
            </th>
        </tr>
    </thead>
    <tbody class="dls-table-body">
    	<s:if test="tipoProductoLista.size==0">
			<tr>
				<td colspan="7" style="text-align: center;">
					<h3>No hay Registros disponibles</h3>
				</td>
			</tr>
		</s:if>
    	<s:iterator value="tipoProductoLista" var="objTipoProducto" status="stat">
	        <tr>
	            <td><s:property value="idTipoProducto"/></td>
	            <td> <s:property value="descripcion"/> </td>
	           
	            
	            <td class="tdButton">
	            	
		            <s:url id="update" action="showTipoProductoFormAction" escapeAmp="false">
		       		    <s:param name="tipoProducto.idTipoProducto" value="idTipoProducto"/>
		       		    <s:param name="oper">edit</s:param>
		       		</s:url>
					<sj:a openDialog="dlgForm"
					  href="%{update}" 
					  button="true" 
					  buttonText="false"
					  cssClass="no-border"
					  indicator="myLoadingBar"
					  buttonIcon="ui-icon-pencil">
						Editar
					</sj:a>
	            </td>
	            <td class="tdButton">
		       		<s:form id="formDel%{#stat.count}" action="insertarOActualizarTipoProducto" method="post">
				      <s:hidden name="tipoProducto.idTipoProducto" value="%{idTipoProducto}"/>
				      <s:hidden name="oper" value="del"/>
				      
 					<sj:submit 
 						type="button"
 						formIds="formDel%{#stat.count}"
 						indicator="myLoadingBar"
 						cssClass="no-margin"
 						button="true"
 						buttonIcon="ui-icon-circle-close" 
 						buttonText="false">
 						Eliminar
 					</sj:submit>
 					</s:form>
	            </td>
	        </tr>
		</s:iterator>
			<tr>
				<td colspan="7"></td>
			</tr>
    </tbody>
</table>