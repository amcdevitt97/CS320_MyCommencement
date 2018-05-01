package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SlideController;
import model.Slide;



public class PresentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\nPresentServlet: doGet");
		String email = (String) req.getSession().getAttribute("user");
		
		if (email == null) {
			System.out.println("   User: <" + email + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		req.getRequestDispatcher("/_view/present.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				Slide slide = null;
				SlideController controller = new SlideController(slide);
				List<Slide> slides = null;
				slides = controller.getAllSlides();
				req.setAttribute("slides",  slides);
				
				System.out.println("   Valid login - starting session, redirecting to /present");
				// redirect to /present page
				req.getRequestDispatcher("/_view/present.jsp").forward(req, resp);	
			}

}
