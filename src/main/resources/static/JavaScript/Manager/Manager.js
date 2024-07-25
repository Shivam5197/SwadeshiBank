
function getListOfPendingAccounts() {
    let content = "";
    let obj = new MasterAjax();
    obj.requestType = "GET";
    obj.url = "management/pendingAccountList";
    obj.contentType = false;
    obj.processData = false;
    obj.requestData(function (responseData, responseStatusCode) {
        if (responseData && (responseData.status === "OK" || responseData.status === "ok")) {
            var data = JSON.parse(responseData.data);
            console.log(data);
            if (data.length != 0) {
                let currentPage = 1;
                let rowsPerPage = 10;
                let filteredData = data;

                function displayTablePage(page, dataToDisplay) {
                    let startIndex = (page - 1) * rowsPerPage;
                    let endIndex = startIndex + rowsPerPage;
                    let paginatedData = dataToDisplay.slice(startIndex, endIndex);

					let tableRows = paginatedData.map((data, index) => `
					    <tr>
					        <th scope="row">${startIndex + index + 1}</th>
					        <td>${data.fullname}</td>
					        <td>${data.dateOfBirth}</td>
					        <td>${data.email}</td>
					        <td>${data.mobileNumber}</td>
					        <td>Rs. ${formatCurrency(data.annualIncome)}</td>
					        <td class="align-right">
							<select class="form-select" id="ApplicationActions" onchange="handleActionChange(this, ${data.daftId})">
							    <option value="">Select Action</option>
							    <option value="Review">Review Application</option>
							    <option value="Approve">Approve Application</option>
							    <option value="Reject">Reject Application</option>
							</select>
					        </td>
					    </tr>
					`).join("");
					
                    document.getElementById("tableBody").innerHTML = tableRows;
                    document.getElementById("pagination").innerHTML = createPaginationButtons(dataToDisplay.length, rowsPerPage, currentPage);
                }

				
				function changePage(page) {
				                 currentPage = page;
				                 displayTablePage(page, filteredData);
				             }
							 
				
                function createPaginationButtons(totalRows, rowsPerPage, currentPage) {
                    let totalPages = Math.ceil(totalRows / rowsPerPage);
                    let buttons = "";

                    for (let i = 1; i <= totalPages; i++) {
                        buttons += `<button class="btn ${i === currentPage ? 'btn-primary' : 'btn-secondary'} mx-1" onclick="changePage(${i})">${i}</button>`;
                    }
                    return buttons;
                }

                function searchTable(query) {
                    filteredData = data.filter(item => 
                        item.fullname.toLowerCase().includes(query.toLowerCase()) ||
                        item.dateOfBirth.toLowerCase().includes(query.toLowerCase()) ||
                        item.email.toLowerCase().includes(query.toLowerCase()) ||
                        item.mobileNumber.toLowerCase().includes(query.toLowerCase()) ||
                        item.annualIncome.toLowerCase().includes(query.toLowerCase())
                    );
                    displayTablePage(1, filteredData); // Reset to page 1 on new search
                }

                content = `<div class="card mb-4 mt-4 shadow-sm" style="background-color: whitesmoke;">
                    <div class="card-body text-center">
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <h2 style="color: darkgray;">Pending Accounts</h2>
                            <input type="text" id="searchBar" class="form-control w-25" placeholder="Search...">
                        </div>
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Full Name</th>
                                    <th scope="col">Date of Birth</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Mobile Number</th>
                                    <th scope="col">Annual Income</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody id="tableBody"></tbody>
                        </table>
                        <div id="pagination" class="d-flex justify-content-center"></div>
                    </div>
                </div>`;

                document.getElementById("ManagerContent").innerHTML = content;
                document.getElementById("searchBar").addEventListener("input", (e) => searchTable(e.target.value));
                displayTablePage(currentPage, data); // Initial page load
            } else {
                content = `<div class="d-flex justify-content-center align-items-center vh-100">
                    <img src="/Images/home/NoDataFound.jpg" alt="Nothing Found Image" class="centered-image" style="max-width: 42vw; max-height: 88vh;">
                </div>`;
                document.getElementById("ManagerContent").innerHTML = content;
            }
        } else {
            content = `<div class="d-flex justify-content-center align-items-center vh-100">
                <img src="/Images/home/NoDataFound.jpg" alt="Nothing Found Image" class="centered-image" style="max-width: 42vw; max-height: 88vh;">
            </div>`;
            document.getElementById("ManagerContent").innerHTML = content;
            console.log(responseData);
        }
    });
}




function formatCurrency(number) {
    // Convert number to string
    var numStr = number.toString();

    // Split the string into parts based on every three characters from the end
    var parts = [];
    while (numStr.length > 3) {
        parts.unshift(numStr.slice(-3));
        numStr = numStr.slice(0, -3);
    }
    parts.unshift(numStr); // Add the remaining part

    // Join the parts with commas
    return parts.join(',');
}

function handleActionChange(selectElement, daftId) {
        const action = selectElement.value;
        switch (action) {
            case 'Review':
                ViewCustomerDetails(daftId);
                break;
            case 'Approve':
                ApproveCustomer(daftId);
                break;
            case 'Reject':
                RejectCustomer(daftId);
                break;
            default:
                // No action selected
                break;
        }
    }


function ApproveCustomer(customerId){

	console.log("I am called");
let obj = new MasterAjax();
obj.requestType = "POST";
obj.url = "management/NewCustomerApprove";
obj.data = customerId; // Convert customerId to JSON
obj.contentType = "application/json"; // Set content type to JSON
obj.processData = true; // Allow processing of d
obj.requestData(function (responseData, responseStatusCode) {
    if (responseData && (responseData.status === "OK" || responseData.status === "ok")) {
        swal({
            title: "Congrats !",
            text: responseData.message,
            icon: "success",
            button: "OK"
        });
		getListOfPendingAccounts();
    } else {
        console.log(responseData);
    }
});

}