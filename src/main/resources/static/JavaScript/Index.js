$(document).ready(function(){
	
	var ajaxObject = new MasterAjax();
	console.log("ajax url :" + ajaxObject.url)
	ajaxObject.requestType = "POST";
	ajaxObject.url = "manager/getUsers";
	ajaxObject.contentType = false;
	ajaxObject.enctype = false;
	ajaxObject.requestData(function(responseData) {
		if (responseData.status == "OK" || responseData.status == "ok" ) {
		let user = responseData;
			console.log(user);
		let table  = `<div class="row">
  <div class="column" style="background-color:#aaa;">
    <h2>Colume 1 </h2>
    <p>${user.data}</p>
  </div>
  <div class="column" style="background-color:#bbb;">
    <h2>Column 2</h2>
   <p>${user.message}</p>
  </div>
  <div class="column" style="background-color:#ccc;">
    <h2>Column 3</h2>
    <p>${user.status}</p>
  </div>
</div>`;
			
	document.getElementById("myDiv").innerHTML = table;		
			
			
			
			
		} else {
			console.log(responseData);
		}
	});
});


function onlod(){

}


function consoleLogs(){
	console.log("Hey There I am Called");
}