package servlet;

import java.io.IOException;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AccountController;
import controller.SlideController;
import controller.StudentController;
import model.Account;
import model.Slide;
import model.Student;

public class SlideServlet extends HttpServlet {
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
		
		//TODO:
		//getSlideForEmail
		//set attributes to given slide elements
		
		
		
		System.out.println("\nSlideServlet: doGet");

		req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("\nSlideServlet: doPost");
		
<<<<<<< HEAD

		Blob photo;
=======
		// DISPLAYING SLIDE INFO
		
>>>>>>> branch 'master' of https://github.com/amcdevitt97/CS320_MyCommencement.git
		String slideFN;
		String slideLN;
		String major;
		boolean addMajor;
		String minor;
		boolean addMinor;
		String honors;
		String GPA;
		boolean showGPA;
		Double studentGPA=0.0;
		String sports;
		String clubs;
		String quote;
		boolean hasPhoto;
		boolean hasVideo;
		boolean hasAudio;
		Slide model = new Slide();
		
		Student student = (Student) req.getSession().getAttribute("student");
		SlideController controller = new SlideController(model);
		
		// Decode form parameters and dispatch to controller
		honors = req.getParameter("honors");
		slideFN = req.getParameter("slideFN");
		slideLN = req.getParameter("slideLN");
		
		//determines state of GPA checkbox
		GPA = req.getParameter("gpaCheck");
		if (GPA != null){
		    showGPA = true;
		    studentGPA = student.getGPA();
		}
		else{
		    showGPA= false;
		}
		
		//determines state of major checkbox
		major = req.getParameter("showMajor");
		if (major != null){
		    addMajor = true;
		    major = student.getMajor();
		    System.out.println(major);
		}
		else{
		    addMajor= false;
		}
		
		//determines state of minor checkbox
		minor = req.getParameter("showMinor");
		if (minor != null){
		    addMinor = true;
		    minor = student.getMinor();
		    System.out.println(minor);
		}
		else{
		    addMinor= false;
		}
		
<<<<<<< HEAD
		Object temp = req.getAttribute("photo");
		photo = (Blob)temp;
		if (photo != null){
		    hasPhoto = true;
		}
		else{
		    hasPhoto= false;
		}
		
		
=======
>>>>>>> branch 'master' of https://github.com/amcdevitt97/CS320_MyCommencement.git
		sports= req.getParameter("sports");
		System.out.println("sport entered:"+ sports);
		clubs= req.getParameter("clubs");
		quote= req.getParameter("quote");
		String email = (String) req.getSession().getAttribute("user");
		
		// ADDS SLIDE ATTRIBUTES TO THE MODEL
		model.setSlideFN(slideFN);
		model.setSlideLN(slideLN);
		model.setShowMajor(addMajor);
		model.setShowMinor(addMinor);
		model.setHonors(honors);
		model.setShowGPA(showGPA);
		model.setSports(sports);
		model.setClubs(clubs);
		model.setQuote(quote);
		model.setStudentEmail(email);
<<<<<<< HEAD
		
=======
>>>>>>> branch 'master' of https://github.com/amcdevitt97/CS320_MyCommencement.git
		
<<<<<<< HEAD
		req.setAttribute("gpa", studentGPA);
		req.setAttribute("major", major);
		req.setAttribute("minor", minor);
		req.setAttribute("slideFN", slideFN);
		req.setAttribute("slideLN", slideLN);
		req.setAttribute("quote", quote);
		req.setAttribute("honors", honors);
		req.setAttribute("sports", sports);
		req.setAttribute("clubs", clubs);
		
		
		controller.addSlide(photo, slideFN, slideLN, hasPhoto, false, false, quote, honors, showGPA, addMajor, addMinor, false, email);
=======
		//	------------ROBERT: CHANGE THESE ( V      V      V  ) 3 VALUES TO 'HASAUDIO' 'HASVIDEO' AND 'HASPHOTO' WHEN EMPLIMENTING FILE UPLOAD
		controller.addSlide(slideFN, slideLN, false, false, false, quote, clubs, honors, sports, showGPA, addMajor, addMinor, false, email);
>>>>>>> branch 'master' of https://github.com/amcdevitt97/CS320_MyCommencement.git

	
		// ADDS SUBMITTED INFO TO NEXT PAGE
		if(controller.getSlideForEmail(email).getShowGPA()){
			req.setAttribute("gpa", student.getGPA());
		}
		if(controller.getSlideForEmail(email).getShowMajor()){
			req.setAttribute("major", student.getMajor());
		}
		if(controller.getSlideForEmail(email).getShowMinor()){
			req.setAttribute("minor", student.getMinor());
		}
		
		
		req.setAttribute("slideFN", controller.getSlideForEmail(email).getSlideFN());
		
		req.setAttribute("slideLN", controller.getSlideForEmail(email).getSlideLN());
		req.setAttribute("quote", controller.getSlideForEmail(email).getQuote());
		req.setAttribute("honors", controller.getSlideForEmail(email).getHonors());
		req.setAttribute("sports", controller.getSlideForEmail(email).getSports());
		System.out.println("sport fetched: "+controller.getSlideForEmail(email).getSports());
		req.setAttribute("clubs", controller.getSlideForEmail(email).getClubs());
		
		
		// SETTING NAME
		Account acctModel = new Account();
		AccountController acctController = new AccountController(acctModel);
		System.out.println(acctController.getFirstnameForEmail(email));
		req.setAttribute("fn", acctController.getFirstnameForEmail(email));
		
		
		req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
		
	}

}
