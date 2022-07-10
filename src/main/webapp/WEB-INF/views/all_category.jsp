<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 05/07/2022
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UAhelper</title>
</head>
<body>
<table>
       <tbody>
    <c:forEach items="${category}" var="category">
<tr>
    <td><c:out value="${category.category}"/></td>
</tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
