<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<%-- <sj:head locale="es" jqueryui="true" jquerytheme="cupertino" defaultIndicator="myLoadingBar"/> --%>

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
		indicator="myLoadingBar"
		navigatorView="true"
		navigatorSearchOptions="{multipleSearch:true}"
		onSuccessTopics="actionerror"
		navigatorEditOptions="{closeAfterEdit:true,closeAfterAdd:true}"
		pager="true"
		autowidth="false"
		editurl="%{URLMant}" width="650">
	
	<sjg:gridColumn key="true" name="idCliente" title="ID Cliente" hidden="true" editable="true"/>
	<sjg:gridColumn key="true" name="tipoDocumento.descripcion" index="idTipoDocumento" title="Tipo Doc." editable="true"

 					/>
	<sjg:gridColumn name="documento"  title="Documento" editable="true" width="50"/>
	<sjg:gridColumn name="nombres" 	  title="Nombres"   editable="true" width="50"/>
	<sjg:gridColumn name="apePat" 	  title="Ape. Pat." editable="true" width="80"/>
	<sjg:gridColumn name="apeMat" 	  title="Ape. Mat." editable="true" />
	<sjg:gridColumn name="sexo" 	  title="Sexo" 		editable="true"  

					/>
	<sjg:gridColumn name="fecNac" 	  title="Fec. Nac." editable="true" formatter="date"
        			formatoptions="{newformat : 'd/m/Y', srcformat : 'Y/m/d'}"/>
	<sjg:gridColumn name="email" 	  title="Email" 	editable="true" width="100"/>
	<sjg:gridColumn name="telefono"   title="Telefono"  editable="true" width="50"/>
	<sjg:gridColumn name="celular"    title="Celular"   editable="true" width="50"/>
	<sjg:gridColumn name="direccion"  title="Direccion" editable="true"  />
		
</sjg:grid>

<s:fielderror id="fieldError"/> 	 	
<s:actionerror id="actionerror"/>
<s:actionmessage id="actionMessage"/>