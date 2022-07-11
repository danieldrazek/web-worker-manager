<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Web Worker Manager</title>

        <link type="text/css" rel="stylesheet" href="css/style.css" >
</head>
<body>
	<div id="header">
		<h2>Edit worker</h2>
	</div>
	<div id="nav">
		<a href="/web-worker-manager/list">
			<div class="button">Workers list</div>
		</a>
	</div>
	<div id="container">
		<form method="post" action="/web-worker-manager/update-worker">
			<fieldset>
			    <input type="hidden" name="id" value="${worker.id}"/>

				<label for="first-name">Name</label>
				<input type="text" id="first-name" name="first-name" value="${worker.firstName}"/>

				<label for="last-name">Surname</label>
				<input type="text" id="last-name" name="last-name" value="${worker.lastName}"/>

				<label for="salary">Salary</label>
				<input type="text" id="salary" name="salary" value="${worker.salary}"/>
			</fieldset>

			<button type="submit">Save</button>
		</form>
	</div>
</body>
</html>