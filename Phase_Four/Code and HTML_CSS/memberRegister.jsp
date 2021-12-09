<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="form-center.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="landingbody">
<div>
	<form action="Register" method="post" >
		<table class="box" border="1px">
			<tr>
				<td>User name</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>			
			<tr>
				<td></td>
				<td><input type="submit" value="Login" onclick = "form.action='Login';">
				<input type="submit" value="Register" onclick = "form.action='Register';"></td>
			</tr>
		</table>


	</form>
	</div>

</body>
</html>