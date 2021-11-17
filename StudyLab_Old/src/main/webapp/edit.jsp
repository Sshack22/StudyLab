<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%
//request.getSession().getAttribute("titleList");
@SuppressWarnings("unchecked")
List<String> listTitle = (List<String>) request.getAttribute("titleList");
%>



<body>

	<form action="Edit" method="post">

		<select name="title" id="title" style="width: 50px;">

			<c:forEach items="${titleList}" var="title">
				<option value="${title}">${title}</option>
			</c:forEach>
		</select>
		
		<input type="submit" name="select" value="Select" />

	</form>






</body>
</html>