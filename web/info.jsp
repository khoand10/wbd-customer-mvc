<%--
  Created by IntelliJ IDEA.
  User: dangkhoa
  Date: 03/05/2018
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Infomation Customer</title>
</head>
<body>
<h1>Infomation</h1><br>
<a href="/customer">back</a><br>
Id: ${requestScope.user_info.getId()}<br>
Name: ${requestScope.user_info.getName()}<br>
Email: ${requestScope.user_info.getEmail()}<br>
Address: ${requestScope.user_info.getAddress()}

</body>
</html>
