<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<script type="text/javascript">
$(function() {
	$("#dlgForm").dialog('option', 'title', 'Medico');
});
</script>

<h1>Mantenimiento de Medicos</h1>

<s:url id="insert" action="showMedicoFormAction" escapeAmp="false">
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
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Telefono</th>
            <th>Turno</th>
            <th>Local</th>
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
				<td colspan="6" style="text-align: center;">
					<h3>No hay Registros disponibles</h3>
				</td>
			</tr>
		</s:if>
    	<s:iterator value="medicoLista" var="objMedico" status="stat">
	        <tr>
	            <td class="id"> <s:property value="idMedico"/> </td>
	            
	            <td> <s:property value="nombres"/> </td>
	            <td> <s:property value="apellidos"/> </td>
	            <td> <s:property value="telefono"/> </td>
	            <td> <s:property value="turno.nomTurno"/> </td>
	            <td> <s:property value="local.nomLocal"/> </td>
	            
	            <td class="tdButton">
	            	
		            <s:url id="update" action="showMedicoFormAction" escapeAmp="false">
		       		    <s:param name="medico.idMedico" value="idMedico"/>
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
		       		<s:form id="formDel%{#stat.count}" action="insertarOActualizarMedico" method="post">
				      <s:hidden name="medico.idMedico" value="%{idMedico}"/>
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
				<td colspan="6"></td>
			</tr>
    </tbody>
</table>

<div id="divResult"></div>

<br/>


