<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<table class="dls-table" style="width: 100%;" cellspacing="0" cellpadding="0">
<thead>
	<tr>
		<th style="width: 20px;">Nro</th>
		<th>Servicio</th>
		<th>Tiempo Aprox</th>
		<th>Costo</th>
		<th class="ui-state-disabled tdButton">
         	<sj:submit 
				type="button"
				cssClass="no-margin"
				button="true"
				buttonIcon="ui-icon-circle-close" 
				buttonText="false">
				Mascotas
			</sj:submit>
         </th>
	</tr>
</thead>
<tbody class="dls-table-body">
	<s:if test="detalleCitaLista.size==0">
		<tr>
			<td colspan="5" style="text-align: center;">
				Agregue los Servicios que desea tomar para su mascota, por favor.
			</td>
		</tr>
	</s:if>
	<s:else>
	<s:iterator value="detalleCitaLista" status="stat">
		<tr>
			<td><s:property value="idCita"/> </td>
			<td>
				<s:select 
					list="servicioLista"
					name="idServicio"
					listKey="idServicio"
					listValue="descripcion"
					disabled="true"
				/> 
			</td>
			<td><s:date name="tiempoAprox" format="HH:mm"/> </td>
			<td><s:property value="costo"/> </td>
			<td class="tdButton">
	       		<s:form id="formDetalleCita%{#stat.count}" action="" method="post">
			      <s:hidden name="cliente.idCliente" value="%{idCliente}"/>
					<sj:submit 
						type="button"
						formIds="formDetalleCita%{#stat.count}"
						indicator="myLoadingBar"
						cssClass="no-margin"
						button="true"
						buttonIcon="ui-icon-circle-close" 
						buttonText="false">
						Eliminar
					</sj:submit>
				</s:form>
           </td>
		</tr>
	</s:iterator>
	<tr>
		<td> </td>
		<td style="text-align: right;"><b>Total</b> </td>
		<td><b><s:date name="tiempoTotal" format="HH:mm"/></b> </td>
		<td><b><s:property value="costoTotal"/></b> </td>
		<td> </td>
	</tr>
	</s:else>
	
	<tr>
		<td colspan="5"> </td>
	</tr>
	
</tbody>
</table>

