<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/screen.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/struts/utils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-timepicker-es.js"></script>

 <style>     
		#scheduler {
			position: absolute;
			height: 380px;
			top: 130px;
			left: 20px;
		}
   </style>

  	
<div id="scheduler"> 
	<s:property escape="false" value="messageStore.scheduler" />
</div>


