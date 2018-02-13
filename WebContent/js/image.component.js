var vm = new Vue({
	  el: '#images',
	  data() {
		  return{
		    data: '',
		    imageName:'',
		    useremail:'',
		    userImages: [],
		    tag:'',		    
		    tags:[],
		    newtags:[],
		    newtag:'',
		    currentImgId:'',
		    tags_image_specific: []
		  }
	  },
	  methods: {
		getSessionId: function(){
			axios.post('getSessionDetails', {
				  
			  })
			  .then(function (response) {
				  let useremail = response.data.email;
				  
				  vm.getImages(useremail)
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
		
		},
		getImages: function(imageId){ 
			     axios.get('resources/getimages/'+imageId, {
				  
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
				  var filename = file.name + "";
				  this.imageName = filename.substr(0, filename.lastIndexOf("."));
				  
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
		    this.currentImgId = id;
		    
		    //get the tags of the image
		    this.getTags();
		    
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
		entertag: function(){
			if(this.tags.length<10){
				
				this.tag= this.tag.trim();
				this.tag = this.tag.replace(/\s+/g, ' ');
	
				if(this.tag.length<=30 && this.tag.length>=2){
					
				  this.tag = this.tag.toLowerCase();
				  if(vm.tags.length==0){
					  vm.tags.push(this.tag); 
				  }
				  else if(vm.tags.length>0 && vm.tags.indexOf(this.tag)<0){
				     vm.tags.push(this.tag);
				  }else{
					  
				  }				  
				}
				this.tag='';
			}		
		},
		removetag: function(index){
			vm.tags.splice(index, 1);
		},
		deleteImage: function(){
		  let confirm = window.confirm("Are you sure you want to delete this image permanently?");
		  document.getElementById('loader-container').style.display="block";
		  if(confirm===true){
			let currentImg =  this.currentImgId;
			let id = this.currentImgId.split('/')
			id = id[id.length-1];
			axios.delete(`resources/deleteImage/${id}`, {
				  
			  })
			  .then(function (response) {
				 if(response.data==='success'){
					
					 let index = vm.userImages.indexOf(currentImg);
					 vm.userImages.splice(index, 1);
					 this.currentImgid='';					 
					 document.getElementById('myModal').style.display = 'none';
					 document.getElementById('loader-container').style.display="none";
				 }
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
			}else{
		       document.getElementById('loader-container').style.display="none";
			}
		},
		submitform: function(){
			
			let data = new FormData();
			let tags = this.tags;
			tags=JSON.stringify(tags);
	          data.append('name', this.imageName);
	          data.append('photo', document.querySelector('input[type=file]').files[0]);
	          data.append('tags',tags);
	          
	          document.getElementById('loader-container').style.display="block";
	          axios.post('UploadImage', data)	        
	            .then(function (res) {
	              console.log(res.status);
	              if(res.data==="success"){
	            	  document.getElementById("uploadButton").value= "";
	            	  document.getElementById("uploadPreview").src= "";
	            	  document.getElementById("name").value= "";
	            	  vm.tags= [];
	            	  window.location.reload();
	              }
	              if(res.data==="failed"){
	            	  document.getElementById('loader-container').style.display="none";
	            	  alert("upload failed! please try again");
	              }
	            })
	            .catch(function (err) {
	              console.log(err.message);
	            });
		    },
		    triggerupload: function(){
		    	document.getElementById('uploadButton').click()
		    },
		    getTags: function(){
		    	vm.newtags= [];
		    	let id = this.currentImgId.slice(this.currentImgId.lastIndexOf('/')+1,this.currentImgId.length);
		    	axios.get(`resources/tags/${id}`, {
					  
				  })
				  .then(function (response) {
					  if(response.status===200){
						  vm.newtags= response.data;
					  }

				  })
				  .catch(function (error) {
				    console.log(error);
				  });
		    },
		    deleteTag: function(index){
		    	
		    	let id = this.currentImgId.slice(this.currentImgId.lastIndexOf('/')+1,this.currentImgId.length);
		    	let name = this.newtags[index];
		    	axios.delete(`resources/deleteTag/${id}/${name}`, {
					  
				  })
				  .then(function (response) {
					  if(response.status===200){
						  vm.newtags.splice(index, 1);
					  }
					  console.log("tag removed");

				  })
				  .catch(function (error) {
				    console.log(error);
				  });
		    },
		    addNewTag: function(){
		            
					this.newtag= this.newtag.trim();
					this.newtag = this.newtag.replace(/\s+/g, ' ');
		
					if(this.newtag.length<=30 && this.newtag.length>=2){
						
					  this.newtag = this.newtag.toLowerCase();
					  if(vm.newtags.length==0){
						  vm.newtags.push(this.tag); 
					  }
					  else if(vm.newtags.length>0 && vm.newtags.indexOf(this.newtag)<0){
					     vm.newtags.push(this.newtag);
					  }else{
						  
					  }
					  
					}
					this.newtag='';				
		    }
		  },
		  
	  mounted: function(){
		  this.getSessionId();
		  
	  } 
})