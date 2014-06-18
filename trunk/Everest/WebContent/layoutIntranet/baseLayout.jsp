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

<sj:head locale="es" jqueryui="true" jquerytheme="ui-everest" customBasepath="template/themes" defaultIndicator="myLoadingBar"/>
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
			<li><a href="welcome">Home</a></li>
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
			<main id="mainContent" class="tm-content">
				
				<tiles:insertAttribute name="body" />
				
			</main>
		</div>
		
		<!-- ############################### RIGTH MENU ############################### -->
            <s:action name="loadMenuAction" executeResult="true"/>
		
	</div>
	
</div>

</body>
</html>