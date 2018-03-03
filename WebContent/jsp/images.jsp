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
  <div class="col-sm-10">
   <div class="row">
     <div class="col-7">
       <input  type="search" class="form-control input-sm"  id="search" placeholder="search">
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
