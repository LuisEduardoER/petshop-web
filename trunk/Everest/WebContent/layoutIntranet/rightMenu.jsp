<%@ taglib prefix="s" uri="/struts-tags"%>

<aside class="tm-sidebar-a uk-width-medium-1-4">
	<div class="uk-panel uk-panel-box uk-panel-box-primary">
		<h3 class="uk-panel-title">Opciones</h3>
		<ul class="uk-nav uk-nav-parent-icon uk-nav-side" data-uk-nav="{}">
		
		<s:iterator value="listaParentOpcion" var="parentOpcion" status="stat">
			<li class="uk-nav-header"><s:property value="#parentOpcion.titulo"/></li>
			<li class="uk-nav-header"><s:property value="stat.titulo"/></li>
			<li class="uk-nav-header"><s:property value="stat.titulo"/></li>
		</s:iterator>
		
		</ul>
	</div>
</aside>
