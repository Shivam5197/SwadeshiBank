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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!-- JSTL Tags end -->


<!-- External JS libraries --> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- External JS libraries --> 

<!-- External CSS libraries --> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!-- External CSS libraries --> 
 
<!-- Internal JS files  --> 
 <script type="text/javascript" charset="utf8"
	src="<c:url value="/JavaScript/Utils/MasterAjax.js"/>"></script>
 <script type="text/javascript" charset="utf8"
	src="<c:url value="/JavaScript/Index.js"/>"></script>

 <!-- Internal JS files  --> 

 <!-- Internal CSS files  --> 
<link type="text/css" href="<c:url value="/CSS/home.css"/>"
	rel="stylesheet">
 <!-- Internal CSS files  --> 

<script type="text/javascript">
	var global_contextPath = "${request.getContextPath()}";
	console.log("global_contextPath" + global_contextPath);
</script>

<style >
body {
    background-color: whitesmoke;
    padding-top: 56px; /* Height of the navbar */
}

.carousel-caption {
    bottom: 16rem;
    z-index: 10;
    color: white;
}

.carousel-item {
    height: 40rem;
    background-color: #777;
    color: black;
    position: relative;
}

.carousel-inner img {
    height: 80vh; /* 70% of the viewport height */
    object-fit: cover;
}

.navbar-dark.bg-darkcyan {
    background-color: darkcyan;
}

.fw-normal {
    padding: 1%;
    font-size: 3vh;
}

.carousel-item > img {
    position: absolute;
    top: 0;
    left: 0;
    min-width: 100%;
    height: 100%;
}

.bd-placeholder-img {
    font-size: 1.125rem;
    text-anchor: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    user-select: none;
}

.marketing-title {
    margin-top: 5vh;
    margin-bottom: 2vh;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    text-align: center;
    font-size: 5vh;
}

.marketing-p {
    margin-top: 1%;
    margin-bottom: 2vh;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    text-align: center;
    font-size: larger;
    color: #777;
}

@media (min-width: 768px) {
    .bd-placeholder-img-lg {
        font-size: 3.5rem;
    }
}

.carousel-item {
    height: 80vh;
}
.btn-horizontal {
            background-color: ghostwhite;
            color: #007B7B;
            border: none;
            padding: 10px 20px;
            text-align: center;
            display: inline-block;
            font-size: 100%;
            margin: 10px;
            cursor: pointer;
            text-decoration: none;
        }
        
.btn-horizontal:hover {
            background-color: #007B7B;
            color: white; /* Slightly darker shade of darkcyan for hover effect */
        }
@import url('https://fonts.googleapis.com/css2?family=Recursive:wght@300;400;500;600;700&display=swap');


/* Navbar */
.navbar-dark.bg-darkcyan {
    background-color: Darkcyan;
}

.nav-link{
   font-size: x-large;
}

/* Style for anchor tags */
a {
    color: initial; /* Optional: Keep the initial color for anchor text */
    text-decoration: none; /* Optional: Remove underline */
}

/* Style for anchor tags on hover */
a:hover {
    color: white; /* Change text color to white */
    font-weight: bold; /* Make text bold */
}


.btn-login {
    padding: 5%;
    width: 4vw;
    font-size: x-large;
    size: 10rem;
    background-color: darkcyan;
    color: white;
    transition: background-color 0.3s, color 0.3s;
}

.btn-login:hover {
    background-color: white;
    color: darkcyan;
}

/* Footer */
.bg-darkcyan {
    background-color: darkcyan;
}

.search-container {
    display: flex;
    align-items: center;
    width: 300px;
    border: 2px solid darkcyan;
    border-radius: 25px;
    overflow: hidden;
    transition: all 0.3s ease;
}

.search-container:hover {
    width: 400px;
    border-color: white;
}

.search-input {
    flex: 1;
    padding: 10px 15px;
    border: none;
    outline: none;
    font-size: 16px;
}

.search-button {
    background-color: transparent;
    border: none;
    padding: 10px 15px;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
}

.search-button img {
    width: 20px;
    height: 20px;
}

.search-button:focus {
    outline: none;
}

.carousel {
    width: 100%;
    max-height: 70vh; /* 50% of viewport height */
}

.carousel-inner {
    max-height: 70vh; /* 50% of viewport height */
}

.carousel-inner img {
    width: 100%;
    height: 100%;
    object-fit: cover; /* Ensures the image covers the entire slide */
}
</style>


