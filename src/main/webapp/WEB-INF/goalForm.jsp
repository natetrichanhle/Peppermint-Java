<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Goals</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <!-- YOUR own local JS -->
    <script type="text/javascript" src="/js/app.js"></script>
</head>



<body class="bg-dark">
    <div class="container d-flex align-items-center justify-content-between">
        <img src="/images/peppermint.png" alt="logo" class="w-50">
        <div>
            <a href = "/dashboard/${monthId}" class="btn">Back</a>
            <a href="/logout" class="btn">Logout</a>
        </div>
    </div>  
    <div class="p-3 container text-center d-flex-column align-items-center form-card box-shadow rounded-3">    
        <h1 class="text-white">Add to your Goals</h1>
        <form:form class="p-3" action="/goals/submit" method="POST" modelAttribute="goal">
            <form:input type="hidden" path="month" value="${monthId}"/>
            <div class="mb-3">
                <form:label path="description" for="formInput" class="form-label text-white">What is your Goal:
                </form:label>
                <form:input type="text" class="form-control" id="formInput" path="description" placeholder="" />
                <form:errors path="description" class="text-danger" />
            </div>
            <div class="d-flex justify-content-around mt-5">
                <a href = "/dashboard/${monthId}" class="btn">Cancel</a>
                <input type="submit" value="Submit" class="btn submit-btn">
            </div>
        </form:form>
    </div>
</body>
</html>

