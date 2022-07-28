<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 09/07/2022
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="../extras/headerLog.jsp" %>
<head>
    <title>UAhelper</title>
</head>
<body>
<c:forEach items="${needs}" var="needs">
    <td>${needs.createDateTime}</td>
    <td>${needs.category.category}</td>
    <td>${needs.name}</td>
    </c:forEach>
</body>
<%@ include file="../extras/footer.jsp" %>
</html>