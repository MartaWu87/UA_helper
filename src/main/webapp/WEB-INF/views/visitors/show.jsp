<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 07/07/2022
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<%@ include file="../extras/header.jsp" %>
</head>
<body>
<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="row">
            <div class="col-lg-4">
                <div class="card mb-4">
                    <div class="card-body text-center">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
                             alt="avatar"
                             class="rounded-circle img-fluid" style="width: 150px;">
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Nazwa placówki</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${user.name}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">E-mail</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${user.mail}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Tel.</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${user.phone}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Adres</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${user.adres}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Województwo</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${user.region.voivodship}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Nr konta do wpłat</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${user.accountNumber}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container py-5 row">
        <div class="card col-lg-12">
            <p class="mb-8"><span class="text-primary font-italic me-1">Aktualne potrzeby placówki</span>
            </p>
            <p class="mb-8" style="font-size: .77rem;"> ${user.needs}</p>
        </div>
    </div>
    <div class="container py-5 row">
        <div class="card col-lg-12">
            <p class="mb-8"><span class="text-primary font-italic me-1">O nas...</span>
            </p>
            <p class="mb-8" style="font-size: .77rem;"> ${user.description}</p>
        </div>
    </div>
</section>
</body>
<%@ include file="../extras/footer.jsp" %>
</html>
