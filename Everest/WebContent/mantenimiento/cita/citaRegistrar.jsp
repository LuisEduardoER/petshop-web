<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<script>
$(function() {
	$.subscribe('closeCalDialog', function(event,data) {
		var html = "<table style='width: 100%;'>"+
				    	"<tr>"+
						"<td style='width: 100%; text-align: center;'>"+
							"<img alt='Loading' src='img/loading.gif'>"+
						"</td>"+
					"</tr>"+
				"</table>";
        $("#dlgCalendar").empty();
        $("#dlgCalendar").html(html);
    });
	$.subscribe('tabchange', function(event, data) {
		
		if($("#Cita").html()==""){
			$("#Servicios").html("");
		}
		if($("#Servicios").html()==""){
			$("#Cita").html("");
		}
	});
});
</script>

<s:form id="frmCita">

<h1>
Registro de Citas
</h1>

<sj:accordion cssClass="accAccordion" autoHeight="true">
	<sj:accordionItem title="Mascota">
		<s:include value="citaMascota.jsp"/>
	</sj:accordionItem>
</sj:accordion>

<s:url id="urlShowDetalleCita" action="showDetalleCitaLista" escapeAmp="true">
	<s:param name="cita.idCita"/>
</s:url>
<s:url id="urlShowCitaDetail" action="showCitaDetailAction" >
</s:url>

<sj:tabbedpanel id="remotetabs" onChangeTopics="tabchange">
  <sj:tab id="tab1" href="%{urlShowDetalleCita}" label="Servicios" effect="blind"/>
  <sj:tab id="tab2" href="%{urlShowCitaDetail}" label="Cita" effect="blind"/>
</sj:tabbedpanel>

<br>

<sj:a button="true" buttonIcon="ui-icon-disk">Registrar</sj:a>

<br>
<script type="text/javascript">
$(function() {
	var icons = {
		header: "ui-icon-circle-arrow-e",
		activeHeader: "ui-icon-circle-arrow-s"
	};
// 	$(".accAccordion").accordion("option","icons",null);
// 	$("h3.accAccordion span").css("float","left");
});
</script>

</s:form>

<sj:dialog
	id="dlgCalendar" 
	autoOpen="false" 
	modal="true"
	showEffect="slide"
	hideEffect="explode"
	width="830"
	closeOnEscape="true"
	onCloseTopics="closeCalDialog"
	title="Horarios">
 	
 	<table id="dlgLoading" style="width: 100%; ">
       	<tr>
       		<td style="width: 100%; text-align: center;">
       			<img alt="Loading" src="img/loading.gif">
       		</td>
       	</tr>
	</table>
 	
</sj:dialog>