<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="form-center.css">
<meta charset="UTF-8">
<title>Study Lab</title>
</head>
<body class="addbody">
	<div>
		<form action="Input" method="post">
			<table>

				<tr>
					<td>Title: <input type="text" name="title" /><input style="margin-left: 10px"
						type="submit" name="print" value="Add" /> <input type="submit" name="menu" value="Back" /></td> 
					<td></td>
				</tr>
				<tr>
					<td><textarea id="input" name="body"></textarea></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>