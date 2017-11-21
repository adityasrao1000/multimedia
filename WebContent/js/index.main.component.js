var vm = new Vue({
	  el: '#index',
	  data: {
	    data: '',
	    title: 'video title goes here',
	    items: [
	        { message: 'http://localhost:3000/list/Anime mix 10 seconds.mp4',title:'Video title goes here hg hgghfhg hghgj hhgjgj!!' },
	        { message: 'http://localhost:3000/list/Madara Uchiha AMV.mp4',title: 'some title goes here !!' },
	        { message: 'http://localhost:3000/list/sample.mp4',title: 'some title goes here !!' },
	        { message: 'http://localhost:3000/list/bestamv1.mp4',title: 'some title goes here !!' },
	        { message: 'http://localhost:3000/list/salvation.mp4',title: 'some title goes here !!' }
	      ],
        url: 'http://localhost:3000/video'
	  },
	  methods: {
        popup: function(id){
         this.url = id.message;
         this.title =  id.title;
        }
	  }
})

