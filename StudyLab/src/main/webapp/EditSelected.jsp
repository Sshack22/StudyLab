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
<body class="addbody">



	<form action="EditSelected" method="post">
		<table>

			<tr>
				<td>Title: <input value="${tempTitle}" type="text"
					name="newtitle"><input type="submit" name="save"
					value="save" style="margin-left: 10px" /> <input
				type="submit" name="menu" value="Back" /></td>

			</tr>
			<tr>
				<td><textarea id="input" name="newbody" rows="4" cols="50">
${textBody}
				</textarea></td>
			</tr>

		</table>
	</form>


</body>
</html>