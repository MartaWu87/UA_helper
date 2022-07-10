<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 07/07/2022
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<%@ include file="header.jsp" %>
</head>
<body>

<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="row">
            <div class="col-lg-12"
            <form:form method="post"
                       modelAttribute="user">
                <form:hidden path="id"/>
                <!-- 2 column grid layout with text inputs for the first and last names -->
                <div class="form-outline mb-1">
                    <input type="text" id="form3Example1" class="form-control" <form:input path="name"/>
                    <label class="form-label" for="form3Example1">Nazwa placówki</label>
                </div>
                <div class="form-outline mb-1">
                    <input type="text" id="form3Example2" class="form-control" <form:input path="adres"/>
                    <label class="form-label" for="form3Example2">Adres placówki</label>
                </div>
                <!-- Email input -->
                <div class="form-outline mb-1">
                    <input type="email" id="form3Example3" class="form-control" <form:input path="mail"/>
                    <label class="form-label" for="form3Example3">Adres e-mail</label>
                </div>
                <div class="form-outline mb-1">
                    <input type="phone" id="form32xample32" class="form-control" <form:input path="phone"/>
                    <label class="form-label" for="form32xample32">Nr telefonu</label>
                </div>
                <div class="form-outline mb-1">
                    <input type="number" id="form3Example41" class="form-control" <form:input path="accountNumber"/>
                    <label class="form-label" for="form3Example41">Account Number</label>
                </div>
                <div class="form-outline mb-1">
                    <input type="text" id="form3Example411" class="form-control" <form:input path="description"/>
                    <label class="form-label" for="form3Example411">Opis</label>
                </div>
                <%--                <div class="form-outline mb-1">--%>
                <%--                    <input type="" id="form3Example4111" <form:input path="region"/>" items="${Region.voivodship}"--%>
                <%--                           class="form-control"/>--%>
                <%--                    <label class="form-label" for="form3Example4111">REgion</label>--%>
                <%--                </div>--%>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">Wybierz województwo</label>
                    </div>
                    <select class="custom-select" id="inputGroupSelect01">
                        <option selected><form:select path="region"/></option>
                    </select><br/>

                </div>


                <!-- Password input -->
                <div class="form-outline mb-1">
                    <input type="password" id="form3Example4" class="form-control" <form:input path="password"/>
                    <label class="form-label" for="form3Example4">Hasło</label>
                </div>
                <div class="form-outline mb-1">
                    <input type="password" id="form3Example42" class="form-control" <form:input path="password"/>
                    <label class="form-label" for="form3Example42">Powtórz hasło</label>
                </div>

                <!-- Submit button -->
                <button type="submit" value="Zarejestruj" class="btn btn-primary btn-block mb-1">Zarejestruj</button>

                <!-- Register buttons -->

            </form:form>
        </div>
    </div>
    </div>
</section>

</body>
<%@ include file="footer.jsp" %>
</html>