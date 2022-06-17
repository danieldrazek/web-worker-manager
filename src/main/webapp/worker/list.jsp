<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Web Worker Manager</title>

    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <h2>Workers list</h2>
    <table>
        <tr>
           <th>Name</th>
           <th>Surname</th>
           <th>Salary</th>
        </tr>
        <c:forEach var="worker" items="${workers}">
            <tr>
                <td>${worker.firstName}</td>
                <td>${worker.lastName}</td>
                <td>${worker.salary}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>