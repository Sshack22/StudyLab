<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<form action="EditSelected" method="post">
		<table>

			<tr>
				<td>title</td>
				<td><input  value="${tempTitle}" type="text" name="newtitle"></td>
			</tr>
			<tr>
				<td></td>
				<td><textarea id="input" name="newbody" rows="4" cols="50">
${textBody}
				</textarea></td>
			</tr>
			<tr>
				<td><input type="submit" name="save" value="save" /></td>
			</tr>



		</table>
	</form>







</body>
</html>