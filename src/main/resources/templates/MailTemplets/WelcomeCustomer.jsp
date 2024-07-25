<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--     <title>Welcome to Swadeshi Bank</title> -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .header {
            text-align: center;
            padding-bottom: 20px;
            border-bottom: 1px solid #ddd;
        }
        .header h1 {
            margin: 0;
            color: darkcyan;
        }
        .content {
            padding: 20px 0;
        }
        .content h2 {
            color: darkcyan;
        }
        .content p {
            margin: 10px 0;
        }
        .footer {
            text-align: center;
            padding-top: 20px;
            border-top: 1px solid #ddd;
        }
        .footer p {
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Welcome <c:out value="${userName}" /> to Swadeshi Bank!</h1>
        </div>
        <div class="content">
            <p>Dear <strong><c:out value="${fullname}" /></strong>,</p>
            <p>We are delighted to have you as a valued customer. Below are your account and Debit card details:</p>

            <h2>Account Details</h2>
            <p><strong>Account Password:</strong> <c:out value="${password}" />  <p style="color:red;">{We strongly recommend to change your password as soon as possible!}</p> </p>
            <p><strong>Customer Relation Number (CRN):</strong> <c:out value="${crn}" /></p>
            <p><strong>Account Number:</strong> <c:out value="${accountNumber}" /></p>
            <p><strong>IFSC Code:</strong> <c:out value="${ifscCode}" /></p>
            <p><strong>Opening Balance:</strong> <c:out value="${openingamount}" /></p>
            <p><strong>Branch Address:</strong> <c:out value="${branchFullAddress}" /></p>

            <h2>Debit Card Details</h2>
            <p><strong>Card Number:</strong> <c:out value="${cardNumber}" /></p>
            <p>For more card information, check on the Swadeshi Bank app under your account.</p>
        </div>
        <div class="footer">
            <p>Thank you for choosing Swadeshi Bank. We look forward to serving you!</p>
        </div>
    </div>
</body>
</html>