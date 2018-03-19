package model;

public class MediaObject {
	private String url;
	
	public enum MediaType{
		PHOTO,
		AUDIO,
		VIDEO,
		INVALID;
	}
	
	public MediaObject() {
		
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public static MediaType getMediaType() {
		return MediaType.INVALID;
	}
}