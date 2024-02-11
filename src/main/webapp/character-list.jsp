<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Character List</title>
</head>
<body>
  <form method="post" action="navigationServlet">
	<table>
	<c:forEach items="${requestScope.allunits }" var="currentunit">
		<tr>
			<td>
				<input type="radio" name="id" value="${currentunit.getId() }">
			</td>
			<td>${currentunit.getName()}</td>
			<td>${currentunit.getType() }</td>
		</tr>
	</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToUnit">
	<input type="submit" value="delete" name="doThisToUnit">
	<input type="submit" value="add" name="doThisToUnit">
  </form>
</body>
</html>