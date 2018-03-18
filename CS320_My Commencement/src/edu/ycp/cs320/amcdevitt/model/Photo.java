package edu.ycp.cs320.amcdevitt.model;

public class Photo extends MediaObject {
	private int length;
	private int width;
	
	public Photo() {
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
	
	public boolean isUploadable(int length, int width) {
		if(length > 100 || width > 100) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static MediaType getType() {
		return MediaType.PHOTO;
	}
}
