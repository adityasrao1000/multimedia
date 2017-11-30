<!DOCTYPE html>
<html>
<head>

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
<button type="button" style="float:right" class="btn btn-default btn-sm" @click="uploadShow">Upload an image <i class="fa fa-plus" style="font-size:15px;color:black" aria-hidden="true"></i></button>
<br><br>
<div class="row">
  <div class="col-sm-3">
  
  </div>
  <div class="col-sm-6">
    <form action="UploadImage" v-on:submit.prevent="submitform($event)" method="post" enctype="multipart/form-data" id="uploadform" style="display:none">
    <div class="form-group">	
	  <input type="text" placeholder="Name" class="form-control" v-model="imageName" name="name" id="name" required>
    </div>
	 <input  type="file" name="photo" required @change="uploadImage">
	  <br>
	  <img class="img-responsive" id="uploadPreview" src="">
	  <button type="submit" class="btn btn-default btn-sm" style="width:50%;display:block; margin:auto" >Upload <i class="fa fa-upload" aria-hidden="true"></i></button>
   </form>
   <br><br>
   <!-- iterate all the images -->
   <div>
   <img v-for="item in userImages" v-bind:src="item" @click="imageModal(item)" class="img-responsive" style="width:31%; margin:2px; height:120px; float:left">
   
   </div>
  </div>
  <div class="col-sm-3">
  
  </div>
</div>

<br><br>

  <!-- The Modal -->
<div id="myModal" class="modal">
  <span class="close" id="closeModal">&times;</span>
  <img class="modal-content" id="img01">
  <div id="image_info"></div>
</div>
</div>
<script src="./js/navbar.js"></script>
<script src="./js/image.component.js"></script>
</body>
</html>