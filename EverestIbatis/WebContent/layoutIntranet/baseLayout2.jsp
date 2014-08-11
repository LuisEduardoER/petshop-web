<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html id="htmlIntranet">
<head>
<meta charset="UTF-8">

<link href="img/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/reset2.css" type="text/css" />

<title>PetShop</title>

<sj:head locale="es" jqueryui="true" jquerytheme="ui-everest" customBasepath="template/themes" />
<%-- <sj:head locale="es" jqueryui="true" jquerytheme="ui-everest" customBasepath="template/themes" defaultIndicator="myLoadingBar"/> --%>
<%-- <sj:head locale="es" jqueryui="true" jquerytheme="cupertino" defaultIndicator="myLoadingBar"/> --%>

</head>
<body>
<table id="myLoadingBar" border="0" cellspacing="0" cellpadding="0" style="width: 100%;position: fixed;margin-top: -6px; padding: 0px !important; display: none; z-index: 1009;">
	<tr>
		<td style="width: 100%;text-align: center;">
			<img alt="Loading" src="img/loading200.gif">
		</td>
	</tr>
</table>

<div class="uk-container">
	<!-- ############################### HEAD ############################### -->
	
	<nav class="tm-navbar uk-navbar">
		
		<ul class="topMenu">
			<li>
				<a href="intranetBienvenidoAction" style="float: left; padding: 0;">
					<img alt="Home Intranet" src="img/PetShop_Only.png" style="height: 50px; float: left; margin: 10px 20px;">
				</a>
			</li>
			<li><a href="#">Menu 1</a></li>
			<li><a href="#">Menu 2</a></li>
			<li><a href="#">Menu 3</a>
				<ul>
				<li>
					<a href="#">
						SubMenu 3.1
					</a>
				</li>
				<li>
					<a href="#">
						SubMenu 3.2
					</a>
				</li>
				</ul>
			</li>
			<li><a href="#">Menu 4</a></li>
			<li><a href="#">Menu 5</a>
				<ul>
				<li>
					<a href="#">
						SubMenu 5.1
					</a>
				</li>
				<li>
					<a href="#">
						SubMenu 5.2
					</a>
				</li>
				</ul>
			</li>
			<li><a href="logOut">LogOut</a></li>
		</ul>

	</nav>
	
	<div class="tm-middle uk-grid" data-uk-grid-match="" data-uk-grid-margin="">
		<div class="tm-main uk-width-medium-3-4" style="min-height: 512px;">                
			<main id="mainContent" class="tm-content" style="width: 1000px;">
				
				<sj:dialog 
		    	id="dlgForm" 
		    	autoOpen="false"
		    	width="450"
		    	minHeight="250"
		    	modal="true" 
		    	onCloseTopics="closeDialog"
		    	showEffect="slide" 
		    	hideEffect="explode"
		    	title="Titulo">
		        
		        <table style="width: 100%;">
		        	<tr>
		        		<td style="width: 100%; text-align: center;">
		        			<img alt="Loading" src="img/loading.gif">
		        		</td>
		        	</tr>
		        </table>
				 
		    </sj:dialog>
    
				<tiles:insertAttribute name="body" />
				
			</main>
		</div>
		
		<!-- ############################### RIGTH MENU ############################### -->
<%--             <s:action name="loadMenuAction" executeResult="true"/> --%>
		
	</div>
	
	<div id="footer" style="background: rgba(0, 0, 0, 0.35);
							color: #ffffff;
							background-image: none;
							box-shadow: 0 1px 6px rgba(50, 90, 90, 0.12), inset 0 0 1px rgba(0, 0, 0, 0), inset 0 1px 0 rgba(0,0,0,0);
							width: 97%;
							content: ' ';
							display: table;
							clear: both;
							margin-top: 15px;
							margin-bottom: 15px;
							text-align: center;
							padding: 10px 15px;
							"
						
							>
		© 2014 Grupo DLS Todos los derechos reservados
	</div>
	
</div>
</body>
<script type="text/javascript">
$(function() {
	$.subscribe('closeDialog', function(event,data) {
		var html = "<table style='width: 100%;'>"+
				    	"<tr>"+
						"<td style='width: 100%; text-align: center;'>"+
							"<img alt='Loading' src='img/loading.gif'>"+
						"</td>"+
					"</tr>"+
				"</table>";
        $("#dlgForm").empty();
        $("#dlgForm").html(html);
    });
	$.subscribe('successDlgForm', function(event,data) {
		$("#dlgForm").dialog("close");
    });
});
</script>

</html>