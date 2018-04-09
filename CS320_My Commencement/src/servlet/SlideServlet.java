package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginController;
import controller.AccountController;
import model.Slide;

public class SlideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\nSlideServlet: doGet");

		req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("\nSlideServlet: doPost");

		String major;
		boolean addMajor;
		String minor;
		boolean addMinor;
		String honors;
		String GPA;
		boolean showGPA;
		String sports;
		String clubs;
		String quote;
		Slide model = new Slide();
		
		//LoginController controller = new LoginController(model);
		//AccountController acctController = new AccountController(model);
		
		// Decode form parameters and dispatch to controller
		
		//determines state of major checkbox
		major = req.getParameter("major");
		if (major != null){
		    addMajor = true;
		}
		else{
		    addMajor= false;
		}
		
		//determines state of minor checkbox
		minor = req.getParameter("minor");
		if (minor != null){
		    addMinor = true;
		}
		else{
		    addMinor= false;
		}
		honors = req.getParameter("honors");
		
		//determines state of GPA checkbox
		GPA = req.getParameter("GPA");
		if (GPA != null){
		    showGPA = true;
		}
		else{
		    showGPA= false;
		}
		sports= req.getParameter("sports");
		clubs= req.getParameter("clubs");
		quote= req.getParameter("quote");
		

		//System.out.println("   Name: <" + email + "> PW: <" + pw + ">");			

		/*
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
				System.out.println("   Valid login - starting session, redirecting to /home");
				req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);						//Comments
			}
			else{
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
		 */
		
	}

}
