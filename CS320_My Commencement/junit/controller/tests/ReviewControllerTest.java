package controller.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.ReviewController;
import model.Review;
import model.Student;

public class ReviewControllerTest {

	private ReviewController controller;
	private Review model;
	@Before
	public void setUp() {
		model = new Review();
		model.setAudio(true);
		model.setClubs(true);
		model.setEmail("email");
		model.setExplination("x");
		model.setFN(true);
		model.setGpa(true);
		model.setHonors(false);
		model.setLN(true);
		model.setMajor(true);
		model.setMinor(false);
		model.setPhoto(true);
		model.setQuote(false);
		model.setReviewID(0);
		model.setSports(true);
		model.setVideo(false);
		controller = new ReviewController(model);
		
	}
	
	
	@Test
	public void addReviewTest() {
		controller.addReview(model.getFN(), model.getLN(), model.getPhoto(), model.getAudio(), model.getVideo(), model.getQuote(), model.getHonors(), model.getGpa(), model.getMajor(), model.getMinor(), model.getEmail(), model.getExplination(), model.getSports(), model.getClubs());
	}
	@Test
	public void majorTest() {
		String email = model.getEmail();
		boolean major = controller.getMajorFromEmailReview(email);
		assertEquals(model.getMajor(), major);
	}
	@Test
	public void minorTest() {
		String email = model.getEmail();
		boolean minor = controller.getMajorFromEmailReview(email);
		assertEquals(model.getMinor(), minor);
	}
	@Test
	public void getSlideReview() {
		String email = model.getEmail();
		Review review = controller.getSlideForEmail(email);
		assertEquals(review.getFN(), model.getFN());
		assertEquals(review.getLN(), model.getLN());
		assertEquals(review.getMajor(), model.getMajor());
		assertEquals(review.getMinor(), model.getMinor());
	}

}
