<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:form id="frmCliente" action="insertarOActualizarCliente">

	<s:url id="urlClienteForm" action="showClienteFormAjax" escapeAmp="false">
		<s:param name="cliente.idCliente" value="cliente.idCliente"/>
		<s:param name="oper" value="oper"/>
	</s:url>
	<sj:div id="divClienteForm"
			href="%{urlClienteForm}"
			formIds="frmCliente"
			reloadTopics="reloadDivClienteForm"
	/>

</s:form>