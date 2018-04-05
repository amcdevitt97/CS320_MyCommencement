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
		<!-- <a href="#"> <div id="logOut"> Log Out </div> </a> -->
	</div>
<div id="content">
	<!-- left-sided content -->
	<div class="left" style="height:430px">
		<h3><%= request.getAttribute("fn") %>'s Students</h3>
		<div class="studentList">
			<div class="studentRowOdd"> 
				<p> A Student </p>
			</div>
			<div class="studentRowEven"> 
				<p> A Student </p>
			</div>
			<div class="studentRowOdd"> 
				<p> A Student </p>
			</div>
			<div class="studentRowEven"> 
				<p> A Student </p>
			</div>
			<div class="studentRowOdd"> 
				<p> A Student </p>
			</div>
			<div class="studentRowEven"> 
				<p> A Student </p>
			</div>
			<div class="studentRowOdd"> 
				<p> A Student </p>
			</div>
			<div class="studentRowEven"> 
				<p> A Student </p>
			</div>
			<div class="studentRowOdd"> 
				<p> A Student </p>
			</div>
			<div class="studentRowEven"> 
				<p> A Student </p>
			</div>
			<div class="studentRowOdd"> 
				<p> A Student </p>
			</div>
			<div class="studentRowEven"> 
				<p> A Student </p>
			</div>
			<div class="studentRowOdd"> 
				<p> A Student </p>
			</div>
			<div class="studentRowEven"> 
				<p> A Student </p>
			</div>
			<div class="studentRowOdd"> 
				<p> A Student </p>
			</div>
			<div class="studentRowEven"> 
				<p> A Student </p>
			</div>
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
  				<input type="checkbox" > 
  				<input type="submit" value="Submit">
			</form>
		
		</div>
	</div>
</div>

</body>
</html>