<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<script>
$(function() {
	$.subscribe('closeOpcionDialog', function(event,data) {
		var html = "<table style='width: 100%;'>"+
				    	"<tr>"+
						"<td style='width: 100%; text-align: center;'>"+
							"<img alt='Loading' src='img/loading.gif'>"+
						"</td>"+
					"</tr>"+
				"</table>";
        $("#dlgOpcionForm").empty();
        $("#dlgOpcionForm").html(html);
    });
});
</script>

<s:form id="form1">

<h1>Mantenimiento de Roles</h1>

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
            	<sj:a button="true" buttonIcon="ui-icon-circlesmall-plus" buttonText="false" disabled="false" cssClass="no-border">Opciones	</sj:a>
            </th>
        </tr>
    </thead>
    <tbody class="dls-table-body">
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
<%-- 	            	<sj:a button="true" buttonIcon="ui-icon-circlesmall-plus" buttonText="false" cssClass="no-border">Opciones</sj:a> --%>
	            	
	            	<s:url id="update" action="showOpcionListaAction" escapeAmp="false">
		       		    <s:param name="rol.idRol" value="idRol"/>
		       		</s:url>
					<sj:a openDialog="dlgOpcionForm"
					  href="%{update}"
					  targets="dlgOpcionForm" 
					  button="true" 
					  buttonText="false"
					  cssClass="no-border"
					  indicator="myLoadingBar"	
					  buttonIcon="ui-icon-circlesmall-plus">
						Opciones
					</sj:a>
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
    	title="Rol">
        
        <table style="width: 100%;">
        	<tr>
        		<td style="width: 100%; text-align: center;">
        			<img alt="Loading" src="img/loading.gif">
        		</td>
        	</tr>
        </table>
		 
    </sj:dialog>

    <sj:dialog 
    	id="dlgOpcionForm" 
    	autoOpen="false"
    	width="450"
    	minHeight="250"
    	modal="true" 
    	onCloseTopics="closeOpcionDialog"
    	showEffect="slide" 
    	hideEffect="explode"
    	title="Opciones">
        
        <table style="width: 100%;">
        	<tr>
        		<td style="width: 100%; text-align: center;">
        			<img alt="Loading" src="img/loading.gif">
        		</td>
        	</tr>
        </table>
		 
    </sj:dialog>