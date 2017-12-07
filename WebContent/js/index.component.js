
	
var vm = new Vue({
	  el: '#index',
	  data() {
		  return{
	        username: '',
	        userImages: []
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
		},
		getImages: function(){
			 axios.get('resources/featuredimage', {
				  
			  })
			  .then(function (response) {
				  let arr=[];
				  for(let i =0;i<response.data.length;i++){
				    arr.push("resources/image/"+response.data[i]);
				    vm.userImages =arr;
				  }
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
		}
	  },
		  
	  mounted: function(){
		  this.getSessionId();
		  this.getImages();
		  
	  }
 
})