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

 <div class="row">
  <div class="col-sm-8">
	<h2 style=" font-family: 'Roboto Condensed', sans-serif;">{{title}}</h2>

	<video id="vid" :src="url"  controls preload="auto" style="width:100%;">
    <source src="" type='video/mp4'>  
    </video>
    
	<div id="rating">
	<div style="; margin-top:10px">
	<i class="fa fa-thumbs-up"></i><i class="fa fa-thumbs-down"></i>
    </div>
    <br><br>
    <div class="progress" style="height:3px;">
     <div  class="progress-bar" role="progressbar" aria-valuenow="70"
      aria-valuemin="0" aria-valuemax="100" style="width:70%">
     </div>
    </div>
    </div>
    
    <br><br>
   </div>   
   <div class="col-sm-4">
   <br><br><br>
   <div v-for="item in items" @click="popup(item)" class="video-container">
     <video  :src="item.message" preload="auto" style=" width:50%; margin:auto">
     
     </video>
     <div style="float:right;width:48%;height:100%;margin-top:-5px">
       <b>{{item.title}}</b>
     </div>
   </div>
   </div>
 </div>
</div>


<script src="./js/navbar.js"></script>
<script src="./js/index.main.component.js"></script>
</body>
</html>