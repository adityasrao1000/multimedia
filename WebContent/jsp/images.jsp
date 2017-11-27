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
<body id="image">
<div id="nav">
  <my-navbar></my-navbar>
</div>
<div id="loader" style="display:none;"></div>
<div class="container-fluid" id="images">
<br>
<button type="button" style="float:right" class="btn btn-default btn-sm" @click="uploadShow">Upload an image</button>
<br><br>
<div class="row">
  <div class="col-sm-3">
  
  </div>
  <div class="col-sm-6">
    <form action="UploadImage" method="post" enctype="multipart/form-data" id="uploadform" style="display:none">
    <div class="form-group">	
	  <input type="text" placeholder="Name" class="form-control" v-bind:value="imageName" id="name" required>
    </div>
	 <input  type="file" name="photo" required @change="uploadImage">
	  <br>
	  <img class="img-responsive" id="uploadPreview" src="">
	  <input type="submit" class="btn btn-default btn-sm" style="width:100%" value="Upload">
   </form>
  </div>
  <div class="col-sm-3">
  
  </div>
</div>

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