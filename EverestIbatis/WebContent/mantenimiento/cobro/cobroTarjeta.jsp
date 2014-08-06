<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

	
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
							<s:textfield size="1"/>
							<s:textfield size="1"/>
							<s:textfield size="1"/>
							<s:textfield size="1"/>
						</td>
					</tr>
				</table>
				
			</td>
			
		</tr>
	</table>
