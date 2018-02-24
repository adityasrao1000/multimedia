const index = {
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
				 axios.get(`resources/totalUserUploads/${useremail}`, {
					  
				  })
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
				  this.username = response.data.username;
				  this.pp = this.pp + response.data.email;
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
			this.userUploads();
		},
		
		getImages: function(){
			 let userImages=this.userImages;
			 let userImages1=this.userImages1;
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
                    userImages.push(obj);
                  }else{
                	  userImages1.push(obj);	
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
	  },
	template:`<div class="container-fluid" id="index">
	<br>
	
	<div class="row">
		<div class="col-sm-2">
		
		</div>
		<div class="col-sm-8 col-xs-12">
		  <div class="row">
			  <div class="col-sm-6 ">
		  <div v-for="item in userImages" class="card">
		    <div class="row" style="margin-bottom:-62px; width:100%; background: rgba(0, 0, 0, 0.3); z-index:1; margin-left:0px;">
		      <div class="col-7">
			      <!-- Left-aligned media object -->
				  <div class="media" style="margin-top:8px; margin-bottom:-6px;">
				    <div class="media-left">
				      <img v-bind:src="item.profilepic" class="media-object" style="width:40px; height:40px; border-radius:50%;margin-right:7px">
				    </div>
				    <div class="media-body">
				      <b class="media-heading" style="cursor:pointer">{{item.username}}</b>
				      <p style="font-size:.9em; color:red"><i class="fa fa-heart" aria-hidden="true"></i> <i class="fa fa-heart" aria-hidden="true"></i> <i class="fa fa-heart" aria-hidden="true"></i></p>
				    </div>
				  </div>
				  
		      </div>
		      <div class="col-5">
		        <div style="display:block; text-align:right">	           
		            <button type="button" class="btn btn-outline-danger btn-sm" style="margin-top:12px;" @click="download(item)">Download</button>
			    </div>
		      </div>
		    </div>
			  
			  <div class="img-cont">
			    <img v-bind:src="item.id" type="image" class="img-fluid" style="width:100%;">
			  </div>		 
			  <ul class="tags">
				  <li><p v-for="t in item.tags" class="tag"><span class="cut">{{t}}</span></p></li>				  
			  </ul>	
		  </div>
			  </div>
			  <div class="col-sm-6 ">
		    <div v-for="item in userImages1" class="card">
		    <div class="row" style="margin-bottom:-62px; width:100%; background: rgba(0, 0, 0, 0.3); z-index:1; margin-left:0px;">
		      <div class="col-7">
			      <!-- Left-aligned media object -->
				  <div class="media" style="margin-top:8px;margin-bottom:-6px;">
				    <div class="media-left">
				      <img v-bind:src="item.profilepic" class="media-object" style="width:40px; height:40px; border-radius:50%;margin-right:7px">
				    </div>
				    <div class="media-body">
				      <b class="media-heading" style="cursor:pointer">{{item.username}}</b>
				      <p style="font-size:.9em; color:red"><i class="fa fa-heart" aria-hidden="true"></i> <i class="fa fa-heart" aria-hidden="true"></i> <i class="fa fa-heart" aria-hidden="true"></i></p>
				    </div>
				  </div>
				  
		      </div>
		      <div class="col-5">
		        <div style="display:block; text-align:right">	            
		            <button type="button" class="btn btn-outline-danger btn-sm" style="margin-top:12px;" @click="download(item)">Download</button>
			    </div>
		      </div>
		    </div>
			  
			  <div class="img-cont">
			    <img v-bind:src="item.id" type="image" class="img-fluid" style="width:100%;">
			  </div>		 
			  <ul class="tags">
				  <li><p v-for="t in item.tags" class="tag"><span class="cut">{{t}}</span></p></li>				  
			  </ul>	
		  </div>
		  </div>
		  </div>
		  
		  
		</div>
		<div class="col-sm-2">
		
		</div>
	</div> 
	</div>`,
	  
}
