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
	private Photo photo;
	private Video video;
	private Audio audio;
	private boolean major;
	private boolean minor;						
	private String honors;
	private String sports;
	private String clubs;
	private String slideFN;
	private String slideLN;
	
	
	@Before
	public void setUp() {

		
		
		
		showGPA = true;
		quote = null;
		major = true;
		minor = true;
		honors = null;
		sports = null;
		clubs = null;
		slideFN = null;
		slideLN = null;
		photo = new Photo();
		audio = new Audio();
		video = new Video();
		photo.setLength(50);
		photo.setWidth(50);								//Testing Email
		audio.setHours(0);
		audio.setMinutes(5);
		audio.setSeconds(15);
		video.setLength(50);
		video.setWidth(50);
		video.setHours(0);
		video.setMinutes(5);
		video.setSeconds(15);
		
		boolean hasPhoto = true;
		boolean hasAudio = true;
		boolean hasVideo = true;
		int slideId = 7;
		String email = "email";
		boolean approved = true;
		slide = new Slide(slideId, showGPA, quote, major, minor, honors, sports, clubs, slideFN, slideLN, hasPhoto, hasAudio, hasVideo, email, approved);
		

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
		//slide.updateSlide();
		//assertEquals(true, slide.blackListCheck());
		
	}
	@Test
	public void blackListSlide1() {
		//slide1.updateSlide();
		//assertEquals(false, slide1.blackListCheck());
		
	}
	
	@Test
	public void blackListSlide2() {
		//slide2.updateSlide();
		//assertEquals(false, slide2.blackListCheck());
		
	}
	
	@Test
	public void blackListSlide3() {
		//slide3.updateSlide();
		//assertEquals(false, slide3.blackListCheck());
		
	}
	@Test
	public void blackListSlide4() {
		//slide4.updateSlide();
		//assertEquals(false, slide4.blackListCheck());
		
	}
	@Test
	public void blackListSlide5() {
		//slide5.updateSlide();
		//assertEquals(false, slide5.blackListCheck());
		
	}
	*/
	
	@Test
	public void testEmail() {
		slide.emailAdvisor();
	}
	

}
