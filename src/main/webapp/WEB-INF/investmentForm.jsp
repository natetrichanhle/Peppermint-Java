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
    <title>Investments</title>
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
<body>
    <!-- Enter body here -->
    <div class="container">    
        <h1>Add to your Investments</h1>
        <form:form action="/investments/submit" method="POST" modelAttribute="investment">
            <div class="mb-3">
                <form:label path="rothIraAmount" for="formInput" class="form-label">Roth IRA:
                </form:label>
                <form:input type="text" class="form-control" id="formInput" path="rothIraAmount" placeholder="" />
                <form:errors path="rothIraAmount" class="text-danger" />
            </div>
            <div class="mb-3">
                <form:label path="stocksAmount" for="formInput" class="form-label">Stocks:
                </form:label>
                <form:input type="text" class="form-control" id="formInput" path="stocksAmount" placeholder="" />
                <form:errors path="stocksAmount" class="text-danger" />
            </div>
            <div class="mb-3">
                <form:label path="cryptoAmount" for="formInput" class="form-label">Crypto:
                </form:label>
                <form:input type="text" class="form-control" id="formInput" path="cryptoAmount" placeholder="" />
                <form:errors path="cryptoAmount" class="text-danger" />
            </div>
            <div class="d-flex justify-content-end">
                <a href = "/dashboard" class="btn mx-5">Cancel</a>
                <input type="submit" value="Submit" class="btn submit-btn">
            </div>
        </form:form>
    </div>
</body>
</html>