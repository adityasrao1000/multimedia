<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<%@ include file="libraries.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<% 
String img = request.getContextPath()+"/resources/image/"+(String)request.getAttribute("id");
%>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/footer.css">
</head>
<body>
<div id="nav">
  <my-navbar></my-navbar>
</div>
<div class="container-fluid" id="imagedetails">
<img width="100%" src="<%=img%>">
</div>
<div id="footer">
<my-footer></my-footer>
</div>
<script src="./js/navbar.js"></script>
<script src="./js/footer.component.js"></script>
<script src="./js/imagedetails.component.js"></script>
</body>
</html>