var nav=new Vue({
  el: '#nav',
  data(){
	  return{
	    profile:'',
	    home: `<%= request.getContextPath() %>/home`,
		images: `<%= request.getContextPath() %>/images`,
		logout: `<%= request.getContextPath() %>/LogoutSessionInvalidate`,
		usersettings: `<%= request.getContextPath() %>/usersettings`,
		profile: `<%= request.getContextPath() %>/profile`,
        isActive: false,
        email: '',
        pwd: ''
	  }
  },
  methods:{
	  getSessionId: function(){
			axios.post(`<%= request.getContextPath() %>/getSessionDetails`, {
				  
			  })
			  .then(function (response) {
				  nav.profile = `<%= request.getContextPath() %>/resources/displayProfilePic/` + response.data.email;
				  document.getElementById("profile").src=nav.profile
				  
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
		},
		loginValidate: function(){
	    	 let useremail = this.email;
	    	
	    	 axios.post(`<%= request.getContextPath() %>/loginValidation`, "email="+ this.email+"&pwd="+this.pwd,{
		  		  
		  	  })
		  	  .then(function (response) {

		  		if(response.data =="valid"){
		  			localStorage.setItem("useremail",useremail.trim());
		  			window.location = `<%= request.getContextPath() %>/profile`;
		  		}else{
		  			let element = document.getElementById("incorrect-password");
   					element.classList.toggle("show");
		  		}
		  		  
		  	  })
		  	  .catch(function (error) {
		  	    console.log(error);
		  	  });
	    },
	    dismiss: function(){
	      let element = document.getElementById("incorrect-password");
   		  element.classList.toggle("show");
	    }
  },
  mounted:function(){
      axios.post(`<%= request.getContextPath() %>/CheckSessionValid`, {
	  		  
	  	  })
	  	  .then(function (response) {
	  		 if(response.data===true){
	  			document.getElementById("logout").style.display="block";
	  			document.getElementById("signup").style.display="none";
	  			
	  		 }else{
	  			document.getElementById("logout").style.display="none";
	  			document.getElementById("signup").style.display="block";
	  		
	  		 }
	  		  
	  	  })
	  	  .catch(function (error) {
	  	    console.log(error);
	  	  });
	  this.getSessionId()
  }
})