
var vm = new Vue({
	  el: '#index',
	  data() {
		  return{
	        username: '',
	        userImages: [],
	        userImages1: [],
	        pp: 'resources/displayProfilePic/',
	        imagename: '',
	        email:'',
	        uploads: 0,
	        tags:new Array()
		  }
	  },
	  methods: {
		  getemail: function(){
			  return this.email;
		  },
		  userUploads: function(){
			     let useremail=localStorage.getItem("useremail");
				 axios.get(`resources/totalUserUploads/${useremail}`, {
					  
				  })
				  .then(function (response) {
					 vm.uploads = response.data.uploads;
				  })
				  .catch(function (error) {
				    console.log(error);
				  });		
		  },
		getSessionId: function(){
			axios.post('getSessionDetails', {
				  
			  })
			  .then(function (response) {
				  vm.username = response.data.username;
				  vm.pp = vm.pp + response.data.email;
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
			this.userUploads();
		},
		uploaded: function(){
			this.imagename = document.querySelector('input[type=file]').files[0].name;
		},
		uploadProfile: function(){
			let data = new FormData();
			
	          data.append('photo', document.querySelector('input[type=file]').files[0]);
	          
	          axios.post('uploadProfilePic', data)
	            .then(function (res) {
	              console.log(res.status);
	              if(res.data==="success"){
	            	  location.reload();
	              }
	              if(res.data==="failed"){
	            	  alert("upload failed! please try again");
	              }
	            })
	            .catch(function (err) {
	              console.log(err.message);
	            });
		    },
		getImages: function(){
			 axios.get('resources/featuredimage', {
				  
			  })
			  .then(function (response) {
				
				  for(let i =0;i<response.data.length;i++){
					let obj = new Object();
                    obj.id= "resources/image/featured/"+response.data[i].id;
                    obj.email = response.data[i].email;
                    obj.username = response.data[i].username; 
                    obj.tags = response.data[i].tags;
                    obj.profilepic = "resources/displayProfilePic/"+response.data[i].email; 
                    if(i%2==0){
                      vm.userImages.push(obj);
                    }else{
                      vm.userImages1.push(obj);	
                    }
				  }
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
		},
		download: function(image){
			
			let id= image.id.slice(image.id.lastIndexOf("/")+1,image.id.length);			
	        window.location = `resources/download/${id}`;	      
		}
	  },
	  mounted: function(){
		  this.getSessionId();
		  this.getImages();
	  }
 
})
