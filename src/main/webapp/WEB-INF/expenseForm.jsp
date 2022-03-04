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
    <title>New Expense Form</title>
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
    <div class="login-reg-main border-round give-me-space-up-down mx-5">
        <img src="/images/peppermint.png" alt="logo" class="w-25">
        <h3>Register:</h3>
        <form:form action="/register" method="post" modelAttribute="expense">
            <div class="form-group">
                <label>Expense Name:</label>
                <form:input path="expenseName" class="form-control" />
                <form:errors path="expenseName" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Amount:</label>
                <form:input path="amount" class="form-control" />
                <form:errors path="amount" class="text-danger" />
            </div>
            <input type="submit" value="Register" class="btn" />
        </form:form>
    </div>

</div>
</body>
</html>