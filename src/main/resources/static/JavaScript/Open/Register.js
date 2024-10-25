function getFormData() {
    let formData = new FormData();

    // Get values from input fields
    let fullName = document.getElementById('prefix').value + " " + document.getElementById('firstName').value;
    let fatherName = document.getElementById('lastName').value;
    let motherName = document.getElementById('middleName').value;
    let dateOfBirth = document.getElementById('dob').value;
    let gender = document.getElementById('gender').value;
    let email = document.getElementById('email').value;
    let mobileNumber = document.getElementById('phone').value;
    let userName = document.getElementById('userName').value;
    let maritalStatus = document.getElementById('maritalStatus').value;
    let category = document.getElementById('Category').value;
    let aadhaarCard = document.getElementById('Aadhaar_Card').value;
    let panCard = document.getElementById('pancard').value;
    let occupation = document.getElementById('Occupation').value;
    let organization = document.getElementById('Organization').value;
    let annualIncome = document.getElementById('rangeInput').value;
    let accountType = document.getElementById('accountType').value;
    let netBanking = document.getElementById('netBanking').value;
    let initialFunds = document.getElementById('openingAmout').value;
    let nomineeFullName = document.getElementById('Nominee_fullname').value;
    let nomineeRelation = document.getElementById('Nominee_relation').value;
    let nomineeAadhaar = document.getElementById('NomineeAadhar').value;
    let nomineePan = document.getElementById('NomineePan').value;
    let nomineeMobileNumber = document.getElementById('nomineePhoneNumber').value;
    let address = document.getElementById('Address').value;
    let city = document.getElementById('city').value;
    let state = document.getElementById('State').value;
    let pinCode = document.getElementById('PinCode').value;

	console.log("Value of initialFunds is : " + initialFunds)

    // Append values to formData
    formData.append("userName", userName);
    formData.append("fullname", fullName);
    formData.append("fatherName", fatherName);
    formData.append("motherName", motherName);
    formData.append("dateOfBirth", dateOfBirth);
    formData.append("gender", gender);
    formData.append("maritalStatus", maritalStatus);
    formData.append("category", category);
    formData.append("mobileNumber", mobileNumber);
    formData.append("email", email);
    formData.append("address", address);
    formData.append("state", state);
    formData.append("pinCode", pinCode);
    formData.append("city", city);
    formData.append("panNumber", panCard);
    formData.append("aadharNumber", aadhaarCard);
    formData.append("occupation", occupation);
    formData.append("annualIncome", annualIncome);
    formData.append("organisation", organization);
    formData.append("nominieFullName", nomineeFullName);
    formData.append("nominieAadharNumber", nomineeAadhaar);
    formData.append("nominieRelation", nomineeRelation);
    formData.append("nominiePanNumber", nomineePan);
    formData.append("nominieMobileNumber", nomineeMobileNumber);
    formData.append("UPIorNetBanking", netBanking);
    formData.append("initialFunds", initialFunds);
    formData.append("accountType", accountType);

    let fields = [
        { value: fullName, name: 'Full Name' },
        { value: fatherName, name: 'Father\'s Name/Spouse\'s Name' },
        { value: motherName, name: 'Mother\'s Name' },
        { value: dateOfBirth, name: 'Date of Birth' },
        { value: gender, name: 'Gender' },
        { value: email, name: 'Email' },
        { value: mobileNumber, name: 'Mobile Number' },
        { value: userName, name: 'User Name' },
        { value: maritalStatus, name: 'Marital Status' },
        { value: category, name: 'Category' },
        { value: aadhaarCard, name: 'Aadhaar Card' },
        { value: panCard, name: 'PAN Card' },
        { value: occupation, name: 'Occupation' },
        { value: organization, name: 'Organization' },
        { value: annualIncome, name: 'Annual Income' },
        { value: accountType, name: 'Account Type' },
        { value: netBanking, name: 'Net Banking' },
        { value: initialFunds, name: 'Account Opening Amount' },
        { value: nomineeFullName, name: 'Nominee Full Name' },
        { value: nomineeRelation, name: 'Nominee Relation' },
        { value: nomineeAadhaar, name: 'Nominee Aadhaar Card' },
        { value: nomineePan, name: 'Nominee PAN Card' },
        { value: nomineeMobileNumber, name: 'Nominee Mobile Number' },
        { value: address, name: 'Address' },
        { value: city, name: 'City' },
        { value: state, name: 'State' },
        { value: pinCode, name: 'Pin Code' }
    ];

    // Validate fields
    for (let field of fields) {
        if (!field.value || field.value.trim() === '') {
            swal('Error', `Please fill the ${field.name} field.`, 'error');
            return;
        }
    }

    // If all fields are filled, proceed with form submission or further processing
//    swal('Success', 'All fields are filled correctly!', 'success');

    let obj = new MasterAjax();
    obj.requestType = "POST";
    obj.url = "registerNewUser";
    obj.data = formData;
    obj.contentType = false;
    obj.processData = false;
    obj.requestData(function (responseData, responseStatusCode) {
        if (responseData && (responseData.status === "OK" || responseData.status === "ok")) {
            swal({
                title: "Congrats !",
                text: responseData.message,
                icon: "success",
                button: "OK"
            });
        } else {
            console.log(responseData);
        }
    });
}
