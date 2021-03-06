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
		req.getSession().setAttribute("fn", userFirstName);
		
		
		
		
		System.out.println("\nSlideServlet: doGet");

		req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("\nSlideServlet: doPost");
		

		Blob photo;
		// DISPLAYING SLIDE INFO
		
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
		
		String email = (String) req.getSession().getAttribute("user");
		Student student  = new Student(0,"", "", "", "", 0.0, "", "", "");
		StudentController studController = new StudentController(student);
		student = studController.getStudentForEmail(email);
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
		    System.out.println("GPA: "+studentGPA);
		}
		else{
			studentGPA =  null;
		    showGPA= false;
		}
		
		//determines state of major checkbox
		major = req.getParameter("showMajor");
		if (major != null){
		    addMajor = true;
		    major = student.getMajor();
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
		
		Object temp = req.getAttribute("photo");
		photo = (Blob)temp;
		if (photo != null){
		    hasPhoto = true;
		}
		else{
		    hasPhoto= false;
		}
		
		
		sports= req.getParameter("sports");
		clubs= req.getParameter("clubs");
		quote= req.getParameter("quote");
		
		
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
		
		
		
		//	------------ROBERT: CHANGE THESE ( V      V      V  ) 3 VALUES TO 'HASAUDIO' 'HASVIDEO' AND 'HASPHOTO' WHEN EMPLIMENTING FILE UPLOAD
		controller.addSlide(slideFN, slideLN, hasPhoto, false, false, quote, clubs, honors, sports, showGPA, addMajor, addMinor, false, email);
		
		req.setAttribute("slideFN", controller.getSlideForEmail(email).getSlideFN());
		req.setAttribute("slideLN", controller.getSlideForEmail(email).getSlideLN());
		
		if(controller.getSlideForEmail(email).getShowMajor()){
			req.setAttribute("majorView", "Major: "+studController.getMajorForEmail(email));
			System.out.println("Major set to: "+ req.getAttribute("majorView"));
		}
		else{
			req.setAttribute("majorView","");
		}
		if(controller.getSlideForEmail(email).getShowMinor() && !studController.getMinorForEmail(email).isEmpty() && !studController.getMinorForEmail(email).equals("null") ){
			req.setAttribute("minorView", "Minor: "+studController.getMinorForEmail(email));
		}
		else{
			req.setAttribute("minorView","");
		}

		if(!controller.getSlideForEmail(email).getHonors().isEmpty()){
			req.setAttribute("honors", "Honors:"+controller.getSlideForEmail(email).getHonors());
		}
		else{
			req.setAttribute("honors","");
		}
		if(!controller.getSlideForEmail(email).getSports().isEmpty()){
			req.setAttribute("sports", "Sports:"+controller.getSlideForEmail(email).getSports());
		}
		else{
			req.setAttribute("sports","");
		}
		if(!controller.getSlideForEmail(email).getClubs().isEmpty()){
			req.setAttribute("clubs", "Clubs:"+controller.getSlideForEmail(email).getClubs());

			System.out.println("Clubs set to: "+ req.getAttribute("clubs"));
		}
		else{
			req.setAttribute("clubs","");
		}
		if(controller.getSlideForEmail(email).getShowGPA() && studController.getGPAForEmail(email) != 0.0){
			req.setAttribute("gpa", "GPA:"+studController.getGPAForEmail(email));
			System.out.println("GPA set to: "+ req.getAttribute("gpa"));
		}
		else{
			req.setAttribute("gpa","");
		}
		if(!controller.getSlideForEmail(email).getQuote().isEmpty()){
			req.setAttribute("quote", controller.getSlideForEmail(email).getQuote());
		}
		else{
			req.setAttribute("quote","");
		}
		
		// SETTING NAME
		Account acctModel = new Account();
		AccountController acctController = new AccountController(acctModel);
		req.setAttribute("fn", acctController.getFirstnameForEmail(email));
		
		
		req.getRequestDispatcher("/_view/home.jsp").forward(req, resp);
		
	}

}
