<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 13/07/2022
  Time: 00:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<%@ include file="header.jsp" %>
<head>
    <title>UAhelper</title>
</head>
<body>
<div class="container">
    <form class="form-signin" method="post" action="/login">
        <h2 class="form-signin-heading">Podaj dane do logowania</h2>
        <p>
            <label> Nazwa : <input type="text" id="username" name="username" class="form-control" required=""
                                   autofocus="">
        </p>
        <p>
            <label> Hasło: <input type="password" id="password" name="password" class="form-control" required="">
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
