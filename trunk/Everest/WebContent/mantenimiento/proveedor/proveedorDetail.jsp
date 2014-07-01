<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <link href="<s:url value="/styles/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<center>
<div class="titleDiv"><s:text name="application.title"/></div>

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

     <table align="center" class="borderAll">
        <tr>
        	<td class="tdLabel"><s:text name="RUC"/></td>
        	<td><s:property value="proveedor.ruc"/></td>
        </tr>
        <tr>
        	<td class="tdLabel"><s:text name="Razon Social"/></td>
        	<td><s:property value="proveedor.razonSocial"/></td>
        </tr>
        <tr>
        	<td class="tdLabel"><s:text name="Direccion"/></td>
        	<td><s:property value="proveedor.direccion"/></td>
        </tr>
           
    </table>
    		 <br/>
  	  		 
    	
</center>		
</body>
</html>