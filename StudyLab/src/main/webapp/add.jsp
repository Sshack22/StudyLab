<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="Input" method="post">
		<table>

			<tr>
				<td>title</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td></td>
				<td><textarea id="input" name="body" rows="4" cols="50"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" name="print" value="add" /></td>
			</tr>



		</table>
	</form>
</body>
</html>