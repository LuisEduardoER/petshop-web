<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<aside class="tm-sidebar-a uk-width-medium-1-4">
	<div class="uk-panel uk-panel-box uk-panel-box-primary">
<!-- 		<h3 class="uk-panel-title">Opciones</h3> -->
		<ul class="uk-nav uk-nav-parent-icon uk-nav-side" data-uk-nav="{}">
	
	<s:iterator value="listaOpcion" var="parent" status="stat">
		<s:if test="#stat.count==1">
			 <sj:accordion cssClass="accOptions"
				    	autoHeight="true"
				    	collapsible="true"
					>
				<s:if test="#parent.opcions.size != 0">
					<sj:accordionItem title="%{#parent.titulo}">
						<ul>
							<s:iterator value="%{#parent.opcions}" var="child">
								<li><a href="<s:property value="#child.url"/>"><s:property value="#child.titulo"/></a></li>
							</s:iterator>
						</ul>	
					</sj:accordionItem>
				</s:if>
			</sj:accordion>
		</s:if>
		<s:else>
			<sj:accordion cssClass="accOptions"
				    	autoHeight="true"
				    	collapsible="true"
				    	active="false"
					>
				<s:if test="#parent.opcions.size != 0">
					<sj:accordionItem title="%{#parent.titulo}">
						<ul>
							<s:iterator value="%{#parent.opcions}" var="child">
								<li><a href="<s:property value="#child.url"/>"><s:property value="#child.titulo"/></a></li>
							</s:iterator>
						</ul>	
					</sj:accordionItem>
				</s:if>
			</sj:accordion>
		</s:else>
					
					
		</s:iterator>
		</ul>
	</div>
	
</aside>
<script type="text/javascript">
  $(function() {
	  var icons = {
			  header: "ui-icon-circle-arrow-e",
			  activeHeader: "ui-icon-circle-arrow-s"
		};
    $( ".accOptions" ).accordion( "option", "icons", null );
//     $( "#accOptions" ).accordion({
//         icons: icons
//       });
  });
  </script>