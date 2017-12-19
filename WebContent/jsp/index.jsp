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
<br>
<img data-toggle="modal" data-target="#profilepic" style="max-width:100px; float:left; margin-right:12px; cursor:pointer" v-bind:src="pp" class="img-fluid rounded" alt="profile pic">
<h5>{{username}}</h5>
<p>uploads <span style="color:white; font-size:.8em">{{uploads}}</span></p>
<br><br><br><br>
<div class="row">
	<div class="col-sm-3">
	
	</div>
	<div class="col-sm-6 col-xs-12 ">
	  <img v-for="item in userImages" v-bind:src="item"  class="rounded float-left" style="width:31%; margin:2px; height:120px; float:left">
	</div>
	<div class="col-sm-3">
	
	</div>
</div> 
</div>
<!-- The Modal -->
  <div class="modal fade" id="profilepic">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
      
        
        <!-- Modal body -->
        <div class="modal-body">
        <button type="button" class="close" data-dismiss="modal" style="color:white;">&times;</button>
          <h5 class="modal-title" style="max-width:90%">Change Profile Picture</h5>
          
          <br>
          <input type="file" accept="image/*" @change="uploaded" id="uploadProfilePic" style="display:none; float:left">
          <button type="button" style=" display:block; color:#E91E63; background:#212121; border:none; float:left" class="btn btn-sm" onclick="document.getElementById('uploadProfilePic').click()">Select <i class="fa fa-picture-o" aria-hidden="true"></i></button>
          <p style="float:left; margin-left:6px;">{{imagename}}</p>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-sm" style=" display:block; color:#E91E63; background:#212121; border:none;" @click="uploadProfile">Upload <i class="fa fa-upload" aria-hidden="true"></i></button>
        </div>
        
      </div>
    </div>
  </div>
</div>

<script src="./js/navbar.js"></script>
<script src="./js/index.component.js"></script>
</body>
</html>