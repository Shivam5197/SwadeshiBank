/*$(document).ready(function(){
	

});
*/
/*UserDTO(userId=null, userName=Devil@123, firstName=Shivam, lastName=Sharma, mobileNumber=9958093592, emailID=null, age=28, address=C-1008 Kalash Homes, state=Maharasthra, city=Pune, pinCode=410251, aadharNumber=532755978532, panNumber=njKqpQPGXB, isActive=true, profession=Chhapri, accountsSet=null, cardsSet=null, loansSet=null, transactionsSet=null, authorities=[])
*/
function findByMobileNumber(){
mobileNumber= document.getElementById('mobileNumber').value;
	var ajaxObject = new MasterAjax();
	console.log("ajax url :" + ajaxObject.url +"Mobile number value: " +mobileNumber);
	ajaxObject.requestType = "POST";
	ajaxObject.url = "getUserByMobile/"+mobileNumber;
	ajaxObject.contentType = false;
	ajaxObject.enctype = false;
	ajaxObject.requestData(function(responseData) {
		if (responseData.status == "OK" || responseData.status == "ok" ) {
		let user = responseData.data;
			console.log(user);
		let table  = `<h1>${user.userId}</h1>
        <h1>${user.userName}</h1>
        <h1>${user.mobileNumber}</h1>
        <h1>${user.lastName}</h1>
>`;
			
	document.getElementById("myDiv").innerHTML = table;		

		} else {
			console.log(responseData);
		}
	});
}


function findAccountDetailsByuserName(){
userName= document.getElementById('userNameForAccounts').value;
	var ajaxObject = new MasterAjax();
	console.log("ajax url :" + ajaxObject.url +"Mobile number value: " +mobileNumber);
	ajaxObject.requestType = "POST";
	ajaxObject.url = "getAccountDetailsFor/"+userName;
	ajaxObject.contentType = false;
	ajaxObject.enctype = false;
	ajaxObject.requestData(function(responseData) {
		if (responseData.status == "OK" || responseData.status == "ok" ) {
		let user = JSON.parse(responseData.data);
		console.log(user);
		let table  = `<h1>${user.userId}</h1>
        <h1>${user.userName}</h1>
        <h1>${user.mobileNumber}</h1>
        <h1>${user.lastName}</h1>
>`;
			
	document.getElementById("myDiv").innerHTML = table;		

		} else {
			console.log(responseData);
		}
	});
}


function consoleLogs(){
		var ajaxObject = new MasterAjax();
	console.log("ajax url :" + ajaxObject.url)
	ajaxObject.requestType = "POST";
	ajaxObject.url = "registerNewUser";
	ajaxObject.contentType = false;
	ajaxObject.enctype = false;
	ajaxObject.requestData(function(responseData) {
		if (responseData.status == "OK" || responseData.status == "ok" ) {
		let user = JSON.parse(JSON.stringify(responseData.data));
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
  
  
  <div class="column" style="background-color:#ccc;">
      <h1>AJAX with JSP and REST Controller</h1>
    <input type="text" id="mobileNumber" placeholder="Enter a parameter"/>
    <button class="btn-primary" id="getDataButton" onclick="findByMobileNumber()">Get Data</button>
  </div>
  
  
    <div class="column" style="background-color:#ccc;">
      <h1>AJAX with JSP and REST Controller</h1>
    <input type="text" id="userNameForAccounts" placeholder="Enter a parameter"/>
    <button class="btn btn-success" id="userNameForAccounts" onclick="findAccountDetailsByuserName()">Get Data</button>
  </div>
  
  
</div>`;
			
	document.getElementById("myDiv").innerHTML = table;		

		} else {
			console.log(responseData);
		}
	});
}