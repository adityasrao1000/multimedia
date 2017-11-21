Vue.component('my-navbar', {
  template: `<nav class="navbar navbar-inverse" style="border: none; border-radius:0">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#"><span style="color:red;" class="glyphicon glyphicon-play "></span></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="home">Home</a></li>
        <li><a href="#">videos</a></li>
        <li><a href="image">images</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="LogoutSessionInvalidate"><button  class="btn btn-danger btn-xs">Logout</button></a></li>
      </ul>
    </div>
  </div>
</nav>`
})
// create a root instance
new Vue({
  el: '#nav',
  mounted: function () {
	    console.log('navbar loaded');
	  }
})