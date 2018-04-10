package model.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.*;

public class SlideTest {

	// Yeah this is gonna need some work - ANM
	
	private Slide slide;
	private Slide slide1;
	private Slide slide2;
	private Slide slide3;
	private Slide slide4;
	private Slide slide5;
	private boolean showGPA;
	private String quote;
	private Photo photo;
	private Video video;
	private Audio audio;
	private String major;
	private String minor;						
	private String honors;
	private String sports;
	private String clubs;
	private String slideFN;
	private String slideLN;
	
	
	@Before
	public void setUp() {
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
		photo.setWidth(50);								//if correct
		audio.setHours(0);
		audio.setMinutes(5);
		audio.setSeconds(15);
		video.setLength(50);
		video.setWidth(50);
		video.setHours(0);
		video.setMinutes(5);
		video.setSeconds(15);
		slide = new Slide(showGPA, quote, major, minor, honors,sports, clubs, slideFN, slideLN, photo, audio, video);
		
		showGPA = true;
		quote = "I love my school";
		major = "Computer Science";
		minor = "Math";
		honors = "YESSSS";
		sports = "doggie style";
		clubs = "Paintball";
		slideFN = "Jules";
		slideLN = "Gleason";
		photo = new Photo();
		audio = new Audio();
		video = new Video();
		photo.setLength(50);
		photo.setWidth(50);								//Check String for curse word
		audio.setHours(0);
		audio.setMinutes(5);
		audio.setSeconds(15);
		video.setLength(50);
		video.setWidth(50);
		video.setHours(0);
		video.setMinutes(5);
		video.setSeconds(15);
		slide1 = new Slide(true, quote, major, minor, honors,sports, clubs, slideFN, slideLN, photo, audio, video);
		
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
		slide2 = new Slide(true, quote, major, minor, honors,sports, clubs, slideFN, slideLN, photo, audio, video);
		
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
		slide3 = new Slide(true, quote, major, minor, honors,sports, clubs, slideFN, slideLN, photo, audio, video);
		
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
		slide4 = new Slide(true, quote, major, minor, honors,sports, clubs, slideFN, slideLN, photo, audio, video);
		
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
		slide5 = new Slide(showGPA, quote, major, minor, honors,sports, clubs, slideFN, slideLN,photo, audio, video);
		
	}
	
	
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
	

}
