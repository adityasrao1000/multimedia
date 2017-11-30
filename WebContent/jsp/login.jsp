<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<%

  String email=(String)session.getAttribute("email");  
  if (email != null) {
	  response.sendRedirect("home");  
  } 
  
  String status="";
  if(request.getAttribute("status")!=null){
	 status = (String)request.getAttribute("status");
  }
  
%>
<%@ include file="libraries.jsp" %>
</head>
<body>
<nav class="navbar">
  <div class="container-fluid">  
    <a class="navbar-brand" href="#">Wallpapers</a>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="register" style="float:right">sign up</a></li>
     
    </ul>
  </div>
</nav>
<br><br><br><br>
<div class="container-fluid">
  <h5 style="color:red; text-align:center"><%=status %></h5>
  <form class="form-horizontal" method="post" action="loginValidation" style="max-width:400px; display:block; margin:auto">
    <div class="form-group">
      <label class="control-label" for="email">Email:</label>
      <div>
        <input type="email" class="form-control"   placeholder="Email" name="email" autofocus />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label" for="pwd">Password:</label>
      <div>          
        <input type="password" class="form-control"   placeholder="Password" name="pwd">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
       
      </div>
    </div>
    <div class="form-group">        
      <div>
        <button type="submit" class="btn btn-default" style="width:70%; display:block; margin:auto">Log In</button>
      </div>
    </div>
    <div style="font-size: .9em">
    <div class="col-xs-6">
    <a>Forgot your password?</a>
    </div>
    <div class="col-xs-6">
    <a href="register">Don't have an account?</a>
    </div>
    </div>
  </form>
</div>

</body>
</html>
