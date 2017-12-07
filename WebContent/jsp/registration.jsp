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
<div class="container-fluid" id="register">
  <div style="max-width:420px; display:block; margin:auto">
  <h4>Registration Form</h4>
  <p>Hi there, please fill in the following fields to open your account.</p>
  </div>
  <form class="form-horizontal" v-on:submit.prevent="formsubmit" style="max-width:400px; display:block; margin:auto">
    <div class="form-group">
      <label class="control-label" for="email">Enter Your Email:</label>
      <div>
        <input type="email" class="form-control" v-model="email" @keyup="emailcheck()" placeholder="Email" name="email" required autofocus />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label" for="pwd1">Enter Password:</label>
      <div>          
        <input type="password" class="form-control"  v-model="pwd1" placeholder="Password" required name="pwd1">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label" for="pwd2">Reenter Password:</label>
      <div>          
        <input type="password" class="form-control" v-model="pwd2"  placeholder="Password" required name="pwd2">
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
<script src="./js/register.component.js"></script>
</body>
</html>
