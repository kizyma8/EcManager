<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>Skills Management</title>
     <link rel="stylesheet" href="<c:url value="/resources/css/login.css" />" type="text/css">
</head>
<body>
<div class="container">
    <div id="loginbox"
         class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="header-form">
                <div class="panel-title">Sign In</div>
            </div>

            <div  class="panel-body">

                <div  id="login-alert"
                     class="alert alert-danger col-sm-12"></div>

                <c:if test="${not empty msg}">
                    <div class="msg" style="color: #ff0000">${msg}</div>
                </c:if>




                <form name="loginForm"
                      action="<c:url value="/j_spring_security_check"/>" method="post">
                    <c:if test="${not empty error }">
                        <div class="error" >${error}</div>
                    </c:if>
                    <div class="form-group">
                        <div  class="input-group">
								<span class="input-group-addon"><i
                                        class="glyphicon glyphicon-user"></i></span> <input id="username"
                                                                                            type="text" class="form-control" name="username"
                                                                                            placeholder="UserName" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
								<span class="input-group-addon"><i
                                        class="glyphicon glyphicon-lock"></i></span> <input id="password"
                                                                                            type="password" class="form-control" name="password"
                                                                                            placeholder="password" required="required">
                        </div>
                        <!-- Show password use JS (main.js) -->
                        <div class="input-group">
                            <div class="checkbox">
                                <label> <input id="showPassword" type="checkbox" />Show
                                    Password
                                </label> </br> <input class="pull-right" id="login-remember"
                                                 type="checkbox" name="_spring_security_remember_me" value="1">
                                Remember me
                                </label>
                            </div>
                        </div>
                    </div>

                    <div  class="form-submit">
                        <!-- Button -->

                        <input class="submit-button" type="submit" value="Login" class="btn btn-default" /> <input
                            type="hidden" name="${_csrf.parameterName}"
                            value="${_csrf.token}" />
                    </div>
                </form>
                <div class="form-group">
                    <div class="col-md-12 control">
                        <div id="have-account">
                            Don't have an account! <a style="text-decoration: none;" href="<c:url value="/register"/>"> Sign
                            Up Here </a>
                        </div>
                    </div>
                </div>




            </div>
        </div>
    </div>

</div>
</body>
</html>