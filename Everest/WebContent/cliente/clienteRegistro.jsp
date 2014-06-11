<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<%-- <sj:head locale="es" jqueryui="true" jquerytheme="cupertino" defaultIndicator="myLoadingBar"/> --%>


<script>
$(function() {
	$.subscribe('rowselect', function(event,data) {
        $("#hdIdCliente").val(event.originalEvent.id);
    });
	$.subscribe('showPets', function(event,data) {
	// 	$("#gridedittable").jqGrid('setColumns',{});
	// 	$("#gridinfo").html('<p>Edit Mode for Row : '+event.originalEvent.id+'</p>');
// 		alert("showPets id: "+ $("#hdIdCliente").val() );
		$( "#dlgPets" ).dialog( "open" );
	});
	$("#showPets").click(function(){
		if($("#hdIdCliente").val() == ""){
			alert("Seleccione un Cliente porfavor.");
			return false;
		}
	});
});
</script>

	<h2>Mantenimiento de Clientes</h2>

<s:form id="form1">
<s:hidden id="hdIdCliente" name="hdIdCliente"/>

<s:url id="urlLista" action="obtenerClienteJSON"/>
<s:url id="URLMant" action="mantenimientoClienteJSON"/>

<sjg:grid  
	
		gridModel="clienteLista"
		dataType="json"
		href="%{urlLista}"
		viewrecords="true"
		rowNum="10"
		navigator="true"
		navigatorView="true"
		navigatorEditOptions="{closeAfterEdit:true,closeAfterAdd:true}"
    	onSelectRowTopics="rowselect"
		pager="true"
		autowidth="false"
		editurl="%{URLMant}" width="650">
	
	<sjg:gridColumn key="true" name="idCliente" title="ID Cliente" hidden="true" editable="true"/>
	<sjg:gridColumn key="true" name="tipoDocumento.descripcion" index="idTipoDocumento" title="Tipo Doc." editable="true"
					edittype="select" editoptions="{value:'1:DNI;2:Carnet de Extranjeria'}"
 					/>
	<sjg:gridColumn name="documento"  title="Documento" editable="true" width="50"/>
	<sjg:gridColumn name="nombres" 	  title="Nombres"   editable="true" width="50"/>
	<sjg:gridColumn name="apePat" 	  title="Ape. Pat." editable="true" width="80"/>
	<sjg:gridColumn name="apeMat" 	  title="Ape. Mat." editable="true" />
	<sjg:gridColumn name="sexo" 	  title="Sexo" 		editable="true"  
					edittype="select" editoptions="{value:'M:Masculino;F:Femenino'}"
					/>
	<sjg:gridColumn name="fecNac" 	  title="Fec. Nac." editable="true" formatter="date"
        			formatoptions="{newformat : 'd/m/Y', srcformat : 'Y/m/d'}"/>
	<sjg:gridColumn name="email" 	  title="Email" 	editable="true" width="100"/>
	<sjg:gridColumn name="telefono"   title="Telefono"  editable="true" width="50"/>
	<sjg:gridColumn name="celular"    title="Celular"   editable="true" width="50"/>
	<sjg:gridColumn name="direccion"  title="Direccion" editable="true"  />
	
</sjg:grid>
<br/>

<s:url id="urlShowPets" action="showMascotaMantenimientoAction"/>

<%-- <sj:a id="showPets" button="true" buttonIcon="ui-icon-calculator" href="%{urlShowPets}">Mascotas</sj:a> --%>
<%-- <sj:submit formIds="form1" href="%{urlShowPets}" button="true" value="Mascotas"></sj:submit> --%>
<s:submit id="showPets" action="showMascotaMantenimientoAction" type="post" value="Ver Mascotas"></s:submit>
<%-- <s:a href="%{urlShowPets}" method="submit">Mascotas</s:a>&nbsp;&nbsp;&nbsp; --%>

<s:fielderror id="fieldError"/> 	 	
<s:actionerror id="actionerror"/>
<s:actionmessage id="actionMessage"/>

</s:form>