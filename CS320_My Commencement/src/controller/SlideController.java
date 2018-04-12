package controller;

import database.IDatabase;
import database.DatabaseProvider;
import database.DerbyDatabase;
import model.Slide;

/**
 * Controller for the Account Class.
 */

public class SlideController {
	private Slide model = null;
	private IDatabase database = null;
	
	public SlideController(Slide model) {
		// creating DB instance here
		this.model = model;
		DatabaseProvider.setInstance(new DerbyDatabase());
		database = DatabaseProvider.getInstance();		
	}
	
	public void addSlide(String slideFN, String slideLN, boolean hasPhoto, boolean hasAudio, boolean hasVideo, String quote, String honors, boolean showGPA, boolean showMajor, boolean showMinor, boolean slideApproved, String studentEmail){
		database.addSlide(slideFN, slideLN, hasPhoto, hasAudio, hasVideo, quote, honors, showGPA, showMajor, showMinor, slideApproved, studentEmail);
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

}