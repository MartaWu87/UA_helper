<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 07/07/2022
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>UAhelper</title>
</head>
<body>
    <tr>
        <th>Podaj nazwę kategorii :</th><br/><br/>
    </tr>
<form:form method="post" modelAttribute="category">
    <form:hidden path="id"/>
    <form:input path="category"/>
    <form:errors path="category"/><br/><br/>
    <input type="submit" value="Dodaj">
</form:form>
</body>
</html>