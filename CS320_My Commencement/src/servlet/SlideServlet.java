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

		String slideFN;
		String slideLN;
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
		
		honors = req.getParameter("honors");
		slideFN = req.getParameter("slideFN");
		slideLN = req.getParameter("slideLN");
		
		//determines state of GPA checkbox
		GPA = req.getParameter("GPA");
		if (GPA != null){
		    showGPA = true;
		}
		else{
		    showGPA= false;
		}
		
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
		
		
		sports= req.getParameter("sports");
		clubs= req.getParameter("clubs");
		quote= req.getParameter("quote");
		String email = (String) req.getSession().getAttribute("user");
		
		model.setSlideFN(slideFN);
		model.setSlideLN(slideLN);
		model.setShowMajorA(addMajor);
		model.setShowMinor(addMinor);
		model.setHonors(honors);
		model.setShowGPA(showGPA);
		model.setSports(sports);
		model.setClubs(clubs);
		model.setQuote(quote);
	
		//ADD CONTROLLER AND ITS METHOD FOR SLIDE CHECK HERE			
		
		req.setAttribute("slideFN", slideFN);
		req.setAttribute("slideLN", slideLN);
		req.setAttribute("quote", quote);
		req.setAttribute("honors", honors);
		req.setAttribute("sports", sports);
		req.setAttribute("clubs", clubs);
		System.out.println("Quote: "+quote);
		
		req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
		
	}

}
