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
    <title>Welcome</title>
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
    <div class="navbar mx-5">    
        <img src="/images/peppermint.png" alt="logo" class="w-25">
        <a class="btn" href="/loginReg">Login / Register</a>
    </div>
    <div>
        <img src="/images/welcomepage.png" alt="logo" class="w-100">
    </div>
    <div class="info-container">
        <div class="info w-25 text-white">
            <img src="/images/budgetplanner.png" alt="logo">
            <p class="info-desc">Say goodbye to spreadsheets with customizable budgets. Easily add and update your categories.</p>
        </div>
        <div class="info w-25 text-white">
            <img src="/images/trackspending.png" alt="logo">
            <p class="info-desc">Stay on top of your finances by seeing where your money comes and goes.</p>
        </div>
    </div>
    <div class="goals-container">
        <div class="w-25">
            <img class="goalimg" src="/images/goals.png" alt="logo">
        </div>
        <div class="info w-50 text-white">
            <h1 class="goalhead">Stay focused on your financial goals</h1>
            <p class="goaldesc">Improve your spending habits with custom goals that keep you <br>
            going. Save for a home, conquer debt, and prepare for the future.</p>
            <a class="btn" href="/loginReg">Sign up for peppermint!</a>
        </div>
    </div>
</body>
</html>