package model;

public class Video extends MediaObject {
	private int hours;
	private int min;
	private int sec;
	private int length;
	private int width;
	
	public Video() {
		this.hours = 0;
		this.min = 0;
		this.sec = 0;
		this.length = 0;
		this.width = 0;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
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
	
	public boolean isUploadable(int length, int width, int hours, int min, int sec) {
		if(length > 100 || width > 100 || hours > 1 || min > 10 || sec > 30) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static MediaType getType() {
		return MediaType.VIDEO;
	}
}