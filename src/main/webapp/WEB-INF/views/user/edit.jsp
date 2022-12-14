<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 08/07/2022
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<%@ include file="../extras/header.jsp" %>
</head>
<body>


<form:form method="post"
           modelAttribute="user">
    <section style="background-color: #eee;">
        <div class="container py-5">
            <div class="row">
                <div class="col-lg-12"
                <form:hidden path="id"/>
                <div class="form-outline mb-1">
                    <input type="text" id="form3Example1" class="form-control" <form:input path="name"/>
                    <form:errors path="name"/>
                    <label class="form-label" for="form3Example1">Nazwa placówki</label>
                </div>
                <div class="form-outline mb-1">
                    <input type="text" id="form3Example2" class="form-control" <form:input path="adres"/>
                    <form:errors path="adres"/>
                    <label class="form-label" for="form3Example2">Adres placówki</label>
                </div>
                <div class="form-outline mb-1">
                    <input type="tekst" id="form3Example3" class="form-control" <form:input path="mail"/>
                    <form:errors path="mail"/>
                    <label class="form-label" for="form3Example3">Adres e-mail</label>
                </div>
                <div class="form-outline mb-1">
                    <input type="phone" id="form32xample32" class="form-control" <form:input path="phone"/>
                    <form:errors path="phone"/>
                    <label class="form-label" for="form32xample32">Nr telefonu</label>
                </div>
                <div class="form-outline mb-1">
                    <input type="text" id="form3Example41" class="form-control" <form:input path="accountNumber"/>
                    <form:errors path="accountNumber"/>
                    <label class="form-label" for="form3Example41">Account Number</label>
                </div>
                <div class="form-outline mb-1">
                    <input type="text" id="form3Example411" class="form-control" <form:input path="description"/>
                    <form:errors path="description"/>
                    <label class="form-label" for="form3Example411">Opis</label>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">Wybierz województwo</label>
                    </div>
                    <form:select path="region" items="${regions}" itemLabel="voivodship"/>
                </div>
                <div class="form-outline mb-1">
                    <input type="password" id="form3Example4" class="form-control" <form:input path="password"/>
                    <form:errors path="password"/>
                    <label class="form-label" for="form3Example4">Hasło</label>
                </div>
                <button type="submit" value="Zapisz zmiany" class="btn btn-primary btn-block mb-1">Zapisz zmiany
                </button>
            </div>
        </div>
        </div>
    </section>
</form:form>
</body>
<%@ include file="../extras/footer.jsp" %>
</html>
