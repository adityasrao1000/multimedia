<!DOCTYPE html>
<html>
<head>

<%@ include file="libraries.jsp" %>
<link rel="stylesheet" href="css/usersettings.css">
</head>
<body>
<div id="index">
<div id="nav">
  <my-navbar></my-navbar>
</div>
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
	        <input type="text" placeholder="enter your old password" class="form-control"  name="oldpwd" id="oldpwd" required>
	        <br>
	        <input type="text" placeholder="enter your new password" class="form-control"  name="newpwd" id="newpwd" required>
	        <br>
	        <input type="text" placeholder="re-enter your new password" class="form-control"  name="newpwd1" id="newpwd1" required>
	        <br>
	        <button  type="button" @click="submitform()" style="background-color:black; color:white"  class="btn btn-sm" id="submitbtn" >Change</button>
	      </div>
	    </div>
	  </div>
	
	  <div class="card">
	    <div class="card-header">
	      <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
	        change your username
	      </a>
	    </div>
	    <div id="collapseTwo" class="collapse">
	      <div class="card-body">
	        Lorem ipsum..
	      </div>
	    </div>
	  </div>
	
	  <div class="card">
	    <div class="card-header">
	      <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
	        change you profile picture
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
<my-footer></my-footer>
</div>
<script src="./js/navbar.js"></script>
<script src="./js/footer.component.js"></script>

</body>
</html>