<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<style type="text/css">
#my_camera video{
	width: 200px;
	height: 200px;
}
#stefanvdlightareoff1{
	z-index: -999 !important;
	background: transparent !important;
}
.myTable td{
	padding: 5px;
	vertical-align: top;
}
.myTable img{
	width: 200px;
	height: 150px;
}
.tdCam{
	width: 200px;
	text-align: center;
}
.tdGallery{
	padding-top: 25px !important;
}
</style>

<script type="text/javascript" src="js/webcam.js"></script>

	<h1>
	<s:if test="oper=='add'">
		Agregar 
	</s:if>
	<s:if test="oper=='edit'">
		Editar
	</s:if>
	 Mascota
	</h1>
	
	 <table>
		<tr><td align="left" style="font:bold;color:red"> 
	            <s:fielderror/> 	 	
                <s:actionerror/>
                <s:actionmessage/>
             </td>
        </tr>
     </table>
     		 	
<s:form id="frm01" action="saveMascotaForm" enctype="multipart/form-data" method="post">
    <s:hidden name="mascota.idMascota"/>
    <s:hidden name="cliente.idCliente" value="%{cliente.idCliente}"/>
    <s:hidden name="oper"/>

	<fieldset>
		<legend>
			<h2>Foto</h2> 
		</legend>
		
		<table class="myTable" style="width: 100%;" cellpadding="0" cellspacing="0">
			<tr>
				<td class="tdCam">
					
					<div id="my_camera" style="overflow: hidden; width: 200px; height: 200px;"></div>
					
					<sj:a button="true" buttonIcon="ui-icon-arrow-4-diag" onclick="take_snapshot()">
						Capturar
					</sj:a>
<!-- 					<button class="btn btn-primary" type="button" > -->
<!--                      	<img src="img/camara.png"/> -->
<!--                      </button> -->
				</td>
				<td class="tdGallery">
					
					<s:if test="oper=='add'">
	         			<img id="imgFoto1"/>
	         			<img id="imgFoto2"/>
	         			<img id="imgFoto3"/>
	         			<img id="imgFoto4"/>
	         		</s:if>
	         		<s:if test="oper=='edit'">
		         		<img id="imgFoto1"
		         			src="cargaImagenAction?idMascota=<s:property value="mascota.idMascota"/>&img=1">
		         		<img id="imgFoto2"
		         			src="cargaImagenAction?idMascota=<s:property value="mascota.idMascota"/>&img=2">
		         		<img id="imgFoto3"
		         			src="cargaImagenAction?idMascota=<s:property value="mascota.idMascota"/>&img=3">
		         		<img id="imgFoto4"
		         			src="cargaImagenAction?idMascota=<s:property value="mascota.idMascota"/>&img=4">
					</s:if>
					
					<s:hidden id="hdnImg1" name="mascota.fotoContentType1"/>
					<s:hidden id="hdnImg2" name="mascota.fotoContentType2"/>
					<s:hidden id="hdnImg3" name="mascota.fotoContentType3"/>
					<s:hidden id="hdnImg4" name="mascota.fotoContentType4"/>
					
				</td>
			</tr>
		</table>
		
	</fieldset>
    
     <table align="center" class="borderAll">
     	 <tr>
     	 	<td class="tdLabel"><s:text name="Nombre"/></td>
		 	<td class="tdLabel"><s:text name="Tipo Animal"/></td>
		 	<td class="tdLabel"><s:text name="Raza"/></td>
		 </tr>
         <tr>
         	<td><s:textfield name="mascota.nombre" size="20"/></td>
         	<td>
		 		<s:select list="tipoAnimalLista"
		 				listKey="idTipoAnimal"
		 				listValue="descripcion"
		 				name="mascota.idTipoAnimal"		 				
		 		/>
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
         		<sj:datepicker
         			name="mascota.fecNac" 
         			size="20" 
         			showOn="focus" 
         			displayFormat="dd/mm/yy" 
         			changeMonth="true" 
         			changeYear="true"/>
         	</td>
         	<td>
				<sj:spinner 
					size="20"
			    	name="mascota.edad"
			    	value="mascota.edad"  
			    	min="0" 
			    	max="20" 
			    	step="1" />
         	</td>
         </tr>
         <tr>
		 	<td class="tdLabel"><s:text name="Pedigree"/></td>
		 	<td class="tdLabel"><s:text name="Esterilizacion"/></td>
		 </tr>
		 <tr>
		 	<td>
		 		<sj:radio name="mascota.pedigree" list="#{'1':'Si', '2':'No'}"/>
		 	</td>
		 	<td>
		 		<sj:radio name="mascota.esterilizacion" list="#{'1':'Si', '2':'No'}"/>
		 	</td>
		 </tr>
		 <tr>
		 	<td class="tdLabel"><s:text name="Alergias"/></td>
		 	<td class="tdLabel"><s:text name="Observaciones"/></td>
		 </tr>
		 <tr>
		 	<td>
		 		<s:textarea name="mascota.alergia" cols="20" rows="2"/>
		 	</td>
		 	<td>
		 		<s:textarea name="mascota.observaciones" cols="20" rows="2"/>
		 	</td>
		 </tr>
    </table>
    <s:if test="oper!='view'">    		 
    <table> 
    	     <tr>
    		    <td><sj:submit 
    		    	type="button" 
    		    	button="true"
    		    	formIds="frm01"
    		    	buttonIcon="ui-icon-disk">Guardar</sj:submit>
    		    </td>
    		 </tr>
    </table>
    </s:if>
<input id="hdnFotoCount" type="hidden" value="1">	  		 
</s:form>
<script>
$(function() {
	$("#tone").show();
	$("#ttwo").hide();
});
</script>
<script type="text/javascript">
    function registrarMascota(){
		document.getElementById("idForm").action = 'saveMascota';
		alert('Mascota registrada');
		return true;
} 
    </script>
  <script>
Webcam.set({
    image_format: 'jpeg',
    jpeg_quality: 90
  });
  Webcam.attach('#my_camera');	
  </script>  
  <script>  
Webcam.set({
    image_format: 'jpeg',
    jpeg_quality: 90
  });
  Webcam.attach('#my_camera');	
  </script>
  <script type="text/javascript">  
      function take_snapshot() {
    	  var data_uri = Webcam.snap();
    	  //alert(data_uri);
    	  
    	  var count = $("#hdnFotoCount").val();
    	  if(count > 4) count=1;
    	  
          document.getElementById('imgFoto'+count).src = data_uri;
          document.getElementById('hdnImg'+count).value = data_uri;
          count++;
          $("#hdnFotoCount").val( count );
      }
 </script>
 
 