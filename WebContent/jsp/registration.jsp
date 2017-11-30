<!DOCTYPE html>
<html lang="en">
<head>
<title>Sign up</title>

<%@ include file="libraries.jsp" %>
</head>
<body>
<nav class="navbar">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Wallpapers</a>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="register"  style="float:right">login</a></li>
     
    </ul>
  </div>
</nav>
<br><br><br><br>
<div class="container-fluid">
  <div style="max-width:420px; display:block; margin:auto">
  <h4>Registration Form</h4>
  <p>Hi there, please fill in the following fields to open your account.</p>
  </div>
  <form class="form-horizontal" method="post" action="loginValidation" style="max-width:400px; display:block; margin:auto">
    <div class="form-group">
      <label class="control-label" for="email">Enter Your Email:</label>
      <div>
        <input type="email" class="form-control"   placeholder="Email" name="email" autofocus />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label" for="pwd">Enter Password:</label>
      <div>          
        <input type="password" class="form-control"   placeholder="Password" name="pwd1">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label" for="pwd">Reenter Password:</label>
      <div>          
        <input type="password" class="form-control"   placeholder="Password" name="pwd2">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
       
      </div>
    </div>
    <div class="form-group">        
      <div>
        <button type="submit" class="btn btn-default" style="width:70%; display:block; margin:auto">Sign up</button>
      </div>
    </div>
    <div style="font-size: .9em; text-align:center">
    Already Registered?<a href="login"> Click Here to login</a>
    </div>
  </form>
</div>

</body>
</html>
