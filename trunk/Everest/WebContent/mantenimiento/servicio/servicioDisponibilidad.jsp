<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<link rel="stylesheet" href="css/styleServicio.css" type="text/css" />

<s:form>

<h1>
Disponibilidad de Servicios
</h1>

<fieldset >
	
	<legend> <h2>&nbsp;</h2> </legend>
	
</fieldset>

<div style="width: 100%; height: 300px;">
	
	<sj:div selectable="true" cssClass="selecColumn">
		<s:iterator value="citaListaMonday" status="stat">
			<s:if test="#stat.count == 1">
				<div class="selectable selectableHead"><s:property value="descripcion"/> </div>
			</s:if>
			<s:else>
				<div class="selectable selectableReserved">
					<p class="alignLeft"></p>
 					<p class="alignRight"><s:date name="hourProg" format="hh:mm"/></p>
				</div>
			</s:else>
		</s:iterator>
	</sj:div>
	<sj:div selectable="true" cssClass="selecColumn">
		<s:iterator value="citaListaTuesday" status="stat">
			<s:if test="#stat.count == 1">
				<div class="selectable selectableHead"><s:property value="descripcion"/> </div>
			</s:if>
			<s:else>
				<div class="selectable selectableReserved">
					<p class="alignLeft"><s:date name="hourProg" format="hh:mm"/></p>
 					<p class="alignRight"><s:date name="hourProg" format="hh:mm"/></p>
				</div>
			</s:else>
		</s:iterator>
	</sj:div>
	<sj:div selectable="true" cssClass="selecColumn">
		<s:iterator value="citaListaWednesday" status="stat">
			<s:if test="#stat.count == 1">
				<div class="selectable selectableHead"><s:property value="descripcion"/> </div>
			</s:if>
			<s:else>
				<div class="selectable selectableReserved">
					<p class="alignLeft"><s:date name="hourProg" format="hh:mm"/></p>
 					<p class="alignRight"><s:date name="hourProg" format="hh:mm"/></p>
				</div>
			</s:else>
		</s:iterator>
	</sj:div>
	<sj:div selectable="true" cssClass="selecColumn">
		<s:iterator value="citaListaThursday" status="stat">
			<s:if test="#stat.count == 1">
				<div class="selectable selectableHead"><s:property value="descripcion"/> </div>
			</s:if>
			<s:else>
				<div class="selectable selectableReserved">
					<p class="alignLeft"><s:date name="hourProg" format="hh:mm"/></p>
 					<p class="alignRight"><s:date name="hourProg" format="hh:mm"/></p>
				</div>
			</s:else>
		</s:iterator>
	</sj:div>
	<sj:div selectable="true" cssClass="selecColumn">
		<s:iterator value="citaListaFriday" status="stat">
			<s:if test="#stat.count == 1">
				<div class="selectable selectableHead"><s:property value="descripcion"/> </div>
			</s:if>
			<s:else>
				<div class="selectable selectableReserved">
					<p class="alignLeft"><s:date name="hourProg" format="hh:mm"/></p>
 					<p class="alignRight"><s:date name="hourProg" format="hh:mm"/></p>
				</div>
			</s:else>
		</s:iterator>
	</sj:div>
	<sj:div selectable="true" cssClass="selecColumn">
		<s:iterator value="citaListaSaturday" status="stat">
			<s:if test="#stat.count == 1">
				<div class="selectable selectableHead"><s:property value="descripcion"/> </div>
			</s:if>
			<s:else>
				<div class="selectable selectableReserved">
					<p class="alignLeft"><s:date name="hourProg" format="hh:mm"/></p>
 					<p class="alignRight"><s:date name="hourProg" format="hh:mm"/></p>
				</div>
			</s:else>
		</s:iterator>
	</sj:div>
	<sj:div selectable="true" cssClass="selecColumn">
		<s:iterator value="citaListaSunday" status="stat">
			<s:if test="#stat.count == 1">
				<div class="selectable selectableHead"><s:property value="descripcion"/> </div>
			</s:if>
			<s:else>
				<div class="selectable selectableReserved">
					<p class="alignLeft"><s:date name="hourProg" format="hh:mm"/> </p>
 					<p class="alignRight"><s:date name="hourProg" format="hh:mm"/></p>
				</div>
			</s:else>
		</s:iterator>
	</sj:div>
	
	<br>
	<sj:div cssStyle="width: 100%; float: left;">
		<div class="selectable selectableHead"></div>
		<div class="selectable selectableHead">Lunes</div>
		<div class="selectable selectableHead">Martes</div>
		<div class="selectable selectableHead">Miercoles</div>
		<div class="selectable selectableHead">Jueves</div>
		<div class="selectable selectableHead">Viernes</div>
		<div class="selectable selectableHead">Sabado</div>
		<div class="selectable selectableHead">Domingo</div>
	</sj:div>
	
	<sj:div selectable="true" cssClass="selecColumn">
		<s:iterator value="{1,2,3,4,5,6,7,8}" var="obj">
			<p class="selectable divHour">
				<s:property value="#obj"/>
			</p>
	 	</s:iterator>
	</sj:div>
	
</div>

</s:form>
