<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Guessing Game</title>
	</head>

	<body>
		
		<form id="login" action="${pageContext.servletContext.contextPath}/login" method="post">
            	<input type="text" name="email" placeholder="email" value="${email}" required>
                <input type="password" name="password"placeholder="Password" value="${password}" required>
                <input type="Submit" value="Login" id="loginSubmit" name="loginSubmit">
                
                <div id="errorMessage">
                	<c:if test="${! empty errorMessage}">
						<tr>${errorMessage}</tr>
					</c:if>
				</div>
				
		</form><!-- /.login -->	
	</body>
</html>