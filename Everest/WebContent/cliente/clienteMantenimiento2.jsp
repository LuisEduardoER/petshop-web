<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
  
<s:form id="form1">

<h1>Mantenimiento de Clientes</h1>

<table class="dls-table" cellspacing="0" cellpadding="0">
    <thead>
        <tr>
            <th>ID</th>
            <th>Tipo</th>
            <th>Documento</th>
            <th>Nombres</th>
            <th>Ape. Pat.</th>
            <th>Ape. Mat.</th>
        </tr>
    </thead>
    <tbody>
    	<s:iterator value="clienteLista" var="objCliente" status="stat">
	        <tr>
	            <td> <s:property value="idCliente"/> </td>
	            <td> <s:property value="tipoDocumento.descripcion"/> </td>
	            <td> <s:property value="documento"/> </td>
	            <td> <s:property value="nombres"/> </td>
	            <td> <s:property value="apePat"/> </td>
	            <td> <s:property value="apeMat"/> </td>
	        </tr>
		</s:iterator>
    </tbody>
</table>
<table class="dls-table dls-option" cellspacing="0" cellpadding="0">
    <thead>
        <tr>
            <th class="tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-person" buttonText="false" cssClass="no-border">Familiares</sj:a>
            </th>
            <th class="tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-contact" buttonText="false" cssClass="no-border">Mascotas</sj:a>
            </th>
            <th class="tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-document" buttonText="false" cssClass="no-border">Ver</sj:a>
            </th>
            <th class="tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-pencil" buttonText="false" cssClass="no-border">Editar</sj:a>
            </th>
            <th class="tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-circle-close" buttonText="false" cssClass="no-border">Eliminar</sj:a>
            </th>
            <th>&nbsp;</th>
            
            <th class="tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-seek-first" buttonText="false" cssClass="no-border">First</sj:a>
            </th>
            <th class="tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-seek-prev" buttonText="false" cssClass="no-border">Prev</sj:a>
            </th>
            <th class="tdButton">
            	<s:textfield value="1" size="3"/>
            </th>
            <th class="tdButton">
            	of 2
            </th>
            <th class="tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-seek-next" buttonText="false" cssClass="no-border">Next</sj:a>
            </th>
            <th class="tdButton">
            	<sj:a button="true" buttonIcon="ui-icon-seek-end" buttonText="false" cssClass="no-border">Last</sj:a>
            </th>
            
            <th class="tdButton">
            	<s:select name="pager"
				       list="#{'5':'5', '10':'10', '15':'15'}"
				       value="pager"/>
            </th>
            
            <th>&nbsp;</th>
        </tr>
    </thead>
</table>

<br/>
<sj:tabbedpanel id="localtabs">
      <sj:tab id="tab1" target="tone" label="Local Tab One"/>
      <sj:tab id="tab2" target="ttwo" label="Local Tab Two"/>
      
      <div id="tone">Tab 1</div>
      <div id="ttwo">Tab 2</div>

</sj:tabbedpanel>

</s:form>