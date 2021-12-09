<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="form-center.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="editbody">

<div id="rectangle"></div>
	<div id="editdiv">
	<form class="editform" action="Delete" method="post">

		<select name="title" id="title">

			<c:forEach items="${titleList}" var="title">
				<option value="${title}">${title}</option>
			</c:forEach>
		</select>
		
		<input type="submit" name="select" value="Delete" />
		<br>
		<input type="submit" name="menu" value="Back" />

	</form>
</div>


</body>
</html>