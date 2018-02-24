<!DOCTYPE html>
<html>
<head>

<%@ include file="libraries.jsp" %>
<link rel="stylesheet" href="css/index.css">
 <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.16.2/axios.min.js"></script>
</head>
<body>
<div id="app">
<div id="nav">
  <my-navbar></my-navbar>
</div>
<router-view></router-view>



<div id="footer">
  <my-footer></my-footer>
</div>
</div>

<script src="./js/navbar.js"></script>
<script src="./js/footer.component.js"></script>
<script src="./js/index.component.js"></script>
<script>

const Foo = { template: '<div>foo</div>' }
const Bar = { 
   data(){
	  return{
		  msg:"hi"
	  } 
   },	
   template: '<div>{{msg}}</div>',
   mounted:function(){
   
  }
}


const routes = [
  { path: '/', component: index },
  { path: '/bar', component: Bar }
]


const router = new VueRouter({
  //mode: 'history',
  routes // short for `routes: routes`
})


const app = new Vue({
  router
}).$mount('#app')


</script>

</body>
</html>