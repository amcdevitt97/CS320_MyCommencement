package model.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.*;

public class SlideTest {

	private Slide slide1;
	private int slideId;
	private boolean showGPA;

	private boolean quote;
	private Photo photo;
	private Video video;
	private Audio audio;
	private boolean major;
	private boolean minor;						
	private boolean honors;
	private boolean sports;
	private boolean clubs;
	private boolean slideFN;
	private boolean slideLN;
	
	
	@Before
	public void setUp() {

		/*
		
		
		showGPA = true;
		quote = true;
		major = true;
		minor = true;
		honors = true;
		sports = true;
		clubs = true;
		slideFN = true;
		slideLN = true;
		photo = new Photo();
		audio = new Audio();
		video = new Video();
		photo.setLength(50);
		photo.setWidth(50);								//Testing Email
		/*audio.setHours(0);
		audio.setMinutes(5);
		audio.setSeconds(15);
		video.setLength(50);
		video.setWidth(50);
		video.setHours(0);
		video.setMinutes(5);
		video.setSeconds(15);
		*/
		boolean hasPhoto = true;
		boolean hasAudio = true;
		boolean hasVideo = true;
		int slideId = 7;
		String email = "email";
		boolean approved = true;
		slide1 = new Slide(slideId, showGPA, quote, major, minor, honors, sports, clubs, slideFN, slideLN, hasPhoto, hasAudio, hasVideo, email, approved);
		
	}
		/*
		
=======
		slideId=1;
>>>>>>> branch 'master' of https://github.com/amcdevitt97/CS320_MyCommencement.git
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
<<<<<<< HEAD
		slideFN = "Jules";
		slideLN = "Gleason";
		photo = new Photo();
		audio = new Audio();
		video = new Video();
		photo.setLength(50);
		photo.setWidth(50);								//if correct
		audio.setHours(0);
		audio.setMinutes(5);
		audio.setSeconds(15);
		video.setLength(50);
		video.setWidth(50);
		video.setHours(0);
		video.setMinutes(5);
		video.setSeconds(15);
		//slide = new Slide(showGPA, quote, major, minor, honors,sports, clubs, slideFN, slideLN, photo, audio, video);
		
		showGPA = true;
		quote = true;
		major = true;
		minor = true;
		honors = true;
		sports = true;
		clubs = true;
		slideFN = true;
		slideLN = true;
		photo = new Photo();
		audio = new Audio();
		video = new Video();
		photo.setLength(50);
		photo.setWidth(50);								//Check String for curse word
		/*audio.setHours(0);
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
		slide1 = new Slide(slideId, showGPA, quote, major, minor, honors, sports, clubs, slideFN, slideLN, hasPhoto, hasAudio, hasVideo, email, approved);
		/*
		showGPA = true;
		quote = "I love my school";
		major = "Computer Science";
		minor = "Math";
		honors = "YESSSS";
		sports = "Baseball";
		clubs = "Paintball";
		slideFN = "Jules";
		slideLN = "Gleason";
		photo = new Photo();
		audio = new Audio();
		video = new Video();
		photo.setLength(50);
		photo.setWidth(500);								//Check Photo object
		audio.setHours(0);
		audio.setMinutes(5);
		audio.setSeconds(15);
		video.setLength(50);
		video.setWidth(50);
		video.setHours(0);
		video.setMinutes(5);
		video.setSeconds(15);
		//slide2 = new Slide(true, quote, major, minor, honors,sports, clubs, slideFN, slideLN, photo, audio, video);
		
		showGPA = true;
		quote = "I love my school";
		major = "Computer Science";
		minor = "Math";
		honors = "YESSSS";
		sports = "Baseball";
		clubs = "Paintball";
		slideFN = "Jules";
		slideLN = "Gleason";
		photo = new Photo();
		audio = new Audio();
		video = new Video();
		photo.setLength(50);
		photo.setWidth(50);								//Check audio object
		audio.setHours(1);
		audio.setMinutes(5);
		audio.setSeconds(15);
		video.setLength(50);
		video.setWidth(50);
		video.setHours(0);
		video.setMinutes(5);
		video.setSeconds(15);
		//slide3 = new Slide(true, quote, major, minor, honors,sports, clubs, slideFN, slideLN, photo, audio, video);
		
		showGPA = true;
		quote = "I love my school";
		major = "Computer Science";
		minor = "Math";
		honors = "YESSSS";
		sports = "Baseball";
		clubs = "Paintball";
		slideFN = "Jules";
		slideLN = "Gleason";
		photo = new Photo();
		audio = new Audio();
		video = new Video();
		photo.setLength(50);
		photo.setWidth(50);								//Check video object
		audio.setHours(0);
		audio.setMinutes(5);
		audio.setSeconds(15);
		video.setLength(50);
		video.setWidth(50);
		video.setHours(0);
		video.setMinutes(50);
		video.setSeconds(15);
		//slide4 = new Slide(true, quote, major, minor, honors,sports, clubs, slideFN, slideLN, photo, audio, video);
		
		showGPA = false;
		quote = "I love my school";
		major = "Computer Science";
		minor = "Math";
		honors = "YESSSS";
		sports = "Baseball";
		clubs = "Paintball";
		slideFN = "Jules";
		slideLN = "Gleason";
		photo = new Photo();
		audio = new Audio();
		video = new Video();
		photo.setLength(50);
		photo.setWidth(50);								//Check Gpa
		audio.setHours(0);
		audio.setMinutes(5);
		audio.setSeconds(15);
		video.setLength(50);
		video.setWidth(50);
		video.setHours(0);
		video.setMinutes(5);
		video.setSeconds(15);
		//slide5 = new Slide(showGPA, quote, major, minor, honors,sports, clubs, slideFN, slideLN,photo, audio, video);
		
=======
		slideFN = "Julie";
		slideLN = "Jones";
		slide = new Slide(slideId, showGPA, quote, showMajor, showMinor, honors, sports, clubs, slideFN, slideLN, hasPhoto, hasAudio, hasVideo, studentEmail, approved);
>>>>>>> branch 'master' of https://github.com/amcdevitt97/CS320_MyCommencement.git
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
		slide1.emailAdvisor();
	}
	

}
