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
			String username = req.getSession().getAttribute("email").toString();
			if(username != null){
				resp.sendRedirect(req.getContextPath() + "/user");
			}
		}
		catch (NullPointerException e){
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String email = null;
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
					
					;
					if(login.loginUser(email, password)){
						req.getSession().setAttribute("email", email);
						loggedin = true;
					}
					else{
						errorMessage = "Invalid username or password.";
					}
				}
				if(loggedin){
					req.setAttribute("email", email);
					req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
					
					resp.sendRedirect(req.getContextPath() + "/home");
				}
				else{
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
