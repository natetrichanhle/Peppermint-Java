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
    <title>Login or Register</title>
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
    <div class="login-reg-main border-round give-me-space-up-down mx-5">
        <img src="/images/peppermint.png" alt="logo" class="w-25">
        <h3>Register:</h3>
        <form:form action="/register" method="post" modelAttribute="newUser">
            <div class="form-group">
                <label>Name:</label>
                <form:input path="name" class="form-control" />
                <form:errors path="name" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Annual Income:</label>
                <form:input type="number" min="13920" path="annualIncome" class="form-control" />
                <form:errors path="annualIncome" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Email:</label>
                <form:input path="email" class="form-control" />
                <form:errors path="email" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Password:</label>
                <form:password path="password" class="form-control" />
                <form:errors path="password" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Confirm Password:</label>
                <form:password path="confirm" class="form-control" />
                <form:errors path="confirm" class="text-danger" />
            </div>
            <input type="submit" value="Register" class="btn" />
        </form:form>
    </div>

    <!-- LOGIN -->
    <!-- newLogin object will touch the model to validate only -->
    <div class="login-reg-main border-round mx-5">
        <h3>Login:</h3>
        <form:form action="/login" method="post" modelAttribute="newLogin">
            <div class="form-group">
                <label>Email:</label>
                <form:input path="email" class="form-control" />
                <form:errors path="email" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Password:</label>
                <form:password path="password" class="form-control" />
                <form:errors path="password" class="text-danger" />
            </div>
            <input type="submit" value="Login" class="btn" />
        </form:form>
    </div>

</div>
</body>
</html>