<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<script type="text/javascript">
$(function() {
	$("#dlgForm").dialog('option', 'title', 'Rol');
});
</script>

<h1>Mantenimiento de Roles</h1>

<s:url id="insert" action="showRolFormAction" escapeAmp="false">
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
            <th>Descripcion</th>
            <th>Estado</th>
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
            <th class="ui-state-disabled tdButton">
            	<sj:submit 
 						type="button"
 						cssClass="no-margin"
 						button="true"
 						buttonIcon="ui-icon-circlesmall-plus" 
 						buttonText="false">
 						Opciones
 					</sj:submit>
            </th>
        </tr>
    </thead>
    <tbody class="dls-table-body">
    	<s:if test="opcionLista.size==0">
			<tr>
				<td colspan="6" style="text-align: center;">
					<h3>No hay Registros disponibles</h3>
				</td>
			</tr>
		</s:if>
    	<s:iterator value="rolLista" var="objRol" status="stat">
	        <tr>
	            <td class="id"> <s:property value="idRol"/> </td>
	            <td> <s:property value="descripcion"/> </td>
	            <td> <s:property value="estado"/> </td>
	            
	            <td class="tdButton">
	            	
		            <s:url id="update" action="showRolFormAction" escapeAmp="false">
		       		    <s:param name="rol.idRol" value="idRol"/>
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
		       		<s:form id="formDel%{#stat.count}" action="insertarOActualizarRol" method="post">
				      <s:hidden name="rol.idRol" value="%{idRol}"/>
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
	            <td class="tdButton">
		       		<s:form id="formOpcion%{#stat.count}" action="showRolOpcionListaAction" method="post">
				      <s:hidden name="rol.idRol" value="%{idRol}"/>
				    
 					<sj:submit 
 						type="button"
 						formIds="formOpcion%{#stat.count}"
 						indicator="myLoadingBar"
 						cssClass="no-margin"
 						button="true"
 						buttonIcon="ui-icon-circlesmall-plus" 
 						buttonText="false">
 						Opciones
 					</sj:submit>
 					</s:form>
	            </td>
	        </tr>
		</s:iterator>
			<tr>
				<td colspan="6"></td>
			</tr>
    </tbody>
</table>

<div id="divResult"></div>

<br/>


