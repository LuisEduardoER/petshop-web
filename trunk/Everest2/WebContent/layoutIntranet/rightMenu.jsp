<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<aside class="tm-sidebar-a uk-width-medium-1-4">
	<div class="uk-panel uk-panel-box uk-panel-box-primary">
		<h3 class="uk-panel-title">Opciones</h3>
		<ul class="uk-nav uk-nav-parent-icon uk-nav-side" data-uk-nav="{}">
		
		<s:iterator value="listaOpcion" var="objOpcion" status="stat">
			
			<s:if test="#objOpcion.opcion == null">
		      <li class="uk-nav-header"><s:property value="#objOpcion.titulo"/></li>
		    </s:if>
		    <s:else>
		      <li><a href="<s:property value="#objOpcion.url"/>"><s:property value="#objOpcion.titulo"/></a></li>
		    </s:else>
    
		</s:iterator>
		
		</ul>
	</div>
</aside>