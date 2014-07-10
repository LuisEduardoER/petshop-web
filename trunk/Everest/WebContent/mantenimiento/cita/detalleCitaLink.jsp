<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:url id="showDetalleCitaForm" action="showDetalleCitaForm"></s:url>
<sj:div 
	id="divDetalleCitaForm" 
	href="%{showDetalleCitaForm}"
	reloadTopics="reloadDivForm" 
	effect="blind" 
	effectDuration="500"
	effectMode="show"/>