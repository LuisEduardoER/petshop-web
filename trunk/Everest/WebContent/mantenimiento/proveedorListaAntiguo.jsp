<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:form id="form1">

<h2>Mantenimiento de Proveedores </h2>
<br/>
	<table width=600 align=center>
	<tr> <s:url id="insert" action="inicializarInsertarOActualizarProveedor"/>
		<!-- <td><s:a href="%{insert}">Agregar Nuevo Proveedor</s:a></td> -->
		<td>
			<sj:a openDialog="myclickdialog" button="true" buttonIcon="ui-icon-circle-plus">
		Agregar Proveedor
	</sj:a>
		</td>
	</tr>
</table>

<br>
<table align=center class="category table table-striped table-bordered table-hover">
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
    
	
</s:form>

<sj:dialog 
    	id="myclickdialog" 
    	autoOpen="false"
    	width="450"
    	modal="true" 
    	title="Proveedor">
     
     <s:include value="/mantenimiento/proveedorForm.jsp"/>
     
    </sj:dialog>
