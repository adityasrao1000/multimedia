var vm = new Vue({
	  el: '#index',
	  data: {
	    data: '',
	    title: 'video title goes here'
	  },
	  methods: {
	    video: function(){
	    	axios.get('Video')
	    	  .then(function(response){
	    		document.getElementById("vid").src='data:video/mp4;base64, ' + response.data; // ex.: { user: 'Your User'}
	    	    console.log(response.status); // ex.: 200
	    	  }); 
	    }
	  }
})
vm.video();
