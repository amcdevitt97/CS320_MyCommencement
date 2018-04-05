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
	private double GPA;
	private String quote;
	private Photo photo;
	private Video video;
	private String major;
	private String minor;						 
	private String honors;
	private String sports;
	private String clubs;
	private String slideFN;
	private String slideLN;
	private String advisor;
	private Review review;
	private Student student;
	private MediaObject mediaObject;
	private ArrayList<String> stringsToCheck;
	private Account account;
	private Audio audio;
	private Scanner scan;
	
	
	public Slide() {
		showGPA = true;
		GPA=0;
		quote = null;
		photo = null;
		video = null;
		audio = null;
		major = null;
		minor = null;
		honors = null;
		sports = null;
		clubs = null;
		slideFN = null;
		slideLN = null;
		review = new Review();
		account = new Account();
		//student = new Student(account.getEmail(), account.getPassword(),account.getFirstname(),account.getLastname(), 0, major, minor, account.);
		mediaObject = new MediaObject();
		stringsToCheck = new ArrayList<String>();
		
	}
	public Slide(boolean gpa, String quote, String major, String minor, String honors, String sports, String clubs, String slideFN, String slideLN, Photo p, Audio a, Video v) {
		this.showGPA = gpa;
		this.quote = quote;
		this.major = major;
		this.minor = minor;
		this.honors = honors;
		this.sports = sports;
		this.clubs = clubs;
		this.slideFN = slideFN;
		this.slideLN = slideLN;
		this.audio = a;
		this.video = v;
		this.photo = p;
		mediaObject = new MediaObject();
		stringsToCheck = new ArrayList<String>();
		stringsToCheck.add(quote);
		stringsToCheck.add(major);
		stringsToCheck.add(minor);
		stringsToCheck.add(honors);
		stringsToCheck.add(sports);
		stringsToCheck.add(clubs);
		stringsToCheck.add(slideFN);
		stringsToCheck.add(slideLN);
		
		
	}
	
	public void updateSlide() {
		blackListCheck();
	}
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
		mediaObject.setMediaObject(audio);
		Audio a = (Audio)mediaObject.getMediaObject();
		if (a.isUploadable(a.getHours(), a.getMinutes(), a.getSeconds()) == false) {
			end = false;
		}
		mediaObject.setMediaObject(photo);
		Photo p = (Photo)mediaObject.getMediaObject();
		if(p.isUploadable(p.getLength(), p.getWidth())== false) {
			end = false;
		}
		mediaObject.setMediaObject(video);
		Video v = (Video)mediaObject.getMediaObject();
		if (v.isUploadable(v.getLength(), v.getWidth(), v.getHours(), v.getMinutes(), v.getSeconds()) == false) {
			end = false;
		}
		
		
		return end;
		
		
	}
	
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