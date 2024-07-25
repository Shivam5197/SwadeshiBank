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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

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

 <script type="text/javascript" charset="utf8"
	src="<c:url value="/JavaScript/User/UserDetails.js"/>"></script>

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
            background-color: white;
        }

        .sidebar-custom {
            background-color: #343a40; /* charcoal background */
            height: 100vh;
            position: fixed;
            transition: all 0.3s;
            z-index: 1;
            overflow-x: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .navbar{
            background-color: darkcyan;
    color: white;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .sidebar-custom .nav-link {
            color: #adb5bd; /* default text color */
        }

        .sidebar-custom .nav-link:hover {
            color: darkcyan; /* hover text color */
        }

        .card-custom {
            background-color: #f8f9fa; /* light gray background for cards */
            color: #343a40; /* dark gray text color */
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s;
        }

        .top-cards:hover {
            background-color: darkcyan; /* hover background color */
            color: white; /* text color on hover */
        }

        .card-custom h5 {
            color: #343a40; /* heading color */
        }

        .navbar-custom {
            background-color: #343a40; /* navbar background */
            color: white; /* navbar text color */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .navbar-custom .nav-link,
        .navbar-custom .navbar-brand {
            color: white; /* default text color */
        }

        .navbar-custom .nav-link:hover,
        .navbar-custom .navbar-brand:hover {
            color: darkcyan; /* hover text color */
        }

        .sidebar-custom {
    background-color:darkcyan;
    height: 100vh;
    position: fixed;
    transition: all 0.3s;
    padding-top: 20px; /* Add padding to the top */
}

.sidebar-custom .nav-link {
    color: white;
    font-size: 16px;
    font-weight: normal; /* Default font weight */
    transition: all 0.3s;
}

.sidebar-custom .nav-link:hover {
    color: darkcyan; /* Text color on hover */
    font-weight: bold; /* Bold font on hover */
    background-color: white; /* Background color on hover */
    border-radius: 5px; /* Rounded corners */
}

        .table-custom {
            background-color: #f8f9fa; /* light gray background for tables */
        }

        .table-custom th,
        .table-custom td {
            color: #343a40; /* table text color */
        }

        .table-custom tbody tr:hover {
            background-color: darkcyan; /* hover background color for table rows */
            color: white; /* hover text color for table rows */
        }

        @media (max-width: 768px) {
            .sidebar-custom {
                width: 100%;
                height: auto;
                position: relative;
            }

            .sidebar-custom .nav-link {
                text-align: center;
            }

            .content {
                margin-left: 0;
            }
        }
        .calculator {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .form-group {
            margin-bottom: 20px;
        }
        .nav-item{
            padding: 5%;
        }
        .search-bar {
            position: relative;
        }
        .search-bar input {
            width: 300px;
            border-radius: 20px;
            padding-left: 40px;
            transition: width 0.4s ease-in-out;
        }
        .search-bar input:focus {
            width: 350px;
        }
        .search-bar .fa-search {
            position: absolute;
            left: 10px;
            top: 50%;
            transform: translateY(-50%);
            color: gray;
        }
        @media (max-width: 767.98px) {
            .sidebar-custom {
                height: auto;
                background-color: darkcyan;
            }
            .search-bar input {
                width: 200px;
            }
            .search-bar input:focus {
                width: 250px;
            }
        }
/*   .chart-container {
            position: relative;
            margin: auto;
            height: 400px; /* Adjust the height */
            width: 400px;  /* Adjust the width */
        } */
</style>


</head>
<body>
<nav class="navbar navbar-expand-lg  sticky-top">
    <a class="ml-3 navbar-brand" href="#" style="color: white;">Bank Dashboard</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarContent">
        <form class="form-inline my-2 my-lg-0 ml-auto search-bar">
            <i class="fas fa-search"></i>
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        </form>
        <ul class="navbar-nav ml-3">
            <li class="nav-item mr-3">
                <a class="nav-link" href="#" style="color: white;"><i class="fas fa-bell"></i></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img src="https://via.placeholder.com/30" class="rounded-circle" alt="Profile">
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Profile</a>
                    <a class="dropdown-item" href="#">Settings</a>
                    <hr style="border-top: 1px solid darkgray;">
                    <a class="dropdown-item" href="/swadeshiBank/v1/logout">Logout</a>
                </div>
            </li>
        </ul>
    </div>
</nav>

<button class="btn btn-dark d-md-none" type="button" data-toggle="collapse" data-target="#sidebarContent" aria-controls="sidebarContent" aria-expanded="false" aria-label="Toggle navigation">
    <i class="fas fa-bars"></i> Menu
</button>

<div class="row no-gutters">
    <nav class="col-md-2 d-md-block sidebar-custom collapse" id="sidebarContent">
        <div class="sidebar-sticky">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="#"><i class="fas fa-user"></i> Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fas fa-credit-card"></i> Cards</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fas fa-hand-holding-usd"></i> Loans</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fas fa-chart-line"></i> Investment</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fas fa-money-check-alt"></i> Payments</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fas fa-gift"></i> Offers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fas fa-cog"></i> Services</a>
                </li>
            </ul>
        </div>
    </nav>

    <main role="main" class="col-md-10 ml-sm-auto col-lg-10 px-4">
        <!-- Your main content goes here -->
    </main>
</div>

        <main role="main" id="content" class="col-md-9 ml-sm-auto col-lg-10 px-4 content">
        
        <!-- All the code will be added here on runTime -->
        
        </main>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        // Bar Chart


    </script>

</body>

</html>