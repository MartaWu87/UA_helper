<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 11/07/2022
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<%@ include file="../extras/header.jsp" %>
<head>
    <title>UAhelper</title>
</head>
<div class="card-body">
    <div class="table-responsive">
        <div class="col-sm-12 col-md-6">
            <div id="dataTable_filter" class="dataTables_filter"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid"
                   aria-describedby="dataTable_info" style="width: 50%;">
                <thead>
                <tr role="row">
                    <th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                        aria-sort="ascending" aria-label="Name: activate to sort column descending"
                        style="width: 57px;">Województwo
                    <td><a href="<c:url value="/admin/region/add"/>" class="btn btn-info">
                        <span class="icon text-white-100"><b>Dodaj</b></a>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${region}" var="region">
                <tr>
                    <input type="hidden" name="id" value="${region.id}"/>
                    <td><c:out value="${region.voivodship}"/></td>
                    <td><a href="<c:url value="/admin/region/delete/${region.id}"/>"
                           class="btn btn-info btn-circle btn-sm">
                        <i class="fas fa-trash"></i>
                </tr>
                </c:forEach>
        </div>
    </div>
</div>
</tbody>
</table>
</body>
<%@ include file="../extras/footer.jsp" %>
</html>