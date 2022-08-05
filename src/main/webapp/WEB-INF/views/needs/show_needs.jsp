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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<%@ include file="../extras/headerLog.jsp" %>
<head>
    <title>UAhelper</title>
</head>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Zarządzanie</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                <div class="row">
                    <div class="col-sm-12">
                        <table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0"
                               role="grid" aria-describedby="dataTable_info" style="width: 100%;">
                            <thead>
                            <tr role="row">
                                <th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-sort="ascending" aria-label="Name: activate to sort column descending"
                                    style="width: 57px;">Data dodania
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Position: activate to sort column ascending" style="width: 62px;">Kategoria
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Position: activate to sort column ascending" style="width: 62px;">
                                    Potrzeba
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Position: activate to sort column ascending" style="width: 62px;"><a
                                        href="<c:url value="/user/needs/add"/>" class="btn btn-info">
                                    <span class="icon text-white-100"><b>Dodaj</b></a>

                                </th>
                                                           </tr>
                            </thead>
                            <tbody>
<c:forEach items="${needs}" var="need">
<tr role="row" class="odd">
<%--    <input type="hidden" name="id" value="${needs.id}"/>--%>
    <td>${need.createDateTime}</td>
    <td>${need.category.name}</td>
    <td>${need.name}</td>
    <td><a href="<c:url value="/user/needs/delete/${need.id}"/>"
           class="btn btn-info btn-circle btn-sm">
        <i class="fas fa-trash"></i>
</c:forEach>
</tr>
                            </tbody>
                        </table>
                    </div>
                </div>
<%@ include file="../extras/footer.jsp" %>
</html>