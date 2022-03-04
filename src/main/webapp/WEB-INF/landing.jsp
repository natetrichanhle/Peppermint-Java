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
    <title>Landing Page</title>
    <!-- for Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"
        integrity="sha512-tS3S5qG0BlhnQROyJXvNjeEM4UpMXHrQfTGmbQ1gKmelCxlSEBUaxhRBj/EFTzpbP4RVSrpEikbmdJobCvhE3g=="
        crossorigin="anonymous" />
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css"
        integrity="sha512-sMXtMNL1zRzolHYKEujM2AqCLUR9F2C4/05cdbxjjLSRvMQIciEPCQZo++nk7go3BtSuK9kfa/s+a4f4i5pLkw=="
        crossorigin="anonymous" />

    <!-- YOUR own local CSS -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/carousel.css">
    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <!-- YOUR own local JS -->
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
    <div class="container">
    <div class="navbar logo">    
        <img src="/images/peppermint.png" alt="logo" class="w-25">
    </div>
    <!-- Enter body here -->
    <div class="container mx-auto"> 
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
    </div>
    <!-- Carousel ------------------------------------------------ -->
    
    <div class="container-fluid my-5">
        <div class="row">
            <div class="col-12 m-auto">
                <div class="owl-carousel owl-theme">
                    <div class="item mb-4">
                        <div class="card border-0 shadow">
                            <a href="/dashboard/${loggedInUser.getMonths()[0].getId()}"><img src="/images/1.jpeg" alt="" class="card-img-top"></a>
                            <div class="card-body">
                                <div class="card-title text-center">
                                    <h4>January</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="item">
                        <div class="card border-0 shadow">
                            <a href="/dashboard/${loggedInUser.getMonths()[1].getId()}"><img src="/images/2.jpeg" alt="" class="card-img-top"></a>
                            <div class="card-body">
                                <div class="card-title text-center">
                                    <h4>Februrary</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="card border-0 shadow">
                            <a href="/dashboard/${loggedInUser.getMonths()[2].getId()}"><img src="/images/3.jpeg" alt="" class="card-img-top"></a>
                            <div class="card-body">
                                <div class="card-title text-center">
                                    <h4>March</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="card border-0 shadow">
                            <a href="/dashboard/${loggedInUser.getMonths()[3].getId()}"><img src="/images/4.jpeg" alt="" class="card-img-top"></a>
                            <div class="card-body">
                                <div class="card-title text-center">
                                    <h4>April</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="card border-0 shadow">
                            <a href="/dashboard/${loggedInUser.getMonths()[4].getId()}"><img src="/images/5.jpeg" alt="" class="card-img-top"></a>
                            <div class="card-body">
                                <div class="card-title text-center">
                                    <h4>May</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="card border-0 shadow">
                            <a href="/dashboard/${loggedInUser.getMonths()[5].getId()}"><img src="/images/6.jpeg" alt="" class="card-img-top"></a>
                            <div class="card-body">
                                <div class="card-title text-center">
                                    <h4>June</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="card border-0 shadow">
                            <a href="/dashboard/${loggedInUser.getMonths()[6].getId()}"><img src="/images/7.jpeg" alt="" class="card-img-top"></a>
                            <div class="card-body">
                                <div class="card-title text-center">
                                    <h4>July</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="card border-0 shadow">
                            <a href="/dashboard/${loggedInUser.getMonths()[7].getId()}"><img src="/images/8.jpeg" alt="" class="card-img-top"></a>
                            <div class="card-body">
                                <div class="card-title text-center">
                                    <h4>August</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="card border-0 shadow">
                            <a href="/dashboard/${loggedInUser.getMonths()[8].getId()}"><img src="/images/9.jpeg" alt="" class="card-img-top"></a>
                            <div class="card-body">
                                <div class="card-title text-center">
                                    <h4>September</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="card border-0 shadow">
                            <a href="/dashboard/${loggedInUser.getMonths()[9].getId()}"><img src="/images/10.jpeg" alt="" class="card-img-top"></a>
                            <div class="card-body">
                                <div class="card-title text-center">
                                    <h4>October</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="card border-0 shadow">
                            <a href="/dashboard/${loggedInUser.getMonths()[10].getId()}"><img src="/images/11.jpeg" alt="" class="card-img-top"></a>
                            <div class="card-body">
                                <div class="card-title text-center">
                                    <h4>November</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="card border-0 shadow">
                            <a href="/dashboard/${loggedInUser.getMonths()[11].getId()}"><img src="/images/12.jpeg" alt="" class="card-img-top"></a>
                            <div class="card-body">
                                <div class="card-title text-center">
                                    <h4>December</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"
        integrity="sha512-bPs7Ae6pVvhOSiIcyUClR7/q2OAsRiovw4vAkX+zJbw3ShAeeqezq50RIIcIURq7Oa20rW2n2q+fyXBNcU9lrw=="
        crossorigin="anonymous"></script>
    <script>
        $('.owl-carousel').owlCarousel({
            loop: true,
            margin: 15,
            nav: true,
            responsive: {
                0: {
                    items: 1
                },
                600: {
                    items: 2
                },
                1000: {
                    items: 3
                }
            }
        })
    </script>
</body>
</html>