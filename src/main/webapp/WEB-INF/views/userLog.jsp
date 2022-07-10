<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 08/07/2022
  Time: 10:37
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
    <c:forEach items="${user}" var="user">

            <td>${user.name}</td>
            <td>${user.adres}</td>
            <td>${user.mail}</td>
            <td>${user.phone}</td>
            <td>${user.accountNumber}</td>
            <td>${user.description}</td>
            <td>${user.needs}</td>
            </td>

    </c:forEach>
</table>
</body>
</html>