package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginController;
import model.Account;

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

		// Decode form parameters and dispatch to controller
		email = req.getParameter("email");
		pw   = req.getParameter("password");

		System.out.println("   Name: <" + email + "> PW: <" + pw + ">");			

		if (email == null || pw == null || email.equals("") || pw.equals("")) {
			errorMessage = "Please specify both email and password";
		} else {
			Account model = new Account();
			LoginController controller = new LoginController(model);
			validLogin = controller.loginUser(email, pw);
			isStudent = controller.isStudent(email);
			if (!validLogin) {
				errorMessage = "Email and/or password invalid";
			}
		}

		// Add parameters as request attributes
		req.setAttribute("email", req.getParameter("email"));
		req.setAttribute("password", req.getParameter("password"));

		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("login",        validLogin);

		// if login is valid, start a session
		if (validLogin) {
			System.out.println("   Valid login - starting session, redirecting to /home or /advisor");

			// store user object in session
			req.getSession().setAttribute("user", email);
			
			if(isStudent){
				// redirect to /home page
				resp.sendRedirect(req.getContextPath() + "/home");
			}
			else{
				// redirect to /advisor page
				resp.sendRedirect(req.getContextPath() + "/advisor");
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
