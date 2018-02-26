<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html">
<html>
<head>
<%@ include file="libraries.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="nav">
  <my-navbar></my-navbar>
</div>
<div class="container-fluid" id="imagedetails">
<img width="100%" src="<%=request.getContextPath()%>/resources/image/${id}">
</div>
<div id="footer">
<my-footer></my-footer>
</div>
<script src="<%=request.getContextPath() %>/js/navbar.js"></script>
<script src="<%=request.getContextPath() %>/js/footer.component.js"></script>
<script src="<%=request.getContextPath() %>/js/imagedetails.component.js"></script>
</body>
</html>