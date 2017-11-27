
	
var vm = new Vue({
	  el: '#images',
	  data: {
	    data: '',
	    imageName:''
	   
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
		},
		uploadImage: function(){
			
				  var preview = document.getElementById('uploadPreview');
				  var file    = document.querySelector('input[type=file]').files[0];
				  var reader  = new FileReader();
				  this.imageName = file.name;
				  reader.addEventListener("load", function () {
				    preview.src = reader.result;
				  }, false);
				  if (file) {
				    reader.readAsDataURL(file);
				  }				
		},
		uploadShow: function(){
			document.getElementById("uploadform").style.display ="block";
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