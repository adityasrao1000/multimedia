<nav class="navbar navbar-expand-sm navbar-light bg-faded">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#nav-content" aria-controls="nav-content" aria-expanded="false" aria-label="Toggle navigation">
	<span class="navbar-toggler-icon"></span>
	</button>
	
	<!-- Brand -->
	<a class="navbar-brand" >Wallpapers</a>
	
	<!-- Links -->
	<div class="collapse navbar-collapse" id="nav-content">   
	<ul class="navbar-nav">
	  <li class="nav-item"><a class="nav-link" v-bind:href="home">Home</a></li>
	  <li class="nav-item"><a class="nav-link" v-bind:href="images">Browse</a></li>
	</ul>
	<ul class="navbar-nav ml-auto">
	<li class="nav-item dropdown" id="logout">
	<button class="nav-link dropdown-toggle"  data-toggle="dropdown" id="Preview" role="button" aria-haspopup="true" aria-expanded="false">
	  <img id="profile" class="img-fluid" style="max-width:30px; max-height:30px; margin-left:4px;"> account 
	</button>
	<div class="dropdown-menu" style="margin-left:-15px;" aria-labelledby="Preview">
	    <a class="dropdown-item" style="color: var(--main-color)" href="<%= request.getContextPath() %>/profile">profile <i class="fa fa-address-book-o" aria-hidden="true"></i></a>
        <a class="dropdown-item" style="color: var(--main-color)" href="<%= request.getContextPath() %>/usersettings">settings <i class="fa fa-cog fa-spin  fa-fw"></i></a>
        <a class="dropdown-item" style="color: var(--main-color)" href="<%= request.getContextPath() %>/logout">logout <i class="fa fa-sign-out"></i></a>
	</div>
	</li>
	<li class="nav-item" id="signup">
	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
	  <div class="btn-group" role="group">
	    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      login
	    </button>
	    <div class="dropdown-menu" style="padding:6px;" aria-labelledby="btnGroupDrop1">
	      <div class="form-group">
			  <label for="usr">Name:</label>
			  <input type="text" v-model="email" class="form-control-sm" style="width:100%" id="nav-login-usr">
		  </div>
		  <div class="form-group">
			  <label for="pwd">Password:</label>
			  <input type="password" v-model="pwd" class="form-control-sm" style="width:100%" id="nav-login-pwd">
		  </div>
		  <button @click="loginValidate" type="submit" class="btn btn-default btn-sm"  style="width:70%; display:block; color:#E91E63; background:#212121; border:none; margin:auto">Log In</button>
	
	      <a style="font-size:.75em;display:flex; justify-content:center;margin-top:10px;" href="<%= request.getContextPath() %>/resetpassword">Forgot your password?</a>
	    </div>
	  </div>
	  <button type="button" class="btn btn-secondary" onclick="window.location='register'">sign up</button>
	</div>
	</li>
	</ul>
</div>
</nav>
<div id="incorrect-password" class="alert alert-danger alert-dismissible fade hide">
    <button type="button" class="close" @click="dismiss">&times;</button>
    <strong>Incorrect username or password.</strong>
</div>