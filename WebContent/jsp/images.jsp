<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
<button type="button" style="float:right; color:#E91E63; background:#212121; border:none" class="btn btn-default btn-sm" @click="uploadShow">Upload an image <i class="fa fa-plus" style="font-size:15px;" aria-hidden="true"></i></button>
<br><br>
<div class="row">
  <div class="col-sm-3">
  
  </div>
  <div class="col-sm-6">
  
    <form  method="post" enctype="multipart/form-data" id="uploadform" style="display:none">
	    <div id="imageUploadContainer">
		    <div class="form-group">	
			  <input type="text" placeholder="Image name" class="form-control" v-model="imageName" name="name" id="name" required>
		    </div>
		     <button class="btn btn-default btn-sm" type="button" id="selectfile" @click="triggerupload">Select a file</button>
			 <input id="uploadButton" type="file" style="display:none" name="photo" required @change="uploadImage">
			  <br>		  
			  <img  class="img-fluid"  id="uploadPreview" style="margin-bottom:5px; width:100%">
			  
			  <ul class="tags">
				  <li><p v-for="(item, index) in tags" class="tag"><span class="cut"><i class="fa fa-times" aria-hidden="true" @click="removetag(index)"></i></span> <a href="#">{{item}}</a></p></li>				  
			  </ul>	  
			  
			  <label style="font-size: .9em; margin-bottom:-5px">tag name:</label>
			  <br>
			  
			  <div class="row">
			    <div class="col-8">
			      <input id="taginput" @keyup.enter="entertag" class="form-control input-sm" v-model="tag" placeholder="tag name" type="text" name="tags" maxlength="30">			 
			    </div>
			    <div class="col-4">
			      <button type="button" @click="entertag" class="btn btn-default btn-sm" style="margin-left:-31px; color:#E91E63; background:#212121; height:37px;">tag <i  style="font-size:14px" class="fa fa-plus-circle" aria-hidden="true"></i></button>
			    </div>
			  </div>
			  <br>
			  <button  type="button" @click="submitform()" class="btn btn-default btn-sm" id="submitbtn" >Upload <i class="fa fa-upload" aria-hidden="true"></i></button>
	     </div>
     </form>

   <br><br>
   <!-- iterate all the images -->
  
   <div>
      <input class="form-control input-sm" style="width:50%" id="search" placeholder="search" type="text">
   </div>
   <br>
   
   <div>
   <img v-for="item in userImages" v-bind:src="item" @click="imageModal(item)" class="rounded float-left" style="width:31%; margin:2px; height:120px; float:left">
   
   </div>
  </div>
  <div class="col-sm-3">
  
  </div>
</div>

  <!-- The Modal -->
<div id="myModal" class="modal">
  <span class="close" id="closeModal">&times;</span>
  <img class="modal-content" id="img01">
  <div id="image_info"></div>
</div>
</div>

<div id="footer">
<my-footer></my-footer>
</div>
<script src="./js/navbar.js"></script>
<script src="./js/footer.component.js"></script>
<script src="./js/image.component.js"></script>
</body>
</html>