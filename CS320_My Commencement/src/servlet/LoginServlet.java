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

		req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
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
					System.out.println("Honors: "+slide.getHonors());
					System.out.println("Clubs: "+slide.getClubs());
					System.out.println("Quote: "+slide.getQuote());
					
					
					req.setAttribute("slideFN", slide.getSlideFN());
					req.setAttribute("slideLN", slide.getSlideLN());
					
					if(slide.getShowMajor()){
						req.setAttribute("major", studController.getMajorForEmail(email));
					}
					if(slide.getShowMinor()){

						req.setAttribute("minor", studController.getMinorForEmail(email));
					}
					req.setAttribute("honors", slide.getHonors());
					req.setAttribute("sports", slide.getSports());
					req.setAttribute("clubs", slide.getClubs());
					if(slide.getShowGPA()){
						req.setAttribute("gpa", studController.getGPAForEmail(email));
					}
					req.setAttribute("quote", slide.getQuote());	
				}
				
				System.out.println("   Valid login - starting session, redirecting to /home");
				req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);						
			}
			else{
				
				List<Student> students = null;
				System.out.println(email);
				students = acctController.getStudentsForAdvisor(email);
				System.out.println(students.get(0).getFirstname());
				req.setAttribute("students",  students);
				
				System.out.println(acctController.getStudentsForAdvisor(email));
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
