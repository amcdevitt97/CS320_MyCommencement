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
	public Review(boolean gpa, boolean quote, boolean photo, boolean audio, boolean video, boolean major, boolean minor, boolean honors, boolean sports, boolean clubs, boolean first, boolean last, String explination){
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
	
	
}
