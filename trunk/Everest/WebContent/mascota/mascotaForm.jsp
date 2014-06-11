<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
     		 	
    <s:form>
    <s:hidden name="mascota.idMascota"/>
     <table align="center" class="borderAll">
         <tr>
         	<td class="tdLabel"><s:text name="Nombre"/></td>
         	<td><s:textfield name="mascota.nombre" size="30"/></td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Edad"/></td>
         	<td><s:textfield name="mascota.edad" size="30"/></td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Raza"/></td>
         	<td><s:textfield name="mascota.raza" size="30"/></td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Sexo"/></td>
         	<td><s:textfield name="mascota.sexo" size="30"/></td>
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
