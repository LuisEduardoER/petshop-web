<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<s:form id="form1">

<h2>Mantenimiento de Mascotas </h2>
<br/>
	<table width=600 align=center>
	<tr> <s:url id="insert" action="inicializarInsertarOActualizarProveedor"/>
		<!-- <td><s:a href="%{insert}">Agregar Nuevo Proveedor</s:a></td> -->
		<td>
			<sj:a openDialog="myclickdialog" button="true" buttonIcon="ui-icon-circle-plus">
		Agregar Mascota
	</sj:a>
		</td>
		<td>
			<s:url id="insert2" action="showMascotaFormAction">
				<s:param name="cliente.idCliente" value="cliente.idCliente"/>
			</s:url>
			<s:a href="%{insert2}">Agregar Nueva Mascota</s:a>

		</td>
	</tr>
</table>

<br>
<table align="center" class="ui-jqgrid-htable"
	   cellpadding="0" cellspacing="0" tabindex="1" border="0" role="grid" aria-multiselectable="false" 
 style="width: 100%;">
<thead>
    <tr class="ui-jqgrid-labels">
        <th class="ui-state-default ui-th-column ui-th-ltr"><s:text name="ID"/></th>
        <th class="ui-state-default ui-th-column ui-th-ltr"><s:text name="Imagen"/></th>
        <th class="ui-state-default ui-th-column ui-th-ltr"><s:text name="Nombre"/></th>
        <th class="ui-state-default ui-th-column ui-th-ltr"><s:text name="Edad"/></th>
        <th class="ui-state-default ui-th-column ui-th-ltr"><s:text name="Raza"/></th>
        <th class="ui-state-default ui-th-column ui-th-ltr"><s:text name="Sexo"/></th>
        <th class="ui-state-default ui-th-column ui-th-ltr">&nbsp;</th>
        <th class="ui-state-default ui-th-column ui-th-ltr">&nbsp;</th>
        <th class="ui-state-default ui-th-column ui-th-ltr">&nbsp;</th>
    </tr>
 </thead>
    <s:if test="count==0">
    	<tr><td colspan="5" style="text-align: center">No hay mascotas registradas para este Cliente.</td></tr>
    </s:if>
    
    <s:else>
    
	<tbody>    	
    <s:iterator value="mascotaLista" status="status">    
    
<%--         <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>"> --%>
        <tr role="row" aria-selected="true" id="<s:property value='#status.index' />" class="jqgfirstrow">

            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell">
            	<s:property value="idMascota"/>
            </td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell" style="text-align: center;">
            	<img alt="Imagen no disponible" style="max-height: 50px; max-width: 50px;" 
					src="cargaImagenAction?idMascota=<s:property value="idMascota"/>">
            </td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell"><s:property value="nombre"/></td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell"><s:property value="edad"/></td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell"><s:property value="raza"/></td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell"><s:property value="sexo"/></td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell">
               	<s:url id="update" action="showMascotaFormAction">
	       		   <s:param name="mascota.idMascota" value="idMascota"/>
	       		   <s:param name="cliente.idCliente" value="cliente.idCliente"/>
	       		</s:url> 
               	<s:a href="%{update}" cssClass="btn btn-primary">
					<span class="ui-button-icon-primary ui-icon ui-icon-pencil"></span>
				</s:a>
            </td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell">
               	<s:url id="delete" action="eliminaProveedor">
	       		   <s:param name="mascota.idMascota" value="idMascota"/>
	       		</s:url>
               	<s:a href="%{delete}" cssClass="btn btn-primary ">
               		<span class="ui-button-icon-primary ui-icon ui-icon-circle-close"></span>
               	</s:a>
            </td>
            <td class="ui-widget-content jqgrow ui-row-ltr" role="gridcell">
               	<s:url id="detalle" action="detalleProveedor">
	       		   <s:param name="mascota.idMascota" value="idMascota"/>
	       		</s:url>
               	<s:a href="%{detalle}" cssClass="btn btn-primary ">
               		<span class="ui-button-icon-primary ui-icon ui-icon-contact"></span>
               	</s:a>
            </td>
        </tr>
	 </s:iterator>
	 </tbody>
	 
	 </s:else>
	 
    </table>
    
	
</s:form>

<sj:dialog 
    	id="myclickdialog" 
    	autoOpen="false"
    	width="450"
    	modal="true" 
    	title="Mascota">
     
<%--      <s:include value="/mascota/mascotaForm.jsp"/> --%>
<h1>
   <s:if test="mascota==null || mascota.idProveedor == null">
	 <s:text name="Agregar Mascota"/>
	 <s:hidden id="oper" name="oper" value="add"/>
   </s:if>
   <s:else>
	 <s:text name="Editar Mascota"/>
	 <s:hidden id="oper" name="oper" value="edit"/>
   </s:else>
</h1>
	 <table>
		<tr><td align="left" style="font:bold;color:red"> 
	            <s:fielderror/> 	 	
                <s:actionerror/>
                <s:actionmessage/>
             </td>
        </tr>
     </table>
     		 	
    <s:form enctype="multipart/form-data" method="post">
    <s:hidden name="mascota.idMascota"/>
    <s:hidden name="hdIdCliente"/>
    
     <table align="center" class="borderAll">
     	 
     	 
     	 <tr>
         	<td class="tdLabel"><s:text name="Imagen"/></td>
         	<td>
<!--          		<img alt="Imagen no disponible"  -->
<%-- 					src="cargaImagenAction?mascota=<s:property value="mascota.idMascota"/>"> --%>
					
				<s:file name="mascota.fotobin"></s:file>
			</td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Nombre"/></td>
         	<td><s:textfield name="mascota.nombre" size="30"/></td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Edad"/></td>
         	<td><s:textfield name="mascota.edad" size="30"/></td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Raza"/></td>
         	<td><s:textfield name="mascota.raza" size="30"/></td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Sexo"/></td>
         	<td><s:textfield name="mascota.sexo" size="30"/></td>
         </tr>
    </table>
    		 <br/>
    <table> 
    	     <tr>
    		    <td><s:submit action="insertarOActualizarMascota" key="button.label.submit" cssClass="butStnd"/></td>
    	        <td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
    		 </tr>
    </table> 		  		 
    	</s:form>

     
    </sj:dialog>

    