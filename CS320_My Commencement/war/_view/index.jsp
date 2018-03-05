<!DOCTYPE html>

<html>
	<head>
		<title>Various Number Games</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		</style>
	</head>

	<body>

	<form action="${pageContext.servletContext.contextPath}/index" method="post">		
		<input type="submit" name="guess" value="Guessing game">
		<input type="submit" name="mul" value="Multiply">
		<input type="submit" name="add" value="Add">
	</form>
	</body>
</html>
