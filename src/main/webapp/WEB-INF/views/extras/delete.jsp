<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 13/07/2022
  Time: 00:39
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
<form action="<c:url value="/user/delete"/>" method="post">
    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Usuń">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
<%@ include file="footer.jsp" %>
</html>