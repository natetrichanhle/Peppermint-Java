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
    <title>Dashboard</title>
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
    <div class="navbar logo">    
        <img src="/images/peppermint.png" alt="logo" class="w-25">
    </div>
    <div class="container d-flex">
        <div class="accounts-container">
            <div class="accounts">
                <div class="d-flex justify-content-center">
                    <h1 class="dash-h1 col-sm-6 col-md-8 account-h1">Accounts</h1>
                    <a href="/accounts/new" class="col-6 col-md-4">
                        <img src="/images/addbutton.png" alt="addbutton" class="addbtn accountbtn">
                    </a>
                </div>
            </div>
        </div>
        <div class="gi-container">
            <div class="goals">
                <h1 class="dash-h1 col-sm-6 col-md-8">Goals</h1>
                <a href="/goals/new" class="col-6 col-md-4">
                    <img src="/images/addbutton.png" alt="addbutton" class="addbtn">
                </a>
            </div>
            <div class="investments">
                <h1 class="dash-h1">Investments</h1>
                <a href="/investments/new">
                    <img src="/images/addbutton.png" alt="addbutton" class="addbtn">
                </a>
            </div>
        </div>
    </div>
    <div class ="container">
        <div class="budget-container">
            <h1 class="dash-h1">Spending & Budgeting</h1>
            <a href="/budgets/new">
                <img src="/images/addbutton.png" alt="addbutton" class="addbtn">
            </a>
        </div>
    </div>
</body>
</html>