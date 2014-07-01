<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>..:: ProveedorForm ::..</title>
</head>

<body>
<table border="0" width="*" cellspacing="5">
<tbody>
	<tr>
		<td colspan="2"><s:include value="/layouts/header.jsp" /></td>
	</tr>
	<tr>
		<td width="*" valign="top" align="left"><s:include value="/layouts/menu.jsp" /></td>
		<td width="*" valign="top" align="center"><s:include value="/proveedor/proveedorDetail.jsp" />
		</td>
	</tr>
	<tr>
		<td colspan="2"><s:include value="/layouts/footer.jsp" /></td>
	</tr>

</tbody>			
</table>

</body>