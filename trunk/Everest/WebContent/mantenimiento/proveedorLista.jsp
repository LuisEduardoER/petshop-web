<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<s:form id="form1">

<s:url id="urlLista" action="obtenerProveedorJSON"/>
<s:url id="URLMant" action="mantenimientoProveedorJSON"/>


<h2>Mantenimiento de Proveedores</h2>

<sjg:grid  
		gridModel="proveedores"
		dataType="json"
		href="%{urlLista}"
		viewrecords="true"
		rowNum="10"
		navigator="true"
		indicator="myLoadingBar"
		navigatorView="true"
		navigatorDelete="true"
		navigatorEditOptions="{closeAfterEdit:true}"
		navigatorAddOptions="{closeAfterAdd:true}"
		pager="true"
		editurl="%{URLMant}" width="600">
	
	<sjg:gridColumn key="true" index="id" name="idProveedor" title="ID" editable="true" hidden="true"/>
	
	<sjg:gridColumn name="ruc" width="50" title="RUC" editable="true"/>
	<sjg:gridColumn name="razonSocial" title="Raz. Social" editable="true"/>
	<sjg:gridColumn name="direccion" title="Direccion" editable="true"/>
	
</sjg:grid>

</s:form>
