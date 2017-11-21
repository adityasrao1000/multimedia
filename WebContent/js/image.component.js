Vue.component('image-load', {
	  template: '<div>A custom component!</div>'
	})
	
var vm = new Vue({
	  el: '#main',
	  data: {
	    data: '',
	    title: 'video title goes here'
	  },
	  methods: {
	    
	  },
	  mounted: function(){
		// Get the modal
		  var modal = document.getElementById('myModal');
		  var modalImg = document.getElementById("img01");
		  // Get the <span> element that closes the modal
		  var span = document.getElementsByClassName("close")[0];

		  // When the user clicks on <span> (x), close the modal
		  span.onclick = function() { 
		      modal.style.display = "none";
		  }
	  }
})