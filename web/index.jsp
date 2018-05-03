<%--
  Created by IntelliJ IDEA.
  User: dangkhoa
  Date: 02/05/2018
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
<h1>Customers</h1>

<form method="get" action="/customer">

    <c:choose>
        <c:when test="${requestScope.customerDetail != null}">
            Id: <input type="text" name="id" value="${customerDetail.getId()}"><br>
            Name: <input type="text" name="name" value="${customerDetail.getName()}"><br>
            Email: <input type="text" name="email" value="${customerDetail.getEmail()}"><br>
            Address: <input type="text" name="address" value="${customerDetail.getAddress()}"><br>
            <input type="hidden" name="method" value="create">
        </c:when>
        <c:when test="${requestScope.customerDetail == null}">
            Id: <input type="text" name="id"/><br>
            Name: <input type="text" name="name"/><br>
            Email: <input type="text" name="email"/><br>
            Address: <input type="text" name="address"/><br>
            <input type="hidden" name="method" value="create">
        </c:when>
    </c:choose>

    <%--<c:if test="customerDetail!=null">--%>
    <%--Id: <input type="text" name="id" value="${customerDetail.getId()}"><br>--%>
    <%--Name: <input type="text" name="name" value="${customerDetail.getName()}"><br>--%>
    <%--Email: <input type="text" name="email" value="${customerDetail.getEmail()}"><br>--%>
    <%--Address: <input type="text" name="address" value="${customerDetail.getAddress()}"><br>--%>
    <%--</c:if>--%>
    <%--<c:if test="customerDetail==null">--%>
    <%--Id: <input type="text" name="id"/><br>--%>
    <%--Name: <input type="text" name="name"/><br>--%>
    <%--Email: <input type="text" name="email"/><br>--%>
    <%--Address: <input type="text" name="address" /><br>--%>
    <%--</c:if>--%>
    <button>submit</button>

</form>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.getId()}</td>
            <td><a href="/customer?method=info&id=${customer.getId()}">${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customer?method=edit&id=${customer.getId()}">edit</a></td>
            <td><a href="/customer?method=delete&id=${customer.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
