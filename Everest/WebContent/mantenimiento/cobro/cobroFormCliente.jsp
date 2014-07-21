<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<table style="width: 100%;" cellspacing="0" cellpadding="0">
			<tr>
				<td style="width: 50%,">
					<fieldset style="height: 140px;">
						<legend><h2>Cliente</h2></legend>
						
						<table class="dls-table-form" style="width: 100%;" cellspacing="0" cellpadding="0">
							<tr>
								<th>DNI</th>
							</tr>
							<tr>
								<td>
									<s:textfield name="cliente.dni"/>
									<sj:a button="true" buttonIcon="ui-icon-circle-triangle-e" buttonText="false">
										Validar
									</sj:a>
								</td>
							</tr>
						</table>
						<table class="dls-table-form" style="width: 100%;" cellspacing="0" cellpadding="0">
							<tr>
								<th>
									Cliente
								</th>
							</tr>
							<tr>
								<td>
									<s:property value="cliente.nombres"/>
									<s:property value="cliente.apePat"/>
								</td>
							</tr>
						</table>
					</fieldset>
				</td>
				<td style="width: 50%;">
					<fieldset style="height: 140px;">
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