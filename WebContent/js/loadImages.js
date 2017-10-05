$(document).ready(function(){
       var img = document.getElementById("img");
        $.get("Image", function(data, status){
        	for(var i = 0;i<data.length;i++){
        		var para = document.createElement("img");
        		para.src = "data:image/jpeg;base64, "+ data[i];
        		para.onclick = function(){modal.style.display = "block"; modalImg.src = this.src;};
        		para.className="images img-responsive"
        		img.appendChild(para);
        	}
            

        });
});