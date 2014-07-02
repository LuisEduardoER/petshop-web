<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<script>
  function handleFileSelect(evt) {
    var files = evt.target.files; // FileList object

    // Loop through the FileList and render image files as thumbnails.
    for (var i = 0, f; f = files[i]; i++) {

      // Only process image files.
      if (!f.type.match('image.*')) {
        continue;
      }

      var reader = new FileReader();

      // Closure to capture the file information.
      reader.onload = (function(theFile) {
        return function(e) {          
          document.getElementById('tdImg').innerHTML = ['<img style="max-height: 200px; max-width: 200px;" src="', e.target.result,'" />'].join('');
        };
      })(f);

      // Read in the image file as a data URL.
      reader.readAsDataURL(f);
    }
  }

  document.getElementById('fileFoto').addEventListener('change', handleFileSelect, false);
</script>

<h1>
	<s:if test="oper=='edit'">
		<s:text name="Editar Mascota"/>
	</s:if>
	<s:if test="oper=='add'">
		<s:text name="Agregar Mascota"/> 
	</s:if>

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
         	<td id="tdImg">
         		<s:if test="oper=='add'">
         			<img alt="Imagen no disponible" style="max-height: 200px; max-width: 200px;" 
						src="img/PetShop_Gray.png">
         		</s:if>
         		<s:else>
	         		<img alt="Imagen no disponible" style="max-height: 200px; max-width: 200px;" 
						src="cargaImagenAction?idMascota=<s:property value="mascota.idMascota"/>">
				</s:else>
			</td>
         </tr>
	<s:if test="oper!='view'">
		<tr>
	       	<td class="tdLabel">&nbsp;</td>
	       	<td>
				<s:file id="fileFoto" name="mascota.foto"></s:file>
			</td>
         </tr>
	</s:if>
         <tr>
         	<td class="tdLabel"><s:text name="Nombre"/></td>
      <s:if test="oper=='view'">
         	<td class="tdLabel"><s:text name="mascota.nombre"/></td>
      </s:if>
      <s:else>
      		<td><s:textfield name="mascota.nombre" size="30"/></td>
      </s:else>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Edad"/></td>
         	<td>
        <s:if test="oper=='add'">
        	<label style="float: left;" id="displayvaluespan" for="echo">0</label>
        </s:if>
        <s:else>
        	<label style="float: left;" id="displayvaluespan" for="echo"><s:property value="mascota.edad"/></label>
        </s:else>
			
		<s:if test="oper!='view'">
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
		</s:if>
         	</td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Raza"/></td>
         <s:if test="oper=='view'">
         	<td class="tdLabel"><s:text name="mascota.raza"/></td>
         </s:if>
         <s:else>
         	<td><s:textfield name="mascota.raza" size="30"/></td>
         </s:else>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Sexo"/></td>
         <s:if test="oper=='view'">
         	<td class="tdLabel"><s:text name="mascota.sexo"/></td>
		</s:if>
		<s:else>
			<td>
	         	<s:select 
			       name="mascota.sexo"			       
			       headerKey="" headerValue="-- Seleccione --"
			       list="#{'M':'Macho', 'H':'Hembra'}"
			       value="mascota.sexo"
			       required="true"
				/>
			</td>
		</s:else>
         </tr>
    </table>
    <br/>
    <s:if test="oper!='view'">
    
    		 
    <table> 
    	     <tr>
    		    <td><s:submit action="insertarOActualizarMascota" key="button.label.submit" cssClass="butStnd"/></td>
    	        <td><s:reset key="button.label.cancel" cssClass="butStnd"/></td>
    		 </tr>
    </table>
    </s:if>
     		  		 
    	</s:form>

