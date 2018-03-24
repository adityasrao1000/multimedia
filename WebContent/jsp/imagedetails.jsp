<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html">
<html>
<head>
<%@ include file="libraries.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<spring:url value="/something" var="url" htmlEscape="true"/>
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
<div class="row">
  <div class="col-sm-1">
  
  </div>
  <div class="col-sm-7">
    <br>
    <div class="form-group">
	  <label for="comment">Comment:</label>
	  <textarea class="form-control" rows="4" id="comment"></textarea>
	  <br>
	  <button type="button" class="btn btn-sm" style=" display:block; color:#E91E63; background:black; border:none; width:75%; margin:auto; font-size:1.3em">Post Comment <i class="fa fa-comment"></i></button>
	</div>
    <div class="media">
	    <img class="align-self-start mr-3" src="https://www.buira.org/assets/images/shared/default-profile.png" alt="Generic placeholder image">
	    <div class="media-body">
	    <h5 class="mt-0">name</h5>
	    <p>Cras sit amet nibh https://www.facebook.com . in gravida nulla. Nulla ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.</p>
	    </div>
    </div>
  </div>
  <div class="col-sm-4">
  
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