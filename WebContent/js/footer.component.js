var footer=Vue.component('my-footer', {
 data(){
	 return{
	  facebook: `${contextPath}assets/social/facebook-logo.svg`,
	  google: `${contextPath}assets/social/google-plus-symbol.svg`,
	  instagram: `${contextPath}assets/social/instagram.svg`
	 }
  },
	methods: {
		
	
		  	},
  template: `
<div class="footer">
 <div id="footer-bar"></div>

   <div id="footer-social">
	   <p style="font-size:.60em;color:white;">Follow and like us on social media:</p>
	   <div class="row">
	     <div class="col-4">
	       <object v-bind:data="facebook" style="margin:auto" class="embed-responsive"></object>
	     </div>
	     <div class="col-4">
	       <object v-bind:data="google" style="margin:auto" class="embed-responsive"></object>
	     </div>
	     <div class="col-4">
	       <object v-bind:data="instagram" style="margin:auto" class="embed-responsive"></object>
	     </div>
	   </div>
   </div>
<br>
<p id="footer-copyrights">&copy; Wallpapers</p>

</div>

`

})
// create a root instance
var foot=new Vue({
  el: '#footer',
  data:{
	
  },
  methods:{
	
  }


})