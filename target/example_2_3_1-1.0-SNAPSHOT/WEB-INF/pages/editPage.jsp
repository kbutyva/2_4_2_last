<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty user.name}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty user.name}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty user.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty user.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty user.name}">
        <input type="hidden" name="id" value="${user.id}">
    </c:if>
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="surname">Surname</label>
    <input type="text" name="surname" id="surname">
    <label for="salary">Salary</label>
    <input type="text" name="salary" id="salary">

    <c:if test="${empty user.name}">
        <input type="submit" value="Add new user">
    </c:if>
    <c:if test="${!empty user.name}">
        <input type="submit" value="Edit user">
    </c:if>
</form>
</body>
</html>
