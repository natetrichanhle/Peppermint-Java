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
    <link rel="stylesheet" type="text/css" href="/css/slider.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <!-- YOUR own local JS -->
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
    <!-- Enter body here -->
    <h1 class="d-flex justify-content-center">Add to your Investments</h1>
    <div class="container">
        <label>RothIRA: </label>    
        <input type="range" id="my-slider" min="0" max="100" value="50" oninput="slider()">
        <div id="slider-value">0</div>
    </div>
    <div class="container2">    
        <label>Stocks: </label>    
        <input type="range" id="my-slider2" min="0" max="100" value="50" oninput="slider2()">
        <div id="slider-value2">0</div>
    </div>
    <div class="container3">
        <label>Crypto: </label>    
        <input type="range" id="my-slider3" min="0" max="100" value="50" oninput="slider3()">
        <div id="slider-value3">0</div>
    </div>
    <div class="slider-btn">
        <a href = "/dashboard" class="btn mx-5">Cancel</a>
        <input type="submit" value="Submit" class="btn submit-btn">
    </div>

<!-- ------------------JS-------------------- -->

        <script>
            const mySlider = document.getElementById("my-slider");
            const sliderValue = document.getElementById("slider-value");

            const mySlider2 = document.getElementById("my-slider2");
            const sliderValue2 = document.getElementById("slider-value2");

            const mySlider3 = document.getElementById("my-slider3");
            const sliderValue3 = document.getElementById("slider-value3");

            function slider() {
                valPercent = (mySlider.value / mySlider.max) * 100;
                sliderValue.textContent = mySlider.value;
            }
            slider();

            function slider2() {
                valPercent2 = (mySlider2.value / mySlider2.max) * 100;
                sliderValue2.textContent = mySlider2.value;
            }
            slider2();

            function slider3() {
                valPercent3 = (mySlider3.value / mySlider3.max) * 100;
                sliderValue3.textContent = mySlider3.value;
            }
            slider3();
        </script>
</body>
</html>