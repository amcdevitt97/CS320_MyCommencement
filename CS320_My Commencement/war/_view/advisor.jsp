<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css">
<link rel="icon" type="image/png" href="Media/icon.png">
<title>MyCommencement - Advisor View</title>

</head>
<body>


	<!-- navbar content -->
	<div id="navBar">
		<img id="logo" src="Media/logo.png" />
		
		<form id="logout" action="${pageContext.servletContext.contextPath}/logout" method="post">
					<input type="Submit" value="Log Out" id="logOut" name="loginSubmit">
		</form>
		<form id="present" action="${pageContext.servletContext.contextPath}/present" method="post">
					<input type="Submit" value="Present" id="Present" name="presentSubmit">
		</form>
		<!-- <a href="#"> <div id="logOut"> Log Out </div> </a> -->
	</div>
<div id="content">
	<div id="errorMessage">
		<c:if test="${! empty errorMessage}">
			<tr>${errorMessage}</tr>
		</c:if>
	</div>
	<!-- left-sided content -->
	<div class="left" style="height:430px">
		<h3><%= request.getAttribute("fn") %>'s Students</h3>
		<div class="studentList" >
		<table style="width:380px;">
		<c:forEach items="${students}" var="student">
			<tr>
				         
				<form id="studentSelect" action="${pageContext.servletContext.contextPath}/studentSelect" method="post">
					<input type="hidden" name="studentSelected" value=${student.email}>  
					<input class="studentRowOdd" type="Submit" style="width: 100%;" value="${student.firstname} ${student.lastname}" id="studentRowButton" name="meme">
				</form>  
			</tr>
		</c:forEach>
		</table>
		</div>

	</div>

	<!-- right-sided content -->
	<div class="right">
			<div class="studentPreview">
				
				<img src="Media/defaultStudent.jpg" class="studentImage" />
				
				<audio controls="true">
  					<source src="Media/test.mp3">
				</audio>
				
				<p hidden><%= request.getAttribute("studentSelected") %></p>
				<h3><b><u> <%= request.getAttribute("slideFN") %> <%= request.getAttribute("slideLN") %></b></u></h3>
					<div class="attributes">
					
						<!--<c:set var = "serverMajor" value = ""/>
      					<c:if test = "${major != null}">
      					</c:if>-->
         				
         				<p><%= request.getAttribute("majorView") %></p>
						<p><%= request.getAttribute("minorView") %> </p>
						<p><%= request.getAttribute("honors") %></p>
						<p><%= request.getAttribute("sports") %></p>
						<p><%= request.getAttribute("clubs") %></p>
						<p><%= request.getAttribute("gpa") %> </p>
					</div>
				<div id="quotebox">	
					<h2><i><%= request.getAttribute("quote") %></i></h2>
				</div>
				<video width="240" height="160" controls autoplay muted>
  					<source src="Media/15Sec.mp4" type="video/mp4" >
					Your browser does not support the video tag.
				</video>
	
			</div>
		<div id="checklist">
			<!--TODO: MAKE SERIES OF CHECK BOXES IN A FORM FOR THE REVIEW CLASS-->
			<p>Please select the elements that you find acceptable:</p>
			<form action="${pageContext.servletContext.contextPath}/review" method = "post">
  				<input type="checkbox" name="AdvisorCheck" value="fname"> First Name
  				<input type="checkbox" name="AdvisorCheck" value="lname"> Last Name
  				<input type="checkbox" name="AdvisorCheck" value="honors"> Honors
  				<input type="checkbox" name="AdvisorCheck" value="sports"> Sports
  				<input type="checkbox" name="AdvisorCheck" value="club"> Clubs
  				<input type="checkbox" name="AdvisorCheck" value="quote"> Quote
  				<input type="checkbox" name="AdvisorCheck" value="photo"> Photo
  				<input type="checkbox" name="AdvisorCheck" value="video"> Video
  				<input type="checkbox" name="AdvisorCheck" value="audio"> Audio
  				<p> </p>
  				<input type="submit" value="Submit">
			</form>
			<c:if test="${not empty submitDone}">
  				<script>alert("Slide approvals sent!");
			</script></c:if>
		
		</div>
	</div>
</div>

</body>
</html>