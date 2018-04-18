<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<title>MyCommencement - <%= request.getAttribute("fn") %>'s slide </title>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>




<!-- navbar content -->
<div id="navBarFix"></div>
<div id="navBar">
	<img id="logo" src="Media/logo.png" />
		<form id="logout" action="${pageContext.servletContext.contextPath}/logout" method="post">
					<input type="Submit" value="Log Out" id="logOut" name="loginSubmit">
		</form>
		<!-- - <form>
			<a href="#"> <div id="logOut"> Log Out </div> </a> 
		</form>--->
</div>

<div id="content">
	<!-- left-sided content -->
	<div class="left">
		<h3><%= request.getAttribute("fn") %>'s Commencement</h3>
		<form id="update" action="${pageContext.servletContext.contextPath}/slide" method="post">
		<p>First Name: <input type="text" name="slideFN" style="width:70%"></p>
		<p>Last Name: <input type="text" name="slideLN" style="width:70%"></p>
		<p>Honors: <input type="text" name="honors"></p>
		<p>Check to show my GPA: <input type="checkbox" name="gpaCheck" value="showGPA" id="gpaBox"></p>
		<p>Check to show my Major: <input type="checkbox" name="showMajor" value="showMajor" id="gpaBox"></p>
		<p>Check to show my Minor: <input type="checkbox" name="showMinor" value="showMinor" id="gpaBox"></p>
		<p>Sports: <input type="text" name="sports"></p>
		<p>Clubs: <input type="text" name="clubs"></p>
		<p>Quote: <input type="text" name="quote"></p>
		<p>Upload Photo:</p> <input class="fileChoosers" type="file" name="photo" accept="image/*"></p>
		<p>Upload name pronunciation:</p> <input class="fileChoosers" type="file" name="audio" accept="audio/*"></p>
		<p>Upload video:</p> <input class="fileChoosers" type="file" name="video" accept="video/*"></p>
		
		<h2>Styling</h2>
		<div id="styleOne">
			<p>Style 1: </p><input type="radio" class="radio" name="style" value="one" checked> 
		</div>
		<div id="styleTwo">
  			<p>Style 2: </p><input type="radio" class="radio"name="style" value="two"> 
  		</div>
  		<div id="styleThree">
  			<p>Style 3: </p><input type="radio" class="radio"name="style" value="three">
		</div>
	</div>

	<!-- right-sided content -->
	<div class="right">
			<div class="studentPreview">
				
				<img src="Media/defaultStudent.jpg" class="studentImage" />
				
				<audio controls="true">
  					<source src="Media/test.mp3">
				</audio>
				
				
				<h3><b><u> <%= request.getAttribute("slideFN") %> <%= request.getAttribute("slideLN") %></b></u></h3>
					<div class="attributes">
					
						<!--<c:set var = "serverMajor" value = ""/>
      					<c:if test = "${major != null}">
      					</c:if>-->
         				
         				<p>Major: <%= request.getAttribute("majorView") %></p>
						<p>Minor:<%= request.getAttribute("minorView") %> </p>
						<p>Honors: <%= request.getAttribute("honors") %></p>
						<p>Sports: <%= request.getAttribute("sports") %></p>
						<p>Clubs: <%= request.getAttribute("clubs") %></p>
						<p>GPA:<%= request.getAttribute("gpa") %> </p>
					</div>
				<div id="quotebox">	
					<h2><i><%= request.getAttribute("quote") %></i></h2>
				</div>
				<video width="240" height="160" controls autoplay muted>
  					<source src="Media/15Sec.mp4" type="video/mp4" >
					Your browser does not support the video tag.
				</video>
	
			</div>
		
		<input type="Submit" value="Update & Save" id="saveButton" name="updateSubmit">
		
		</form>
	</div>
</div>

</body>
</html>