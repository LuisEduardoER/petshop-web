<%@ taglib prefix="s" uri="/struts-tags"%>

<ul class="uk-breadcrumb">
	<li><a href="welcome">Home</a></li>
	<li class="uk-active"><span>Login</span></li>
</ul>                    
                    
<div class="login ">
	<div class="page-header">
		<h1>Login</h1>
	</div>
	
	<form action="validarUsuario" method="post" class="form-horizontal">

		<fieldset class="well">
			<div class="control-group">
				<div class="control-label">
					<label id="username-lbl" for="username" class=" required">User Name<span class="star">&#160;*</span></label>
				</div>
				<div class="controls">
					<!-- <input type="text" name="username" id="username" value="" class="validate-username" size="25" required aria-required="true" /> -->
					<s:textfield name="usuario.user" size="30"/>
				</div>
			</div>
			<div class="control-group">
				<div class="control-label">
					<label id="password-lbl" for="password" class=" required">Password<span class="star">&#160;*</span></label>
				</div>
				<div class="controls">
					<!-- <input type="password" name="password" id="password" value="" class="validate-password" size="25" maxlength="99" required aria-required="true" /> -->
					<s:password name="usuario.pass" size="30"/>
				</div>
			</div>
			<div class="controls">
				<!-- <button type="submit" class="btn btn-primary">Log in</button> -->
				<s:label cssStyle="color: red;" name="strMessage"/>
			</div>
			<div class="controls">
				<!-- <button type="submit" class="btn btn-primary">Log in</button> -->
				<s:submit key="Log in" cssClass="btn btn-primary"/>
			</div>

		</fieldset>
	</form>
</div>
<div>
	<ul class="nav nav-tabs nav-stacked">
		<li>
			<a href="#">Forgot your password?</a>
		</li>
		<li>
			<a href="#">Forgot your username?</a>
		</li>
	</ul>
</div>
