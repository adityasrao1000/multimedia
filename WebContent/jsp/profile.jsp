<!DOCTYPE html>
<html>
<head>
<%@ include file="libraries.jsp" %>
<link rel="stylesheet" href="css/profile.css">
<link rel="stylesheet" href="css/loader.css">
<title>Profile</title>
</head>
<body>
<div id="profile">
<div id="nav">
  <my-navbar></my-navbar>
</div>
<div id="loader" style="display:none;"></div>
<div class="container-fluid">
<br>
<img data-toggle="modal" data-target="#profilepic"  @click="openModal" style="max-width:100px; float:left; margin-right:12px; cursor:pointer" v-bind:src="pp" class="img-fluid rounded" alt="profile pic">
<h5>{{username}}</h5>
<p>uploads <span style="color:white; font-size:.8em">{{uploads}}</span></p>
<br><br>
<button type="button" style="float:right; color:#E91E63; background:#212121; border:none" class="btn btn-default btn-sm" @click="uploadShow">Upload an image <i class="fa fa-plus" style="font-size:15px;  margin-left:5px; margin-top:4px;" aria-hidden="true"></i></button>
<br><br>
<div class="row">
  <div class="col-sm-3">
  
  </div>
  <div class="col-sm-6">
  
    <form  method="post" enctype="multipart/form-data" id="uploadform" style="display:none">
	    <div id="imageUploadContainer">
		    <div class="form-group">	
			  <input type="text" accept="image/*" placeholder="Image name" class="form-control" v-model="imageName" name="name" id="name" required>
		    </div>
		     <button class="btn btn-default btn-sm" type="button" id="selectfile" @click="triggerupload">Select a file</button>
			 <input id="uploadButton" type="file" style="display:none" name="photo" required @change="uploadImage">
			  <br>		  
			  <img  class="img-fluid"  id="uploadPreview" style="margin-bottom:5px; width:100%">
			  
			  <ul class="tags">
				  <li><p v-for="(item, index) in tags" class="tag"><span class="cut"><i class="fa fa-times" aria-hidden="true" @click="removetag(index)"></i></span> <a >{{item}}</a></p></li>				  
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
   <img v-for="item in userImages" v-bind:src="item" @click="imageModal(item)"  accept="image/*" class="rounded float-left" style="width:31%; margin:2px; height:120px; float:left">
   
   </div>
  </div>
  <div class="col-sm-3">
  
  </div>
</div>
<div id="loader-container">
  <div class="loader"></div>
</div>
<!-- The Modal -->
<div id="myModal" class="modal">
  <span class="close" id="closeModal" @click="closeImageModal">&times;</span>
  <div class="img-modal-container">    
      <button type="button" @click="deleteImage" style="float:right" class="btn btn-outline-danger">Delete <i class="fa fa-times-circle" aria-hidden="true"></i></button>
	  <button type="button" @click="editImage" class="btn btn-outline-warning" style="float:right; margin-right:10px">Edit <i class="fa fa-pencil" aria-hidden="true"></i></button>
	  <img class="modal-content" id="img01">
	  <div id="image_info"></div>
	  <br>
	  <p style="float:left; margin-right:7px;">Tags:</p>
	  <ul class="tags">
		 <li><div v-for="(item, index) in newtags" class="tag tagImg"><p><span class="cut"><i v-if="edit" class="fa fa-times" aria-hidden="true" @click="deleteTag(index)"></i></span> {{item}}</p></div></li>				  
	  </ul>	
	  <br>
	  <div style="display:block; width:100%">
	    <input v-if="edit" class="form-control input" style="max-width:200px;float:left; height:30px" v-model="newtag" @keyup.enter="addNewTag" id="add-tag" placeholder="enter a tag" type="text" maxlength="30"><i v-if="edit" style="font-size:30px; margin-left:10px;" @click="addNewTag" class="fa fa-plus"></i>
      </div>
      <br><br style="float:bottom" id="mark">
  </div>
</div>

</div>
<div id="ppUploadModal">
	<div>
	
		<div class="modal-body">
          <h5 class="modal-title" >Change Profile Picture</h5>
          <button  type="button" class="close" @click="closeModal" data-dismiss="modal">&times;</button>
          <br>
          <input type="file" accept="image/*" @change="uploaded" id="profilePicUpload" style="display:none; float:left">
          <button type="button" style=" display:block; color:#E91E63; background:#212121; border:none; float:left" class="btn btn-sm" onclick="document.getElementById('profilePicUpload').click()">Select <i class="fa fa-picture-o" aria-hidden="true"></i></button>
          <p style="float:left; margin-left:6px;">{{imagename_profilePic}}</p>
        </div>
        <br><br>
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-sm" style=" display:block; color:#E91E63; background:#212121; border:none;" @click="uploadProfile">Upload <i class="fa fa-upload" aria-hidden="true"></i></button>
        </div>
	</div>
</div>
</div>
<div id="footer">
<my-footer></my-footer>
</div>
<script src="./js/navbar.js"></script>
<script src="./js/footer.component.js"></script>
<script src="./js/profile.component.js"></script>
</body>
</html>