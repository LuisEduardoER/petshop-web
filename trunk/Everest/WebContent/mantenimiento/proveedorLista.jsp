<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<s:form id="form1">

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
		indicator="myLoadingBar"
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

</s:form>
