var register=new Vue({
	
  el: '#register',
  data() {
	  return{
    status: '',
    emailStatus:'',
    email:'',
    pwd1: '',
    pwd2: ''
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
	   
		   axios.post('Register', `email=${this.email}&pwd1=${this.pwd1}&pwd2=${this.pwd2}`, {
				  
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
			    console.log(error);
			  });
	   }
	  }  

});