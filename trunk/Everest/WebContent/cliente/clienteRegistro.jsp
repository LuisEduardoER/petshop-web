<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<script src="../js/jquery-1.10.2.js" 				type="text/javascript"></script>
<script src="../js/jquery-ui-1.10.4.custom.js" 		type="text/javascript"></script>
<script src="../../Everest/js/jquery-ui-1.10.4.custom.min.js" 	type="text/javascript"></script>

<link rel="stylesheet" href="../../Everest/template/themes/ui-everest/jquery-ui.css">
  
	<h2>Mantenimiento de Clientes</h2>
	
<s:url id="urlLista" action="obtenerClienteJSON"/>
<s:url id="URLMant" action="mantenimientoClienteJSON"/>

<sjg:grid  
		gridModel="clientees"
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
	
	<sjg:gridColumn key="true" index="id" name="idCliente" title="ID" hidden="true" editable="true"/>
	
	<sjg:gridColumn name="documento" width="100" title="Documento" editable="true"/>
	<sjg:gridColumn name="nombres" title="Nombres" editable="true"/>
	<sjg:gridColumn name="apePat" title="Ape. Pat." editable="true"/>
	<sjg:gridColumn name="apeMat" title="Ape. Mat." editable="true"/>
	<sjg:gridColumn name="sexo" width="30" title="Sexo" editable="true" />
	<sjg:gridColumn name="fecNac" title="Fec. Nac." editable="true" formatter="date"
        formatoptions="{newformat : 'd/m/Y', srcformat : 'Y/m/d'}"/>
	<sjg:gridColumn name="email" title="Email" editable="true"/>
	<sjg:gridColumn name="telefono" title="Telefono" editable="true"/>
	<sjg:gridColumn name="celular" title="Celular" editable="true"/>
	<sjg:gridColumn name="direccion" title="Direccion" editable="true"/>
		
</sjg:grid>

