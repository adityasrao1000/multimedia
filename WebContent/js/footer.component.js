var footer=Vue.component('my-footer', {
 data(){
	 return{
	
	 }
  },
	methods: {
		
	
		  	},
  template: `
<div class="footer" style="background:black;  floaat:bottom; display:block; margin-top:70px">
 <div style="height:10px; background:#f44336"></div>

   <div style="max-width: 160px; display:block;margin:auto; margin-top:11px;">
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
<p style="text-align:center;font-size:.9em; margin-top:10px;margin-bottom:0px ">&copy; Wallpapers</p>

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