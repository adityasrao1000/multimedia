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
	    	 
	    	 
	    	 axios.post('loginValidation', "email="+ this.email+"&pwd="+this.pwd,{
		  		  
		  	  })
		  	  .then(function (response) {

		  		if(response.data =="valid"){
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