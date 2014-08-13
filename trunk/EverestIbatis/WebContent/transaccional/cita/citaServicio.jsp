<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:form id="frmDetalleCita">

<s:url var="urlLoadServicioAJAX" action="loadServicioAJAX"/>

<sj:div id="divCitaServicioAjax"
		href="%{urlLoadServicioAJAX}"
		formIds="frmDetalleCita"
		reloadTopics="reloadCitaServicioAjax"
		indicator="myLoadingBar"
		/>

</s:form>