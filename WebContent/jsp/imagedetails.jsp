<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html">
<html>
<head>
<%@ include file="libraries.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/imagedetails.css">
</head>
<body>
<div id="nav">
  <my-navbar></my-navbar>
</div>
<div class="container-fluid" id="imagedetails">
<br><br>
<div class="row">
  <div class="col-sm-1">
  
  </div>
  <div class="col-sm-7">
    <img width="100%" id="main-img" src="<%=request.getContextPath()%>/resources/image/${id}">
  </div>
  <div class="col-sm-4">
      <div class="media">
	    <div class="media-left">
	      <img accept="image/png" src="<%=request.getContextPath()%>/resources/displayProfilePic/${email}" class="media-object">
	    </div>
	    <div class="media-body">
	      <b class="media-heading">${username}</b>
	      <div class="progress" style="width:70%">
		    <div class="progress-bar bg-primary" style="width:60%">
		      60%
		    </div>
		    
		    <div class="progress-bar bg-danger" style="width:40%">
		      40%
		    </div>
		  </div>
	    </div>
	  </div>
	  <div style="margin-top:35px;">
	    <button type="button" class="btn btn-primary">like <i class="fa fa-thumbs-o-up"></i></button>  
	    <button type="button" class="btn btn-danger">dislike <i class="fa fa-thumbs-o-down"></i></button>
	  </div>
	  <br>
	  <div>
	   <div class="row">
	     <div class="col-6">
	      <p><b>Downloads </b><br><b class="total-downloads">${downloads}</b></p>
	     </div>
	     <div class="col-6">
	      <p><b>Uploaded </b><br><b class="total-downloads">${upload_date}</b></p>
	     </div>
	   </div>
	  </div>
  </div>
</div>
<br><br><br><br>
</div>
<div id="footer">
<my-footer></my-footer>
</div>
<script src="<%=request.getContextPath() %>/js/navbar.js"></script>
<script src="<%=request.getContextPath() %>/js/footer.component.js"></script>
<script src="<%=request.getContextPath() %>/js/imagedetails.component.js"></script>
</body>
</html>