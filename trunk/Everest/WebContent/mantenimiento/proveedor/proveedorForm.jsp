<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <link href="<s:url value="/styles/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<center>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1>
   <s:if test="proveedor==null || proveedor.idProveedor == null">
	 <s:text name="label.proveedor.add"/>
   </s:if>
   <s:else>
	 <s:text name="label.proveedor.edit"/>
   </s:else>
</h1>
	<table width=600 align=center>
	    <tr><td><a href="obtenerProveedores.action">Ver Proveedores</a></td>
	     </tr>
	</table>	 
	 <table>
		<tr><td align="left" style="font:bold;color:red"> 
	            <s:fielderror/> 	 	
                <s:actionerror/>
                <s:actionmessage/>
             </td>
        </tr>
     </table>
     		 	
    <s:form>
    <s:hidden name="proveedor.idProveedor"/>
     <table align="center" class="borderAll">
         <tr>
         	<td class="tdLabel"><s:text name="RUC"/></td>
         	<td><s:textfield name="proveedor.ruc" size="30"/></td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Razon Social"/></td>
         	<td><s:textfield name="proveedor.razonSocial" size="30"/></td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Direccion"/></td>
         	<td><s:textfield name="proveedor.direccion" size="30"/></td>
         </tr>
    </table>
    		 <br/>
    <table> 
    	     <tr>
    		    <td><s:submit action="insertarOActualizarProveedor" key="button.label.submit" cssClass="butStnd"/></td>
    	        <td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
    		 </tr>
    </table> 		  		 
    	</s:form>
</center>		
</body>
</html>