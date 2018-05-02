package controller;

import database.IDatabase;

import java.sql.Blob;
import java.util.List;

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
	
	public void addSlide(String slideFN, String slideLN, boolean hasPhoto, boolean hasAudio, boolean hasVideo, String quote, String clubs, String honors, String sports, boolean showGPA, boolean showMajor, boolean showMinor, boolean slideApproved, String studentEmail){
		database.addSlide(slideFN, slideLN, hasPhoto, hasAudio, hasVideo, quote, clubs, honors, sports, showGPA, showMajor, showMinor, slideApproved, studentEmail);

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
	
	public Slide getSlideForEmail(String email){
		Slide slide = database.getSlideForEmail(email);
		return slide;
	}

	public List<Slide> getAllSlides(){
		List<Slide> slides = database.showAllSlides();
		return slides;
	}
}
