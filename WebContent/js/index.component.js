
	
var vm = new Vue({
	  el: '#index',
	  data() {
		  return{
	        username: ''
		  }
	  },
	  methods: {
		getSessionId: function(){
			axios.post('getSessionDetails', {
				  
			  })
			  .then(function (response) {
				  vm.username = response.data;
				  
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
		}
		},
		  
	  mounted: function(){
		  this.getSessionId();
		  
	  }
 
})