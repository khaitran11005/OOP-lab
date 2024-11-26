package hust.soict.dsai.aims.media;

public class Track {
	
	private String title;
	private int length;
	
	public Track() {
		this.title = null;
		this.length = 0;
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
}
