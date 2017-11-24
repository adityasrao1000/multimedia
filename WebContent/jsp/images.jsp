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
  <link rel="stylesheet" href="css/images.css">
  <link rel="stylesheet" href="css/loader.css">
</head>
<body style="background-color:#444444" id="image">
<div id="nav">
  <my-navbar></my-navbar>
</div>
<div id="loader" style="display:none;"></div>
<div class="container-fluid" id="images">
<br>
<input type="file" accept="image/*">
<br><br>

  <div id="img">
  
  </div>
  
  <!-- The Modal -->
<div id="myModal" class="modal">
  <span class="close">&times;</span>
  <img class="modal-content" id="img01">
  <div id="caption"></div>
</div>
<image-load></image-load>
</div>
<script src="./js/navbar.js"></script>
<script src="./js/image.component.js"></script>
<script>
// Get the modal
var modal = document.getElementById('myModal');
var modalImg = document.getElementById("img01");
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() { 
    modal.style.display = "none";
}
</script>
</body>
</html>