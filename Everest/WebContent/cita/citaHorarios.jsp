<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<style>
.selectable {
border:1px solid #F1F1F1;
float:left;
height:20px;
margin:1px;
padding:5px;
width:85px;
}
.selectableHead{
height: 20px;
background: #61B4C8;
color: white;
}
.divHour{
background: white !important;
color: black !important;
}

.selectablelist {
border:1px solid #000;
height:25px;
margin:5px;
padding:10px;
list-style-type: none;
}

.ui-selected {
background:#47A7BF;
color:#FFF;
}

.ui-selecting {
background:#61B4C8;
color: white;
}
</style>

<script type="text/javascript">
	$.subscribe('onstop', function(event,data) {
        var result = $("#selectresult").empty();
        
        $(".ui-selected").each(function(){
        	
        	var className= $(this).attr("class").indexOf("divHour");
                  	
            if(className == -1)
            	result.append($(this).html()+' ');
        });
	});
    </script> 

<table style="width: 100%;">
	<tr>
		<td style="width: 100%;">
			
			<table style="width: 800px;">
				<tr>
					<td style="width: 90px;">
						<sj:a button="true"
							buttonIcon="ui-icon-seek-prev">Anterior</sj:a>
					</td>
					<td>
						Turno
						<select>
							<option>Mañana</option>
							<option>Tarde</option>
						</select>
					</td>
					<td style="text-align: right;">
						<sj:a button="true"
							buttonIcon="ui-icon-seek-next">Siguiente</sj:a>
					</td>
				</tr>
			</table>
			
		</td>
	</tr>
	<tr>
		<td style="width: 100%;">
					    
		    <sj:div cssStyle="width: 800px; float: left; border-right: 1px dotted #FECA40">
		    	
		    	<div class="selectable selectableHead">&nbsp;</div>
		        <div class="selectable selectableHead">Lunes</div>
		        <div class="selectable selectableHead">Martes</div>
		        <div class="selectable selectableHead">Miercoles</div>
		        <div class="selectable selectableHead">Jueves</div>
		        <div class="selectable selectableHead">Viernes</div>
		        <div class="selectable selectableHead">Sabado</div>
		        <div class="selectable selectableHead">Domingo</div>
		    </sj:div>
		     
		    <sj:div id="selectabledivs" 
		    	selectableOnStopTopics="onstop" 
		    	selectable="true"
		    	cssStyle="width: 800px; float: left; border-right: 1px dotted #FECA40">
		    	
		    	<div class="selectable divHour">9:00</div>
		        <div id="one" class="selectable">Uno</div>
		        <div id="two" class="selectable">Dos</div>
		        <div id="three" class="selectable">Tres</div>
		        <div id="four" class="selectable">Cuatro</div>
		        <div id="five" class="selectable">Cinco</div>
		        <div id="six" class="selectable">Seis</div>
		        <div id="seven" class="selectable">Seven</div>
		        
		        <div class="selectable divHour">9:30</div>
		        <div id="eigth" class="selectable">eigth</div>
		        <div id="nine" class="selectable">nine</div>
		        <div id="ten" class="selectable">ten</div>
		        <div id="eleven" class="selectable">eleven</div>
		    </sj:div>
			
			Tu Seleccionaste:  <strong><span id="selectresult"></span></strong>. <br/>
			
			<br>
					     
		</td>
	</tr>
</table>
