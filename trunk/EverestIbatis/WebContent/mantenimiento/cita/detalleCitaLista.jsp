<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<script type="text/javascript">
$(function() {
	$("#dlgForm").dialog('option', 'title', 'Servicios');
});
</script>

<s:url id="insert" action="showDetalleCitaLink"/>
<sj:a 
	openDialog="dlgForm"
	href="%{insert}"
	button="true" 
	buttonIcon="ui-icon-plus"
	>Agregar</sj:a>

<s:fielderror/> 	 	
<s:actionerror/>
<s:actionmessage/>

<table id="table" class="dls-table" cellspacing="0" cellpadding="0">
    <thead>
        <tr>
            <th>Nro.</th>
            <th>Servicio</th>
            <th>Costo</th>
            <th>Tiempo Aprox</th>
            <th>Pelo</th>
            <th>Tamano</th>
            <th class="ui-state-disabled tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-circle-close" buttonText="false" disabled="false" cssClass="no-border">Eliminar</sj:a>
            </th>
        </tr>
    </thead>
    <tbody class="dls-table-body">
    	<s:if test="detalleCitaLista.size==0">
			<tr>
				<td colspan="5" style="text-align: center;">
					No hay Registros disponibles
				</td>
			</tr>
		</s:if>
    	<s:iterator value="detalleCitaLista" var="objDetalle" status="stat">
    		
	        <tr>
	            <td><s:property value="idDetalleCita"/></td>
	            <td> <s:property value="servicio.descripcion"/> </td>
	            <td> <s:property value="costo"/> </td>
				<td> <s:date name="tiempoAprox" format="mm:ss"/> </td>
	            <td> <s:property value="pelo"/> </td>
	            <td> <s:property value="tamano"/> </td>
	            
	            <td class="tdButton">
	            	
		            <s:url id="delete" action="showServicioFormAction" escapeAmp="false">
		       		    <s:param name="detalleCita.servicio.idServicio" value="idServicio"/>
		       		    <s:param name="oper">del</s:param>
		       		</s:url>
					<sj:a
					  href="%{delete}" 
					  button="true" 
					  buttonText="false"
					  cssClass="no-border"
					  indicator="myLoadingBar"
					  buttonIcon="ui-icon-circle-close">
						Eliminar
					</sj:a>
	            </td>
	        </tr>
		</s:iterator>
			<tr>
				<td colspan="5"></td>
			</tr>
    </tbody>
</table>