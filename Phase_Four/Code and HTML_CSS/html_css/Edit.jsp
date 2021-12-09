<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="form-center.css">
<title>Study Lab</title>
</head>


<body class="editbody">
	<div id="rectangle"></div>
	<div id="editdiv">
		<form class="editform" action="Edit" method="post">

			<select name="title" id="title">

				<c:forEach items="${titleList}" var="title">
					<option value="${title}">${title}</option>
				</c:forEach>
			</select> <input type="submit" name="select" value="Select" /> <br> <input
				type="submit" name="menu" value="Back" />

		</form>
	</div>





</body>
</html>