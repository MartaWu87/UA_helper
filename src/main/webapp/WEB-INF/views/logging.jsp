<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 08/07/2022
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Uahelper</title>
</head>
<body>


<form:form method="post"
           modelAttribute="user">
    ZALOGUJ <br/><br/>
    adres e-mail   <form:input path="mail"/><br/><br/>
    hasło   <form:input path="password"/><br/><br/>

    <input type="submit" value="Zaloguj">
</form:form>

</body>
</html>
