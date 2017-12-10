var navbar=Vue.component('my-navbar', {
 data() {
	  return{
        isActive:false
	  }
  },
	methods: {
		
		},
		mounted: function () {
		  console.log('navbar loaded');

		   	  axios.post('CheckSessionValid', {
		  		  
		  	  })
		  	  .then(function (response) {
		  		 if(response.data===true){
		  
		  			document.getElementById("logout").style.display="block";
		  			document.getElementById("signup").style.display="none";
		  			
		  		 }else{
		  			document.getElementById("logout").style.display="none";
		  			document.getElementById("signup").style.display="block";
		  		
		  		 }
		  		  
		  	  })
		  	  .catch(function (error) {
		  	    console.log(error);
		  	  });
		  	},
  template: `<nav class="navbar" style="border: none; border-radius:0">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar" ></span>
        <span class="icon-bar" ></span>
        <span class="icon-bar" ></span>                        
      </button>
      <a class="navbar-brand" href="#">Wallpapers</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="home">Home</a></li>
        <li><a href="#">videos</a></li>
        <li><a href="image">images</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      
        <li class="dropdown"  id="logout" style="cursor:pointer">
          <a class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user-circle-o" aria-hidden="true"></i> account <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="home">profile <i class="fa fa-address-book-o" aria-hidden="true"></i></a></li>
            <li><a href="#">settings <i class="fa fa-cog fa-spin  fa-fw"></i></a></li>
            <li><a href="LogoutSessionInvalidate">logout <i class="fa fa-sign-out"></i></a></li>
          </ul>
        </li>
        <li  id="signup"><a href="register">Signup</a></li>
      </ul>
    </div>
  </div>
</nav>`

})
// create a root instance
var nav=new Vue({
  el: '#nav',

})