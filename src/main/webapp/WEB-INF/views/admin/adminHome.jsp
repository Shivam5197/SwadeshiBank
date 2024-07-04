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


<script type="text/javascript">
	var global_contextPath = "${request.getContextPath()}";
	console.log("global_contextPath" + global_contextPath);
</script>


</head>
<body>

<button onclick="onlod()">click me</button>
<button onclick="consoleLogs()">click me</button>
    <h1>AJAX with JSP and REST Controller</h1>
    <input type="text" id="paramInput" placeholder="Enter a parameter"/>
    <button id="getDataButton">Get Data</button>
    <p id="result"></p>
<div id="myDiv"></div>



 
</body>
<!-- Internal JS files  --> 
 <script type="text/javascript" charset="utf8"
	src="<c:url value="/JavaScript/Utils/MasterAjax.js"/>"></script>
 <script type="text/javascript" charset="utf8"
	src="<c:url value="/JavaScript/Index.js"/>"></script>

</html>