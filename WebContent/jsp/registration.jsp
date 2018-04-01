<!DOCTYPE html>
<html lang="en">
<head>
<title>Sign up</title>
<%@ include file="libraries.jsp" %>
<link rel="stylesheet" href="css/registration.css">
</head>
<body>
<div id="nav">
<%@ include file="/jsp/navbar.jsp" %>
</div>
<br>
<div class="container-fluid" id="register">
  <form class="form-horizontal" v-on:submit.prevent="formsubmit">
    <h4>Registration Form</h4>
    <p>Hi there, please fill in the following fields to open your account.</p>
    <div class="form-group">
      <label class="control-label" for="email">Enter Your Email:</label>
      <div>
        <input type="email" class="form-control" v-model="email"  @keyup="emailcheck()" placeholder="Email" name="email"  required autofocus />
        <span style="color:red">{{emailStatus}}</span>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label" for="username">Enter a user name:</label>
      <div>
        <input type="text" class="form-control" v-model="username" pattern=".{2,}"  placeholder="User Name" name="username"  required/>        
      </div>
    </div>
    <div class="form-group">
      <label class="control-label" for="pwd1">Enter Password:</label>
      <div>          
        <input type="password" class="form-control" title="6 characters minimum" pattern=".{6,}" v-model="pwd1" placeholder="Password" required name="pwd1">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label" for="pwd2">Reenter Password:</label>
      <div>          
        <input type="password" class="form-control"  title="6 characters minimum" pattern=".{6,}" v-model="pwd2"  placeholder="Password" required name="pwd2">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
       
      </div>
    </div>
    <div class="form-group">        
      <div>
        <button type="submit" class="btn btn-default">Sign up</button>
      </div>
    </div>
    <div style="font-size: .9em; text-align:center">
      Already Registered?<a href="login"> Click Here to login</a>
    </div>
  </form>
</div>
<div id="footer">
<jsp:include page="${request.getContextPath()}/jsp/footer.jsp"></jsp:include>
</div>
<script src="./js/register.component.js"></script>
<script>
<%@ include file="/js/navbarMVC.jsp" %>
<%@ include file="/js/footerMVC.jsp" %>
</script>
</body>
</html>
