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
     		 	
    <s:form id="frmCitaDetalle" action="insertarCitaDetalle">
		<table align="center">
		    
		    <tr>
		    	<td class="tdLabel"><s:text name="Servicio"/></td>
		    	<td>
		    		<s:select
		    			name="citaDetalle.servicio.idServicio" 
		    			list="servicioLista"
		    			listKey="idServicio"
		    			listValue="descripcion"
		    		/>
		    	</td>
		    </tr>		    
		    <tr>
		    	<td class="tdLabel"><s:text name="Pelo"/></td>
		    	<td>
		    		<select name="citaDetalle.pelo">
		    			<option value="Corto">Corto</option>
		    			<option value="Largo">Largo</option>
		    		</select>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Tamano"/></td>
		    	<td>
		    		<select name="citaDetalle.tamano">
		    			<option value="Pequeno">Pequeno</option>
		    			<option value="Mediano">Mediano</option>
		    			<option value="Grande">Grande</option>
		    		</select>
		    	</td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Tiempo"/></td>
		    	<td><s:textfield name="citaDetalle.tiempo" size="30" required="true"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Costo"/></td>
		    	<td><s:textfield name="citaDetalle.costo" size="30" required="true"/></td>
		    </tr>
		    <tr>
		    	<td class="tdLabel"><s:text name="Observaciones"/></td>
		    	<td><s:textfield name="citaDetalle.observaciones" size="30" required="true" /></td>
		    </tr>
		</table>
				 <br/>
		<table> 
			     <tr>
				    <td>
				    	<sj:submit button="true" value="Guardar"/>
				    </td>
		        	<td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
				 </tr>
		</table>
    </s:form>
	