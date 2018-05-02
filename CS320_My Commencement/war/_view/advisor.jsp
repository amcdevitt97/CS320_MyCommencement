<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css">
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
	<!-- left-sided content -->
	<div class="left" style="height:430px">
		<h3><%= request.getAttribute("fn") %>'s Students</h3>
		<div class="studentList" >
		<table style="width:380px;">
		<c:forEach items="${students}" var="student">
			<tr class="studentRowOdd" >
				<td>${student.firstname} ${student.lastname}</td>           
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
				
				
				<h3><b><u>Default Name</b></u></h3>
					<div class="attributes">
						<p>Major: </p>
						<p>Minor: </p>
						<p>Honors: </p>
						<p>Sports: </p>
						<p>Clubs: </p>
						<p>GPA: </p>
					</div>
				<div id="quotebox">	
					<h2><i>This is a quote</i></h2>
				</div>
				<video width="240" height="160" controls autoplay muted>
  					<source src="Media/15Sec.mp4" type="video/mp4" >
					Your browser does not support the video tag.
				</video>
	
			</div>
		<div id="checklist">
			<!--TODO: MAKE SERIES OF CHECK BOXES IN A FORM FOR THE REVIEW CLASS-->
			<form action="#">
  				<input type="checkbox" name="AdvisorCheck" value="fname"> First Name
  				<input type="checkbox" name="AdvisorCheck" value="lname"> Last Name
  				<input type="checkbox" name="AdvisorCheck" value="honors"> Honors
  				<input type="checkbox" name="AdvisorCheck" value="sports"> Sports
  				<input type="checkbox" name="AdvisorCheck" value="club"> Clubs
  				<input type="checkbox" name="AdvisorCheck" value="quote"> Quote
  				<input type="checkbox" name="AdvisorCheck" value="photo"> Photo
  				<input type="checkbox" name="AdvisorCheck" value="video"> Video
  				<input type="checkbox" name="AdvisorCheck" value="audio"> Audio
  				<input type="submit" value="Submit">
			</form>
		
		</div>
	</div>
</div>

</body>
</html>