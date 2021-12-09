
<%@ page language="java" session="true"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="form-center.css">
<meta charset="ISO-8859-1">
<title>Study Lab</title>

</head>
<body class="menubody">
	<div id="rectangle"></div>
	<div>
		<form class="menuform" action="Menu" method="post">

			<h1>What would you like to do?</h1>



			<input type="submit" name="add" value="Add Entry"
				onclick="Form.action='Input';" /> <input type="submit" name="edit"
				value="Edit Entries" onclick="Form.action='Edit';" /> <input
				type="submit" name="delete" value="Delete Entry" /> <br> <br>

			<br> <br> <input type="submit" name="button2"
				value="Logout" />

		</form>
	</div>
</body>
</html>