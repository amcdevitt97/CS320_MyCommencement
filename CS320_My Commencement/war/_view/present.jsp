<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>MyCommencement - Presentation</title>
		<link rel="icon" type="image/png" href="Media/icon.png">

		<link rel="stylesheet" href="css/reveal.css">
		<link rel="stylesheet" href="personal.css">
		<link rel="stylesheet" href="css/theme/simple.css">

		<!-- Theme used for syntax highlighting of code -->
		<link rel="stylesheet" href="web_lib/css/zenburn.css">

		<!-- Printing and PDF exports -->
		<script>
			var link = document.createElement( 'link' );
			link.rel = 'stylesheet';
			link.type = 'text/css';
			link.href = window.location.search.match( /print-pdf/gi ) ? 'css/print/pdf.css' : 'css/print/paper.css';
			document.getElementsByTagName( 'head' )[0].appendChild( link );
		</script>
	</head>
	<body>
		<div class="reveal">
			<div class="slides">
				<c:forEach items="${slides}" var="slide">
					<section>
					
					
					<img src="Media/defaultStudent.jpg" class="studentImage" />
					
					<audio controls="true">
	  					<source src="Media/test.mp3">
					</audio>
					
					
					<h3><b><u> ${slide.slideFN} ${slide.slideLN}</b></u></h3>
						<div class="attributes">
						
							<!--<c:set var = "serverMajor" value = ""/>
	      					<c:if test = "${major != null}">
	      					</c:if>-->
	         				
	         				<p>Major: <%= request.getAttribute("majorView") %></p>
							<p>Minor:<%= request.getAttribute("minorView") %> </p>
							<p>Honors: ${slide.honors}</p>
							<p>Sports: ${slide.sports}<p>
							<p>Clubs: ${slide.clubs}</p>
							<p>GPA:<%= request.getAttribute("gpa") %> </p>
						</div>
					<div id="quotebox">	
						<h2><i>${slide.quote}</i></h2>
					</div>
					<video width="240" height="160" controls autoplay muted>
	  					<source src="Media/15Sec.mp4" type="video/mp4" >
						Your browser does not support the video tag.
					</video>
					</section>
				</c:forEach>
				
			</div>
		</div>

		<script src="web_lib/js/head.min.js"></script>
		<script src="js/reveal.js"></script>

		<script>
			// More info about config & dependencies:
			// - https://github.com/hakimel/reveal.js#configuration
			// - https://github.com/hakimel/reveal.js#dependencies
			Reveal.initialize({
				dependencies: [
					{ src: 'plugin/markdown/marked.js' },
					{ src: 'plugin/markdown/markdown.js' },
					{ src: 'plugin/notes/notes.js', async: true },
					{ src: 'plugin/highlight/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad(); } }
				]
			});
		</script>
	</body>
</html>
