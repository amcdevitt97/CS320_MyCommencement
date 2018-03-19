package model;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//File Name SendEmail.java

import java.util.*;
import javax.activation.*;

public class Slide {
	private boolean showGPA;
	private double GPA;
	private String quote;
	private Photo photo;
	private Video video;
	private String major;
	private String minor;						//Testing psuh 
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
	
	public Slide() {
		showGPA = true;
		GPA=0;
		quote = null;
		photo = null;
		video = null;
		major = null;
		minor = null;
		honors = null;
		sports = null;
		clubs = null;
		slideFN = null;
		slideLN = null;
		review = new Review();
		student = new Student(slideFN, slideLN, clubs, clubs, GPA, major, minor, advisor, 0);
		mediaObject = new MediaObject();
		stringsToCheck = new ArrayList<String>();
		account = new Account();
	}
	
	public void updateSlide() {
		blackListCheck();
	}
	public boolean blackListCheck() {
		stringsToCheck.add(quote);
		stringsToCheck.add(major);
		stringsToCheck.add(minor);
		stringsToCheck.add(honors);
		stringsToCheck.add(sports);
		stringsToCheck.add(clubs);
		stringsToCheck.add(slideFN);
		stringsToCheck.add(slideLN);
		try {
			Scanner scan = new Scanner(new File("BadWords.txt"));
			while(scan.hasNext()) {
				String line = scan.nextLine().toLowerCase().toString();
				for (String c: stringsToCheck) {
					if (line.contains(c)) {
						return false;
						break;
					}
					
				}
			}
			
			
		}catch(IOException e) {
			System.out.print("Cannot search to file ");
		}
		
		
	}
	
	public void emailAdvisor() {
		
	}
	
}