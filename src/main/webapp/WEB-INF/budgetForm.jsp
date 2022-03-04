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
    <title>Budgets</title>
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
    <!-- Enter body here -->
    <div class="container d-flex align-items-center justify-content-between">
        <img src="/images/peppermint.png" alt="logo" class="w-50">
        <div>
            <a href = "/dashboard/${monthId}"  class="btn">Back</a>
            <a href="/logout" class="btn">Logout</a>
        </div>
    </div>    
    <div class="container d-flex-column text-center align-items-center form-card box-shadow rounded-3">
        <h1 class="text-white">Add to your Expenses</h1>
        <form:form  class="p-3  " action="/budgets/submit" method="POST" modelAttribute="budget">
        <form:errors path="*" class="text-danger d-flex justify-content-center"/>
            <form:input type="hidden" path="savingsAccount" value="${monthId}"/>
            <div class="mb-3">
                <form:label path="category" for="formInput" class="form-label text-white">What are you budgeting for:
                </form:label>
                <form:input type="text" class="form-control" id="formInput" path="category" placeholder="" />
            </div>
            <div class="mb-3">
                <form:label path="amount" for="formInput" class="form-label text-white">Amount:
                </form:label>
                <form:input type="text" class="form-control" id="formInput" path="amount" placeholder="" />
            </div>
            <div class="d-flex justify-content-around mt-5">
                <a href = "/dashboard/${monthId}" class="btn">Cancel</a>
                
                <input type="submit" value="Submit" class="btn submit-btn">
                
            </div>
        </form:form>
    </div>
</body>
</html>