<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="Delete" method="post">

		<select name="title" id="title" style="width: 50px;">

			<c:forEach items="${titleList}" var="title">
				<option value="${title}">${title}</option>
			</c:forEach>
		</select>
		
		<input type="submit" name="select" value="Delete" />
		<br>
		<input type="submit" name="menu" value="Back" />

	</form>



</body>
</html>