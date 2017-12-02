
	
var vm = new Vue({
	  el: '#images',
	  data() {
		  return{
	    data: '',
	    imageName:'',
	    userImages: []
		  }
	  },
	  methods: {
		getSessionId: function(){
			axios.post('getSessionDetails', {
				  
			  })
			  .then(function (response) {
				  let username = response.data;
				  vm.getImages(username)
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
		
		},
		getImages: function(username){ 
			     axios.get('resources/getimages/'+username, {
				  
				  })
				  .then(function (response) {
					  let arr=[];
					  for(let i =0;i<response.data.length;i++){
					    arr.push("resources/image/"+response.data[i]);
					    vm.userImages =arr;
					  }
				  })
				  .catch(function (error) {
				    console.log(error);
				  });
		},
		uploadImage: function(){
			      var formData = new FormData();
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
		imageModal: function(id){
			let modal = document.getElementById('myModal');			
			let modalImg = document.getElementById("img01");		
			    modal.style.display = "block";
			    modalImg.src = id;

			// Get the <span> element that closes the modal
			var span = document.getElementById("closeModal");

			// When the user clicks on <span> (x), close the modal
			span.onclick = function() { 
			    modal.style.display = "none";
			}
		},
		uploadShow: function(){
			document.getElementById("uploadform").style.display ="block";
		},
		
		submitform: function(){
			let data = new FormData();
			
	          data.append('name', this.imageName);
	          data.append('photo', document.querySelector('input[type=file]').files[0]);
	          
	          axios.post('UploadImage', data)
	            .then(function (res) {
	              console.log(res.status);
	              if(res.data==="success"){
	            	  document.getElementById("uploadButton").value= "";
	            	  document.getElementById("uploadPreview").src= "";
	            	  document.getElementById("name").value= "";
	            	  alert("file successfully uploaded");
	              }
	              if(res.data==="failed"){
	            	  alert("upload failed! please try again");
	              }
	            })
	            .catch(function (err) {
	              console.log(err.message);
	            });
     		//document.getElementById("uploadform").submit();
		}
		  },
		  
	  mounted: function(){
		  this.getSessionId();
		  
	  }
 
})