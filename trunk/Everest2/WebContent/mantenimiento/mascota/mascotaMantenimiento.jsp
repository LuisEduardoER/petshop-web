<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url id="insert" action="showMascotaFormAction" escapeAmp="false">
	<s:param name="cliente.idCliente" value="cliente.idCliente"/>
	<s:param name="oper">add</s:param>
</s:url>

<s:hidden name="cliente.idcLiente" value="cliente.idcLiente"></s:hidden>

<fieldset>
	<legend>
		<h1>Mantenimiento de Mascotas</h1>
	</legend>
	<s:hidden name="cliente.idCliente"/>
	<h2> 
		Cliente: <s:property value="cliente.nombres"/>&nbsp;
			 <s:property value="cliente.apePat"/>
	 </h2>
</fieldset>

<sj:a openDialog="dlgForm"
	  href="%{insert}"
	  targets="dlgForm" 
	  button="true" 
	  indicator="myLoadingBar"
	  buttonIcon="ui-icon-circle-plus">
	Agregar
</sj:a>

<table align="center" class="dls-table" cellpadding="0" cellspacing="0">
<thead>
    <tr>
        <th>ID</th>
        <th>Imagen</th>
        <th>Nombre</th>
        <th>Edad</th>
        <th>Raza</th>
        <th>Sexo</th>
        <th class="ui-state-disabled tdButton">
       		<sj:a button="true" buttonIcon="ui-icon-pencil" buttonText="false" disabled="false" cssClass="no-border">Editar</sj:a>
        </th>
        <th class="ui-state-disabled tdButton">
       		<sj:a button="true" buttonIcon="ui-icon-circle-close" buttonText="false" disabled="false" cssClass="no-border">Eliminar</sj:a>
        </th>
    </tr>
 </thead>
 <tbody>
 	<s:if test="mascotaLista.size==0">
    	<tr>
    		<td colspan="9" style="text-align: center">
    			<h3>No hay Registros disponibles</h3>
    		</td>
    	</tr>
    </s:if>    	
    <s:iterator value="mascotaLista" status="status">    
    
        <tr id="<s:property value='#status.index' />" >

            <td>
            	<s:property value="idMascota"/>
            </td>
            <td style="text-align: center;">
            	<img alt="Imagen no disponible" style="max-height: 50px; max-width: 50px;" 
					src="cargaImagenAction?idMascota=<s:property value="idMascota"/>">
            </td>
            <td><s:property value="nombre"/></td>
            <td><s:property value="edad"/></td>
            <td><s:property value="raza"/></td>
            <td><s:property value="sexo"/></td>
            <td class="tdButton">
               	<s:url id="update" action="showMascotaFormAction" escapeAmp="false">
	       		    <s:param name="mascota.idMascota" value="idMascota"/>
	       		    <s:param name="cliente.idCliente" value="cliente.idCliente"/>
	       		    <s:param name="oper">edit</s:param>
	       		</s:url> 
				<sj:a openDialog="dlgForm"
				  href="%{update}"
				  button="true" 
				  buttonText="false"
				  indicator="myLoadingBar"
				  buttonIcon="ui-icon-pencil">
					Editar
				</sj:a>
            </td>
            <td class="tdButton">
               	<s:url id="detalle" action="detalleProveedor">
	       		   <s:param name="mascota.idMascota" value="idMascota"/>
	       		</s:url>
               	<sj:a openDialog="dlgForm"
				  href="%{update}"
				  targets="dlgForm" 
				  button="true" 
				  buttonText="false"
				  indicator="myLoadingBar"
				  buttonIcon="ui-icon-circle-close">
					Eliminar
				</sj:a>
            </td>
        </tr>
	 </s:iterator>
	 </tbody>
	 
	 
    </table>

<s:form id="formBack" action="showClienteRegistroAction" method="post">
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
    
<sj:dialog 
    	id="dlgForm" 
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

    