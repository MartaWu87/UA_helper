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

                <form:form method="post"
                           modelAttribute="category">
                    <form:input path="name"/>
                    <form:errors path="name"/><br/><br/>
                <input type="submit" value="Dodaj kategorię" class="btn btn-info">
                </form:form>
        </div>
    </div>
</div>
</table>

</body>
<%@ include file="../extras/footer.jsp" %>
</html>