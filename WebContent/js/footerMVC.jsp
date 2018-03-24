var foot=new Vue({
  el: '#footer',
  data(){
	 return{
		  facebook: `<%= request.getContextPath() %>/assets/social/facebook-logo.svg`,
          google: `<%= request.getContextPath() %>/assets/social/google-plus-symbol.svg`,
          instagram: `<%= request.getContextPath() %>/assets/social/instagram.svg`
	 }
  },
  methods: {
	

  },
})