<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <link href="<s:url value="/styles/main.css"/>" rel="stylesheet" type="text/css"/>
    <title><s:text name="label.proveedores"/></title>
</head>
<body>

<div class="titleDiv"><s:text name="application.title"/></div>	
<h1><s:text name="label.proveedores"/></h1>		   
<table width=600 align=center>
	<tr> <s:url id="insert" action="inicializarInsertarOActualizarProveedor"/>
		<td><s:a href="%{insert}">Agregar Nuevo Proveedor</s:a></td>
	</tr>
</table>
<br>
<table align=center class="borderAll">
    <tr>
        <th><s:text name="ID"/></th>
        <th><s:text name="RUC"/></th>
        <th><s:text name="Razon Social"/></th>
        <th><s:text name="Direccion"/></th>
        <th>&nbsp;</th>
    </tr>
    <s:iterator value="proveedores" status="status">
        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
            <td class="nowrap"><s:property value="idProveedor"/></td>
            <td class="nowrap"><s:property value="ruc"/></td>
            <td class="nowrap"><s:property value="razonSocial"/></td>
            <td class="nowrap"><s:property value="direccion"/></td>
            <td class="nowrap">
                	<s:url id="update" action="inicializarInsertarOActualizarProveedor">
		       		   <s:param name="proveedor.idProveedor" value="idProveedor"/>
		       		</s:url> 
                	<s:a href="%{update}">Editar</s:a>&nbsp;&nbsp;&nbsp;
                	
                	
                	<s:url id="delete" action="eliminaProveedor">
		       		   <s:param name="proveedor.idProveedor" value="idProveedor"/>
		       		</s:url>
                	<s:a href="%{delete}">Eliminar</s:a>
                	
                	<s:url id="detalle" action="detalleProveedor">
		       		   <s:param name="proveedor.idProveedor" value="idProveedor"/>
		       		</s:url>
                	<s:a href="%{detalle}">Detalle</s:a>
            </td>
        </tr>  		
	 </s:iterator>
    </table>
</body>
</html>