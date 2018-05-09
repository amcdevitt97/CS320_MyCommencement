package servlet;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

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

public class StudentSelectServlet extends HttpServlet {
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
		System.out.println("\nStudentSelectServlet: doGet");
		req.getRequestDispatcher("/_view/advisor.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("\nStudentSelectServlet: doPost");
		

		// DISPLAYING SLIDE INFO
		String[] values= req.getParameterValues("studentSelected");
		String email = values[0];
		System.out.println("email is:"+email);
		req.getSession().setAttribute("studentSelected", email);
		req.setAttribute("studentSelected", email);
		Student student  = new Student(0,"", "", "", "", 0.0, "", "", "");
		StudentController studController = new StudentController(student);
		student = studController.getStudentForEmail(email);
		Slide model = new Slide();
		SlideController controller = new SlideController(model);
		Slide slide = controller.getSlideForEmail(email);
		
		if(slide==null){
			req.setAttribute("slideFN", "No slide made!");
			req.setAttribute("slideLN","");
			req.setAttribute("majorView","");
			req.setAttribute("minorView","");
			req.setAttribute("honors","");
			req.setAttribute("sports","");
			req.setAttribute("clubs","");
			req.setAttribute("gpa","");
			req.setAttribute("quote","");
		}
		else{
			req.setAttribute("slideFN", slide.getSlideFN());
			req.setAttribute("slideLN", slide.getSlideLN());
			
			if(slide.getShowMajor()){
				req.setAttribute("majorView", "Major: "+studController.getMajorForEmail(email));
				System.out.println("Major set to: "+ req.getAttribute("majorView"));
			}
			else{
				req.setAttribute("majorView","");
			}
			if(slide.getShowMinor() && !studController.getMinorForEmail(email).isEmpty() && !studController.getMinorForEmail(email).equals("null") ){
				req.setAttribute("minorView", "Minor: "+studController.getMinorForEmail(email));
			}
			else{
				req.setAttribute("minorView","");
			}

			if(!slide.getHonors().isEmpty()){
				req.setAttribute("honors", "Honors:"+slide.getHonors());
			}
			else{
				req.setAttribute("honors","");
			}
			if(!slide.getSports().isEmpty()){
				req.setAttribute("sports", "Sports:"+slide.getSports());
			}
			else{
				req.setAttribute("sports","");
			}
			if(!slide.getClubs().isEmpty()){
				req.setAttribute("clubs", "Clubs:"+slide.getClubs());

				System.out.println("Clubs set to: "+ req.getAttribute("clubs"));
			}
			else{
				req.setAttribute("clubs","");
			}
			if(slide.getShowGPA() && studController.getGPAForEmail(email) != 0.0){
				req.setAttribute("gpa", "GPA:"+studController.getGPAForEmail(email));
				System.out.println("GPA set to: "+ req.getAttribute("gpa"));
			}
			else{
				req.setAttribute("gpa","");
			}
			if(!slide.getQuote().isEmpty()){
				req.setAttribute("quote", slide.getQuote());
			}
			else{
				req.setAttribute("quote","");
			}
		}
		
		
		
		// SETTING NAME
		Account acctModel = new Account();
		AccountController acctController = new AccountController(acctModel);
		String advisor = (String) req.getSession().getAttribute("user");
		req.setAttribute("fn", acctController.getFirstnameForEmail(advisor));
		
		// SETTING STUDENTS
		List<Student> students = null;
		students = acctController.getStudentsForAdvisor(advisor);
		req.setAttribute("students",  students);
		
		
		req.getRequestDispatcher("/_view/advisor.jsp").forward(req, resp);
		
	}

}
