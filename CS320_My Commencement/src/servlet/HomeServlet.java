package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AccountController;
import controller.LoginController;
import controller.SlideController;
import model.Account;
import model.Slide;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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
				System.out.println(userFirstName);
				req.getSession().setAttribute("fn", userFirstName);
				
				LoginController logCont = new LoginController(model);
				if(logCont.isStudent(email)){
					SlideController slideCont = new SlideController(null); 
					Slide slide= slideCont.getSlideForEmail(email);
					System.out.println("Honors: "+slide.getHonors());
					System.out.println("Clubs: "+slide.getClubs());
					System.out.println("Quote: "+slide.getQuote());
				}
				
				req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String email = req.getSession().getAttribute("user").toString();
			System.out.println(email);
			
			
			req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
		
	}

}