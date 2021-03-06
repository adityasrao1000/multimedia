<!DOCTYPE html>
<html>
<head>

<%@ include file="libraries.jsp" %>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
<div id="nav">
<%@ include file="/jsp/navbar.jsp" %>
</div>
<div id="index">
<div class="container-fluid" id="index">
<br>

<div class="row">
	<div class="col-sm-2">
	
	</div>
	<div class="col-sm-8 col-xs-12">
	 <div class="image-container">
     <div v-for="item in userImages" class="card">
	    <div class="row" style="margin-bottom:-3.875em; width:100%; background: rgba(0, 0, 0, 0.3); z-index:1; margin-left:0px;">
	      <div class="col-7">
		      <!-- Left-aligned media object -->
			  <div class="media" style="margin-top:0.5em; margin-bottom:-0.4em;">
			    <div class="media-left">
			      <img accept="image/png" v-bind:src="item.profilepic" class="media-object" style="width:2.5em; height:2.5em; border-radius:50%;margin-right:7px">
			    </div>
			    <div class="media-body">
			      <b class="media-heading" style="cursor:pointer">{{item.username}}</b>
			      <p style="font-size:.9em; color:red"><i class="fa fa-heart" aria-hidden="true"></i> <i class="fa fa-heart" aria-hidden="true"></i> <i class="fa fa-heart" aria-hidden="true"></i></p>
			    </div>
			  </div>
			  
	      </div>
	      <div class="col-5">
	        <div style="display:block; text-align:right">	           
	            <button type="button" class="btn btn-outline-danger btn-sm" style="margin-top:12px;" @click="download(item)">Download</button>
		    </div>
	      </div>
	    </div>
		  
		  <div class="img-cont">
		    <img v-bind:src="item.id" @click="viewimage(item.id)" type="image" class="img-fluid" style="width:100%;">
		  </div>		 
		  <ul class="tags">
			  <li><p v-for="t in item.tags" class="tag"><span class="cut">{{t}}</span></p></li>				  
		  </ul>	
	  </div>	  
	  </div>
	  <br><br><br><br>
	  <div style="width:100%; display:flex; justify-content:center">
	  <nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-end">
		    <li class="page-item disabled"  style="color:var(--main-color); background:black">
		      <a class="page-link"  style="color:var(--main-color); background:black" href="#" tabindex="-1">Previous</a>
		    </li>
		    <li class="page-item"><a  style="color:var(--main-color); background:black" class="page-link" href="#">1</a></li>
		    <li class="page-item"><a  style="color:var(--main-color); background:black" class="page-link" href="#">2</a></li>
		    <li class="page-item"><a  style="color:var(--main-color); background:black" class="page-link" href="#">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#"  style="color:var(--main-color); background:black">Next</a>
		    </li>
		  </ul>
	  </nav>
	  </div>
	</div>
	<div class="col-sm-2">
	
	</div>
</div> 
</div>

</div>
<br><br><br>
<div id="footer">
<jsp:include page="${request.getContextPath()}/jsp/footer.jsp"></jsp:include>
</div>
<script src="./js/index.component.js"></script>
<script>
<%@ include file="/js/navbarMVC.jsp" %>
<%@ include file="/js/footerMVC.jsp" %>
</script>
</body>
</html>