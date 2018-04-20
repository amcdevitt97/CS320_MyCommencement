package model;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Slide {
	private int slideId;
	private boolean showGPA;
	private boolean quote;
	private boolean hasPhoto;
	private boolean hasVideo;
	private boolean hasAudio;
	private boolean showMajor;
	private boolean showMinor;	
	private boolean approved;
	private boolean honors;
	private boolean sports;
	private boolean clubs;
	private boolean slideFN;
	private boolean slideLN;
	private String studentEmail;
	//private ArrayList<String> stringsToCheck;
	//private Scanner scan;
	
	// yo just FYI we're gonna need a ton of new tests for this class...
	
	public Slide() {
		slideId = 0;
		showGPA = true;
		quote = true;
		showMajor = true;
		showMinor = true;
		honors = true;
		sports = true;
		clubs = true;
		slideFN = true;
		slideLN = true;
		hasPhoto = true;
		hasVideo = true;
		hasAudio = true;
		approved = true;
		studentEmail = null;
		//stringsToCheck = new ArrayList<String>();
	}
	
	public Slide(int slideId, boolean gpa, boolean quote, boolean major, boolean minor, boolean honors, boolean sports, boolean clubs, boolean slideFN, boolean slideLN, boolean hasPhoto, boolean hasAudio, boolean hasVideo, String studentEmail, boolean approved) {
		this.slideId = slideId;
		this.showGPA = gpa;
		this.quote = quote;
		this.showMajor = major;
		this.showMinor = minor;
		this.honors = honors;
		this.sports = sports;
		this.clubs = clubs;
		this.slideFN = slideFN;
		this.slideLN = slideLN;
		this.hasAudio = hasAudio;
		this.hasVideo = hasPhoto;
		this.hasPhoto = hasVideo;
	}
	
	// GETTERS AND SETTERS
	
	public void setSlideId(int id){
		this.slideId = id;
	}
	
	public int getSlideId(){
		return slideId;
	}
	
	public void setShowGPA(Boolean value){
		this.showGPA = value;
	}
	
	public boolean getShowGPA(){
		return showGPA;
	}
	
	public void setQuote(boolean quote){
		this.quote = quote;
	}
	
	public boolean getQuote(){
		return quote;
	}
	
	public void setShowMajor(Boolean value){
		this.showMajor = value;
	}
	
	public boolean getShowMajor(){
		return showMajor;
	}
	
	public void setShowMinor(Boolean value){
		this.showMinor = value;
	}
	
	public boolean getShowMinor(){
		return showMinor;
	}
	
	public void setHonors(boolean honors){
		this.honors = honors;
	}
	
	public boolean getHonors(){
		return honors;
	}
	
	public void setClubs(boolean clubs){
		this.clubs = clubs;
	}
	
	public boolean getClubs(){
		return clubs;
	}
	
	public void setSports(boolean sports){
		this.sports = sports;
	}
	
	public boolean getSports(){
		return sports;
	}
	
	public void setSlideFN(boolean slideFN){
		this.slideFN = slideFN;
	}
	
	public boolean getSlideFN(){
		return slideFN;
	}
	
	public void setSlideLN(boolean slideLN){
		this.slideLN = slideLN;
	}
	
	public boolean getSlideLN(){
		return slideLN;
	}
	
	public void setStudentEmail(String studentEmail){
		this.studentEmail = studentEmail;
	}
	
	public String getStudentEmail(){
		return studentEmail;
	}
	
	public void setHasAudio(boolean hasAudio){
		this.hasAudio = hasAudio;
	}
	
	public boolean getHasAudio(){
		return hasAudio;
	}
	
	public void setHasPhoto(boolean hasPhoto){
		this.hasPhoto = hasPhoto;
	}
	
	public boolean getHasPhoto(){
		return hasPhoto;
	}
	
	public void setHasVideo(boolean hasVideo){
		this.hasVideo = hasVideo;
	}
	
	public boolean getHasVideo(){
		return hasVideo;
	}
	
	public void setApproved(boolean approved){
		this.approved = approved;
	}
	
	public boolean getApproved(){
		return approved;
	}
	
	// After further inspection, they belong in a controller - ANM
	
	
	/*
	public void updateSlide() {
		blackListCheck();
	}
	
	stringsToCheck = new ArrayList<String>();
	stringsToCheck.add(quote);
	stringsToCheck.add(honors);
	stringsToCheck.add(sports);
	stringsToCheck.add(clubs);
	stringsToCheck.add(slideFN);
	stringsToCheck.add(slideLN);
	
	public boolean blackListCheck() {
		boolean end = true;
		
		try {
			scan = new Scanner(new File("BadWords"));
			while(scan.hasNext()) {
				String line = scan.nextLine().toLowerCase().toString();
				for (String c: stringsToCheck) {
					if (line.contains(c)) {
						end = false;
						
					}
					
				}
			}
			
			
		}catch(IOException e) {
			System.out.print("Cannot search to file ");
		}
		if ( showGPA == false) {
			end = false;
		}
		*/
	
		/*audio.setMediaObject(audio);
		Audio a = new Audio();
		if (a.isUploadable(a.getHours(), a.getMinutes(), a.getSeconds()) == false) {
			end = false;
		}
		photo.setMediaObject(photo);
		Photo p = new Photo();
		if(p.isUploadable(p.getLength(), p.getWidth())== false) {
			end = false;
		}
		video.setMediaObject(video);
		Video v = new Video();
		if (v.isUploadable(v.getLength(), v.getWidth(), v.getHours(), v.getMinutes(), v.getSeconds()) == false) {
			end = false;
		}
		
		
		return end;
		
		
	}
	*/
	public void emailAdvisor() {
		// Recipient's email ID needs to be mentioned.
		final String username = "testchris437@gmail.com";
		final String password = "DonHake123";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(username));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}