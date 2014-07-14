<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<fieldset>
	
	<table style="width: 100%;">
		<tr>
			<td style="vertical-align: top;">
				
				<table style="width: 100%;">
					<tr>
						<td>Tipo</td>
						<td>
							<sj:radio
								id="radioTipoTarjeta"
								list="{'Debito', 'Credito'}"
								name="tipoTarjeta"
						 		/>
						</td>
					</tr>
					<tr>
						<td>Tarjeta</td>
						<td>
							<sj:radio
								id="radioTarjeta"
								list="{'Visa', 'MasterCard'}"
								name="tarjeta"
						 		/>
						</td>
					</tr>
					<tr>
						<td>Nro.</td>
						<td>
							<s:textfield size="3"/>
							<s:textfield size="3"/>
							<s:textfield size="3"/>
							<s:textfield size="3"/>
						</td>
					</tr>
				</table>
				
			</td>
			<td style="vertical-align: top;">
				
				<table style="width: 100%;">
					<tr>
						<td>Total Bruto</td>
						<td><s:textfield/> </td>
					</tr>
					<tr>
						<td>IGV</td>
						<td><s:textfield/> 19%</td>
						<td></td>
					</tr>
					<tr>
						<td>Total</td>
						<td><s:textfield/> </td>
					</tr>
				</table>
				
			</td>
		</tr>
	</table>
	
</fieldset>