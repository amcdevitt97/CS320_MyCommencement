package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginController;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try{
			System.out.println("test");
			String username = req.getSession().getAttribute("email").toString();
			if(username != null){
				System.out.println("test");
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		}
		catch (NullPointerException e){
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("test");
		String email = null;
		String type = null;
		String password = null;
		String buttonPress = null;
		boolean loggedin = false;
		String errorMessage = null;
		LoginController login = new LoginController();

		buttonPress = req.getParameter("loginSubmit");
		

		if(buttonPress != null){
			if(buttonPress.toLowerCase().equals("login")){
				email = req.getParameter("email");
				password = req.getParameter("password");
				if("".equals(email) || email == null ||
						"".equals(password) || password == null){
					errorMessage = "Invalid email or password.";
					System.out.println(errorMessage);
				}
				else {
					// verify login is correct
					if(login.loginUser(email, password)){
						req.getSession().setAttribute("email", email);
						
						// determines which JSP to display based on the account
						if(login.isStudent(email)){
							req.getSession().setAttribute("type", "student");
						}
						else{
							req.getSession().setAttribute("type", "advisor");
						}
						loggedin = true;
					}
					// if login fails...
					else{
						errorMessage = "Invalid username or password.";
					}
				}
				
				
				if(loggedin){
					System.out.println("test");
					req.setAttribute("email", email);
					if(login.isStudent(email)){
						req.setAttribute("type", "student");
					}
					else{
						req.setAttribute("type", "advisor");
					}
					req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
					
					resp.sendRedirect(req.getContextPath() + "/home");
				}
				else{
					System.out.println("test");
					req.setAttribute("email", email);
					req.setAttribute("errorMessage", errorMessage);
					req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
				}
			}
		}
		else{
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}
	}

}
