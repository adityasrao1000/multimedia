
	
var vm = new Vue({
	  el: '#main',
	  data: {
	    data: ''
	   
	  },
	  methods: {
		  
		getImages: function(userEmail){ 
			     axios.post(`getImages/${userEmail}`, {
				    userId: '1',
				    title: todoTitle,
				    completed: false
				  })
				  .then(function (response) {
				    resultElement.innerHTML = generateSuccessHTMLOutput(response);
				  })
				  .catch(function (error) {
				    resultElement.innerHTML = generateErrorHTMLOutput(error);
				  });
		}
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