<%@ taglib prefix="s" uri="/struts-tags"%>

<form id="form1">
        
        <h1>Bienvenido</h1>
        <h2>
        	<s:property value="strNameUsuario"/>
        </h2>

<!--         <div class="tm-headerbar uk-text-center uk-clearfix uk-hidden-small"> -->
		<div style="width: 100%; text-align: center; height: 100%; vertical-align: middle;">
                <a class="tm-logo" href="#">
                    <img src="img/PetShop.png" alt="Demo">
                </a>
            </div>
         

        <div class="controls">
            <s:label name="strMessage"/>
        </div>
			
        <br />
    </form>
