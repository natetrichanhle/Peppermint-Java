<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <!-- JS for rendering chart -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js">
    </script>
</head>


<body class="bg-dark">
    <div class="container">
    <div class="container d-flex align-items-center justify-content-between">
        <img src="/images/peppermint.png" alt="logo" class="w-50">
        <div>
            <a href="/landing" class="btn">Back</a>
            <a href="/logout" class="btn">Logout</a>
        </div>
    </div>
    <div class="container d-flex pr-0">
        <div class="accounts-container rounded-3 box-shadow border-dark">
            <div class="accounts">
                <div class="d-flex justify-content-center align-items-center month-container">
                    <div>
                        <h1 class="month-head">${month.getMonthOfYear()}</h1>
                    </div>
                    <div class="dropdown">
                        <button class="dropbtn">Change Month</button>
                        <div class="dropdown-content">
                            <c:forEach var="m" items="${loggedInUser.getMonths()}">
                                <a class= "btn m-1" href="/dashboard/${m.getId()}">
                                    <c:out value="${m.getMonthOfYear()}" />
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="accounts-tabs4 rounded-3 border-dark box-shadow">
                    <h3 class="total-h3 color-white">Monthly Income: $${monthlyTotal}</h3>
                </div>
                <div class="accounts-tabs rounded-3 border-dark">
                    <h3 class="savings-h3">Savings: $${savingsTotal}
                    </h3>
                </div>
                <div class="accounts-tabs2 rounded-3 border-dark">
                    <h3 class="investments-h3">Investments:
                        $${investmentTotal}</h3>
                </div>
                <div class="accounts-tabs3 rounded-3 border-dark">
                    <h3 class="utilities-h3">Utilities: $${utilitiesTotal}</h3>
                </div>
            </div>
        </div>
        <!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
        <div class="gi-container">
            <div class="goals rounded-3 box-shadow border-dark">
                <div class="d-flex justify-content-center">
                    <h1 class="dash-h1 col-sm-6 col-md-8 goal-h1">Goals</h1>
                    <a href="/goals/new/" class="col-6 col-md-4">
                        <img src="/images/addbutton.png" alt="addbutton" class="addbtn goalbtn">
                    </a>
                </div>
                <div class="goal-info mx-5 overflow-auto">
                    <table
                        class="table table-borderless d-flex align-items-center justify-content-center">
                        <c:forEach var="goal" items="${month.getGoals()}">
                            <tr>
                                <td class="goalList">
                                    <c:out value="${goal.description}" />
                                </td>
                                <td>
                                <td>
                                    <form action="/goals/${goal.id}" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input type="submit" value="Complete"
                                            class="btn goal-deletebtn">
                                    </form>
                                </td>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
            <div class="investments rounded-3 box-shadow border-dark">
                <div class="d-flex justify-content-center">
                    <h1 class="dash-h1 invest-h1">Investments</h1>
                    <a href="/investments/new">
                        <img src="/images/addbutton.png" alt="addbutton" class="addbtn investbtn">
                    </a>
                </div>
                <div class="mx-5 d-flex justify-content-between">
                    <!-- render some shit here for investments -->
                    <div class="d-flex align-items-center">
                        <div>
                            <h3 class="text-white">Roth Ira: $${rothIraTotal}</h3>
                            <h3 class="text-white">Crypto: $${cryptoTotal}</h3>
                            <h3 class="text-white">Stocks: $${stocksTotal}</h3>
                        </div>
                    </div>
                    <div>
                        <canvas id="myChart" style="width:100%;max-width:400px"></canvas>

                        <script>
                            var xValues = ['RothIRA','Stocks','Crypto'];
                            var yValues = [
                                        "${month.getInvestment().getRothIraAmount()}",
                                        "${month.getInvestment().getStocksAmount()}",
                                        "${month.getInvestment().getCryptoAmount()}"];
                            var barColors = [
                                "burlywood",
                                "slategray",
                                "floralwhite"
                            ];
                            var borderColors=[
                                "black",
                                "black",
                                "black"
                            ]
                            new Chart("myChart", {
                                type: "doughnut",
                                data: {
                                    labels: xValues,
                                    datasets: [{
                                        backgroundColor: barColors,
                                        borderColor: borderColors,
                                        data: yValues
                                    }]
                                },
                                options: {
                                    legend: {
                                        labels: {
                                            fontColor: "white",
                                            fontSize: 16
                                        }},
                                    plugins:{doughnutlabel:{labels:[{text:'${Math.floor(month.getInvestment().getTotalInvestments())}',color:'white',
                                    font:{size:20}},{text:'total',color:'white'}]}}
                                }
                            });
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
    <div class="container">
        <div class="budget-container rounded-3 box-shadow border-dark">
            <div class="d-flex justify-content-center">
                <h1 class="dash-h1 budget-h1">Savings & Expenses</h1>
                <a href="/budgets/new">
                    <img src="/images/addbutton.png" alt="addbutton" class="addbtn budgetbtn">
                </a>
            </div>
            <div class="mx-5 d-flex justify-content-evenly">
                <div class="mx-5 spend-container text-center">
                    <p class="expense-h4">You have $${expenseTotal} left to spend this month.</p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-striped active" role="progressbar"
                        aria-valuenow="${savingsProgression}" aria-valuemin="0" aria-valuemax="100" style="width:${savingsProgression}%">
                        ${savingsProgression}%
                        </div>
                    </div>
                </div>
                <div class="mx-5 saving-container overflow-auto">
                    <table class="table table-hover budgetTable">
                        <tr>
                            <th class="budget-th">Expenses</th>
                            <th class="budget-th">Amount</th>
                            <th class="budget-th">Actions</th>
                        </tr>
                        <c:forEach var="budget" items="${month.getSavings().getExpenses()}">
                            <tr class="budgetList">
                                <td>
                                    <c:out value="${budget.category}" />
                                </td>
                                <td>
                                    $
                                    <c:out value="${budget.amount}" />
                                </td>
                                <td>
                                    <form action="/budgets/${budget.id}" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input type="submit" value="Delete" class="btn">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>