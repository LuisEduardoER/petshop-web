<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

	<table style="width: 100%;">
		<tr>
			<td style="vertical-align: top;">
				
				<table style="width: 100%;">
					<tr>
						<td>Linea Disponible</td>
						<td><s:textfield size="8" disabled="true"/></td>
					</tr>
					<tr>
						<td>Dias</td>
						<td><sj:spinner size="8" min="1" max="60"/></td>
					</tr>
					<tr>
						<td>Fec. Pago</td>
						<td>
							<sj:datepicker
								showOn="focus"
								displayFormat="dd/mm/yy"
								changeMonth="true"
								changeYear="true"
								value="today"
								size="8"
							/>
						</td>
					</tr>
					<tr>
						<td>Saldo</td>
						<td><s:textfield size="8" disabled="true"/></td>
					</tr>
				</table>
				
			</td>
			
		</tr>
	</table>
