package model;

public class MediaObject {
	private String url;
	private MediaType type = MediaType.INVALID;
	
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
	
	public MediaObject getMediaObject(MediaType type) {
		if(type == MediaType.VIDEO) {
			return new Video();
		}
		else if(type == MediaType.AUDIO) {
			return new Audio();
		}
		else if(type == MediaType.PHOTO) {
			return new Photo();
		}
		else {
			return null;
		}
	}
}