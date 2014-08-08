<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<fieldset>
	<legend>
		<h1>Mantenimiento de Usuarios</h1>
	</legend>
</fieldset>

<s:form action="showUsuarioForm">

	<s:hidden name="usuario.idUsuario" value="%{usuario.idUsuario}"/>
    <s:hidden name="oper" value="add"/>

<sj:submit 
	type="button"
	button="true" 
	buttonIcon="ui-icon-plus"
	>Agregar</sj:submit>

</s:form>

<table id="tableClientes" class="dls-table" cellspacing="0" cellpadding="0">
    <thead>
        <tr>
            <th>ID</th>
            <th>Rol</th>
            <th>Usuario</th>
            <th>Estado</th>
            <th class="ui-state-disabled tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-pencil" buttonText="false" disabled="false" cssClass="no-border">Editar</sj:a>
            </th>
        </tr>
    </thead>
    <tbody class="dls-table-body">
    	<s:if test="listaUsuario.size==0">
			<tr>
				<td colspan="7" style="text-align: center;">
					<h3>No hay Registros disponibles</h3>
				</td>
			</tr>
		</s:if>
    	<s:iterator value="usuarioLista" var="obj" status="stat">
	        <tr>
	            <td><s:property value="idUsuario"/></td>
	            <td>
	            	<s:select list="rolLista"
	            			listKey="idRol"
	            			listValue="descripcion"
	            			name="idRol"
	            			value="idRol"
	            			disabled="true"
	            	/>
	            </td>
	            <td> <s:property value="user"/> </td>
	            <td> <s:property value="estado"/> </td>
	            
	            <td class="tdButton">
	            <s:form id="frmEdit%{#stat.count}" action="showUsuarioForm">
		       		    <s:hidden name="usuario.idUsuario" value="%{idUsuario}"/>
		       		    <s:hidden name="oper" value="edit"/>
		       		
					<sj:submit 
					  type="button"
					  button="true" 
					  buttonText="false"
					  cssClass="no-border"
					  formIds="frmEdit%{#stat.count}"
					  indicator="myLoadingBar"
					  buttonIcon="ui-icon-pencil">
						Editar
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

<sj:dialog 
    	id="dlgForm" 
    	autoOpen="false"
    	width="450"
    	minHeight="250"
    	modal="true" 
    	onCloseTopics="closeDialog"
    	showEffect="slide" 
    	hideEffect="explode"
    	resizable="true"
    	title="Usuario">
    	
        <table style="width: 100%;">
        	<tr>
        		<td style="width: 100%; text-align: center;">
        			<img alt="Loading" src="img/loading.gif">
        		</td>
        	</tr>
        </table>
		 
    </sj:dialog>