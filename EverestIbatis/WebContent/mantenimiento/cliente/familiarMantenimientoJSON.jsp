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
	$.subscribe('onsuccessgrid', function(event,data) {
        $("#divResult").html(data);
    });
	$.subscribe('showPets', function(event,data) {
			
		if($("#hdIdCliente").val() == ""){
			alert("Seleccione un Cliente porfavor.");
			return false;
		}
// 		$("#form1").ajaxSubmit(options);
		
		$("#form1").submit();
		 
	});
	$.subscribe('familyTopic', function(event,data) {
		$("#dlgFamiliaresForm").dialog("open");
	});
	$.subscribe('closeDialog', function(event,data) {
		var html = "<table style='width: 100%;'>"+
				    	"<tr>"+
						"<td style='width: 100%; text-align: center;'>"+
							"<img alt='Loading' src='img/loading.gif'>"+
						"</td>"+
					"</tr>"+
				"</table>";
        $("#dlgMascotaForm").empty();
        $("#dlgMascotaForm").html(html);
    });
});
</script>

	<h2>Mantenimiento de Clientes</h2>

<s:form id="form1" action="showMascotaMantenimientoAction" method="post">
<s:hidden id="hdIdCliente" name="cliente.idCliente"/>

<s:url id="urlLista" action="obtenerFamliaresJSON"/>
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

		navigator="true"
		navigatorView="true"
		navigatorAdd="true"
		navigatorEditOptions="{closeAfterEdit:true}"
		navigatorAddOptions="{closeAfterAdd:true}"
		navigatorExtraButtons="{
                seperator: { 
                        title : 'seperator'  
                }, 
                pets : { 
                        title : 'Mascotas', 
                        icon: 'ui-icon-calculator', 
                        topic: 'showPets'
                },
                family : { 
                        title : 'Familiares', 
                        icon: 'ui-icon-person', 
                        topic: 'familyTopic'
                },
                seperator: { 
                        title : 'seperator'  
                }
        }"
    	onSelectRowTopics="rowselect"
    	onSuccessTopics="onsuccessgrid"
		pager="true"
		indicator="myLoadingBar"
		loadingText="Cargando..."
		targets="divResult"
		autowidth="true"
		editurl="%{URLMant}" width="650">
	
	<sjg:gridColumn name="id" index="id" title="ID" editable="true" hidden="true"/>
	<sjg:gridColumn name="idCliente" index="id" key="true" title="ID Cliente" editable="true" hidden="true"/>
	<sjg:gridColumn name="usuario.idUsuario" key="true" index="idUsuario" title="ID Usuario" editable="true" hidden="true"/>
	
	<sjg:gridColumn name="tipoDocumento.descripcion" index="idTipoDocumento" title="Tipo Doc." editable="true" width="40"
					edittype="select" editoptions="{value:'1:DNI;2:Carnet de Extranjeria'}"
 					/>
	<sjg:gridColumn name="documento"  title="Documento" editable="true" width="70"/>
	<sjg:gridColumn name="nombres" 	  title="Nombres"   editable="true" width="60"/>
	<sjg:gridColumn name="apePat" 	  title="Ape. Pat." editable="true" width="90"/>
	<sjg:gridColumn name="apeMat" 	  title="Ape. Mat." editable="true" width="90"/>
	<sjg:gridColumn name="sexo" 	  title="Sexo" 		editable="true"  width="30"
					edittype="select" editoptions="{value:'M:Masculino;F:Femenino'}"
					/>
	<sjg:gridColumn name="fecNac" 	  title="Fec. Nac." editable="true" formatter="date" width="90" 
        			formatoptions="{newformat : 'd/m/Y', srcformat : 'Y/m/d'}"/>
	<sjg:gridColumn name="email" 	  title="Email" 	editable="true" width="100" />
	<sjg:gridColumn name="telefono"   title="Telefono"  editable="true" width="50" />
	<sjg:gridColumn name="celular"    title="Celular"   editable="true" width="50" />
	<sjg:gridColumn name="direccion"  title="Direccion" editable="true"  />
	
</sjg:grid>
<br/>

<s:url id="urlShowPets" action="showMascotaMantenimientoAction"/>

<div id="divResult">
</div>
<s:fielderror/> 	 	
<s:actionerror/>
<s:actionmessage/>


</s:form"src/edu/everest/entity/Cliente.java">

<sj:dialog 
    	id="dlgFamiliaresForm" 
    	autoOpen="false"
    	width="450"
    	modal="true" 
    	onCloseTopics="closeDialog"
    	showEffect="slide" 
    	hideEffect="explode"
    	title="Familiares">
        
        <table style="width: 100%;">
        	<tr>
        		<td style="width: 100%; text-align: center;">
        			<img alt="Loading" src="img/loading.gif">
        		</td>
        	</tr>
        </table>
		 
    </sj:dialog>
