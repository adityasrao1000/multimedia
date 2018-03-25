<!DOCTYPE html>
<html>
<head>

<%@ include file="libraries.jsp" %>
<link rel="stylesheet" href="css/usersettings.css">
<title>Settings</title>
</head>
<body>
<div id="nav">
<%@ include file="/jsp/navbar.jsp" %>
</div>
<div id="usersettings">
<div class="container-fluid" id="usersettings">
<br>
<br>
<div class="row">
  <div class="col-sm-5">
	 <div id="accordion">
	
	  <div class="card">
	    <div class="card-header">
	      <a class="card-link" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
	        <b>change you password <i class="fa fa-key" aria-hidden="true"></i></b>
	      </a>
	    </div>
	    <div id="collapseOne" class="collapse">
	      <div class="card-body">
	        <input type="text" placeholder="enter your old password" class="form-control"  v-model="oldpwd" name="oldpwd" id="oldpwd" required>
	        <br>
	        <input type="text" placeholder="enter your new password" class="form-control"  v-model="newpwd1" name="newpwd1" id="newpwd1" required>
	        <br>
	        <input type="text" placeholder="re-enter your new password" class="form-control" v-model="newpwd2" name="newpwd2" id="newpwd2" required>
	        <br>
	        <button  type="button" @click="changePassword" style="background-color:black; color:#E91E63;"  class="btn btn-sm" id="submitbtn" >Change</button>
	      </div>
	    </div>
	  </div>
	
	  <div class="card">
	    <div class="card-header">
	      <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
	       <b>change your username</b>
	      </a>
	    </div>
	    <div id="collapseTwo" class="collapse">
	      <div class="card-body">
	        <input type="text" placeholder="enter your username" class="form-control"  v-model="username" name="username" id="username" required>
	        <p></p>
	        <button  type="button" @click="" style="background-color:black; color:var(--main-color);"  class="btn btn-sm" id="submitbtn" >Change</button>
	      </div>
	    </div>
	  </div>
	
	  <div class="card">
	    <div class="card-header">
	      <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
	       <b>change you profile picture</b>
	      </a>
	    </div>
	    <div id="collapseThree" class="collapse">
	      <div class="card-body">
	        Lorem ipsum..
	      </div>
	    </div>
	  </div>
	
	</div>
  </div>
  <div class="col-sm-7">
    
  </div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</div>
</div>
<div id="footer">
<jsp:include page="${request.getContextPath()}/jsp/footer.jsp"></jsp:include>
</div>
<script src="./js/usersettings.component.js"></script>
<script>
<%@ include file="/js/navbarMVC.jsp" %>
<%@ include file="/js/footerMVC.jsp" %>
</script>
</body>
</html>