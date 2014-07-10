<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<h1>Registrar Pago</h1>

<table style="width: 100%;" cellspacing="0" cellpadding="0">
			<tr>
				<td style="width: 50%,">
					<fieldset style="height: 90px;">
						<legend><h2>Cliente</h2></legend>
						
						<table class="dls-table-form" style="width: 100%;" cellspacing="0" cellpadding="0">
							<tr>
								<th>DNI</th>
								<th>
									Cliente
								</th>
							</tr>
							<tr>
								<td>
									<s:textfield name="cliente.dni" size="10"/>
									<sj:a button="true" buttonIcon="ui-icon-circle-triangle-e" buttonText="false">
										Validar
									</sj:a>
								</td>
								<td>[Nombres] [ApePat]</td>
							</tr>
						</table>
					</fieldset>
				</td>
				<td style="width: 50%,">
					<fieldset style="height: 90px;">
						<legend><h2>Cita</h2></legend>
						
						<table class="dls-table-form" style="width: 100%;" cellspacing="0" cellpadding="0">
							<tr>
								<th>ID</th>
								<th>Fecha</th>
								<th>Mascota</th>
								<th>Medico</th>
							</tr>
							<tr>
								<td>[IdCita]</td>
								<td>[FecAtencion]</td>
								<td>[Nombre]</td>
								<td>[Nombres] [ApePat]</td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
		</table>


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
		            <th>Id</th>
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
		effectDuration="500"/>
	
</s:form>

<s:form id="frmTipoPago">

	<sj:radio
		id="radioTipoPago"
		list="#{'1':'Tarjeta de Credito', '2':'Contado', '3':'Linea de Credito'}"
		name="tipoPago"
		formIds="frmTipoPago"
		onChangeTopics=""
 		/>
	<s:url id="urlTipoComprobante" action="loadTipoComprobanteAction"/>
	<sj:div href="%{urlTipoComprobante}" 
		reloadTopics="reloadTipoComprobante" 
		formIds="frmTipoPago" 
		effect="blind" 
		effectMode="show" 
		effectDuration="500"/>
		
</s:form>