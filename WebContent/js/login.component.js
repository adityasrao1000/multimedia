var login=new Vue({
  el: '#login',
  data() {
	  return{
	    status: '',
	    email:'',
	    pwd: ''
	  }
  },
  methods:{
	    loginValidate: function(){
	    	 
	    	 let useremail = this.email;
	    	 axios.post('loginValidation', "email="+ this.email+"&pwd="+this.pwd,{
		  		  
		  	  })
		  	  .then(function (response) {

		  		if(response.data =="valid"){
		  			localStorage.setItem("useremail",useremail.trim());
		  			window.location = "home";
		  		}else{
		  			login.status= 'Your email or password is incorrect';
		  		}
		  		  
		  	  })
		  	  .catch(function (error) {
		  	    console.log(error);
		  	  });
	    }
	  }  

})