<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 11/07/2022
  Time: 23:10
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

<form:form method="post"
           modelAttribute="region">
    <form:input path="voivodship"/>
    <form:errors path="voivodship"/><br/>
       <input type="submit" value="Save">
</form:form>

</body>
</html>