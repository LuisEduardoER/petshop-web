<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<s:form id="form1">

<h1>Mantenimiento de Opciones</h1>

<table id="tableClientes" class="dls-table" cellspacing="0" cellpadding="0">
    <thead>
        <tr>
            <th>Id</th>
            <th>Parent</th>
            <th>Descripcion</th>
            <th>Titulo</th>
            <th>URL</th>
            <th>Orden</th>
            <th>Estado</th>
            <th class="ui-state-disabled tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-pencil" buttonText="false" disabled="false" cssClass="no-border">Editar</sj:a>
            </th>
            <th class="ui-state-disabled tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-circlesmall-plus" buttonText="false" disabled="false" cssClass="no-border">Opciones	</sj:a>
            </th>
        </tr>
    </thead>
    <tbody class="dls-table-body">
    	<s:iterator value="opcionLista" var="objOpcion" status="stat">
	        <tr>
	            <td class="id"> <s:property value="idOpcion"/> </td>
	            <td> <s:property value=""/> </td>
	            <td> <s:property value="descripcion"/> </td>
	            <td> <s:property value="titulo"/> </td>
	            <td> <s:property value="url"/> </td>
	            <td> <s:property value="orden"/> </td>
	            <td> <s:property value="estado"/> </td>
	            
	            <td class="tdButton">
	            	
		            <s:url id="update" action="showOpcionFormAction" escapeAmp="false">
		       		    <s:param name="opcion.idOpcion" value="idOpcion"/>
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
	            	<sj:a button="true" buttonIcon="ui-icon-circlesmall-plus" buttonText="false" cssClass="no-border">Opciones</sj:a>
	            </td>
	        </tr>
		</s:iterator>
			<tr>
				<td colspan="5"></td>
			</tr>
    </tbody>
</table>

<div id="divResult"></div>

<br/>

</s:form>

<sj:dialog 
    	id="dlgForm" 
    	autoOpen="false"
    	width="450"
    	minHeight="250"
    	modal="true" 
    	onCloseTopics="closeDialog"
    	showEffect="slide" 
    	hideEffect="explode"
    	title="Opcion">
        
        <table style="width: 100%;">
        	<tr>
        		<td style="width: 100%; text-align: center;">
        			<img alt="Loading" src="img/loading.gif">
        		</td>
        	</tr>
        </table>
		 
    </sj:dialog>