<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Your Purchase</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" type="text/css">
</head>
<body style="background: linear-gradient(#b5dfff, #0074cc) #b5dfff;">
<div class="container" style="height: 97%">
    <div class="hb">
        <div class="panel-header">
            <div style="padding-top:50px; background:linear-gradient(#d6d6d6, #f4f4f4)#d6d6d6;
-webkit-background-clip: text;  /* подробнее про background-clip */
color: transparent">Your purchase
            </div>
        </div>


        <hr/>
        <div class="button-panel">
            <div class="buttonConf" id="logout"><a class="res-but"
                                                   href="<c:url value="/purchase" />">Повернутись</a></div>
        </div>

    </div>

    <div class="tables-box">
        <div class="table" id="table1">
            <table border="1">
                <tr>
                    <th>Продукти</th>
                </tr>
                <c:forEach items="${purchasPanelList}" var="purchase">
                    <tr>
                        <c:set var="product" value="Продукти"/>
                        <c:choose>
                            <c:when test="${purchase.category.equals(product)}">
                                <td>${purchase.purchasePrice}</td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="table" id="table2">
            <table border="1">
                <tr>
                    <th>Комунальні витрати</th>
                </tr>
                <c:forEach items="${purchasPanelList}" var="purchase">
                    <tr>
                        <c:set var="komun" value="Комунальні_витрати"/>
                        <c:choose>
                            <c:when test="${purchase.category.equals(komun)}">
                                <td>${purchase.purchasePrice}</td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="table" id="table">
            <table border="1">
                <tr>
                    <th>Банківські витрати</th>
                </tr>
                <c:forEach items="${purchasPanelList}" var="purchase">
                    <tr>
                        <c:set var="bank" value="Банківські_витрати"/>
                        <c:choose>
                            <c:when test="${purchase.category.equals(bank)}">
                                <td>${purchase.purchasePrice}</td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="table" id="table3">
            <table border="1">
                <tr>
                    <th>Розваги</th>
                </tr>
                <c:forEach items="${purchasPanelList}" var="purchase">
                    <tr>
                        <c:set var="funny" value="Розваги"/>
                        <c:choose>
                            <c:when test="${purchase.category.equals(funny)}">
                                <td>${purchase.purchasePrice}</td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="table" id="table4">
            <table border="1">
                <tr>
                    <th>Непередбачувані витрати</th>
                </tr>
                <c:forEach items="${purchasPanelList}" var="purchase">
                    <tr>
                        <c:set var="contingencies" value="Непередбачувані_витрати"/>
                        <c:choose>
                            <c:when test="${purchase.category.equals(contingencies)}">
                                <td>${purchase.purchasePrice}</td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="table" id="table0">
            <c:set var="sum" value="0"/>
            <c:forEach items="${purchasPanelList}" var="purchase">
                <c:set var="sum" value="${sum+purchase.purchasePrice}"/>
            </c:forEach>

            <table border="1">
                <tr>
                    <th>Сума покупок за місяць</th>
                </tr>
                <tr>
                    <td>${sum}</td>
                </tr>
            </table>
        </div>
    </div>

</div>

</body>
</html>
