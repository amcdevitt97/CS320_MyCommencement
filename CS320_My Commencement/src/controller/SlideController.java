package controller;

import database.IDatabase;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseProvider;
import database.DerbyDatabase;
import model.Review;
import model.Slide;
import controller.ReviewController;
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
	
	public Slide getSlideForEmail(String email){
		Slide slide = database.getSlideForEmail(email);
		return slide;
	}

	public List<Slide> getAllSlides(){
		List<Slide> slides = database.showAllSlides();
		return slides;
	}
	
	public List<Slide> getAllValidSlides(){
		List<Slide> slides = database.showAllSlides();
		List<Slide> validSlides = new ArrayList<Slide>();
		for(int i=0;i<slides.size();i++){
			if(slides.get(i)!=null && slides.get(i).getStudentEmail()!=null){
				validSlides.add(slides.get(i));
				System.out.println(slides.get(i).getSlideFN());
			}
		}
		return validSlides;
	}
	public List<Slide> getAllApprovedSlides(){
		List<Slide> slides = database.showAllSlides();
		List<Slide> approvedSlides = new ArrayList<Slide>();
		for(int i=0;i<slides.size();i++){
			if(slides.get(i)!=null && slides.get(i).getStudentEmail()!=null){
				String student= slides.get(i).getStudentEmail();
				System.out.println("student getting checked: "+student);
				ReviewController reviewCont = new ReviewController(null);
				Review review = reviewCont.getReviewForEmail(student);
				if(review==null){
					System.out.println("Review not found for "+student+". Skipping...");
				}
				// I apologize in advance Professor Hake...
				// - Alyssa 
				else if(review.getSports()){
					System.out.println(1);
					if(review.getQuote()){
						System.out.println(2);
						if(review.getClubs()){
							//	Was so close to showing all "approved" slides when it failed-out around here...
							System.out.println(3);
							if(review.getFN()){
								System.out.println(4);
								if(review.getGpa()){
									System.out.println(5);
									if(review.getHonors()){
										System.out.println(6);
										if(review.getLN()){
											System.out.println(7);
											if(review.getMajor()){
												System.out.println(8);
												if(review.getMinor()){
													System.out.println(9);
													if(review.getAudio()){
														System.out.println(10);
														if(review.getPhoto()){
															System.out.println(11);
															if(review.getVideo()){
																System.out.println("Slide for "+student+" is approved!");
																slides.get(i).setApproved(true);
																approvedSlides.add(slides.get(i));
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return approvedSlides;
	}
}
