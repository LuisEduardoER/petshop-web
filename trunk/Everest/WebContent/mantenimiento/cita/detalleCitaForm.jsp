<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>


    	<s:hidden name="oper" value="add"></s:hidden>
    	
		<table align="center">
		    
		    <tr>
		    	<td class="tdLabel">Servicio</td>
		    	<td> 
		    	
		    		<sj:autocompleter
						id="cboServicioLista"
						name="idServicio" 
						list="servicioLista" 
						listKey="idServicio" 
						listValue="descripcion"
						formIds="frmDetalleCita"
						selectBox="true"
						selectBoxIcon="true"
						onChangeTopics="reloadDivForm" 
					/>
		    	</td>
		    </tr>
		    <s:if test="idServicio==2">
		    	<tr>
			    	<td class="tdLabel"><s:text name="Pelo"/></td>
			    	<td>
			    		<sj:radio
				            name="detalleCita.pelo"
				            list="{'Corto','Largo'}"
			    		/>
			    	</td>
			    </tr>
			    <tr>
			    	<td class="tdLabel"><s:text name="Tamano"/></td>
			    	<td>
			    		<sj:radio
				            name="detalleCita.tamano"
				            list="{'Pequeno','Mediano','Grande'}"
			    		/>
			    	</td>
			    </tr>
		    </s:if>
		    <tr>
		    	<td class="tdLabel"><s:text name="Tiempo"/></td>
		    	<td>
		    		<sj:datepicker 
	    				name="detalleCita.strTiempoAprox"
	    				showOn="focus"
	    				size="5"
	    				timepicker="true"
	    				timepickerOnly="true"
	    				timepickerShowHour="false"
	    				timepickerGridMinute="10"
	    				timepickerStepMinute="10"
	    				timepickerFormat="mm:ss"/>
		    		min
		    	</td>
		    	
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Costo"/></td>
		    	<td>
<%-- 		    		<s:textfield id="displayvaluespan" name="detalleCita.strCosto" size="30" required="true"/> --%>
		    		<sj:spinner
		    			formIds="frmDetalleCita"
				    	name="detalleCita.costo"
				    	min="000.00"
				    	max="200.00"
				    	step="000.10" 
				    	value="%{detalleCita.costo}" 
				    	size="10"
				    	mouseWheel="true"/>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Observaciones Adicionales"/></td>
<!-- 		    	name="detalleCita.observaciones" size="30" -->
		    	<td><s:textarea name="detalleCita.observaciones" cols="40" rows="5"/></td>
		    </tr>
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
<%-- 				    	<sj:submit button="true" value="Guardar"/> --%>
						<s:url id="urlAgregarServicio" value="editDetalleCitaListaAction"/>
						<sj:a 
							href="%{urlAgregarServicio}"
							formIds="frmDetalleCita"
							targets="Servicios"
							button="true"
							buttonIcon="ui-icon-disk"
							effect="blind"
							effectMode="show"
							onSuccessTopics="successDlgForm"
							>
							Agregar
						</sj:a>
				    </td>
				    <td>
				    	&nbsp;
				    </td>
				 </tr>
		</table>
    