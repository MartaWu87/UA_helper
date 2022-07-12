<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 07/07/2022
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<%@ include file="headerLog.jsp" %>
<head>
    <title>UAhelper</title>
</head>
<body>

<form:form method="post" modelAttribute="needs">

    Wybierz kategorię  <form:select path="category" items="${category}" itemLabel="category"/><br/><br/>
    opis potrzeby  <form:input path="name"/>
    <form:errors path="name"/><br/><br/>

    <input type="submit" value="Dodaj">
</form:form>

</body>
<%@ include file="footer.jsp" %>
</html>
