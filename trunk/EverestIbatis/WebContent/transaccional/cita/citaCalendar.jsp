<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/screen.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/struts/utils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-timepicker-es.js"></script>

 <style>     
#scheduler {
	height: 380px;
	text-align: center;
}
#scheduler_here{
	border: 1px solid #CECECE;
}
.dhx_cal_event .dhx_title{
	height: 17px !important;
}
</style>

<s:form>

<h1>
	Disponiblidad
</h1>

<div id="scheduler"> 
	<s:property escape="false" value="messageStore.scheduler" />
</div>

<br/>

<table style="width: 100%;">
	<tr>
		<td style="width: 100%; text-align: right; padding-right: 93px;">
			<sj:a button="true" buttonIcon="ui-icon-circle-arrow-w" onclick="javascript:history.back(-1);">
	    		Volver
	    	</sj:a>
		</td>
	</tr>
</table>

</s:form>