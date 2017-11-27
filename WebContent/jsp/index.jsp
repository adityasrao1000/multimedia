<!DOCTYPE html>
<html>
<head>
<%

String email=(String)session.getAttribute("email");  
  if (email == null) {
	  response.sendRedirect("login");  
  } 
%>
<%@ include file="libraries.jsp" %>
<link rel="stylesheet" href="css/index.css">
</head>
<body style="background-color:#444444; color:lightgrey">
<div id="nav">
  <my-navbar></my-navbar>
</div>
<div class="container-fluid" id="index">
<h4>Welcome <%= email %></h4>
</div>


<script src="./js/navbar.js"></script>

</body>
</html>