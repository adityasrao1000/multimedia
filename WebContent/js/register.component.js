var register=new Vue({
	
  el: '#register',
  data() {
	  return{
    status: '',
    emailStatus:'',
    email:'',
    pwd1: '',
    pwd2: '',
    username: ''
	  }
  },
  methods:{
	   emailcheck: function(){
		   
		   var patt = new RegExp(/^[a-zA-Z0-9]+(@)[a-zA-Z0-9]+/);
		   
		   if(patt.test(this.email)){
		   axios.get(`resources/emailcheck/${this.email}`,  {
			   
		      })
			  .then(function (response) {
				  if(response.data.status==='true'){
					  register.emailStatus="* This email already exists, please use a different email."; 
				  }else{
					  register.emailStatus =""; 
				  }
				  
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
		   }
	   },
	   formsubmit(){
	       if(this.pwd1!==this.pwd2){
	    	   alert("passwords should match!");
	    	   return false;
	       }
		   axios.post('resources/Register', `email=${this.email}&pwd1=${this.pwd1}&pwd2=${this.pwd2}&username=${this.username}`, {
				  
		      })
			  .then(function (response) {
				  
				  if(response.data.status=="success"){
					  
					 let redirect= confirm("You have successfully created an account with us, would you like to login to your account now?");

					 if(redirect===true){				
						 window.location.href='login'
					 }
				  }else{
					  alert("Pleace check the data you have entered and try again");
				  }
				  
			  })
			  .catch(function (error) {
				alert("Pleace check the data you have entered and try again");
			    console.log(error);
			  });
	   }
	  }  

});