<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="form-center.css">
<meta charset="UTF-8">
<title>Study Lab add file</title>
</head>
<body class="addbody">

	<form class="addform" action="Input" method="post">
		<table>

			<tr>
				<td>Title</td>
				<td><input style="width: 100%" type="text" name="title" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="print" value="add" /></td>
				<td><textarea id="input" name="body" rows="40" cols="100%"></textarea></td>
			</tr>
			<tr>
				<td></td>
			</tr>



		</table>
	</form>
</body>
</html>