<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<sj:head locale="es" jqueryui="true" jquerytheme="cupertino" defaultIndicator="myLoadingBar"/>


<script>
$(function() {
	$.subscribe('rowselect', function(event,data) {
        $("#hdIdCliente").val(event.originalEvent.id);
    });
	$.subscribe('onsuccessgrid', function(event,data) {
        $("#divResult").html(data);
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
<s:hidden id="hdIdCliente" name="cliente.idCliente"/>

<s:url id="urlLista" action="obtenerClienteJSON"/>
<s:url id="URLMant" action="mantenimientoClienteJSON"/>

<sjg:grid  
		id="gridCliente"
		gridModel="clienteLista"
		name="clienteLista"
		dataType="json"
		href="%{urlLista}"
		viewrecords="true"
		rowList="10,20,30"
    	rowNum="10"
    	rownumbers="true"
		navigator="true"
		navigatorView="true"
		navigatorAdd="true"
		navigatorEditOptions="{closeAfterEdit:true}"
		navigatorAddOptions="{closeAfterAdd:true}"
		navigatorExtraButtons="{
                seperator: { 
                        title : 'seperator'  
                }, 
                hide : { 
                        title : 'Show/Hide', 
                        icon: 'ui-icon-wrench', 
                        topic: 'showPets'
                },
                alert : { 
                        title : 'Alert', 
                        caption : 'Show Alert!', 
                        onclick: function(){ alert('Grid Button clicked!') }
                }
        }"
    	onSelectRowTopics="rowselect"
    	onSuccessTopics="onsuccessgrid"
		pager="true"
		targets="divResult"
		autowidth="false"
		editurl="%{URLMant}" width="650">
	
	<sjg:gridColumn name="id" index="id" title="ID" editable="true" hidden="true"/>
	<sjg:gridColumn name="idCliente" index="id" key="true" title="ID Cliente" editable="true" hidden="true"/>
	<sjg:gridColumn name="usuario.idUsuario" key="true" index="idUsuario" title="ID Usuario" editable="true" hidden="true"/>
	
	<sjg:gridColumn name="tipoDocumento.descripcion" index="idTipoDocumento" title="Tipo Doc." editable="true"
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
<s:submit id="showPets" cssClass="btn btn-primary" action="showMascotaMantenimientoAction" type="post" value="Ver Mascotas"></s:submit>
<%-- <s:a href="%{urlShowPets}" method="submit">Mascotas</s:a>&nbsp;&nbsp;&nbsp; --%>

<div id="divResult">
</div>
<s:fielderror/> 	 	
<s:actionerror/>
<s:actionmessage/>


</s:form>