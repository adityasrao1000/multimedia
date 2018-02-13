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
	<div class="col-sm-2">
	
	</div>
	<div class="col-sm-8 col-xs-12">
	  <div class="row">
		  <div class="col-sm-6 ">
	  <div v-for="item in userImages" class="card">
	    <div class="row">
	      <div class="col-7">
		      <!-- Left-aligned media object -->
			  <div class="media" style="margin-top:8px; margin-left:10px;margin-bottom:-6px;">
			    <div class="media-left">
			      <img v-bind:src="item.profilepic" class="media-object" style="width:40px; height:40px; border-radius:50%;margin-right:7px">
			    </div>
			    <div class="media-body">
			      <b class="media-heading" style="cursor:pointer">{{item.username}}</b>
			      <p style="font-size:.9em; color:red"><i class="fa fa-heart" aria-hidden="true"></i> <i class="fa fa-heart" aria-hidden="true"></i> <i class="fa fa-heart" aria-hidden="true"></i></p>
			    </div>
			  </div>
			  
	      </div>
	      <div class="col-5">
	        <div style="display:block; text-align:right">	           
	            <button type="button" class="btn btn-outline-danger btn-sm" style="margin-top:12px; margin-right:8px" @click="download(item)">Download</button>
		    </div>
	      </div>
	    </div>
		  
		  <div class="img-cont">
		    <img v-bind:src="item.id" type="image" class="img-fluid" style="width:100%;">
		  </div>		 
		  <ul class="tags">
			  <li><p v-for="t in item.tags" class="tag"><span class="cut">{{t}}</span></p></li>				  
		  </ul>	
	  </div>
		  </div>
		  <div class="col-sm-6 ">
		    <div v-for="item in userImages1" class="card">
	    <div class="row">
	      <div class="col-7">
		      <!-- Left-aligned media object -->
			  <div class="media" style="margin-top:8px; margin-left:10px;margin-bottom:-6px;">
			    <div class="media-left">
			      <img v-bind:src="item.profilepic" class="media-object" style="width:40px; height:40px; border-radius:50%;margin-right:7px">
			    </div>
			    <div class="media-body">
			      <b class="media-heading" style="cursor:pointer">{{item.username}}</b>
			      <p style="font-size:.9em; color:red"><i class="fa fa-heart" aria-hidden="true"></i> <i class="fa fa-heart" aria-hidden="true"></i> <i class="fa fa-heart" aria-hidden="true"></i></p>
			    </div>
			  </div>
			  
	      </div>
	      <div class="col-5">
	        <div style="display:block; text-align:right">	            
	            <button type="button" class="btn btn-outline-danger btn-sm" style="margin-top:12px; margin-right:8px" @click="download(item)">Download</button>
		    </div>
	      </div>
	    </div>
		  
		  <div class="img-cont">
		    <img v-bind:src="item.id" type="image" class="img-fluid" style="width:100%;">
		  </div>		 
		  <ul class="tags">
			  <li><p v-for="t in item.tags" class="tag"><span class="cut">{{t}}</span></p></li>				  
		  </ul>	
	  </div>
	      </div>
	  </div>
	  
	
	  <br><br>
	  <nav aria-label="Page navigation example" style="float:left; margin-left:4px">
		  <ul class="pagination justify-content-end">
		    <li class="page-item disabled"  style="color:#E91E63; background:black">
		      <a class="page-link"  style="color:#E91E63; background:black" href="#" tabindex="-1">Previous</a>
		    </li>
		    <li class="page-item" ><a  style="color:#E91E63; background:black" class="page-link" href="#">1</a></li>
		    <li class="page-item"><a  style="color:#E91E63; background:black" class="page-link" href="#">2</a></li>
		    <li class="page-item"><a  style="color:#E91E63; background:black" class="page-link" href="#">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#"  style="color:#E91E63; background:black">Next</a>
		    </li>
		  </ul>
	  </nav>
	  
	</div>
	<div class="col-sm-2">
	
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
<br><br><br>
<div id="footer">
<my-footer></my-footer>
</div>
<script src="./js/navbar.js"></script>
<script src="./js/footer.component.js"></script>
<script src="./js/index.component.js"></script>
</body>
</html>