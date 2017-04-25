<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>EcoManager</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" type="text/css">
</head>
<body style="background: linear-gradient(#b5dfff, #0074cc) #b5dfff;">
<div class="container" style="height: 97%">
    <div id="panel">
        <div class="hb">
            <div class="panel-header">
                <div style="padding-top:50px; background:linear-gradient(#d6d6d6, #f4f4f4)#d6d6d6;
		-webkit-background-clip: text;  /* подробнее про background-clip */
	  color: transparent">Economic Manager
                </div>
            </div>


                <hr/>
                <div class="button-panel">
                   <div class="buttonConf" > <a class="res-but"
                            href="<c:url value="/" />">Редагувати профіль</a></div>
                    <div class="buttonConf" style="line-height: 40px;"> <a class="res-but"
                             href="<c:url value="/" />">Зарплата</a></div>
                    <div class="buttonConf"> <a class="res-but"
                            href="<c:url value="/result" />">Виписка за місяць</a></div>
                    <div  class="buttonConf" id="logout"><a class="res-but"
                            href="<c:url value="/j_spring_security_logout" />">Logout</a></div>

                </div>


        </div>
    </div>
    <form:form action="${pageContext.request.contextPath}\purchase" method="post"
               commandName="purchasePanel" enctype="multipart/form-data">
        <div class="panel-body">


            <div class="header-body">
                <div>Виписка</div>
            </div>
            <div class="purches-balanc">
                <div class="purches-balanc" id="string">
                    Витрати за цей місяц: <span style="color:red">${sum}</span></br>
                    Залишок: <span style="color:red">${balance}</span>
                </div>
                <div style="border-top:2px solid #0E5F9C; margin-left:-69px"></div>
                <div class="add-purches">

                    <div style="font-size:140%; padding-left:2%; font-weight:bold; margin-right: 20px">Добавити
                        витрати
                    </div>
                    </br>
                    <div style=" width:100%; height:1px; clear:both;"></div>
                    <div style="color: red; padding-left: 50px"><c:if test='${not empty "${Error}"}'>
                        ${Error}
                    </c:if></div>
                    <div class="linia" style="padding-top:15px">
                        <label for="addPrice" id="addPrice" style="font-size:115%; padding-left:2%; font-weight:bold;">Введіть
                            ціну</label>
                        <div class="input-group">
                            <input id="add-pur" path="addPrice" type="text" style="text-align:center; width:100px"
                                   placeholder="0" name="purchasePrice">
                        </div>
                    </div>
                    <div class="linia" style="margin-left:5%">
                        <label for="addCategory" id="addCategory"
                               style="font-size:115%; padding-left:2%; font-weight:bold;">Виберіть категорію</label>
                        <div class="input-group">
                            <select path="addCategory" id="addCategor" name="category">
                                <option value="Ви не вибрали категорыю"></option>
                                <option value="Продукти">Продукти</option>
                                <option value="Комунальні_витрати">Комунальні витрати</option>
                                <option value="Банківські_витрати">Банківські витрати</option>
                                <option value="Розваги">Розваги</option>
                                <option value="Непередбачувані_витрати">Непередбачувані витрати</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="submint-button">
                <input class="sub-button" type="submit" value="Добавити">
            </div>

        </div>
    </form:form>

</div>
</div>
</body>
</html>