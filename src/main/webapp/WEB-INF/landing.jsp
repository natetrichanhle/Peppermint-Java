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
    <title>Insert Title Here</title>
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
    <div class="navbar logo">    
        <img src="/images/peppermint.png" alt="logo" class="w-25">
    </div>
    <!-- Enter body here -->
    <div class="container mx-auto p-5"> 
        <h2>Welcome, <c:out value="${loggedInUser.getName()}"/></h2>
        <div>
            <p>Gone are the days when people use to only rely on their 
                savings for future security. In today's world, savings 
                may not be adequate to ensure financial safety. Idle 
                money kept in your savings bank account or locker 
                may also not serve the purpose. That is because of two reasons 
                one, the idle cash in your bank account is an opportunity 
                loss as it is not capable of earning more money, and second,
                it does not have the potential to beat inflation. Use our site
                to help make good decescions on how much of your money goes where every month.
            </p>
        </div>
        
            <c:forEach var = "i" items="${loggedInUser.getMonths()}">
                    <a href="/dashboard/${i.getId()}"><c:out value = "${i.getMonthOfYear()}"/></a>
            </c:forEach>
        
        
    </div>

</body>
</html>