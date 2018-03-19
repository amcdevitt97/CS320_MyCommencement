package edu.ycp.cs320.amcdevitt.model;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//File Name SendEmail.java

import java.util.*;
import javax.activation.*;

public class Slide {
	private boolean showGPA;
	private String quote;
	private Photo photo;
	private Video video;
	private Audio audio;
	private String major;
	private String minor;						//Testing push 
	private String honors;
	private String sports;
	private String clubs;
	private String slideFN;
	private String slideLN;
	private Review review;
	//private StudentAccount studentAccount;
	private MediaObject mediaObject;
	private ArrayList<String> stringsToCheck;
	//private Account account;
	
	
	
	public Slide() {
		showGPA = true;
		quote = null;
		major = null;
		minor = null;
		honors = null;
		sports = null;
		clubs = null;
		slideFN = null;
		slideLN = null;
		review = new Review();
		//studentAccount = new StudentAccount();
		mediaObject = new MediaObject();
		
		//account = new Account();
		audio = new Audio();
		video = new Video();
	}
	public Slide(boolean gpa, String quote,String major, String minor,String honors, String sports, String clubs, String slideFN, String slideLN, Photo photo, Audio audio, Video video) {
		this.showGPA = gpa;
		this.quote = quote;
		this.major = major;
		this.minor = minor;
		this.honors = honors;
		this.sports = sports;
		this.clubs = clubs;
		this.slideFN = slideFN;
		this.slideLN = slideLN;
		this.photo = photo;
		this.audio = audio;
		this.video = video;
		review = new Review();
		//studentAccount = new StudentAccount();
		//account = new Account();
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
		boolean blacklist = true;
		try {
			Scanner scan = new Scanner(new File("BadWords"));
			while(scan.hasNext()) {
				String line = scan.nextLine().toLowerCase().toString();
				for (String c: stringsToCheck) {
					if (line.contains(c)) {
						System.out.println("Bad words " + c);
						blacklist = false;
						
					}
					
				}
			}
			
			
		}catch(IOException e) {
			System.out.print("Cannot search to file ");
		}
		if (showGPA == false) {
			System.out.println("GPA");
			blacklist = false;
		}
		
		if(audio.isUploadable(audio.getHours(), audio.getMinutes(), audio.getSeconds()) == false) {
			System.out.println("audio");
			blacklist = false;
		}
		else if (video.isUploadable(video.getLength(), video.getWidth(), video.getHours(), video.getMinutes(), video.getSeconds()) == false) {
			System.out.println("video");
			blacklist = false;
		}
		else if (photo.isUploadable(photo.getLength(), photo.getWidth()) == false) {
			System.out.println("photo");
			blacklist = false;
		}
		
		return blacklist;
	}
	
	public void emailAdvisor() {
		
	}
	
}
