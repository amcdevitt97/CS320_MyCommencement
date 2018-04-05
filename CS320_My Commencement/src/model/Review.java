package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Review {
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
	private String email;
	private ArrayList<Boolean> list;
	private boolean approved;
	
	public Review(){
		gpaApproved = false;
		quoteApproved = false;
		photoApproved = false;
		audioApproved = false;
		videoApproved = false;
		majorApproved = false;
		minorApproved = false;
		honorsApproved = false;
		sportsApproved = false;
		clubsApproved = false;
		fnApproved = false;
		lnApproved = false;
		explination = null;
		email = null;
		list=new ArrayList<Boolean>();
		list.add(gpaApproved);
		list.add(quoteApproved);
		list.add(photoApproved);
		list.add(audioApproved);
		list.add(videoApproved);
		list.add(majorApproved);
		list.add(minorApproved);
		list.add(honorsApproved);
		list.add(sportsApproved);
		list.add(clubsApproved);
		list.add(fnApproved);
		list.add(lnApproved);
		approved = false;
		
	}
	public Review(boolean gpa, boolean quote, boolean photo, boolean audio, boolean video, boolean major, boolean minor, boolean honors, boolean sports, boolean clubs, boolean first, boolean last, String explination, String email){
		this.gpaApproved = gpa;
		this.quoteApproved = quote;
		this.photoApproved = photo;
		this.audioApproved = audio;
		this.videoApproved = video;
		this.majorApproved = major;
		this.minorApproved = minor;
		this.honorsApproved = honors;
		this.sportsApproved = sports;
		this.clubsApproved = clubs;
		this.fnApproved = first;
		this.lnApproved = last;
		this.explination = explination;
		this.email = email;
		list=new ArrayList<Boolean>();
		list.add(gpaApproved);
		list.add(quoteApproved);
		list.add(photoApproved);
		list.add(audioApproved);
		list.add(videoApproved);
		list.add(majorApproved);
		list.add(minorApproved);
		list.add(honorsApproved);
		list.add(sportsApproved);
		list.add(clubsApproved);
		list.add(fnApproved);
		list.add(lnApproved);
		approved = false;
	}
	
	public void finalizeReview() {
		
		for(Boolean c: list) {
			if( c == false) {
				approved = false;
				break;
			}
			else {
				approved = true;
			}
		}
	}
	
	public boolean getApproved() {
		return this.approved;
	}
	public void setGpa(boolean gpa) {
		this.gpaApproved = gpa;
	}
	public boolean getGpa() {
		return this.gpaApproved;
	}
	public void setQuote(boolean quote) {
		this.quoteApproved = quote;
	}
	public boolean getQuote() {
		return this.quoteApproved;
	}
	public void setPhoto(boolean photo) {
		this.photoApproved = photo;
	}
	public boolean getPhoto() {
		return this.photoApproved;
	}
	public void setAudio(boolean audio) {
		this.audioApproved = audio;
	}
	public boolean getAudio() {
		return this.audioApproved;
	}
	public void setVideo(boolean video) {
		this.videoApproved = video;
	}
	public boolean getVideo() {
		return this.videoApproved;
	}
	public void setMajor(boolean major) {
		this.majorApproved = major;
	}
	public boolean getMajor() {
		return this.majorApproved;
	}
	public void setMinor(boolean minor) {
		this.majorApproved = minor;
	}
	public boolean getMinor() {
		return this.majorApproved;
	}
	public void setHonors(boolean honors) {
		this.honorsApproved = honors;
	}
	public boolean getHonors() {
		return this.honorsApproved;
	}
	public void setClubs(boolean clubs) {
		this.clubsApproved = clubs;
	}
	public boolean getClubs() {
		return this.clubsApproved;
	}
	public void setSports(boolean sports) {
		this.sportsApproved = sports;
	}
	public boolean getSports() {
		return this.sportsApproved;
	}
	public void setFN(boolean first) {
		this.fnApproved = first;
	}
	public boolean getFN() {
		return this.fnApproved;
	}
	public void setLN(boolean last) {
		this.lnApproved = last;
	}
	public boolean getLN() {
		return this.lnApproved;
	}
	public void setExplination(String s) {
		this.explination = s;
	}
	public String getExplination() {
		return this.explination;
	}
	public void setEmail(String s) {
		this.email = s;
	}
	public String getEmail() {
		return this.email;
	}
	
}
