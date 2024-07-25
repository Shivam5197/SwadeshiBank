<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
   <head>
       <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Swadeshi Bank</title>
      <!-- JSTL Tags Start -->
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
      <!-- JSTL Tags end -->

      <!-- External JS libraries -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
         integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
         crossorigin="anonymous"></script>
      <!-- External JS libraries -->

      <!-- External CSS libraries -->
      <%-- Sweet Alert CDN --%>
      <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'>
      <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
      <%-- Sweet Alert CDN --%>
      
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
         rel="stylesheet"
         integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
         crossorigin="anonymous">
      <!-- External CSS libraries -->

      <!-- Internal JS files  -->
      <script type="text/javascript" charset="utf8" src="<c:url value='/JavaScript/Utils/MasterAjax.js'/>"></script>
      <script type="text/javascript" charset="utf8" src="<c:url value='/JavaScript/Index.js'/>"></script>
      <script type="text/javascript" charset="utf8" src="<c:url value='/JavaScript/Open/Register.js'/>"></script>
      <!-- Internal JS files  -->

      <!-- Internal CSS files  -->
      <link type="text/css" href="<c:url value='/CSS/home.css'/>" rel="stylesheet">
      <!-- Internal CSS files  -->

      <script type="text/javascript">
         var global_contextPath = "${request.getContextPath()}";
         console.log("global_contextPath: " + global_contextPath);
      </script>

      <style>
         body {
         background: linear-gradient(to bottom right, #000000, #7ED6DF);
         /* Dark cyan gradient */
         color: #333;
         }
         label {
         font-weight: bold;
         }
         .card {
         border-radius: 15px;
         margin-bottom: 20px;
         width: 100%;
         background: rgba(255, 255, 255, 0.2);
         /* Semi-transparent white background */
         border-radius: 10px;
         backdrop-filter: blur(10px); /* Glass effect */
         box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3); /* Soft shadow */
         padding: 2rem;
         }
         .form-group {
         margin-top: 5%;
         }
         .form-control {
         border-radius: 10px;
         }
         .form-check-input {
         margin-top: 0.3rem;
         }
         .personalContainer {
         width: 80%;
         padding: 1rem;
         margin-left: 10%;
         margin-right: 10%;
         /* box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); */
         border-radius: 0.5rem;
         }
         .range-label {
         margin-top: 1rem;
         font-size: 1.2rem;
         }
         .vertical-line {
         border-left: 1px solid #4C4646;
         text-align: center;
         margin-left: 3%;
         }
         h5 {
         text-align: center;
         }
         .checkbox-container {
         margin-top: 1.5rem;
         text-align: left;
         }
         .checkbox-container label {
         font-size: 1rem;
         margin-left: 0.5rem;
         }
         .terms {
         margin-top: 1rem;
         }
         .terms a {
         color: #007bff;
         text-decoration: none;
         }
         .terms a:hover {
         text-decoration: underline;
         }
         .submit-button {
         margin-top: 2rem;
         padding: 1rem 2rem;
         font-size: 1.2rem;
         color: white;
         background: linear-gradient(to right, darkcyan, lightcyan);
         border: none;
         border-radius: 0.5rem;
         cursor: pointer;
         transition: background 0.3s ease;
         width: 100%;
         }
         .submit-button:hover {
         background: linear-gradient(to right, lightcyan, darkcyan);
         }
          .highlight {
            border: 2px solid red;
        }
      </style>
   </head>
   <body>
      <div class="personalContainer mt-5">
         <div class="row">
            <div class="col-md-4">
               <div class="card p-5">
                  <h5 class="card-title" style="">Personal Details</h5>
                  <form>
                     <div class="form-group">
                        <label for="firstName">Full Name*</label>
                        <div class="input-group">
                           <div class="input-group-prepend">
                              <select style="background-color: #F5F5F5;" class="form-control"
                                 id="prefix">
                                 <option value="Mr.">Mr.</option>
                                 <option value="Mrs.">Mrs.</option>
                                 <option value="Miss">Miss</option>
                                 <option value="Ms.">Ms.</option>
                                 <option value="Dr.">Dr.</option>
                                 <option value="Prof.">Prof.</option>
                                 <option value="Hon.">Hon.</option>
                                 <option value="Sir">Sir</option>
                              </select>
                           </div>
                           <input type="text" class="form-control" id="firstName"
                              placeholder="ex: Vishal Sharma">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="lastName">Father's Name/Spouse's Name*</label> <input
                           type="text" class="form-control" id="lastName"
                           placeholder="ex: Tej Prakash Sharma">
                     </div>
                     <div class="form-group">
                        <label for="middleName">Mother's Name*</label> <input type="text"
                           class="form-control" id="middleName"
                           placeholder="ex: Indra Devi Sharma">
                     </div>
                     <div class="row">
                        <div class="col-md-6">
                           <div class="form-group">
                              <label for="dob">Date of Birth*</label> <input type="date"
                                 class="form-control" id="dob" placeholder="10/09/1992">
                           </div>
                        </div>
                        <div class="col-md-6">
                           <div class="form-group">
                              <label for="gender">Gender</label> 
                              <select class="form-control"
                                 id="gender">
                                 <option value="male">Male</option>
                                 <option value="female">Female</option>
                              </select>
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="email">Email*</label> <input type="email"
                           class="form-control" id="email"
                           placeholder="alistratova23@gmail.com">
                     </div>
                     <div class="form-group">
                        <label for="phone">Mobile Number*</label> <input type="tel"
                           class="form-control" id="phone" placeholder="+12354678645">
                     </div>
                     <div class="form-group">
                        <label for="userName">User Name*</label> <input type="text"
                           class="form-control" id="userName" placeholder="harry@89689">
                     </div>
                     <div class="form-group">
                        <label for="maritalStatus">Marital Status</label> 
                        <select
                           class="form-control" id="maritalStatus">
                           <option value="single">Single</option>
                           <option value="married">Married</option>
                        </select>
                     </div>
                     <div class="form-group">
                        <label for="Category">Category</label> 
                        <select
                           class="form-control" id="Category">
                           <option value="general">General</option>
                           <option value="sc/st">SC/ST</option>
                           <option value="obc">OBC</option>
                        </select>
                     </div>
                     <div class="form-group">
                        <label for="issuedBy">Aadhaar Card*</label> <input type="number"
                           class="form-control" id="Aadhaar_Card"
                           placeholder="7894651326845123">
                     </div>
                     <div class="form-group">
                        <label for="issueDate">PAN Card*</label> <input type="text"
                           class="form-control" id="pancard" placeholder="KHAS21323">
                     </div>
                  </form>
               </div>
            </div>
            <div class="col-md-8">
               <div class="card p-3 mb-3">
                  <div class="row">
                     <div class="col-md-4">
                        <h5 class="card-title">Professional Details*</h5>
                        <form>
                           <div class="form-group">
                              <label for="Occupation">Occupation*</label> <input type="text"
                                 class="form-control" id="Occupation" placeholder="Business">
                           </div>
                           <div class="form-group">
                              <label for="Organisation">Organization</label> <input
                                 type="text" class="form-control" id="Organization"
                                 placeholder="Organization">
                           </div>
                           <div class="form-group">
                              <label for="deliveryAddress">Annual Income</label> <input
                                 type="range" class="form-control-range" min="1000"
                                 max="10000000" step="100" id="rangeInput">
                              <div class="range-label">
                                 Value: <span id="rangeValue">1000</span>
                              </div>
                              <input type="number" class="input-number form-control"
                                 min="1000" max="100000" step="100" id="numberInput"
                                 value="1000">
                           </div>
                        </form>
                     </div>
                     <div class="vertical-line col-md-1"></div>
                     <div class="col-md-6">
                        <h5 class="card-title">Account Details*</h5>
                        <form>
                           <div class="form-group">
                              <label for="accountType">Account Type</label> 
                              <select
                                 class="form-control" id="accountType">
                                 <option value="Savings">Savings</option>
                                 <option value="Checking">Checking</option>
                                 <option value="Business">Business</option>
                                 <option value="Joint">Joint</option>
                                 <option value="Student">Student</option>
                                 <option value="Fixed Deposit">Fixed Deposit</option>
                                 <option value="Recurring Deposit">Recurring Deposit</option>
                              </select>
                           </div>
                     <div class="form-group">
                        <label for="maritalStatus">Net Banking?</label> 
                        <select
                           class="form-control" id="netBanking">
                           <option value="Yes">Yes</option>
                           <option value="No">No</option>
                        </select>
                     </div>
                           <div class="form-group">
                              <label for="deliveryAddress">Account Opening amount</label> <input
                                 type="range" class="form-control-range" min="1000"
                                 max="100000" step="100" id="rangeInputOpeningAmount">
                              <div class="range-label">
                                 Value: <span id="rangeValue">1000</span>
                              </div>
                              <input type="number" class="input-number form-control"
                                 min="1000" max="100000" step="100" id="openingAmout"
                                 value="1000">
                           </div>
                        </form>
                     </div>
                  </div>
               </div>
               <div class="card p-3 mb-3">
                  <div class="row">
                     <div class="col-md-4">
                        <h5 class="card-title">Nominee Details</h5>
                        <form>
                           <div class="form-group">
                              <label for="Nominee_fullname">Full Name*</label> <input
                                 type="text" class="form-control" id="Nominee_fullname"
                                 placeholder="Ram Narayan">
                           </div>
                           <div class="form-group">
                              <label for="Nominee_relation">Relation *</label> <input
                                 type="text" class="form-control" id="Nominee_relation"
                                 placeholder="Father">
                           </div>
                           <div class="form-group">
                              <label for="NomineeAadhar">Aadhar Card*</label> <input
                                 type="number" class="form-control" id="NomineeAadhar"
                                 placeholder="7894651326845123">
                           </div>
                           <div class="form-group">
                              <label for="NomineePan">Pan Card *</label> <input type="text"
                                 class="form-control" id="NomineePan" placeholder="WERT456321">
                           </div>
                           <div class="form-group">
                              <label for="nomineePhoneNumber">Mobile Number *</label> <input
                                 type="tel" class="form-control" id="nomineePhoneNumber"
                                 placeholder="87946513215">
                           </div>
                        </form>
                     </div>
                     <div class="vertical-line col-md-1"></div>
                     <div class="col-md-6">
                        <h5 class="card-title">Address Details</h5>
                        <form>
                           <div class="form-group">
                              <label for="Address">Address</label> <input type="text"
                                 class="form-control" id="Address"
                                 placeholder="b-1/abc d-04 near buman store">
                           </div>
                           <div class="form-group">
                              <label for="city">City</label> <input type="text"
                                 class="form-control" id="city" placeholder="New Delhi">
                           </div>
                           <div class="form-group">
                              <label for="State">State</label> <input type="text"
                                 class="form-control" id="State" placeholder="New Delhi">
                           </div>
                           <div class="form-group">
                              <label for="PinCode">PinCode</label> <input type="text"
                                 class="form-control" id="PinCode" placeholder="201005">
                           </div>
                        </form>
                     </div>
                  </div>
                  <div class="row ml-3">
        <div class="checkbox-container">
            <input class="form-check-input" type="checkbox" id="confirmationCheckbox">
            <label for="confirmationCheckbox">
                I confirm that the above information is checked and correct as per the customer.
            </label>
        </div>
    </div>
    <div class="row ml-3">
        <div class="terms">
            <input class="form-check-input" type="checkbox" id="termsCheckbox">
            <label for="termsCheckbox">
                I agree to the <a href="#terms">Terms and Conditions</a>.
            </label>
        </div>
    </div>
    <div class="row">
        <button class="submit-button" onclick="getFormData();" disabled>Open Account</button>
    </div>
               </div>
            </div>
         </div>
      </div>
      </div>
      <script>
         const rangeInput = document.getElementById('rangeInput');
         const rangeValue = document.getElementById('rangeValue');
         const numberInput = document.getElementById('numberInput');
         
         // Update the displayed value when the range input changes
         rangeInput.addEventListener('input', function() {
         	rangeValue.textContent = rangeInput.value;
         	numberInput.value = rangeInput.value;
         });
         
         // Update the range input when the number input changes
         numberInput.addEventListener('input', function() {
         	rangeInput.value = numberInput.value;
         	rangeValue.textContent = numberInput.value;
         });
         
         
         
         function toggleSubmitButton() {
             const confirmationCheckbox = document.getElementById('confirmationCheckbox');
             const termsCheckbox = document.getElementById('termsCheckbox');
             const submitButton = document.querySelector('.submit-button');

             const isConfirmationChecked = confirmationCheckbox.checked;
             const isTermsChecked = termsCheckbox.checked;

             submitButton.disabled = !(isConfirmationChecked && isTermsChecked);

             if (!isConfirmationChecked) {
                 confirmationCheckbox.classList.add('highlight');
             } else {
                 confirmationCheckbox.classList.remove('highlight');
             }

             if (!isTermsChecked) {
                 termsCheckbox.classList.add('highlight');
             } else {
                 termsCheckbox.classList.remove('highlight');
             }
         }

         document.addEventListener('DOMContentLoaded', () => {
             const confirmationCheckbox = document.getElementById('confirmationCheckbox');
             const termsCheckbox = document.getElementById('termsCheckbox');

             confirmationCheckbox.addEventListener('change', toggleSubmitButton);
             termsCheckbox.addEventListener('change', toggleSubmitButton);

             // Initialize button state
             toggleSubmitButton();
         });
      </script>
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script
         src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
      <script
         src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   </body>
</html>