</head>
<body>


    <nav class="navbar navbar-expand-lg navbar-dark bg-darkcyan fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">SwadeshiBank</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="#">Account</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Cards</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Loans</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Investment</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Payments</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Offers</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Services</a></li>
                    <li class="nav-item">
                        <div class="search-container">
                            <input type="text" class="search-input" placeholder="Search...">
                            <button class="search-button">
                                <img src="https://img.icons8.com/ios-filled/50/000000/search.png" alt="Search">
                            </button>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-login" href="/swadeshiBank/v1/login">Login</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>

    <main>
        <div class="toInclude">
        <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
                <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="3" aria-label="Slide 4"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="<c:url value="/Images/home/Coursel_first.jpg"/>" alt="">
                    <div class="container">
                        <div class="carousel-caption text-start">
                            <h1>Unlock Your Financial Freedom with SwadeshiBank!</h1>
                            <p>Experience hassle-free banking with our user-friendly online platform and mobile app, keeping you connected with your </p>
                      <p>     finances anytime, anywhere. Enjoy competitive interest rates and exclusive savings plans to help you reach your financial goals faster. </p> 
                      <p>  Rest easy knowing your money is protected with top-notch security features and 24/7 customer support.
                            </p>
                            <p><a class="btn btn-horizontal" href="/swadeshiBank/v1/open-account">Open Account</a></p>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="<c:url value="/Images/home/Coursel_second.jpeg"/>" alt="">
                    <div class="container">
                        <div class="carousel-caption text-start">
                            <h1>Investment Advisory</h1>
                            <p>Maximize your wealth potential with expert investment advice. Our seasoned advisors provide strategic insights and tailored 
                            </p><p>recommendations to help you navigate the complexities of financial markets and achieve long-term growth.</p>
                            <p><a class="btn btn-horizontal" href="#">Learn more</a></p>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="<c:url value="/Images/home/Coursel_third.png"/>" alt="">
                    <div class="container">
                        <div class="carousel-caption text-end">
                            <h1>Business Banking</h1>
                            <p>Support your business growth with specialized banking solutions. From business loans and merchant services to payroll management and corporate accounts, we cater to your business needs.</p>
                            <p><a class="btn btn-horizontal" href="#">Learn more</a></p>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="<c:url value="/Images/home/Coursel_fourth.png"/>" alt="">
                    <div class="container">
                        <div class="carousel-caption text-end">
                            <h1>24/7 Customer Support</h1>
                            <p>Experience dedicated customer support around the clock. Our knowledgeable team is ready to assist you with any banking inquiries, ensuring prompt and reliable service whenever you need it.</p>
                            <p><a class="btn btn-horizontal" href="#">Contact Us</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

    <div class="container marketing">

    <div>
        <h1 class="marketing-title" style="color: #4A4A4A;">Bank For A Better Tomorrow</h1>
        <p class="marketing-p">Committed to helping our customers succeed.</p>
    </div>


        <div class="row mt-5 p-3">
            <div class="col-lg-4">
                <img src="<c:url value="/Images/home/Fixed_Deposit.jpeg"/>" class="bd-placeholder-img rounded-circle" width="220" height="220" alt="">
                <h2 class="fw-normal">Fixed Deposits</h2>
                <p>Fixed deposits (FDs) are secure investments where a lump sum is deposited with a bank for a fixed term at a predetermined interest rate. Offering guaranteed returns and safety, FDs are perfect for risk-averse investors. They provide flexible tenure options and periodic interest payouts or maturity benefits.</p>
                <p><a class="btn btn-secondary" href="#">View details »</a></p>
              </div>
            <div class="col-lg-4">
                <img src="<c:url value="/Images/home/mutual_funds.jpeg"/>" class="bd-placeholder-img rounded-circle" width="220" height="220" alt="">
                <h2 class="fw-normal">Mutual Funds</h2>
                <p>Mutual funds pool money from multiple investors to invest in diversified portfolios of stocks, bonds, or other securities. Managed by professionals, they offer diversification, liquidity, and the potential for higher returns, making them suitable for various risk appetites and financial goals.</p>
                <p><a class="btn btn-secondary" href="#">View details &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <img src="<c:url value="/Images/home/exchange.jpeg"/>" class="bd-placeholder-img rounded-circle" width="220" height="220" alt="">
                <h2 class="fw-normal">Foreign Exchange Rates</h2>
                <p>Foreign exchange involves trading currencies from different countries in the global forex market. It facilitates international trade and investment, offering opportunities for profit from currency fluctuations. The forex market operates 24/5, providing high liquidity and accessibility to traders worldwide.</p>
                <p><a class="btn btn-secondary" href="#">View details &raquo;</a></p>
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">Seamless Payments: <span class="text-muted">Your Gateway to Hassle-Free Transactions </span></h2>
<p class="lead"><a style="font-weight: bold;">&#8226; Unified Payments Interface (UPI):</a><span class=""> Instant money transfers between bank accounts using mobile devices.</span></p>
<p class="lead"><a style="font-weight: bold;">&#8226; Mobile Wallets: </a><span class="">Quick payments with apps like Paytm, Google Pay, and PhonePe, eliminating physical cash.</span></p>
<p class="lead"><a style="font-weight: bold;">&#8226; Internet Banking: </a><span class="">Manage accounts, transfer funds, and pay bills online securely and efficiently.</span></p>
<p class="lead"><a style="font-weight: bold;">&#8226; Point of Sale (POS) Terminals: </a><span class="">Card payments in retail outlets, enhancing transaction speed and ease.</span></p>
<p class="lead"><a style="font-weight: bold;">&#8226; Contactless Payments: </a><span class="">Quick, secure transactions with NFC-enabled cards and smartphones, reducing physical contact.</span></p>


            </div>
            <div class="col-md-5">
                <img src="<c:url value="/Images/home/Payments.jpeg"/>" class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" alt="">
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7 order-md-2">
                <h2 class="featurette-heading">Unlocking Dreams:<span class="text-muted"> Secure Home Solutions for Every Indian</span></h2>
                <p class="lead"><a style="font-weight: bold;">&#8226; Affordable Housing:</a><span class=""> Increasing availability of affordable housing schemes and loans for aspiring homeowners.</span></p>
                <p class="lead"><a style="font-weight: bold;">&#8226; Rising Property Investments: </a><span class="">Growing interest in real estate as a secure investment option among Indians.</span></p>
                <p class="lead"><a style="font-weight: bold;">&#8226; Government Initiatives: </a><span class="">Schemes like PMAY (Pradhan Mantri Awas Yojana) promoting affordable housing for all.</span></p>
                <p class="lead"><a style="font-weight: bold;">&#8226; Urban Expansion: </a><span class="">Rapid urbanization driving the demand for residential spaces across cities.</span></p>
                <p class="lead"><a style="font-weight: bold;">&#8226; Digital Mortgage Solutions: </a><span class="">Online platforms facilitating easier access to home loans and mortgage approvals.</span></p>
            </div>
            <div class="col-md-5 order-md-1">
                <img src="<c:url value="/Images/home/homeLone.jpeg"/>" class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" alt="">
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">Protecting Tomorrow:  <span class="text-muted">Comprehensive Insurance Solutions for Every Need</span></h2>
                <p class="lead"><a style="font-weight: bold;">&#8226; Health Insurance:</a><span class="">Increasing awareness and adoption of health insurance plans to cover medical expenses.</span></p>
                <p class="lead"><a style="font-weight: bold;">&#8226; Life Insurance: </a><span class="">Popular investment choice offering financial security and protection for families.</span></p>
                <p class="lead"><a style="font-weight: bold;">&#8226; Vehicle Insurance: </a><span class="">Mandatory coverage for vehicles, safeguarding against accidents and damages.</span></p>
                <p class="lead"><a style="font-weight: bold;">&#8226; Crop Insurance: </a><span class="">Vital support for farmers, protecting against crop losses due to natural calamities.</span></p>
                <p class="lead"><a style="font-weight: bold;">&#8226; Digital Insurance Platforms: </a><span class="">Convenient online access to compare, buy, and manage insurance policies.</span></p>
            </div>
            <div class="col-md-5">
                <img src="<c:url value="/Images/home/insurance.jpeg"/>" class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" alt="">
            </div>
        </div>

        <hr class="featurette-divider">
    </div>
</div>     <!-- To Include Div -->

    <!-- Footer -->
    <footer class="bg-darkcyan text-white text-center py-4">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <h5>About Us</h5>
                    <ul class="list-unstyled">
                        <li><a href="#" class="text-white">Our Story</a></li>
                        <li><a href="#" class="text-white">Careers</a></li>
                        <li><a href="#" class="text-white">Blog</a></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <h5>Support</h5>
                    <ul class="list-unstyled">
                        <li><a href="#" class="text-white">Contact Us</a></li>
                        <li><a href="#" class="text-white">FAQ</a></li>
                        <li><a href="#" class="text-white">Help Center</a></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <h5>Legal</h5>
                    <ul class="list-unstyled">
                        <li><a href="#" class="text-white">Privacy Policy</a></li>
                        <li><a href="#" class="text-white">Terms of Use</a></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <h5>Follow Us</h5>
                    <a href="#" class="text-white me-2"><i class="bi bi-facebook"></i></a>
                    <a href="#" class="text-white me-2"><i class="bi bi-twitter"></i></a>
                    <a href="#" class="text-white"><i class="bi bi-linkedin"></i></a>
                </div>
            </div>
        </div>
    </footer>
    </main>

</body>

</html>