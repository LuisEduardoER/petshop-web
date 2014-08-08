<%@ taglib prefix="s" uri="/struts-tags" %>  

<style>
.uk-alert{
	background: rgba(100,184,178,0.1);
	color: #64b8b2;
	padding: 0.5px;
}
</style>

<div class="uk-alert" data-uk-alert="">
	<span class="ui-icon ui-icon-info" style="margin-right: .3em;
margin-top: 18px;
margin-left: 5px;"></span>
    <p><s:property value="message"/> </p>
</div>