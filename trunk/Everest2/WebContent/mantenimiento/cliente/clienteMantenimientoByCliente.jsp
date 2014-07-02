<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
  
<s:form>


  	
	<h2>Registro de Cliente</h2>
	
	<sj:tabbedpanel id="localtabs" disabledTabs="[1,2]" >
      <sj:tab id="tab1" target="tabs-1" label="Cliente"/>
      <sj:tab id="tab2" target="tabs-2" label="Familiares"/>
      <sj:tab id="tab2" target="tabs-3" label="Mascotas"/>
	
  <div id="tabs-1">
  
  <s:form>
  
  	<table>
		<tr>
			<td>Nombres</td>
			<td>Apellido Paterno</td>
			<td>Apellido Materno</td>
		</tr>
		<tr>
			<td><s:textfield name="cliente.nombres"/></td>
			<td><s:textfield name="cliente.apePat"/></td>
			<td><s:textfield name="cliente.apeMat"/></td>
		</tr>
		<tr>
			<td>Tipo Doc. Identidad</td>
			<td>Doc. Identidad</td>
			<td>Fec. Nac.</td>
		</tr>
		<tr>
			<td>
				<s:select name="cliente.tipoDocumento.idTipoDocumento"
					       headerKey="-1" headerValue="-----"
					       list="#{'1':'DNI', '2':'Carnet de Extranjeria'}"
					       required="true"
					/>
			</td>
			<td><s:textfield name="cliente.documento"/></td>
			<td><s:textfield name="cliente.fecNac"/></td>
		</tr>
		<tr>
			<td>Sexo</td>
			<td>Telf. de Casa</td>
			<td>Celular</td>
		</tr>
		<tr>
			<td> 
				<s:select name="cliente.sexo"
					       headerKey="-1" headerValue="-----"
					       list="#{'M':'Masculino', 'F':'Femenino'}"
					       required="true"
					/>
			</td>
			<td><s:textfield name="cliente.telefono"/></td>
			<td><s:textfield name="cliente.celular"/></td>
		</tr>
	</table>
	
	<sj:a button="true" buttonIcon="ui-icon-disk" >Guardar</sj:a>
	
	</s:form>
	
  </div>
  <div id="tabs-2">
    
<!-- llamar familiarMantenimiento.jsp -->

  </div>
  <div id="tabs-3">
    
<!-- llamar proveedorMantenimiento.jsp -->    
    
  </div>

</sj:tabbedpanel>

</s:form>