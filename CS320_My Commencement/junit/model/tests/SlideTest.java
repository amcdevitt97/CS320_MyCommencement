package model.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.*;

public class SlideTest {

	private Slide slide;
	private int slideId;
	private boolean showGPA;
	private String quote;
	private boolean hasPhoto;
	private boolean hasVideo;
	private boolean hasAudio;
	private boolean showMajor;
	private boolean showMinor;	
	private boolean approved;
	private String honors;
	private String sports;
	private String clubs;
	private String slideFN;
	private String slideLN;
	private String studentEmail;
	
	
	@Before
	public void setUp() {
		slideId=1;
		showGPA = true;
		quote = "I love my school";
		hasPhoto = true;
		hasVideo = true;
		hasAudio= true;
		showMajor = true;
		showMinor = true;
		approved = false;
		honors = "Validvictorian";
		sports = "Baseball";
		clubs = "Paintball";
		slideFN = "Julie";
		slideLN = "Jones";
		slide = new Slide(slideId, showGPA, quote, showMajor, showMinor, honors, sports, clubs, slideFN, slideLN, hasPhoto, hasAudio, hasVideo, studentEmail, approved);
	}
	

	// GETTERS AND SETTERS
	
	@Test
	public void testSetSlideID(){
		slide.setSlideId(7);
		assertEquals (7, slide.getSlideId());
	}
	
	@Test
	public void testSetShowGPA(){
		slide.setShowGPA(false);
		assertEquals (false, slide.getShowGPA());
	}
	
	@Test
	public void testSetQuote(){
		slide.setQuote("my quote");
		assertEquals ("my quote", slide.getQuote());
	}
	
	@Test
	public void testSetHasPhoto(){
		slide.setHasPhoto(false);
		assertEquals (false, slide.getHasPhoto());
	}
	
	@Test
	public void testSetHasAudio(){
		slide.setHasAudio(false);
		assertEquals (false, slide.getHasAudio());
	}
	
	@Test
	public void testSetHasVideo(){
		slide.setHasVideo(false);
		assertEquals (false, slide.getHasVideo());
	}

	@Test
	public void testSetShowMajor(){
		slide.setShowMajor(false);
		assertEquals (false, slide.getShowMajor());
	}
	
	@Test
	public void testSetShowMinor(){
		slide.setShowMinor(false);
		assertEquals (false, slide.getShowMinor());
	}

	@Test
	public void testSetApproved(){
		slide.setApproved(true);
		assertEquals (true, slide.getApproved());
	}
	
	@Test
	public void testSetHonors(){
		slide.setHonors("meme queen");
		assertEquals ("meme queen", slide.getHonors());
	}
	
	@Test
	public void testSetSports(){
		slide.setSports("underwater basketweaving");
		assertEquals ("underwater basketweaving", slide.getSports());
	}
	
	@Test
	public void testSetClubs(){
		slide.setClubs("Anime club");
		assertEquals ("Anime club", slide.getClubs());
	}
	
	@Test
	public void testSetSlideFN(){
		slide.setSlideFN("Doug");
		assertEquals ("Doug", slide.getSlideFN());
	}
	@Test
	public void testSetSlideLN(){
		slide.setSlideLN("Dimmadome");
		assertEquals ("Dimmadome", slide.getSlideLN());
	}
	@Test
	public void testSetEmail(){
		slide.setStudentEmail("doug@gmail.com");
		assertEquals ("doug@gmail.com", slide.getStudentEmail());
	}
	
	// TODO: REMOVE AND PLACE IN SLIDECONTROLLER
	// TESTS THAT BELONG IN THE CONTROLLER
	
	/*
	@Test
	public void blackListSlide() {
		slide.updateSlide();
		assertEquals(true, slide.blackListCheck());
		
	}
	@Test
	public void blackListSlide1() {
		slide1.updateSlide();
		assertEquals(false, slide1.blackListCheck());
		
	}
	
	@Test
	public void blackListSlide2() {
		slide2.updateSlide();
		assertEquals(false, slide2.blackListCheck());
		
	}
	
	@Test
	public void blackListSlide3() {
		slide3.updateSlide();
		assertEquals(false, slide3.blackListCheck());
		
	}
	@Test
	public void blackListSlide4() {
		slide4.updateSlide();
		assertEquals(false, slide4.blackListCheck());
		
	}
	@Test
	public void blackListSlide5() {
		slide5.updateSlide();
		assertEquals(false, slide5.blackListCheck());
		
	}
	@Test
	public void testEmail() {
		slide.emailAdvisor();
	}
	*/

}
