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

<s:form id="frmAdd" action="showMascotaForm">
<s:hidden name="cliente.idCliente"/>
<s:hidden name="oper" value="add"/>
<sj:submit
	  type="button" 
	  button="true"
	  formIds="frmAdd" 
	  indicator="myLoadingBar"
	  buttonIcon="ui-icon-circle-plus">
	Agregar
</sj:submit>
</s:form>


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
					src="cargaImagenAction?idMascota=<s:property value="idMascota"/>&img=1">
            </td>
            <td><s:property value="nombre"/></td>
            <td><s:property value="edad"/></td>
            <td><s:property value="raza"/></td>
            <td>
<%--             	<s:property value="sexo"/> --%>
            	<s:select 
			       name="mascota.sexo"
			       headerKey="" headerValue="-- Seleccione --"
			       list="#{'M':'Macho', 'H':'Hembra'}"
			       value="sexo"
			       disabled="true"
				/>
            </td>
            <td class="tdButton">
            	<s:form id="frmEdit%{#status.count}" action="showMascotaForm">
		       		    <s:hidden name="mascota.idMascota" value="%{idMascota}"/>
		       		    <s:hidden name="cliente.idCliente" value="%{idCliente}"/>
		       		    <s:hidden name="oper" value="edit"/>
					<sj:submit
					  formIds="frmEdit%{#status.count}"
					  type="button"
					  button="true" 
					  buttonText="false"
					  indicator="myLoadingBar"
					  buttonIcon="ui-icon-pencil">
						Editar
					</sj:submit>
				</s:form>
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

<s:form id="formBack" action="showClienteLista" method="post">
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

    