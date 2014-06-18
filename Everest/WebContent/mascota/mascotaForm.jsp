<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>



<h1>
   <s:if test="mascota==null || mascota.idProveedor == null">
	 <s:text name="Agregar Mascota"/>
	 <s:hidden id="oper" name="oper" value="add"/>
   </s:if>
   <s:else>
	 <s:text name="Editar Mascota"/>
	 <s:hidden id="oper" name="oper" value="edit"/>
   </s:else>
</h1>
	 <table>
		<tr><td align="left" style="font:bold;color:red"> 
	            <s:fielderror/> 	 	
                <s:actionerror/>
                <s:actionmessage/>
             </td>
        </tr>
     </table>
     		 	
    <s:form enctype="multipart/form-data" method="post">
    <s:hidden name="mascota.idMascota"/>
    <s:hidden name="cliente.idCliente"/>

    
     <table align="center" class="borderAll">
     	 
     	 
     	 <tr>
         	<td class="tdLabel">&nbsp;</td>
         	<td>
         		<img alt="Imagen no disponible" style="max-height: 200px; max-width: 200px;" 
					src="cargaImagenAction?idMascota=<s:property value="mascota.idMascota"/>">
			</td>
         </tr>
         <tr>
         	<td class="tdLabel">&nbsp;</td>
         	<td>
				<s:file name="mascota.foto"></s:file>
			</td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Nombre"/></td>
         	<td><s:textfield name="mascota.nombre" size="30"/></td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Edad"/></td>
         	<td>
<%--          	<s:textfield name="mascota.edad" size="30"/> --%>
<%--          	<sj:spinner name="mascota.edad" --%>
<%-- 				        showOn="always" --%>
<%-- 				        min="0" --%>
<%-- 				        max="10" --%>
<%-- 				        step="1"/> --%>
			<label style="float: left;" id="displayvaluespan" for="echo"><s:property value="mascota.edad"/></label>
<!-- 			displayValueElement="displayvaluespan" -->
        	<sj:slider 
				id="echo" 
				name="mascota.edad"
				displayValueElement="displayvaluespan"
				value="0"
				label="5" 
				min="0" 
				max="10" 
				step="1"
				animate="true"
				cssStyle="margin-left: 25px; margin-top: 5px;"
			/>
			
         	</td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Raza"/></td>
         	<td><s:textfield name="mascota.raza" size="30"/></td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Sexo"/></td>
         	<td>
	         	<s:select 
			       name="mascota.sexo"			       
			       headerKey="" headerValue="-- Seleccione --"
			       list="#{'M':'Macho', 'H':'Hembra'}"
			       value="mascota.sexo"
			       required="true"
				/>
			</td>
         </tr>
    </table>
    		 <br/>
    <table> 
    	     <tr>
    		    <td><s:submit action="insertarOActualizarMascota" key="button.label.submit" cssClass="butStnd"/></td>
    	        <td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
    		 </tr>
    </table> 		  		 
    	</s:form>

