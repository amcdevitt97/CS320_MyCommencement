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

public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String email = (String) req.getSession().getAttribute("user");
		
		System.out.println("\nReviewServlet: doGet");

		req.getRequestDispatcher("/_view/advisor.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("\nLoginServlet: doPost");
		
		String email = req.getParameter("email");
		Account acctModel = new Account();
		AccountController acctController = new AccountController(acctModel);
		req.setAttribute("fn", acctController.getFirstnameForEmail(email));
		
		
		String[] results = req.getParameterValues("AdvisorCheck");
		
		boolean firstName = true;
		boolean lastName= true;
		boolean honors = true;
		boolean sports = true;
		boolean club = true;
		boolean quote = true;
		boolean photo = true;
		boolean video = true;
		boolean audio = true;
		String f = "fname";
		String l = "lname";
		String h = "honors";
		String s = "sports";
		String c = "clubs";
		String q = "quote";
		String p = "photo";
		String v = "video";
		String a = "audio";
		
		for(int i = 0; i < results.length; i++) {
			if (f.equals(results[i]){
				
			}
		}
		
		
			// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/advisor.jsp").forward(req, resp);
		

		
	}

}