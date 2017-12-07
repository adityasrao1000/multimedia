var navbar=Vue.component('my-navbar', {
	methods: {
		session: function(){
			
			let session = localStorage.getItem("sessionset");
			return session;
		}
		},
		mounted: function () {
		  console.log('navbar loaded');

		   	  axios.post('CheckSessionValid', {
		  		  
		  	  })
		  	  .then(function (response) {
		  		  localStorage.setItem("sessionset", response.data );
		  		  
		  	  })
		  	  .catch(function (error) {
		  	    console.log(error);
		  	  });
		  	},
  template: `<nav class="navbar" style="border: none; border-radius:0">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar" style="background-color:black"></span>
        <span class="icon-bar" style="background-color:black"></span>
        <span class="icon-bar" style="background-color:black"></span>                        
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
        <li v-if="session()"><a href="LogoutSessionInvalidate">Logout</a></li>
        <li v-else><a href="register">Signup</a></li>
      </ul>
    </div>
  </div>
</nav>`

})
// create a root instance
var nav=new Vue({
  el: '#nav',

})