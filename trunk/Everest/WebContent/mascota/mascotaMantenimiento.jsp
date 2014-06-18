<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<script>
$(function() {
	$.subscribe('closeDialog', function(event,data) {
		var html = "<table style='width: 100%;'>"+
				    	"<tr>"+
						"<td style='width: 100%; text-align: center;'>"+
							"<img alt='Loading' src='img/loading.gif'>"+
						"</td>"+
					"</tr>"+
				"</table>";
        $("#dlgMascotaForm").empty();
        $("#dlgMascotaForm").html(html);
    });
});
</script>

<s:form id="form1">

<s:url id="insert" action="showMascotaFormAction" escapeAmp="false">
	<s:param name="cliente.idCliente" value="cliente.idCliente"/>
	<s:param name="oper">add</s:param>
</s:url>

<s:hidden name="cliente.idcLiente" value="cliente.idcLiente"></s:hidden>

<h2>Mantenimiento de Mascotas </h2>
<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cliente: <s:text name="cliente.nombres"/> <s:text name="cliente.apePat"/></h2>

	<table>
	<tr> 
		
		<td>
			<sj:a openDialog="dlgMascotaForm"
				  href="%{insert}"
				  targets="dlgMascotaForm" 
				  button="true" 
				  indicator="myLoadingBar"
				  buttonIcon="ui-icon-circle-plus">
		Agregar Mascota
	</sj:a>
		</td>
	</tr>
</table>

<br>
<table align="center" class="ui-jqgrid-htable"
	   cellpadding="0" cellspacing="0" tabindex="1" border="0" role="grid" aria-multiselectable="false" 
 style="width: 100%;">
<thead>
    <tr class="ui-jqgrid-labels">
        <th class="ui-state-default ui-th-column ui-th-ltr"><s:text name="ID"/></th>
        <th class="ui-state-default ui-th-column ui-th-ltr"><s:text name="Imagen"/></th>
        <th class="ui-state-default ui-th-column ui-th-ltr"><s:text name="Nombre"/></th>
        <th class="ui-state-default ui-th-column ui-th-ltr"><s:text name="Edad"/></th>
        <th class="ui-state-default ui-th-column ui-th-ltr"><s:text name="Raza"/></th>
        <th class="ui-state-default ui-th-column ui-th-ltr"><s:text name="Sexo"/></th>
        <th class="ui-state-default ui-th-column ui-th-ltr">Ver</th>
        <th class="ui-state-default ui-th-column ui-th-ltr">Editar</th>
        <th class="ui-state-default ui-th-column ui-th-ltr">Eliminar</th>
    </tr>
 </thead>
    <s:if test="count==0">
    	<tr>
    		<td colspan="9" style="text-align: center">
    			<h2>No hay mascotas registradas para este Cliente.</h2>
    		</td>
    	</tr>
    </s:if>
    
    <s:else>
    
	<tbody>    	
    <s:iterator value="mascotaLista" status="status">    
    
<%--         <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>"> --%>
        <tr role="row" aria-selected="true" id="<s:property value='#status.index' />" class="jqgfirstrow">

            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell">
            	<s:property value="idMascota"/>
            </td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell" style="text-align: center;">
            	<img alt="Imagen no disponible" style="max-height: 50px; max-width: 50px;" 
					src="cargaImagenAction?idMascota=<s:property value="idMascota"/>">
            </td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell"><s:property value="nombre"/></td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell"><s:property value="edad"/></td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell"><s:property value="raza"/></td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell"><s:property value="sexo"/></td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell" style="width: 50px;text-align: center;">
            	<s:url id="view" action="showMascotaFormAction" escapeAmp="false">
	       		    <s:param name="oper">view</s:param>
	       		    <s:param name="mascota.idMascota" value="idMascota"/>
	       		    <s:param name="cliente.idCliente" value="cliente.idCliente"/>
	       		</s:url>
               	<sj:a openDialog="dlgMascotaForm"
				  href="%{view}"
				  targets="dlgMascotaForm" 
				  button="true" 
				  buttonText="false"
				  indicator="myLoadingBar"
				  buttonIcon="ui-icon-contact">
					Ver Mascota
				</sj:a>
            </td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell" style="width: 50px;text-align: center;">
               	<s:url id="update" action="showMascotaFormAction" escapeAmp="false">
	       		    <s:param name="mascota.idMascota" value="idMascota"/>
	       		    <s:param name="cliente.idCliente" value="cliente.idCliente"/>
	       		    <s:param name="oper">edit</s:param>
	       		</s:url> 
<%--                	<s:a href="%{update}" cssClass="btn btn-primary"> --%>
<%-- 					<span class="ui-button-icon-primary ui-icon ui-icon-pencil"></span> --%>
<%-- 				</s:a> --%>
				<sj:a openDialog="dlgMascotaForm"
				  href="%{update}"
				  targets="dlgMascotaForm" 
				  button="true" 
				  buttonText="false"
				  indicator="myLoadingBar"
				  buttonIcon="ui-icon-pencil">
					Editar Mascota
				</sj:a>
            </td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell" style="width: 50px;text-align: center;">
               	<s:url id="detalle" action="detalleProveedor">
	       		   <s:param name="mascota.idMascota" value="idMascota"/>
	       		</s:url>
               	<sj:a openDialog="dlgMascotaForm"
				  href="%{update}"
				  targets="dlgMascotaForm" 
				  button="true" 
				  buttonText="false"
				  indicator="myLoadingBar"
				  buttonIcon="ui-icon-circle-close">
					Eliminar Mascota
				</sj:a>
            </td>
        </tr>
	 </s:iterator>
	 </tbody>
	 
	 </s:else>
	 
    </table>
    <br/>
    
	
	<s:a href="showClienteRegistroAction" >Volver</s:a>
	
</s:form>

<sj:dialog 
    	id="dlgMascotaForm" 
    	autoOpen="false"
    	width="450"
    	minHeight="350"
    	modal="true" 
    	onCloseTopics="closeDialog"
    	showEffect="slide" 
    	hideEffect="explode"
    	title="Mascota">
        
        <table style="width: 100%;">
        	<tr>
        		<td style="width: 100%; text-align: center;">
        			<img alt="Loading" src="img/loading.gif">
        		</td>
        	</tr>
        </table>
		 
    </sj:dialog>

    