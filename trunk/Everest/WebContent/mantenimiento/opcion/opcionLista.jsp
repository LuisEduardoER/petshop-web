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

<h1>Mantenimiento de Opciones</h1>

<div id="gridinfo" class="ui-widget-content ui-corner-all">
	<s:hidden name="rol.idRol"/>
	<h2> Rol: <s:property value="rol.descripcion"/> </h2>
</div>
<br/>

<table id="tableClientes" class="dls-table" cellspacing="0" cellpadding="0">
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
        </tr>
    </thead>
    <tbody class="dls-table-body">
    	<s:iterator value="opcionLista" var="objOpcion" status="stat">
	        <tr>
	            <td><s:property value="idOpcion"/></td>
	            
	            <s:if test="opcion.titulo!=''">
		        	<td><s:property value="opcion.titulo"/></td>
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
					  targets="dlgForm" 
					  button="true" 
					  buttonText="false"
					  cssClass="no-border"
					  indicator="myLoadingBar"
					  buttonIcon="ui-icon-pencil">
						Editar
					</sj:a>
	            </td>
	        </tr>
		</s:iterator>
			<tr>
				<td colspan="7"></td>
			</tr>
    </tbody>
</table>

<a href="showRolLista">Volver</a>

<div id="divResult"></div>

<br/>

</s:form>

<sj:dialog 
    	id="dlgOpcionForm" 
    	autoOpen="false"
    	width="450"
    	minHeight="250"
    	modal="true" 
    	onCloseTopics="closeOpcionDialog"
    	showEffect="slide" 
    	hideEffect="explode"
    	resizable="true"
    	title="Opcion">
    	
        <table style="width: 100%;">
        	<tr>
        		<td style="width: 100%; text-align: center;">
        			<img alt="Loading" src="img/loading.gif">
        		</td>
        	</tr>
        </table>
		 
    </sj:dialog>