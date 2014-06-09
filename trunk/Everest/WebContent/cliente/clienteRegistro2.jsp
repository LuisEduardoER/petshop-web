<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<script src="../js/jquery-1.10.2.js" 				type="text/javascript"></script>
<script src="../js/jquery-ui-1.10.4.custom.js" 		type="text/javascript"></script>
<script src="../../Everest/js/jquery-ui-1.10.4.custom.min.js" 	type="text/javascript"></script>

<link rel="stylesheet" href="../../Everest/template/themes/ui-everest/jquery-ui.css">
  
<script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  </script>
	
	<h2>Registro de Cliente</h2>
	
	<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Cliente</a></li>
    <li><a href="#tabs-2">Familiares</a></li>
    <li><a href="#tabs-3">Mascotas</a></li>
  </ul>
  <div id="tabs-1">
  
  <s:form>
  
  	<table>
		<tr>
			<td>Nombres</td>
			<td>Apellido Paterno</td>
			<td>Apellido Materno</td>
		</tr>
		<tr>
			<td><s:textfield name="cliente.nombres"/></td>
			<td><s:textfield name="cliente.apePat"/></td>
			<td><s:textfield name="cliente.apeMat"/></td>
		</tr>
		<tr>
			<td>Tipo Doc. Identidad</td>
			<td>Doc. Identidad</td>
			<td>Fec. Nac.</td>
		</tr>
		<tr>
			<td>
				<s:select name="cliente.tipoDocumento.idTipoDocumento"
					       headerKey="-1" headerValue="-----"
					       list="#{'1':'DNI', '2':'Carnet de Extranjeria'}"
					       required="true"
					/>
			</td>
			<td><s:textfield name="cliente.documento"/></td>
			<td><s:textfield name="cliente.fecNac"/></td>
		</tr>
		<tr>
			<td>Sexo</td>
			<td>Telf. de Casa</td>
			<td>Celular</td>
		</tr>
		<tr>
			<td> 
				<s:select name="cliente.sexo"
					       headerKey="-1" headerValue="-----"
					       list="#{'M':'Masculino', 'F':'Femenino'}"
					       required="true"
					/>
			</td>
			<td><s:textfield name="cliente.telefono"/></td>
			<td><s:textfield name="cliente.celular"/></td>
		</tr>
	</table>
	
	<sj:a button="true" buttonIcon="ui-icon-disk" >Guardar</sj:a>
	
	</s:form>
	
  </div>
  <div id="tabs-2">
    
<s:url id="urlLista" action="obtenerProveedorJSON"/>
<s:url id="URLMant" action="mantenimientoProveedorJSON"/>

<sjg:grid  
		gridModel="proveedores"		
		caption="Lista de Proveedores"
		dataType="json"
		href="%{urlLista}"
		viewrecords="true"
		rowNum="10"
		navigator="true"
		navigatorView="true"
		navigatorDelete="true"
		navigatorEditOptions="{closeAfterEdit:true,closeAfterAdd:true}"
		pager="true"
		editurl="%{URLMant}" width="600">
	
	<sjg:gridColumn key="true" index="id" name="idProveedor" title="ID" editable="true"/>
	
	<sjg:gridColumn name="ruc" width="50" title="RUC" editable="true"/>
	<sjg:gridColumn name="razonSocial" title="Raz. Social" editable="true"/>
	<sjg:gridColumn name="direccion" title="Direccion" editable="true"/>
	
</sjg:grid>

  </div>
  <div id="tabs-3">
    
    <s:url id="urlLista" action="obtenerProveedorJSON"/>
<s:url id="URLMant" action="mantenimientoProveedorJSON"/>

<sjg:grid  
		gridModel="proveedores"		
		caption="Lista de Proveedores"
		dataType="json"
		href="%{urlLista}"
		viewrecords="true"
		rowNum="10"
		navigator="true"
		navigatorView="true"
		navigatorDelete="true"
		navigatorEditOptions="{closeAfterEdit:true,closeAfterAdd:true}"
		pager="true"
		editurl="%{URLMant}" width="600">
	
	<sjg:gridColumn key="true" index="id" name="idProveedor" title="ID" editable="true"/>
	
	<sjg:gridColumn name="ruc" width="50" title="RUC" editable="true"/>
	<sjg:gridColumn name="razonSocial" title="Raz. Social" editable="true"/>
	<sjg:gridColumn name="direccion" title="Direccion" editable="true"/>
	
</sjg:grid>
    
  </div>
  
</div>
