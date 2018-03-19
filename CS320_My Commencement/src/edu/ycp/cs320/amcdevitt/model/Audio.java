package edu.ycp.cs320.amcdevitt.model;

public class Audio extends MediaObject {
	private int hours;
	private int min;
	private int sec;
	
	public Audio() {
		this.hours = 0;
		this.min = 0;
		this.sec = 0;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public int getHours() {
		return hours;
	}
	
	public void setMinutes(int min) {
		this.min = min;
	}
	
	public int getMinutes() {
		return min;
	}
	
	public void setSeconds(int sec) {
		this.sec = sec;
	}
	
	public int getSeconds() {
		return sec;
	}
	
	public boolean isUploadable(int hours, int min, int sec) {
		if(hours > 1 || min > 10 || sec > 30) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static MediaType getType() {
		return MediaType.AUDIO;
	}
}
