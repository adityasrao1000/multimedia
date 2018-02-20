
var vm = new Vue({
	  el: '#usersettings',
	  data() {
		  return{
	        oldpwd:'',
	        newpwd1:'',
	        newpwd2:'',
	        username:''
		  }
	  },
	  methods: {
		  submitPasswordChange: function(){
		
				if(this.newpwd1.length<6 || this.newpwd2.length<6){
					alert("your password should be atleast 6 characters long")
					return;
				}
				if(this.newpwd1!==this.newpwd2){
					alert("your passwords do not match");
					return;
				}
				axios.put(`resources/changePassword/${this.oldpwd}/${this.newpwd1}`,  {
					   
			      })
				  .then(function (response) {
					  if(response.status ===404){
						  alert("oops something went wrong please try again");
					  }else{
						  alert("your password has been successfully changed")
					  }
					  
				  })
				  .catch(function (error) {
				    console.log(error);
				  });
				
			},
		changePassword: function(){
		
			axios.get(`resources/verifyPassword/${this.oldpwd}`, {
				  
			  })
			  .then(function (response) {
				  if(response.data){
					  vm.submitPasswordChange();
				  }
			  })
			  .catch(function (error) {
			    
			  });
		}
		
	  },
	  mounted: function(){
		  
	  }
 
})
