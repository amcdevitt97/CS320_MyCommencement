package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginController;
import controller.AccountController;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				String email = (String) req.getSession().getAttribute("email");
				if (email == null) {
					System.out.println("   User: <" + email + "> not logged in or session timed out");
					
					// user is not logged in, or the session expired
					resp.sendRedirect(req.getContextPath() + "/login");
					return;
				}
				else{
					String fn=null;
					String ln=null;
					fn = "Alyssa";
					ln = "McDevitt";
					
					req.setAttribute("firstname", fn);
					req.setAttribute("lastname", ln);
				}
		
		
				req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
			req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
		
	}

}
