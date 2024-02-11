<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Character</title>
</head>
<body>
	<form action="editUnitServlet" method="post">
		<input type="hidden" name="id" value="${toEdit.getId() }"/>
		<label for="name">Name: </label>
		<input name="name" type="text" value="${toEdit.getName() }" />
		<label for="unitClass">Class: </label>
		<input name="unitClass" type="text" value="${toEdit.getType() }" />
		<button type="submit">Save Character</button>
	</form>
</body>
</html>