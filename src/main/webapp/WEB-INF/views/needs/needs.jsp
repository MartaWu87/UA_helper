<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 08/07/2022
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>

<%@ include file="../extras/headerLog.jsp" %>
<header>
    <title>UAhelper</title>
</header>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Zarządzanie potrzebami</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                        <div class="dataTables_length" id="dataTable_length"><label>Show <select name="dataTable_length"
                                                                                                 aria-controls="dataTable"
                                                                                                 class="custom-select custom-select-sm form-control form-control-sm">
                            <option value="10">10</option>
                            <option value="25">25</option>
                            <option value="50">50</option>
                            <option value="100">100</option>
                        </select></label></div>
                    </div>
                    <div class="col-sm-12 col-md-6">
                        <div id="dataTable_filter" class="dataTables_filter"></div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <td><a href="<c:url value="/user/needs/add"/>" class="btn btn-info">
                            <span class="icon text-white-100"><b>Dodaj</b></a></td>
                        <br/><br/>
                        <table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0"
                               role="grid" aria-describedby="dataTable_info" style="width: 100%;">
                            <thead>
                            <tr role="row">
                                <th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-sort="ascending" aria-label="Name: activate to sort column descending"
                                    style="width: 57px;">Data dodania
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Position: activate to sort column ascending" style="width: 62px;">
                                    kategoria
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Position: activate to sort column ascending" style="width: 62px;">
                                    potrzeba
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Position: activate to sort column ascending" style="width: 62px;">
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--                <sec:authorize access="isAuthenticated()">--%>
                            <c:forEach items="${needs}" var="needs">
                            <tr role="row" class="odd">
                                <input type="hidden" name="id" value="${needs.id}"/>
                                <td>${needs.createDateTime}</td>
                                <td>${needs.category.name}</td>
                                <td>${needs.name}</td>
                                <td><a href="<c:url value="/user/needs/delete/${needs.id}"/>"
                                       class="btn btn-info btn-circle btn-sm">
                                    <i class="fas fa-trash"></i>
                                    </c:forEach>


                            </tr>


                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12 col-md-5">
                    </div>
                </div>
            </div>
            <%@ include file="../extras/footer.jsp" %>
