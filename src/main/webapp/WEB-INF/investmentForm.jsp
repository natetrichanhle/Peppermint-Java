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
    <div class="">    
        <h1>Add to your Investments</h1>
        <div class="range align-items-center">
            <div class="sliderValue">
                <span>100</span>
            </div>
            <label>Roth IRA:</label>
            <div class="field">
                <div class="value left">0</div>
                <input type="range" min="0" max="100" steps="1">
                <div class="value right">100</div>
            </div>
        </div>
        <div class="range align-items-center">
            <div class="sliderValue">
                <span>100</span>
            </div>
            <label>Stocks:</label>
            <div class="field">
                <div class="value left">0</div>
                <input type="range" min="0" max="100" steps="1">
                <div class="value right">100</div>
            </div>
        </div>
        <div class="range align-items-center">
            <div class="sliderValue">
                <span>100</span>
            </div>
            <label>Crypto:</label>
            <div class="field">
                <div class="value left">0</div>
                <input type="range" min="0" max="100" steps="1">
                <div class="value right">100</div>
            </div>
        </div>
        
        <!-- Slider JS -->
        <script>
            const slideValue = document.querySelector("span");
            const inputSlider = document.querySelector("input");
            inputSlider.oninput = (() => {
                let value = inputSlider.value;
                slideValue.textContent = value;
                slideValue.style.left = (value/2) + "%";
                slideValue.classList.add("show");
            });
            inputSlider.onblur=(() => {
                slideValue.classList.remove("show");
            });
        </script>
    </div>
</body>
</html>