<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<%
String status="";
  if(request.getAttribute("status")!=null){
	  status=(String)request.getAttribute("status");
  }
  String email=(String)session.getAttribute("email");  
  if (email != null) {
	  response.sendRedirect("home");  
  } 
  
  
%>
<%@ include file="libraries.jsp" %>
</head>
<body>
<div id="nav">
  <my-navbar></my-navbar>
</div>
<br><br><br><br>
<div class="container-fluid" id="login">
  <h5 style="color:red; text-align:center"><%= status%></h5>
  <form class="form-horizontal" action="loginValidation" method="post"  style="max-width:400px; display:block; margin:auto">
    <div class="form-group">
      <label class="control-label" for="email">Email:</label>
      <div>
        <input type="email" class="form-control"  placeholder="Email" name="email" autofocus />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label" for="pwd">Password:</label>
      <div>          
        <input type="password"  class="form-control" name="pwd"  placeholder="Password" >
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
<script src="./js/navbar.js"></script>
<script src="./js/login.component.js"></script>
</body>
</html>
