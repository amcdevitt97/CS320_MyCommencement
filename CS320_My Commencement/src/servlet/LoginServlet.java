package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginController;
import controller.SlideController;
import controller.StudentController;
import controller.AccountController;
import model.Account;
import model.Slide;
import model.Student;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		System.out.println("\nLoginServlet: doGet");

		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("\nLoginServlet: doPost");

		String errorMessage = null;
		String email        = null;
		String pw           = null;
		boolean validLogin  = false;
		boolean isStudent = false;
		Account model = new Account();
		LoginController controller = new LoginController(model);
		AccountController acctController = new AccountController(model);
		
		
		// Decode form parameters and dispatch to controller
		email = req.getParameter("email");
		pw   = req.getParameter("password");

		System.out.println("   Name: <" + email + "> PW: <" + pw + ">");			

		if (email == null || pw == null || email.equals("") || pw.equals("")) {
			errorMessage = "Please specify both email and password";
		} else {
			
			validLogin = controller.loginUser(email, pw);
			isStudent = controller.isStudent(email);
			if (!validLogin) {
				errorMessage = "Email and/or password invalid";
			}
		}

		// Add parameters as request attributes
		req.setAttribute("email", req.getParameter("email"));
		req.setAttribute("password", req.getParameter("password"));
		System.out.println(acctController.getFirstnameForEmail(email));
		req.setAttribute("fn", acctController.getFirstnameForEmail(email));

		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("login",        validLogin);

		// if login is valid, start a session
		if (validLogin) {
			//controller.checkReviewSlide(model.getFirstname(), hasPhoto, hasAudio, hasQuote, hasVideo, showMajor, showMinor, showHonors, showSports, showClubs, showFN, showLN, explination, email);
			// store user object in session
			req.getSession().setAttribute("user", email);
			
			if(isStudent){
				// redirect to /home page
				Student student  = new Student(0,"", "", "", "", 0.0, "", "", "");
				StudentController studController = new StudentController(student);
				student = studController.getStudentForEmail(email);
				req.getSession().setAttribute("student", student);
				
				// SETS SLIDE ATTRIBUTES FROM DB
				SlideController slideCont = new SlideController(null); 
				Slide slide= slideCont.getSlideForEmail(email);
				
				if(slide!=null){
					
					
					req.setAttribute("slideFN", slide.getSlideFN());
					req.setAttribute("slideLN", slide.getSlideLN());
					
					if(slide.getShowMajor()){
						req.setAttribute("majorView", "Major: "+studController.getMajorForEmail(email));
					}
					else{
						req.setAttribute("majorView","");
					}
					if(slide.getShowMinor() && !studController.getMinorForEmail(email).isEmpty() && !studController.getMinorForEmail(email).equals("null") ){
						req.setAttribute("minorView", "Minor: "+studController.getMinorForEmail(email));
					}
					else{
						req.setAttribute("minorView","");
					}
					
					if(!slide.getHonors().isEmpty()){
						req.setAttribute("honors", "Honors:"+slide.getHonors());
					}
					else{
						req.setAttribute("honors","");
					}
					if(!slide.getSports().isEmpty()){
						req.setAttribute("sports", "Sports:"+slide.getSports());
					}
					else{
						req.setAttribute("sports","");
					}
					if(!slide.getClubs().isEmpty()){
						req.setAttribute("clubs", "Clubs:"+slide.getClubs());
					}
					else{
						req.setAttribute("clubs","");
					}
					if(slide.getShowGPA()){
						req.setAttribute("gpa", "GPA:"+studController.getGPAForEmail(email));
					}
					else{
						req.setAttribute("gpa","");
					}
					if(!slide.getQuote().isEmpty()){
						req.setAttribute("quote", slide.getQuote());
					}
					else{
						req.setAttribute("quote","");
					}
				}
				else{
					req.setAttribute("slideFN", "First");
					req.setAttribute("slideLN", "Last");
					req.setAttribute("majorView","Major:");
					req.setAttribute("minorView","Minor:");
					req.setAttribute("honors", "Honors:");
					req.setAttribute("sports", "Sports:");
					req.setAttribute("clubs", "Clubs:");
					req.setAttribute("gpa", "GPA:");
					req.setAttribute("quote", "'Quote'");	
				}
				
				System.out.println("   Valid login - starting session, redirecting to /home");
				req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);						
			}
			else{
				
				// Grabbing all students
				List<Student> students = null;
				System.out.println(email);
				students = acctController.getStudentsForAdvisor(email);
				System.out.println(students.get(0).getFirstname());
				req.setAttribute("students",  students);
				
				// Showing empty slide
				req.setAttribute("slideFN", "Select a student");
				req.setAttribute("slideLN","");
				req.setAttribute("majorView","");
				req.setAttribute("minorView","");
				req.setAttribute("honors","");
				req.setAttribute("sports","");
				req.setAttribute("clubs","");
				req.setAttribute("gpa","");
				req.setAttribute("quote","");
				
				System.out.println("   Valid login - starting session, redirecting to /advisor");
				// redirect to /advisor page
				req.getRequestDispatcher("/_view/advisor.jsp").forward(req, resp);	
			}
			

			return;
		}
		else{
			System.out.println("   Invalid login - returning to /login");

			// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}

		
	}

}
