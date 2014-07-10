<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<table>
		<tr><td align="left" style="font:bold;color:red"> 
	            <s:fielderror/> 	 	
                <s:actionerror/>
                <s:actionmessage/>
             </td>
        </tr>
     </table>
     		 	
    <s:form id="frmDetalleCita" >
    	<s:hidden name="oper" value="add"></s:hidden>
    	
		<table align="center">
		    
		    <tr>
		    	<td class="tdLabel"><s:text name="Servicio"/></td>
		    	<td>
		    		<s:url id="urlLoadServiciosJSON" action="loadServiciosJSON"/> 
					<sj:select 
						href="%{urlLoadServiciosJSON}"
						name="idServicio" 
						list="servicioLista" 
						listKey="idServicio" 
						listValue="descripcion"
						formIds="frmDetalleCita"
						onChangeTopics="reloadDivForm" 
						headerKey="-1" 
						headerValue="-- Seleccione --"
					/>
<%-- 		    		<s:select --%>
<%-- 		    			id="cboServicioLista" --%>
<%-- 		    			name="servicio.idServicio"  --%>
<%-- 		    			list="servicioLista" --%>
<%-- 		    			listKey="idServicio" --%>
<%-- 		    			listValue="descripcion" --%>
<%-- 		    		/> --%>
		    		<script type="text/javascript">
					$("#cboServicioLista").change(function() {
						cbo = $("#cboServicioLista").val();						
						if(cbo == "2"){
							$("#trPelo").show();
							$("#trTamano").show();
						}else{
							$("#trPelo").hide();
							$("#trTamano").hide();
						}
					});
					</script>
		    	</td>
		    </tr>		    
		    <tr id="trPelo" style="display: none;">
		    	<td class="tdLabel"><s:text name="Pelo"/></td>
		    	<td>
		    		<sj:radio
			            name="detalleCita.pelo"
			            list="{'Corto','Largo'}"
		    		/>
		    	</td>
		    </tr>
		    <tr id="trTamano" style="display: none;">
		    	<td class="tdLabel"><s:text name="Tamano"/></td>
		    	<td>
		    		<sj:radio
			            name="detalleCita.tamano"
			            list="{'Pequeno','Mediano','Grande'}"
		    		/>
		    	</td>
		    </tr>
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
		    			reloadTopics=""
				    	name="detalleCita.costo"
				    	min="000.00"
				    	max="200.00"
				    	step="000.10" 
				    	value="000.00" 
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
    </s:form>