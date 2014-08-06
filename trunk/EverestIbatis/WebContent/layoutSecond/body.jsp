<%@ taglib prefix="s" uri="/struts-tags"%>

<ul class="uk-breadcrumb"><li><a href="/demo/themes/joomla/2014/everest/">Home</a></li><li><a href="/demo/themes/joomla/2014/everest/index.php/joomla">Joomla</a></li><li class="uk-active"><span>Login</span></li></ul>                    
                    
<div class="login ">
		<div class="page-header">
		<h1>
			Login		</h1>
	</div>
	
	
							
		
	
	<form action="/demo/themes/joomla/2014/everest/index.php/joomla/login?task=user.login" method="post" class="form-horizontal">

		<fieldset class="well">
												<div class="control-group">
						<div class="control-label">
							<label id="username-lbl" for="username" class=" required">User Name<span class="star">&#160;*</span></label>						</div>
						<div class="controls">
							<input type="text" name="username" id="username" value="" class="validate-username" size="25" required aria-required="true" />						</div>
					</div>
																<div class="control-group">
						<div class="control-label">
							<label id="password-lbl" for="password" class=" required">Password<span class="star">&#160;*</span></label>						</div>
						<div class="controls">
							<input type="password" name="password" id="password" value="" class="validate-password" size="25" maxlength="99" required aria-required="true" />						</div>
					</div>
							
			
			
						<div  class="control-group">
				<div class="control-label"><label>Remember me</label></div>
				<div class="controls"><input id="remember" type="checkbox" name="remember" class="inputbox" value="yes"/></div>
			</div>
			
			<div class="controls">
				<button type="submit" class="btn btn-primary">
					Log in				</button>
			</div>

			<input type="hidden" name="return" value="aW5kZXgucGhwP29wdGlvbj1jb21fdXNlcnMmdmlldz1wcm9maWxl" />
			<input type="hidden" name="2a16fa24e8c340cf9cb0fd4e6801148e" value="1" />		</fieldset>
	</form>
</div>
<div>
	<ul class="nav nav-tabs nav-stacked">
		<li>
			<a href="/demo/themes/joomla/2014/everest/index.php/joomla/login?view=reset">
			Forgot your password?</a>
		</li>
		<li>
			<a href="/demo/themes/joomla/2014/everest/index.php/joomla/login?view=remind">
			Forgot your username?</a>
		</li>
			</ul>
</div>
