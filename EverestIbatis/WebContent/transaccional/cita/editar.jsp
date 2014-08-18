<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/screen.css" />

<s:form>
	
	<table style="width: 100%;">
		<tr>
			<td><label>Desde</label> </td>
			<td>
				<sj:datepicker showOn="focus" 
								displayFormat="dd/mm/yy"
								name="start_date"/>
			</td>
		</tr>
		<tr>
			<td><label>Hasta</label> </td>
			<td>
				<sj:datepicker showOn="focus" 
								displayFormat="dd/mm/yy"
								name="end_date"/> 
			</td>
		</tr>
	</table>
	
		<sj:submit id="idForm28LightboxGuardar"  button="true" value="Guardar" onclick="lightbox.save();" />
		<sj:submit id="idForm28LightboxCancelar" button="true" value="Cancelar" onclick="lightbox.close()" />
	
		<s:hidden id="productoApicola" name="productoApicola"  />
		<s:hidden id="envase" name="envase"  />
		
</s:form>
	
<script>
	var nombres = ["","","Guardar","Cancelar","",""];

	getValues = function () {
		var ev = {};
		var inputs = document.body.getElementsByTagName('input');

		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].type == "button") {
				continue;
			}
			var name = inputs[i].getAttribute('name');
			if (name == "start_date" || name == "end_date"){
				ev[name] = parent.scheduler.templates.api_date(inputs[i].value);
			}
			else{
				ev[name] = inputs[i].value;
			}
		}
		return ev;
	};

	setValues = function (obj) {
		var inputs = document.body.getElementsByTagName('input');
		for (var i = 0; i < inputs.length; i++){
			if (inputs[i].type != "button") {
				var name = inputs[i].getAttribute('name');
				if (name == "start_date" || name == "end_date"){
					inputs[i].value = parent.scheduler.date.date_to_str(parent.scheduler.config.api_date)(obj[name]);
				}else{
					inputs[i].value = nombres[i];
				}
			}
		}
	};


	
</script>






