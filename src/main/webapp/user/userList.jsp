<!-- userList.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Password</th>
        <th>Full Name</th>
        <th>Date of Birth</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Verify Status</th>
        <th>Role ID</th>
        <!-- Thêm các cột khác cần hiển thị -->
    </tr>
    <c:forEach var="user" items="${usersList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.passwordHash}</td>
            <td>${user.fullName}</td>
            <td>${user.dateOfBirth}</td>
            <td>${user.address}</td>
            <td>${user.phone}</td>
            <td>${user.verifyStatus}</td>
            <td>${user.roleId}</td>
            <!-- Thêm các cột khác cần hiển thị -->
        </tr>
    </c:forEach>
</table>
</body>
</html>
