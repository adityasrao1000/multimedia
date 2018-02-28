
var vm = new Vue({
	  el: '#index',
	  data() {
		  return{
	        username: '',
	        userImages: [],
	        userImages1: [],
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
			     var config = {
			    		  headers: {'accept': 'application/json'}
			    		};
				 axios.get(`resources/totalUserUploads/${useremail}`, {
					  
				  },config)
				  .then(function (response) {

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
		},
		viewimage: function(url){
			let id= url.slice(url.lastIndexOf("/")+1,url.length);			
	        window.location.assign(`resources/viewimage/${id}`);	      
		}
	  },
	  mounted: function(){
		  this.getSessionId();
		  this.getImages();
	  }
 
})
