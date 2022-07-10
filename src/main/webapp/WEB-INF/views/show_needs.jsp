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
<%@ include file="header.jsp" %>
<head>
    <title>UAhelper</title>
</head>
<body>

<table>
    <tr>
        <th>Moje potrzeby:</th><br/><br/>
        <th>kategoria</th>
        <th>potrzeba</th>
    </tr>
    <c:forEach items="${needs}" var="needs">
        <tr>
            <td></td>
            <td>${needs.category}</td>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      g
            <td>${needs.name}</td>
        </tr>
    </c:forEach>
</table>
<%@ include file="footer.jsp" %>

</body>
