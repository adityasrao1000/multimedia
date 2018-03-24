<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<%

  String email=(String)session.getAttribute("email");  
  if (email != null) {
	  response.sendRedirect("home");  
  } 
  
  
%>
<%@ include file="libraries.jsp" %>
</head>
<body>
<div id="nav">
<%@ include file="/jsp/navbar.jsp" %>
</div>
<div id="login-body">
<br><br><br><br>
<div class="container-fluid" id="login">
  <h5 style="color:red; text-align:center">{{status}}</h5>
  <form class="form-horizontal" @submit.prevent="loginValidate" action="loginValidation" method="post"  style="max-width:400px; display:block; margin:auto">
    <div class="form-group">
      <label class="control-label" for="email">Email:</label>
      <div>
        <input type="email" class="form-control" v-model="email" placeholder="Email" name="email" autofocus required />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label" for="pwd">Password:</label>
      <div>          
        <input type="password"  class="form-control" v-model="pwd" name="pwd"  placeholder="Password" required />
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
       
      </div>
    </div>
    <div class="form-group">        
      <div>
        <button type="submit" class="btn btn-default"  style="width:70%; display:block; color:var(--main-color); background:black; border:none; margin:auto">Log In</button>
      </div>
    </div>
    <div class="row" style="font-size: .9em">
    <div class="col-6">
    <a href="resetpassword">Forgot your password?</a>
    </div>
    <div class="col-6">
    <a href="register">Don't have an account?</a>
    </div>
    </div>
  </form>
  <br><br><br>
</div>
</div>
<div id="footer">
<jsp:include page="${request.getContextPath()}/jsp/footer.jsp"></jsp:include>
</div>
<script src="./js/login.component.js"></script>
<script>
<%@ include file="/js/navbarMVC.jsp" %>
<%@ include file="/js/footerMVC.jsp" %>
</script>
</body>
</html>
