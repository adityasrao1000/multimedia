
var vm = new Vue({
	  el: '#resetpassword',
	  data() {
		  return{
	        email:''	   
		  }
	  },
	  methods: {
		 
		generateotp: function(){
			axios.put(`resources/forgotPassword/${this.email}`, {
				  
			  })
			  .then(function (response) {
				 alert(response.data)
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
		}
		
		
	  },
	  mounted: function(){
		
	  }
 
})
