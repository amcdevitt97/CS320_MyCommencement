<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>




<!-- navbar content -->
<div id="navBarFix"></div>
<div id="navBar">
	<img id="logo" src="Media/logo.png" />
	<a href="#"> <div id="logOut"> Log Out </div> </a> 
</div>

<div id="content">
	<!-- left-sided content -->
	<div class="left">
		<h3><%= request.getAttribute("fn") %>'s Commencement</h3>

		<p>Major: <input type="text" name="major"></p>
		<p>Minor: <input type="text" name="minor"></p>
		<p>Honors: <input type="text" name="honors"></p>
		<p>Check to show my GPA: <input type="checkbox" name="gpa" value="showGPA" id="gpaBox"></p>
		<p>Sports: <input type="text" name="sport"></p>
		<p>Clubs: <input type="text" name="club"></p>
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
		<a href="#" id="saveButton"> Update & Save </a>
	</div>
</div>

</body>
</html>