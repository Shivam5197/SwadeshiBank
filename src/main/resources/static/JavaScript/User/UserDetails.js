


$(document).ready(function(){

	
	dashboard();

});





function dashboard(){
	console.log("I am called");
	
 let data = 	`<div class="d-flex justify-content-start flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">

	    <h1 class="h2">Dashboard</h1>
	</div>

	<div class="row">
	    <div class="col-md-3 mb-3">
	        <div class="card card-custom top-cards">
	            <div class="card-body">
	                <h5 class="card-title">Account Number</h5>
	                <p class="card-text">123456789</p>
	            </div>
	        </div>
	    </div>
	    <div class="col-md-3 mb-3">
	        <div class="card card-custom top-cards">
	            <div class="card-body">
	                <h5 class="card-title">Account Balance</h5>
	                <p class="card-text">$10,000</p>
	            </div>
	        </div>
	    </div>
	    <div class="col-md-3 mb-3">
	        <div class="card card-custom top-cards">
	            <div class="card-body">
	                <h5 class="card-title">CRN Number</h5>
	                <p class="card-text">CRN123456</p>
	            </div>
	        </div>
	    </div>
	    <div class="col-md-3 mb-3">
	        <div class="card card-custom top-cards">
	            <div class="card-body">
	                <h5 class="card-title">Account Activity</h5>
	                <p class="card-text">Active</p>
	            </div>
	        </div>
	    </div>
	</div>

	<div class="row">
	<div class="col-md-6 mb-3">
	                <div class="card card-custom">
	                    <div class="card-body">
	                        <h5 class="card-title">Savings</h5>
	                        <div class="chart-container">
	                            <canvas id="donutChart"></canvas>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="col-md-6 mb-3">
	                <div class="card card-custom">
	                    <div class="card-body">
	                        <h5 class="card-title">Spends</h5>
	                        <div class="chart-container">
	                            <canvas id="barChart"></canvas>
	                        </div>
	                    </div>
	                </div>
	            </div>

	<div class="row">
	    <div class="col-md-6 mb-3">
	        <div class="card card-custom">
	            <div class="card-body">
	                <!-- <h5 class="card-title">Calculate your EMI's</h5> -->
	               
	                    <h2 class="text-center mb-4">Loan EMI Calculator</h2>
	                    <form id="emiForm">
	                        <div class="form-group">
	                            <label for="loanType">Loan Type</label>
	                            <select class="form-control" id="loanType" name="loanType">
	                                <option value="homeLoan">Home Loan</option>
	                                <option value="carLoan">Car Loan</option>
	                                <option value="personalLoan">Personal Loan</option>
	                                <!-- Add more options as needed -->
	                            </select>
	                        </div>
	                        <div class="form-group">
	                            <label for="loanAmount">Loan Amount (in INR)</label>
	                            <input type="number" class="form-control" id="loanAmount" name="loanAmount" required>
	                        </div>
	                        <div class="form-group">
	                            <label for="interestRate">Interest Rate (%)</label>
	                            <input type="number" class="form-control" id="interestRate" name="interestRate" step="0.01" required>
	                        </div>
	                        <div class="form-group">
	                            <label for="loanTerm">Loan Term (months)</label>
	                            <input type="number" class="form-control" id="loanTerm" name="loanTerm" required>
	                        </div>
	                        <button type="submit" class="btn btn-primary btn-block">Calculate EMI</button>
	                    </form>
	                    <div id="emiResult" class="mt-4">
	                        <!-- EMI Calculation Result will be shown here -->
	                    </div>
	                
	            
	            </div>
	        </div>
	    </div>
	    <div class="col-md-6 mb-3">
	        <div class="card card-custom">
	            <div class="card-body">
	                <h5 class="card-title">Recent transactions</h5>
	                <table class="table table-hover table-custom">
	                    <thead>
	                        <tr>
	                            <th>Send To</th>
	                            <th>Account number</th>
	                            <th>Transaction time</th>
	                            <th>Transaction amount</th>
	                            <th>Transaction status</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                        <tr>
	                            <td>John Doe</td>
	                            <td>123456789</td>
	                            <td>2023-06-27</td>
	                            <td>$100</td>
	                            <td>Completed</td>
	                        </tr>
	                        <!-- More rows -->
	                    </tbody>
	                </table>
	            </div>
	        </div>
	    </div>
	</div>
`;
document.getElementById("content").innerHTML = data;
}


// Function to calculate EMI
function calculateEMI(event) {
          event.preventDefault();

          let loanType = document.getElementById('loanType').value;
          let loanAmount = parseFloat(document.getElementById('loanAmount').value);
          let interestRate = parseFloat(document.getElementById('interestRate').value) / 100 / 12; // Monthly interest rate
          let loanTerm = parseFloat(document.getElementById('loanTerm').value);

          if (loanAmount <= 0 || interestRate <= 0 || loanTerm <= 0) {
              alert('Please enter valid inputs.');
              return;
          }

          let emi = (loanAmount * interestRate * Math.pow(1 + interestRate, loanTerm)) / (Math.pow(1 + interestRate, loanTerm) - 1);

          // Display the EMI result
          let emiResultElement = document.getElementById('emiResult');
          emiResultElement.innerHTML = `
              <h4>Loan Type: ${loanType}</h4>
              <p>Loan Amount: ₹${loanAmount.toFixed(2)}</p>
              <p>Interest Rate: ₹${(interestRate * 12 * 100).toFixed(2)}% per annum</p>
              <p>Loan Term: ${loanTerm} months</p>
              <h5 class="mt-3">EMI (Equated Monthly Installment): ₹${emi.toFixed(2)}</h5>
          `;
      }

      // Attach form submission event listener
/*      document.getElementById('emiForm').addEventListener('submit', calculateEMI);
*/


window.setTimeout(function() {

	var ctxBar = document.getElementById('barChart').getContext('2d');
	var barChart = new Chart(ctxBar, {
	    type: 'bar',
	    data: {
	        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
	        datasets: [{
	            label: 'Spending',
	            data: [12, 19, 3, 5, 2, 3, 12],
	            backgroundColor: 'rgba(75, 192, 192, 0.2)',
	            borderColor: 'rgba(75, 192, 192, 1)',
	            borderWidth: 1
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero: true
	                }
	            }]
	        }
	    }
	});

}, 1000);
// Bar Chart

window.setTimeout(function() {

/*     var ctxLine = document.getElementById('lineChart').getContext('2d');
     var lineChart = new Chart(ctxLine, {
         type: 'line',
         data: {
             labels: ['January', 'February', 'March', 'April', 'May', 'June'],
             datasets: [{
                 label: 'Savings',
                 data: [100, 200, 150, 300, 250, 400],
                 backgroundColor: 'rgba(75, 192, 192, 0.2)',
                 borderColor: 'rgba(75, 192, 192, 1)',
                 borderWidth: 1
             }]
         },
         options: {
             scales: {
                 y: {
                     beginAtZero: true
                 }
             }
         }
     });*/
	 var ctxDonut = document.getElementById('donutChart').getContext('2d');
	 var donutChart = new Chart(ctxDonut, {
	   type: 'doughnut',
	   data: {
	     labels: ['Fixed Deposits', 'Recurring Deposits', 'PPF', 'NSC', 'EPF'],
	     datasets: [{
	       label: 'Savings Distribution',
	       data: [40, 25, 15, 10, 10],
	       backgroundColor: ['#ff6384', '#36a2eb', '#cc65fe', '#ffce56', '#4bc0c0']
	     }]
	   },
	   options: {
	     responsive: true,
	     maintainAspectRatio: false
	   }
	 });
	 }, 1000);	 