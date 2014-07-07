<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<fieldset>
	<legend>
		<h1>Mantenimiento de Opciones</h1>
	</legend>
</fieldset>

<s:url id="insert" action="showOpcionFormAction" escapeAmp="false">
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
            <th>Id</th>
            <th>Parent</th>
            <th>Titulo</th>
            <th>URL</th>
            <th>Orden</th>
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
	            
	            <s:if test="opcion.titulo!=''">
		        	<td><s:property value="opcion.descripcion"/></td>
		        </s:if>
		        <s:else>
		        	<td style="background-color: #62B4C9; color: #FFF;">Parent</td>
		        </s:else>
		        
	            <td> <s:property value="descripcion"/> </td>
	            <td> <s:property value="url"/> </td>
	            <td> <s:property value="orden"/> </td>
	            <td> <s:property value="estado"/> </td>
	            
	            <td class="tdButton">
	            	
		            <s:url id="update" action="showOpcionFormAction" escapeAmp="false">
		       		    <s:param name="opcion.idOpcion" value="idOpcion"/>
		       		    <s:param name="rol.idRol" value="rol.idRol"/>
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
		       		<s:form id="formDel%{#stat.count}" action="insertarOActualizarOpcion" method="post">
				      <s:hidden name="opcion.idOpcion" value="%{idOpcion}"/>
				      <s:hidden name="rol.idRol" value="%{rol.idRol}"/>
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