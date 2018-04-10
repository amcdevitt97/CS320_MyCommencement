package model;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//File Name SendEmail.java
import java.util.*;
//import javax.mail.*;
//import javax.mail.internet.*;



import javax.activation.*;

public class Slide {
	private boolean showGPA;
	private String quote;
	private Photo photo;
	private Video video;
	private Audio audio;
	private boolean showMajor;
	private boolean showMinor;						 
	private String honors;
	private String sports;
	private String clubs;
	private String slideFN;
	private String slideLN;
	private String studentEmail;
	//private ArrayList<String> stringsToCheck;
	
	//private Scanner scan;
	
	
	public Slide() {
		showGPA = true;
		quote = null;
		showMajor = true;
		showMinor = true;
		honors = null;
		sports = null;
		clubs = null;
		slideFN = null;
		slideLN = null;
		photo = null;
		video = null;
		audio = null;
		studentEmail = null;
		//stringsToCheck = new ArrayList<String>();
		
	}
	public Slide(boolean gpa, String quote, boolean showMajor, boolean showMinor, String honors, String sports, String clubs, String slideFN, String slideLN, Photo p, Audio a, Video v, String studentEmail) {
		this.showGPA = gpa;
		this.quote = quote;
		this.showMajor = showMajor;
		this.showMinor = showMinor;
		this.honors = honors;
		this.sports = sports;
		this.clubs = clubs;
		this.slideFN = slideFN;
		this.slideLN = slideLN;
		this.audio = a;
		this.video = v;
		this.photo = p;
	}
	
	// GETTERS AND SETTERS
	
	public void setShowGPA(Boolean value){
		this.showGPA = value;
	}
	
	public boolean getShowGPA(){
		return showGPA;
	}
	
	public void setQuote(String quote){
		this.quote = quote;
	}
	
	public String getQuote(){
		return quote;
	}
	
	public void setShowMajorA(Boolean value){
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
	
	public void setHonors(String honors){
		this.honors = honors;
	}
	
	public String getHonors(){
		return honors;
	}
	
	public void setClubs(String clubs){
		this.clubs = clubs;
	}
	
	public String getClubs(){
		return clubs;
	}
	
	public void setSports(String sports){
		this.sports = sports;
	}
	
	public String getSports(){
		return sports;
	}
	
	public void setSlideFN(String slideFN){
		this.slideFN = slideFN;
	}
	
	public String getSlideFN(){
		return slideFN;
	}
	
	public void setSlideLN(String slideLN){
		this.slideLN = slideLN;
	}
	
	public String getSlideLN(){
		return slideLN;
	}
	
	public void setStudentEmail(String studentEmail){
		this.studentEmail = studentEmail;
	}
	
	public String getStudentEmail(){
		return studentEmail;
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
	/*public void emailAdvisor() {
		// Recipient's email ID needs to be mentioned.
	      String to = "cdeshong1@ycp.edu";

	      // Sender's email ID needs to be mentioned
	      String from = "cdeshong1@ycp.edu";

	      // Assuming you are sending email from localhost
	      String host = "localhost";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("This is the Subject Line!");

	         // Now set the actual message
	         message.setText("Testing");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}*/
	
}