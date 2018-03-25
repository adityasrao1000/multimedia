<!DOCTYPE html>
<html lang="en">
<head>
<title>Change Password</title>
<%@ include file="libraries.jsp" %>
<link rel="stylesheet" href="css/resetpassword.css">
</head>
<body>
<div id="nav">
<%@ include file="/jsp/navbar.jsp" %>
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
        <button type="submit" @click="generateotp" class="btn btn-default">generate otp</button>
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
<jsp:include page="${request.getContextPath()}/jsp/footer.jsp"></jsp:include>
</div>
<script src="./js/resetpassword.component.js"></script>
<script>
<%@ include file="/js/navbarMVC.jsp" %>
<%@ include file="/js/footerMVC.jsp" %>
</script>
</body>
</html>
