var footer=Vue.component('my-footer', {
 data(){
	 return{
	
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
	       <object data="assets/social/facebook-logo.svg" style="margin:auto" class="embed-responsive"></object>
	     </div>
	     <div class="col-4">
	       <object data="assets/social/google-plus-symbol.svg" style="margin:auto" class="embed-responsive"></object>
	     </div>
	     <div class="col-4">
	       <object data="assets/social/instagram.svg" style="margin:auto" class="embed-responsive"></object>
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