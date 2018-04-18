package controller;

import javax.servlet.http.HttpServletRequest;
  
import database.DatabaseProvider;
import database.DerbyDatabase;
import database.IDatabase;
import model.Account;

public class LoginController {
	private Account model = null;
	private IDatabase database = null;
	
	public LoginController(Account model) {
		this.model = model;
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();
	}

	public Boolean loginUser(String email, String password){
		Boolean loginCorrect = this.database.queryForValidLogin(email, password);
		return loginCorrect;
	}
	
	public Boolean isStudent(String email){
		Boolean isStudentValue = this.database.isStudent(email);
		return isStudentValue;
	}
	
	/*public void checkReviewSlide(boolean showGPA, boolean hasPhoto, boolean hasAudio, boolean hasQuote, boolean hasVideo, boolean showMajor, boolean showMinor, boolean showHonors, boolean showSports, boolean showClubs, boolean showFN, boolean showLN, String explination, String email) {
		this.database.addReview(showGPA, hasQuote, hasPhoto, hasAudio, hasVideo, showMajor, showMinor, showHonors, showSports, showClubs, showFN, showLN, explination, email);
		this.database.getReviewSlide(email);
	}*/
	
}

