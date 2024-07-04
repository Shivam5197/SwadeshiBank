$(document).ready(function(){
	

});


function onload(){
	var ajaxObject = new MasterAjax();
	ajaxObject.requestType = "GET";
	ajaxObject.url = "/swadeshiBank/v1/manager/getUsers";
	ajaxObject.contentType = false;
	ajaxObject.enctype = false;
	ajaxObject.requestData(function(responseData) {
		if (responseData.status == "OK" || responseData.status == "ok" ) {
		let user = JSON.parse(responseData.data);
			console.log(responseData);
		} else {
			console.log(responseData);
		}
	});
}