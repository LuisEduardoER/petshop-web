<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<script type="text/javascript">
$(function() {
	$("#dlgForm").dialog('option', 'title', 'Opcion');
});
</script>

<fieldset>
	<legend>
		<h1>Mantenimiento de Opciones por Rol</h1>
	</legend>
	<s:hidden name="rol.idRol"/>
	<h2> Rol: <s:property value="rol.descripcion"/> </h2>
</fieldset>

<s:url id="insert" action="showRolOpcionFormAction" escapeAmp="false">
	<s:param name="rol.idRol" value="%{rol.idRol}"/>
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
            <th>Id</th>
            <th>Parent</th>
            <th>Titulo</th>
            <th>Descripcion</th>
            <th class="ui-state-disabled tdButton">
<%--             	<sj:a button="true" buttonIcon="ui-icon-circle-close" buttonText="false" disabled="false" cssClass="no-border">Eliminar</sj:a> --%>
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
    	<s:if test="opcionLista.size==0">
			<tr>
				<td colspan="7" style="text-align: center;">
					<h3>No hay Registros disponibles</h3>
				</td>
			</tr>
		</s:if>
    	<s:iterator value="opcionLista" var="objOpcion" status="stat">
	        <tr>
	            <td><s:property value="idOpcion"/></td>
	            
	            <s:if test="parentOpcionId!=0">
		        	<td><s:property value="opcion.titulo"/></td>
		        </s:if>
		        <s:else>
		        	<td style="background-color: #62B4C9; color: #FFF;">Parent</td>
		        </s:else>
		        <td> <s:property value="titulo"/> </td>
	            <td> <s:property value="descripcion"/> </td>
	            
	            <td class="tdButton">
					<s:form id="formOpcion%{#stat.count}" action="insertarOActualizarRolOpcion" method="post">
				      <s:hidden name="rolOpcion.id.idOpcion" value="%{idOpcion}"/>
				      <s:hidden name="rolOpcion.id.idRol" value="%{rol.idRol}"/>
				      <s:hidden name="oper" value="del"/>
				    
 					<sj:submit 
 						type="button"
 						formIds="formOpcion%{#stat.count}"
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

<!-- <a href="showRolLista">Volver</a> -->
<s:form id="formBack" action="showRolLista" method="post">
<table style="width: 100%;">
	<tr>
		<td style="width: 100%; text-align: right;">
			<sj:submit
				formIds="formBack"
				indicator="myLoadingBar"
				type="button"
				button="true"
				buttonIcon="ui-icon-circle-arrow-w">
					Volver
				</sj:submit>
		</td>
	</tr>
</table>
</s:form>
