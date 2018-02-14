var navbar=Vue.component('my-navbar', {
 data() {
	  return{
        isActive:false,
        profile:''
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
  template: `
  <nav class="navbar navbar-expand-sm navbar-light bg-faded">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#nav-content" aria-controls="nav-content" aria-expanded="false" aria-label="Toggle navigation">
	<span class="navbar-toggler-icon"></span>
	</button>
	
	<!-- Brand -->
	<a class="navbar-brand" >Wallpapers</a>
	
	<!-- Links -->
	<div class="collapse navbar-collapse" id="nav-content">   
	<ul class="navbar-nav">
	  <li class="nav-item"><a class="nav-link" href="home">Home</a></li>
	</ul>
	<ul class="navbar-nav ml-auto">
	<li class="nav-item dropdown" id="logout">
	<a class="nav-link dropdown-toggle" data-toggle="dropdown" id="Preview" href="#" role="button" aria-haspopup="true" aria-expanded="false">
	<img id="profile" class="img-fluid" style="max-width:30px; max-height:30px; margin-left:4px;"> account 
	</a>
	<div class="dropdown-menu" aria-labelledby="Preview">
	    <li><a class="dropdown-item"  href="profile">profile <i class="fa fa-address-book-o" aria-hidden="true"></i></a></li>
        <li><a class="dropdown-item" href="usersettings">settings <i class="fa fa-cog fa-spin  fa-fw"></i></a></li>
        <li><a class="dropdown-item" href="LogoutSessionInvalidate">logout <i class="fa fa-sign-out"></i></a></li>
	</div>
	</li>
	<li class="nav-item" id="signup"><a class="nav-link" href="register">Signup</a></li>
	</ul>
</div>
</nav>

`

})
// create a root instance
var nav=new Vue({
  el: '#nav',
  data(){
	  return{
	    profile:''
	  }
  },
  methods:{
	  getSessionId: function(){
			axios.post('getSessionDetails', {
				  
			  })
			  .then(function (response) {
				  nav.profile = "resources/displayProfilePic/" + response.data.email;
				  document.getElementById("profile").src=nav.profile
				  
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
		}
  },
  mounted:function(){
	  this.getSessionId()
  }


})