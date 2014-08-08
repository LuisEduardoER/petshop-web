<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title><s:text  name="global.titulo" /></title>	
<sj:head locale="es" jqueryui="true" jquerytheme="south-street"/>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/screen.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/struts/utils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-timepicker-es.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="struts2, jquery, jquery-ui, plugin, showcase, jqgrid" />
<meta http-equiv="description" content="A Showcase for the Struts2 jQuery Plugin" />


<script type="text/javascript">
function muestraCalendario(){
	document.getElementById("idForm28").action = 'cargaCalendario';
	document.getElementById("idForm28").submit();
}



</script>
 <style>     
		#scheduler {
			position: absolute;
			height: 380px;
			top: 130px;
			left: 20px;
		}
   </style>
</head>
<body >
<div id="idDivForm08" align="left">
<div id="idDivMensajeForm08" align="left"></div>  



<label id="idLabelTituloRegistroProgramacionEnvasado">Registro de Cita</label>	  

	<s:form id="idForm28" action="cargaCalendario">
		<sj:submit value="cargar" button="true" ></sj:submit>
  	</s:form>
  	
	<div id="scheduler"> 
			<s:property escape="false" value="messageStore.scheduler" />
	</div>

</div>
</body>
</html>