<!DOCTYPE html>
<html>
<head>

<%@ include file="libraries.jsp" %>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
<div id="index">
<div id="nav">
  <my-navbar></my-navbar>
</div>
<div class="container-fluid" id="index">
<h4>Welcome {{username}}</h4>
</div>

<div class="col-sm-6 col-xs-12 col-sm-offset-3">
 <img v-for="item in userImages" v-bind:src="item"  class="img-responsive" style="width:31%; margin:2px; height:120px; float:left">
</div>
   
</div>
<script src="./js/navbar.js"></script>
<script src="./js/index.component.js"></script>
</body>
</html>