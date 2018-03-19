package edu.ycp.cs320.amcdevitt.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ReviewTest {

	private boolean gpaApproved;
	private boolean quoteApproved;
	private boolean photoApproved;
	private boolean audioApproved;
	private boolean videoApproved;
	private boolean majorApproved;
	private boolean minorApproved;
	private boolean honorsApproved;
	private boolean sportsApproved;
	private boolean clubsApproved;
	private boolean fnApproved;
	private boolean lnApproved;
	private String explination;
	private Review review;
	private Review review2;
	
	@Before
	public void setUp() {
		gpaApproved = true;
		quoteApproved = true;
		photoApproved = true;
		audioApproved = true;									//testing if all approved
		videoApproved = true;
		majorApproved = true;
		minorApproved = true;
		honorsApproved = true;
		sportsApproved = true;
		clubsApproved = true;
		fnApproved = true;
		lnApproved = true;
		explination = null;
		review = new Review(gpaApproved,quoteApproved,photoApproved,audioApproved, videoApproved, majorApproved, minorApproved, honorsApproved, sportsApproved, clubsApproved,fnApproved,lnApproved,explination);
		
		gpaApproved = true;
		quoteApproved = true;
		photoApproved = true;
		audioApproved = true;
		videoApproved = true;
		majorApproved = false;
		minorApproved = true;									//Testing if disapproved
		honorsApproved = true;
		sportsApproved = true;
		clubsApproved = true;
		fnApproved = true;
		lnApproved = true;
		explination = "There is an unapproved part of slide";
		review2 = new Review(gpaApproved,quoteApproved,photoApproved,audioApproved, videoApproved, majorApproved, minorApproved, honorsApproved, sportsApproved, clubsApproved,fnApproved,lnApproved,explination);
	}
	
	@Test
	public void testReview() {
		review.finalizeReview();
		boolean a = review.getApproved();
		assertEquals(true, a);
		
	}
	@Test
	public void testReview2() {
		review2.finalizeReview();
		boolean a = review.getApproved();
		assertEquals(false, a);
		
	}

}
