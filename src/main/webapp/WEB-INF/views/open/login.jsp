<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- JSTL Tags Start -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <!-- JSTL Tags end -->
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0; /* Remove default margin */
            padding: 0; /* Remove default padding */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
          background: linear-gradient(to bottom right,#000000, 
            #7ED6DF); /* Dark cyan gradient */
        }

        .card {
            width: 100%;
            max-width: 400px;
            background: rgba(255, 255, 255, 0.2); /* Semi-transparent white background */
            border-radius: 10px;
            backdrop-filter: blur(10px); /* Glass effect */
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3); /* Soft shadow */
            padding: 2rem;
        }

        .card h1 {
            text-align: center;
            margin-bottom: 1.5rem;
            color: white;
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        .form-control {
            background-color: rgba(255, 255, 255, 0.7); /* Semi-transparent white input background */
            border: none;
            border-radius: 5px;
            padding: 0.75rem 1rem;
            color: #333; /* Text color */
        }

        .form-control:focus {
            background-color: rgba(255, 255, 255, 0.9); /* Lighter background on focus */
        }

        .btn-login {
            background: linear-gradient(to right, darkcyan, lightcyan);
            border: none;
            color: white;
            padding: 0.75rem 1.5rem;
            border-radius: 5px;
            transition: background 0.3s ease-in-out;
            box-shadow: 0 3px 6px rgba(0, 0, 0, 0.1); /* Subtle shadow */
        }

        .btn-login:hover {
            background: linear-gradient(to right, lightcyan, darkcyan);
        }

        .forgot-password a {
            color: #6c757d;
            text-decoration: none;
        }

        .forgot-password a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="card">
        <h1>Login</h1>

        <c:if test="${param.error != null}">
            <div class="alert alert-danger" role="alert">${param.error}</div>
        </c:if>

        <form action="<c:url value='/swadeshiBank/v1/processLogin' />" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-login btn-block">Login</button>
            </div>
            <div class="forgot-password text-center" >
                <a href="forgotPassword.jsp" style="color:white">Forgot Password?</a>
            </div>
            <div class="forgot-password text-center" style="color:white">
            Don't have a account yet? 
                <a href="/swadeshiBank/v1/open-account" style="color:blue"> Come grow with us</a>
            </div>
        </form>
    </div>
</body>
</html>
 