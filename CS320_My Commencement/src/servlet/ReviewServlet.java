package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginController;
import controller.ReviewController;
import controller.SlideController;
import controller.StudentController;
import controller.AccountController;
import model.Account;
import model.Review;
import model.Slide;
import model.Student;

public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("\nReviewServlet: doGet");
		String email = (String) req.getSession().getAttribute("user");
		
		if (email == null) {
			System.out.println("   User: <" + email + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		Account model = new Account();
		AccountController controller = new AccountController(model);
		String userFirstName = controller.getFirstnameForEmail(email);
		req.getSession().setAttribute("fn", userFirstName);
		
		// Grabbing all students
		List<Student> students = null;
		students = controller.getStudentsForAdvisor(email);
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
		
		req.getRequestDispatcher("/_view/advisor.jsp").forward(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("\nReviewServlet: doPost");
		
		String errorMessage = null;
		
		String email = (String) req.getSession().getAttribute("user");
		System.out.println(email);
		Account acctModel = new Account();
		AccountController acctController = new AccountController(acctModel);
		req.setAttribute("fn", acctController.getFirstnameForEmail(email));
		Review model = new Review();
		ReviewController controller = new ReviewController(model);
		
		// Grabbing all students
		List<Student> students = null;
		students = acctController.getStudentsForAdvisor(email);
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
		
		String[] results = req.getParameterValues("AdvisorCheck");
		boolean firstName = false;
		boolean lastName= false;
		boolean honors = false;
		boolean sports = false;
		boolean club = false;
		boolean quote = false;
		boolean photo = false;
		boolean video = false;
		boolean audio = false;
		String f = "fname";
		String l = "lname";
		String h = "honors";
		String s = "sports";
		String c = "clubs";
		String q = "quote";
		String p = "photo";
		String v = "video";
		String a = "audio";
		
		if(results!=null){
			for(int i = 0; i < results.length; i++) {
				if (f.equals(results[i])){
					firstName = true;
				}
				else if(l.equals(results[i])) {
					lastName = true;
				}
				else if(h.equals(results[i])) {
					honors = true;
				}
				else if(s.equals(results[i])) {
					sports = true;
				}
				else if(c.equals(results[i])) {
					club = true;
				}
				else if(q.equals(results[i])) {
					quote = true;
				}
				else if(p.equals(results[i])) {
					photo = true;
				}
				else if(v.equals(results[i])) {
					video = true;
				}
				else if(a.equals(results[i])) {
					audio = true;
				}
			}
			String studentEmail = (String) req.getSession().getAttribute("studentSelected");
			studentEmail = (String) req.getAttribute("studentSelected");
			System.out.println("student currently selected is: "+(String) req.getSession().getAttribute("studetnSelected"));
			if(studentEmail!=null){
				controller.addReview(firstName, lastName, photo, audio, video, quote, honors, model.getGpa(), model.getMajor(), model.getMinor(), studentEmail, null, sports, club);
				System.out.println("Review Added!");
				req.setAttribute("submitDone","done");
			}
			else{
				errorMessage="Please select a student to view their slide content.";
				req.setAttribute("errorMessage", errorMessage);
			}
			
		}
		else{
			errorMessage="Please approve at least one element.";
			req.setAttribute("errorMessage", errorMessage);
		}
		
		
		
		
		
			// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/advisor.jsp").forward(req, resp);
		

		
	}

}