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
	$(function() {
		$("#dlgForm").dialog('option', 'width', 'auto');
		$.subscribe('tabchange', function(event, data) {
// 			alert("tone: "+$("#tone").css("display") +"\n"+
// 				  "ttwo: "+$("#ttwo").css("display") );
			
			if( $("#tone").css("display") == "none"){
				$("#tone").show();
				$("#ttwo").hide();
			}
			else if( $("#ttwo").css("display") == "none"){
				$("#tone").hide();
				$("#ttwo").show();
			}
			return false;
		});
	});
</script>

	<s:if test="oper=='edit'">
		<script type="text/javascript">
			$(function() {
				$("#dlgForm").dialog('option', 'title', 'Editar Mascota');
			});
		</script>
	</s:if>
	<s:if test="oper=='add'">
		<script type="text/javascript">
			$(function() {
				$("#dlgForm").dialog('option', 'title', 'Agregar Mascota');
			});
		</script> 
	</s:if>

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

    
    <sj:tabbedpanel id="tab" onChangeTopics="tabchange">
<%--       <sj:tab id="tab1" href="%{remoteurl1}" label="Tab One" /> --%>
<%--       <sj:tab id="tab2" href="%{remoteurl2}" label="Tab Two"/> --%>
      
      <sj:tab id="tab1" target="tone" label="Imagen"/>
      <sj:tab id="tab2" target="ttwo" label="Tomar Foto"/>
      
      <div id="tone">
      
      	<table cellspacing="0" cellpadding="0" style="width:100%; text-align: center;">
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
      	</table>
      	
      </div>
      <div id="ttwo" style="display:none;">
      	<table cellspacing="0" cellpadding="0" style="width:450px; text-align: center; height: 143px;">
      		<tr>
      			<td style="width: 120px;"></td>
      			<td style="width: 210px; height: 100%; background-color: black;">
      			</td>
      			<td style="width: 120px;">
   					<sj:a button="true" buttonIcon="ui-icon-image">Capturar</sj:a>
   					<sj:a button="true" buttonIcon="ui-icon-image">Descartar</sj:a>
      			</td>
      		</tr>
      	</table>
      </div>
      
    </sj:tabbedpanel>
    
     <table align="center" class="borderAll">
     	 <tr>
     	 	<td class="tdLabel"><s:text name="Nombre"/></td>
		 	<td class="tdLabel"><s:text name="Tipo Animal"/></td>
		 	<td class="tdLabel"><s:text name="Raza"/></td>
		 </tr>
         <tr>
         	<td><s:textfield name="mascota.nombre" size="20"/></td>
         	<td>
		 		<s:select list="#{'':'-- Seleccione --','1':'Perro','2':'Gato'}">
		 		</s:select>
		 	</td>      
      		<td><s:textfield name="mascota.raza" size="20"/></td>
         </tr>
         <tr>
         	<td class="tdLabel"><s:text name="Sexo"/></td>
         	<td class="tdLabel"><s:text name="Fec. Nac."/></td>
         	<td class="tdLabel"><s:text name="Edad"/></td>
         </tr>
         <tr>
         	<td>
	         	<s:select 
			       name="mascota.sexo"
			       headerKey="" headerValue="-- Seleccione --"
			       list="#{'M':'Macho', 'H':'Hembra'}"
			       value="mascota.sexo"
			       required="true"
				/>
			</td>
         	<td>
         		<sj:datepicker size="20" showOn="focus" displayFormat="dd/MM/yy" changeMonth="true" changeYear="true"/>
         	</td>
         	<td>
				<sj:spinner 
					size="20"
			    	name="mascota.edad" 
			    	min="0" 
			    	max="20" 
			    	step="1" 
			    	value="0"/>
         	</td>
         </tr>
         <tr>
		 	<td class="tdLabel"><s:text name="Pedigree"/></td>
		 	<td class="tdLabel"><s:text name="Esterilizacion"/></td>
		 </tr>
		 <tr>
		 	<td>
		 		<sj:radio name="pedigree" list="{'Si', 'No'}"/>
		 	</td>
		 	<td>
		 		<sj:radio name="esterilizacion" list="{'Si', 'No'}"/>
		 	</td>
		 </tr>
		 <tr>
		 	<td class="tdLabel"><s:text name="Alergias"/></td>
		 	<td class="tdLabel"><s:text name="Observaciones"/></td>
		 </tr>
		 <tr>
		 	<td>
		 		<s:textarea cols="20" rows="2"/>
		 	</td>
		 	<td>
		 		<s:textarea cols="20" rows="2"/>
		 	</td>
		 </tr>
    </table>
    <s:if test="oper!='view'">    		 
    <table> 
    	     <tr>
    		    <td><sj:submit 
    		    	action="insertarOActualizarMascota"
    		    	type="button" 
    		    	button="true" 
    		    	buttonIcon="ui-icon-disk">Guardar</sj:submit>
    		    </td>
    		 </tr>
    </table>
    </s:if>
     		  		 
</s:form>
<script>
$(function() {
	$("#tone").show();
	$("#ttwo").hide();
});
</script>
