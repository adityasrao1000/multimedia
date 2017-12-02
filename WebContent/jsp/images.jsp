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
  
    <form @submit.prevent="submitform()" method="post" enctype="multipart/form-data" id="uploadform" style="display:none">
	    <div style="padding:10px; border:1px solid lightgrey; border-radius:4px; background-color:#F5F5F5">
		    <div class="form-group">	
			  <input type="text" placeholder="Image name" class="form-control" v-model="imageName" name="name" id="name" required>
		    </div>
		     <input  type="button" class="btn btn-default btn-sm" value="Select a file" onclick="document.getElementById('uploadButton').click()">
			 <input id="uploadButton" type="file" style="display:none" name="photo" required @change="uploadImage">
			  <br>
			  <img class="img-responsive" id="uploadPreview" style="margin-bottom:5px;" src="">	  
			  <button  type="submit" class="btn btn-default btn-sm" style="color:white; background-color:#2196F3;width:50%;display:block; margin:auto" >Upload <i class="fa fa-upload" aria-hidden="true"></i></button>
	     </div>
     </form>

   <br><br>
   <!-- iterate all the images -->
   <div class="row">
    <div class="col-xs-4">
      <div class="form-group">
        
        <div class="dropdown">
		  <button class="btn-sm btn-default dropdown-toggle" style="border:1px solid lightgrey" type="button" data-toggle="dropdown">Filter <span class="caret"></span></button>
		  <ul class="dropdown-menu">
		    <li><a><input style="transform: scale(1.4); -ms-transform: scale(1.4); -webkit-transform: scale(1.4);" type="checkbox"> <b style="float:right;margin:auto">Date</b></a></li>		  
		  </ul>
	   </div> 
      </div> 
    </div>
    <div class="col-xs-8">
       <input class="form-control input-sm" id="search" placeholder="search" type="text">
    </div>
   </div>
   
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