var login=new Vue({
	
  el: '#register',
  data() {
	  return{
    status: '',
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
				  alert(response.data.status)
				  
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
				  alert(response.data.status)
				  if(response.data.status=="success"){
					 let redirect= confirm("You have successfully created an account with us, would you like to login to your account now?");
				  }
				  
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
	   }
	  }  

});