<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css">
<title>MyCommencement - Login</title>
<link rel="icon" type="image/png" href="Media/icon.png">
</head>
<body>


	<!-- navbar content -->
	<div id="navBar">
		<img id="logo" src="Media/logo.png" />
	</div>
<div id="content">
	<div id="errorMessage">
		<c:if test="${! empty errorMessage}">
			<tr>${errorMessage}</tr>
		</c:if>
	</div>

	<div id="loginPanel">
		<form id="login" action="${pageContext.servletContext.contextPath}/login" method="post">
					<input type="text" name="email" placeholder="email"  required>
					<input type="password" name="password" placeholder="Password"  required>
					<input type="Submit" value="Login" id="loginSubmit" name="loginSubmit">
		</form>
	</div>

</div>

</body>
</html>