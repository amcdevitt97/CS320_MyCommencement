package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Account;
import model.Student;
import model.Advisor;
import model.Slide;

public interface IDatabase {
	//	CREATION
	public boolean createTables();
	public boolean dropTables();
	public Connection connect() throws SQLException;
	public void loadInitialData();
	
	// LOGIN
	public Account returnAccountForEmail(String email);
	public Boolean queryForValidLogin(String email, String password);
	public Boolean isStudent (String email);
	public Student getStudentForEmail(String email);
	
	// UX DATA
	public String getFirstNameForEmail(String email);
	public String getLastNameForEmail(String email);
	public List<Student> getStudentsForAdvisorEmail(String email);
	
	// SLIDE DATA
	
	public void addSlide(String slideFN, String slideLN, boolean hasPhoto,boolean hasAudio, boolean hasVideo, String quote, String clubs, String honors, boolean showGPA, boolean showMajor, boolean showMinor, boolean slideApproved, String studentEmail);
	public Double getGPAForEmail(String email);
	public String getMajorForEmail(String email);
	public String getMinorForEmail(String email);
	public Slide getSlideForEmail(String email);
	
	// THESE NEED MADE: 
	//public void addReview(boolean showGPA, boolean hasQuote, boolean hasPhoto, boolean hasAudio, boolean hasVideo, boolean showMajor, boolean showMinor, boolean showHonors, boolean showSports, boolean showClubs, boolean showFN, boolean showLN, String explination, String email);
	//public void getReviewSlide(String email);
	
	//TESTING 
	public String showAllAccounts();
	public String showAllStudents();
	public List<Slide> showAllSlides();
	
}
