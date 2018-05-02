package controller;

import database.IDatabase;
import database.DatabaseProvider;
import database.DerbyDatabase;
import model.Review;

/**
 * Controller for the Account Class.
 */

public class ReviewController {
	private Review model = null;
	private IDatabase database = null;
	
	public ReviewController(Review model) {
		// creating DB instance here
		this.model = model;
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();		
	}
	
	public void addReview(boolean slideFN, boolean slideLN, boolean hasPhoto, boolean hasAudio, boolean hasVideo, boolean quote, boolean honors, boolean showGPA, boolean showMajor, boolean showMinor, String studentEmail, String explination, boolean sports, boolean clubs){
		database.addReview(slideFN, slideLN, hasPhoto, hasAudio, hasVideo, quote, honors, showGPA, showMajor, showMinor, studentEmail, explination, sports, clubs);
		System.out.println(database.showAllSlides());
	}
	
	public String getMajorForEmail(String email){
		String students = database.getMajorForEmail(email);
		return students;
	}
	
	public String getMinorForEmail(String email){
		String students = database.getMinorForEmail(email);
		return students;
	}
	
	public Review getSlideForEmail(String email){
		Review review = database.getReviewForEmail(email);
		return review;
	}

}
