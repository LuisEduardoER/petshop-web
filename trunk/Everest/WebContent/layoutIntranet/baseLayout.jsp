<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML>
<html lang="es-es" dir="ltr"  data-config='{"twitter":0,"plusone":0,"facebook":0,"style":"turquoise"}'>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- <base href="http://46.16.75.22/demo/themes/joomla/2014/everest/index.php/joomla/login" /> -->
  <meta name="generator" content="Joomla! - Open Source Content Management" />
  <title>Everest - Login</title>
  <!-- <link href="http://46.16.75.22/demo/themes/joomla/2014/everest/index.php/joomla/login" rel="canonical" /> -->
  <!-- <link href="http://46.16.75.22/demo/themes/joomla/2014/everest/index.php/component/search/?Itemid=129&amp;format=opensearch" rel="search" title="Search Everest Theme" type="application/opensearchdescription+xml" /> -->
  <link href="img/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon" />
  
  <link rel="stylesheet" href="css/widgetkit-66e22cf1-177e9ac9.css" type="text/css" />
<%--   <script src="js/mootools-core-d171a0eb.js" 		type="text/javascript"></script> --%>
  <script src="js/core-d5fdf156.js" 				type="text/javascript"></script>
  <script src="js/jquery.min-c35f01fc.js" 			type="text/javascript"></script>
<%--   <script src="js/jquery-noconflict-82bf3726.js" 	type="text/javascript"></script> --%>
<%--   <script src="js/jquery-migrate.min-19e9837c.js" 	type="text/javascript"></script> --%>
  <script src="js/html5fallback-7c3b8574.js" 		type="text/javascript"></script>
  <script src="js/widgetkit-6bfac609-540c13dd.js" 	type="text/javascript"></script>

<%--   <script src="js/jquery-1.10.2.js" 				type="text/javascript"></script> --%>
<%--   <script src="js/jquery-ui-1.10.4.custom.js" 		type="text/javascript"></script> --%>
<%--   <script src="js/jquery-ui-1.10.4.custom.min.js" 	type="text/javascript"></script> --%>

<link rel="apple-touch-icon-precomposed" href="img/apple_touch_icon.png">
<link rel="stylesheet" href="css/bootstrap-a9b9b142.css">
<link rel="stylesheet" href="css/theme-92f24e24.css">
<script src="js/theme-0e5b849f.js"></script>

<sj:head locale="es" jqueryui="true" jquerytheme="ui-everest" customBasepath="template/themes" defaultIndicator="myLoadingBar"/>
<%-- <sj:head locale="es" jqueryui="true" jquerytheme="cupertino"/> --%>

</head>



<body class="tm-sidebar-a-right tm-sidebars-1 tm-noblog  tm-content-boxed">

<table id="myLoadingBar" border="0" cellspacing="0" cellpadding="0" style="width: 100%;position: fixed;margin-top: -1px; padding: 0px !important; display: none;">
	<tr>
		<td style="width: 100%;text-align: center;">
			<img alt="Loading" src="img/loading200.gif">
		</td>
	</tr>
</table>

    <div class="uk-container uk-container-center">

<!-- ############################### HEAD ############################### -->

	

<!-- ############################### TOP MENU ############################### -->

    <tiles:insertAttribute name="topMenu" />
        
<!-- ############################### BODY ############################### -->

                <div class="tm-middle uk-grid" data-uk-grid-match data-uk-grid-margin>

<!-- ############################### BODY ############################### -->
					
					<div class="tm-main uk-width-medium-3-4">                
		                <main class="tm-content">
		                	<tiles:insertAttribute name="body" />
		                </main>
            		</div>
            		
            <!-- ############################### RIGTH MENU ############################### -->
            
            <tiles:insertAttribute name="rightMenu" />
                        
        </div>
        
<!-- ############################### FOOTER ############################### -->
    
	<tiles:insertAttribute name="footer" />
        
    </div>

   
        <div id="offcanvas" class="uk-offcanvas">
        <div class="uk-offcanvas-bar"><div class="uk-panel">
<form id="search-112" class="uk-search" action="/demo/themes/joomla/2014/everest/index.php/joomla/login" method="post" role="search" >
	<input class="uk-search-field" type="search" name="searchword" placeholder="search...">
	<button class="uk-search-close" type="reset"></button>
	<input type="hidden" name="task"   value="search">
	<input type="hidden" name="option" value="com_search">
	<input type="hidden" name="Itemid" value="107">
</form></div>
<ul class="uk-nav uk-nav-offcanvas"><li class="uk-parent"><a href="/demo/themes/joomla/2014/everest/">Home</a><ul class="uk-nav-sub"><li><a href="/demo/themes/joomla/2014/everest/?style=default">Default</a></li><li><a href="/demo/themes/joomla/2014/everest/?style=red">Red</a></li><li><a href="/demo/themes/joomla/2014/everest/?style=desert">Desert</a></li><li><a href="/demo/themes/joomla/2014/everest/?style=lilac">Lilac</a></li><li><a href="/demo/themes/joomla/2014/everest/?style=turquoise">Turquoise</a></li><li><a href="/demo/themes/joomla/2014/everest/?style=grey">Grey</a></li><li><a href="/demo/themes/joomla/2014/everest/?style=gold">Gold</a></li><li><a href="/demo/themes/joomla/2014/everest/?style=ocean">Ocean</a></li></ul></li><li class="uk-parent"><a href="/demo/themes/joomla/2014/everest/index.php/features">Features</a><ul class="uk-nav-sub"><li><a href="/demo/themes/joomla/2014/everest/index.php/features/layouts">Layouts</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/features/uikit">UIkit</a></li></ul></li><li class="uk-parent"><a href="/demo/themes/joomla/2014/everest/index.php/widgetkit">Widgetkit</a><ul class="uk-nav-sub"><li><a href="/demo/themes/joomla/2014/everest/index.php/widgetkit/slideshow">Slideshow</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/widgetkit/slideset">Slideset</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/widgetkit/gallery">Gallery</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/widgetkit/map">Map</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/widgetkit/accordion">Accordion</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/widgetkit/lightbox">Lightbox</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/widgetkit/spotlight">Spotlight</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/widgetkit/twitter">Twitter</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/widgetkit/media-player">Media Player</a></li></ul></li><li><a href="/demo/themes/joomla/2014/everest/index.php/icons">Icons</a></li><li class="uk-parent"><a href="/demo/themes/joomla/2014/everest/index.php/zoo">ZOO</a><ul class="uk-nav-sub"><li><a href="/demo/themes/joomla/2014/everest/index.php/zoo/zoo-blog">Blog</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/zoo/zoo-product-catalog">Product Catalog</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/zoo/zoo-download-archive">Download Archive</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/zoo/zoo-business-directory">Business Directory</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/zoo/zoo-movie-database">Movie Database</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/zoo/zoo-cookbook">Cookbook</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/zoo/zoo-documentation">Documentation</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/zoo/zoo-pages">Pages</a></li></ul></li><li class="uk-parent uk-active"><a href="/demo/themes/joomla/2014/everest/index.php/joomla">Joomla</a><ul class="uk-nav-sub"><li><a href="#">Content views</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/joomla/featured-articles">Featured Articles</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/joomla/list-all-categories">List All Categories</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/joomla/category-list">Category List</a></li><li><a href="#">Other views</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/joomla/contacts">Contacts</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/joomla/web-links">Web Links</a></li><li class="uk-active"><a href="/demo/themes/joomla/2014/everest/index.php/joomla/login">Login</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/joomla/tags">Tags</a></li></ul></li></ul></div>
    </div>
    
</body>
</html>