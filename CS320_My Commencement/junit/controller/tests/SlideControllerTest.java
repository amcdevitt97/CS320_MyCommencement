package controller.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import controller.SlideController;
import model.Slide;

public class SlideControllerTest {
	private Slide model;
	private SlideController controller;
	
	@Before
	public void setUp() {
		model = new Slide(0, false, "", false, false, "", "", "", "", "", false, false, false, "", false);
		model.setSlideId(1);;
		model.setShowGPA(true);
		model.setQuote("My quote");
		model.setShowMajor(true);
		model.setShowMinor(true);
		model.setHonors("Class President");
		model.setClubs("Chess Club");
		model.setSports("Baseball");
		model.setSlideFN("Joe");
		model.setHasAudio(true);
		model.setHasPhoto(true);
		model.setHasVideo(true);
		model.setStudentEmail("amcdevitt@ycp.edu");
		model.setApproved(false);
		controller = new SlideController(model);
	}
	
	// ADD METHOD TESTS 
		
		
	
	

}
