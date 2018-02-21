<!DOCTYPE html>
<html lang="en">
<head>
<title>Change Password</title>
<%@ include file="libraries.jsp" %>

</head>
<body>
<div id="nav">
  <my-navbar></my-navbar>
</div>
<br><br><br><br>
<div class="container-fluid" id="resetpassword">
  <div class="row">
    <div class="col-sm-4">
    
    </div>
    <div class="col-sm-4">
      <div>
        <div class="form-group">
	      <label class="control-label" for="email">Enter your Email:</label>
	      <div>
	        <input type="email" class="form-control" v-model="email" placeholder="Email" name="email" autofocus required />
	      </div>
	    </div>
	    <div class="form-group">        
      <div>
        <button type="submit" @click="generateotp" class="btn btn-default"  style="width:60%; display:block; color:#E91E63; background:#212121; border:none; margin:auto">generate otp</button>
      </div>
    </div>
      </div>
    </div>
    <div class="col-sm-4">
    
    </div>
  </div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

<div id="footer">
<my-footer></my-footer>
</div>
<script src="./js/navbar.js"></script>
<script src="./js/footer.component.js"></script>
<script src="./js/resetpassword.component.js"></script>
</body>
</html>
