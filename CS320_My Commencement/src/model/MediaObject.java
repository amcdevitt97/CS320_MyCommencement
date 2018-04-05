package model;

public class MediaObject<E> {
	private String url;
	private MediaType type = MediaType.INVALID;
	private  E mediaObject;
	
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
	
	public MediaType getMediaType() {
		return type;
	}
	
	public void setMediaType(MediaType type) {
		this.type = type;
	}
	public void setMediaObject(E x) {
		this.mediaObject = x;
	}
	
	public E getMediaObject() {
		return this.mediaObject;
	}
}