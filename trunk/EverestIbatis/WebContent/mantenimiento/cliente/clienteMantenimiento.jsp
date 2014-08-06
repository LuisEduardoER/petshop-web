<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h1>Mantenimiento de Clientes</h1>

<fieldset>
<s:form id="frmFiltro">
	<table class="dls-table-form" style="width: 100%;" cellspacing="0" cellpadding="0">
		<tr>
			<th>Tipo Cliente</th>
			<th>DNI/RUC</th>
			<th>Nombre/Razon Social</th>			
		</tr>
		<tr>
			<td>
				<s:select list="#{'N':'Persona Natural', 'J':'Persona Juridica'}"
						name="cliente.tipoCliente"/>
			</td>
			<td><s:textfield name="cliente.dni"/></td>
			<td><s:textfield name="cliente.nombres"/></td>
			<td>				
				<sj:a button="true" 
					buttonIcon="ui-icon-circle-zoomout"
					href="filtrarCliente"
					indicator="myLoadingBar"
					formIds="frmFiltro"
					targets="divLista"
					>Buscar</sj:a> 
			</td>
		</tr>
	</table>
</s:form>
</fieldset>

<s:form id="frmAdd" action="showClienteRegistrar">
<s:hidden name="oper" value="add"/>
<sj:submit
	type="button"
	formIds="frmAdd"
	button="true" 
	buttonIcon="ui-icon-plus"
	>Agregar</sj:submit>
</s:form>

<div id="divLista">
	<jsp:include page="clienteLista.jsp"></jsp:include>
</div>
