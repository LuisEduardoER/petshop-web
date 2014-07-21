<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h1>Cobro a Clientes</h1>

<s:form id="frmCobroCliente">

	<s:url id="urlShowCobroCliente" action="showCobroClienteAction"/>
	<sj:div
		id="divCobroFormCliente"
		href="%{urlShowCobroCliente}"
		formIds="frmCobroCliente"
		effectMode="show"
		effect="blind"
		effectDuration="500"
	/>

</s:form>

<sj:accordion collapsible="true">
	<sj:accordionItem title="Detalle">
		
		<sj:a 
			openDialog="dlgForm"
			button="true" 
			buttonIcon="ui-icon-plus"
			>Agregar</sj:a>
		<table id="table" class="dls-table" cellspacing="0" cellpadding="0">
		    <thead>
		        <tr>
		            <th>Nro</th>
		            <th>ID</th>
		            <th>Producto/Servicio</th>
		            <th>Cantidad</th>
		            <th>Precio</th>
		            <th class="ui-state-disabled tdButton">
		            	<sj:submit 
	 						type="button"
	 						cssClass="no-margin"
	 						button="true"
	 						buttonIcon="ui-icon-circle-close" 
	 						buttonText="false">
	 						Eliminar
	 					</sj:submit>
		            </th>
		        </tr>
		    </thead>
		    <tbody class="dls-table-body">
		    	<s:iterator value="{1,2,3,4,5}" var="objOpcion" status="stat">
			        <tr>
			            <td> <s:property/> </td>
			            <td> <s:property/> </td>
			            <td> [Producto/Servicio] </td>
			            <td> [Cantidad] </td>
			            <td> S/. [Precio] </td>
			            <td class="tdButton">
		 					<sj:submit 
		 						type="button"
		 						cssClass="no-margin"
		 						button="true"
		 						buttonIcon="ui-icon-circle-close" 
		 						buttonText="false">
		 						Eliminar
	 						</sj:submit>
			            </td>
			        </tr>
				</s:iterator>
			            <td>&nbsp;</td>
			            <td><b>Totales</b></td>
			            <td>[SUMA_CANTIDAD]</td>
			            <td>[SUMA_PRECIO]</td>
			            <td>&nbsp;</td>
					<tr>
						<td colspan="5"></td>
					</tr>
		    </tbody>
		</table>
		
	</sj:accordionItem>
</sj:accordion>
<br/>
<s:form id="frmComprobante">
	
	<sj:radio
		id="radiobuttonset"
		list="#{'boleta':'Boleta', 'factura':'Factura'}"
		name="tipoComprobante"
		formIds="frmComprobante"
		onChangeTopics="reloadTipoComprobante"
 		/>
 	
 	<s:url id="urlTipoComprobante" action="loadTipoComprobanteAction"/>
	<sj:div href="%{urlTipoComprobante}" 
		reloadTopics="reloadTipoComprobante" 
		formIds="frmComprobante" 
		effect="blind" 
		effectMode="show" 
		effectDuration="300"/>
	
</s:form>

<s:form id="frmTipoCobro">

	<sj:radio
		id="radioTipoCobro"
		list="#{'contado':'Contado', 'tarjeta':'Tarjeta', 'lineaCredito':'Linea de Credito'}"
		name="tipoCobro"
		formIds="frmTipoCobro"
		onChangeTopics="reloadTipoCobro"
 		/>
	<s:url id="urlTipoCobro" action="loadTipoCobroAction"/>
	<sj:div href="%{urlTipoCobro}" 
		reloadTopics="reloadTipoCobro" 
		formIds="frmTipoCobro" 
		effect="blind" 
		effectMode="show" 
		effectDuration="300"/>
		
</s:form>