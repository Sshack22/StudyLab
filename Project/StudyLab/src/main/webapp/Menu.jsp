


<%@ page language="java" session="true"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

if (session.getAttribute("member") == null)
	response.sendRedirect("memberRegister.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="Menu" method="post">

		<h1>What would you like to do?</h1>
		
		<input type="submit" name="button1" value="test print username" />
		<input type="submit" name="button2" value="Logout" />
		<input type="submit" name="add" value="add" onclick="Form.action='Input';"/>
		<input type="submit" name="edit" value="edit" onclick="Form.action='Edit';"/>
		<input type="submit" name="delete" value="delete"/>
		<input type="submit" name="premade" value="premade"/>
		

	</form>

</body>
</html>