<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Web Worker Manager</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="header">
    <h2>Workers list</h2>
	</div>
	<div id="container">
		<table class="styled-table">
			<thead>
				<tr>
				   <th>Name</th>
				   <th>Surname</th>
				   <th>Salary</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="worker" items="${workers}">
					<tr>
						<td>${worker.firstName}</td>
						<td>${worker.lastName}</td>
						<td>${worker.salary}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>