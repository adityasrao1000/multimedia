<!DOCTYPE html>
<html lang="en">
<head>
<title>Images</title>
<%@ include file="libraries.jsp" %>
</head>
<body>
<div id="nav">
  <my-navbar></my-navbar>
</div>
<div class="container-fluid">
<br><br>
<div class="row">
  <div class="col-sm-1"></div>
  <div class="col-sm-10"  style="min-height:400px;">
   <div class="row">
     <div class="col-7">
       <input class="form-control input-sm"  id="search" placeholder="search" type="text">
     </div>
     <div class="col-2">
       <div class="dropdown">
		  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
		     Order by 
		  </button>
		  <div class="dropdown-menu">
		    <a class="dropdown-item" href="#">relevance</a>
		    <a class="dropdown-item" href="#">downloads</a>
		    <a class="dropdown-item" href="#">upload date</a>
		  </div>
		</div>
     </div>
     <div class="col-3">
     
     </div>
   </div>
    <div  style=" display:block;float:bottom; float:left; margin-left:4px; height:50px;">
    <nav aria-label="Page navigation example">
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
  </div>
  <div class="col-sm-1"></div>
</div>
<br><br>
<br><br><br></br>
<br><br>
<br><br><br></br>
<br></br>
</div>
<div id="footer">
<my-footer></my-footer>
</div>
<script src="./js/navbar.js"></script>
<script src="./js/footer.component.js"></script>
<script src="./js/images.component.js"></script>
</body>
</html>
